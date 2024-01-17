package com.won15367.home.controller;

import java.io.IOException;
import java.io.PrintWriter;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.won15367.home.dao.MemberDao;
import com.won15367.home.dto.MemberDto;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {
	
	@Autowired
	private SqlSession sqlSession;
	
	@GetMapping(value="join")
	public String join() {
		return "join";
	}
	
	@PostMapping(value="joinOk")
	public String joinOk(HttpServletRequest request, Model model) {
				
		MemberDao dao = sqlSession.getMapper(MemberDao.class);
		
		int checkFlag = dao.idCheckDao(request.getParameter("mid"));
		
		if (checkFlag == 0) {
			dao.joinDao(request.getParameter("mid"), request.getParameter("mpw"), request.getParameter("mname"), request.getParameter("memail"));
			model.addAttribute("mname", request.getParameter("mname"));
			model.addAttribute("mid", request.getParameter("mid"));
		}
		
		model.addAttribute("joinFail", checkFlag);
		
		return "joinOk";
				
	}
	
	@GetMapping(value="login")
	public String login() {
		return "login";
	}
	
	@PostMapping(value="loginOk")
	public String loginOk(HttpServletRequest request, Model model, HttpSession session) {
		
		MemberDao dao = sqlSession.getMapper(MemberDao.class);
		
		int checkFlag = dao.loginCheckDao(request.getParameter("mid"), request.getParameter("mpw"));
		
		if(checkFlag == 1) {  // 로그인 성공
			
			session.setAttribute("sessionId", request.getParameter("mid"));
			
			MemberDto memberdto = dao.memberInfoDao(request.getParameter("mid"));
			model.addAttribute("memberDto", memberdto);
			
		} else {		
			model.addAttribute("loginFail", 1);
		}
		
		return "loginOk";
	}
	
	@GetMapping(value="logout")
	public String logout(HttpSession session, HttpServletResponse response) {
		
		session.invalidate();
		
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		try {
			PrintWriter printout = response.getWriter();
  		    printout.println("<script>alert('"+ "로그아웃 하시겠습니까?" +"');location.href='"+"login"+"';</script>");
  		    printout.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
				
		return "login";
				
	}
	
	@GetMapping(value="modify_form")
	public String modify_form(HttpSession session, HttpServletResponse response, Model model) {
	
		MemberDao dao = sqlSession.getMapper(MemberDao.class);
		
		MemberDto dto = dao.memberInfoDao((String) session.getAttribute("sessionId"));
		model.addAttribute("memberDto", dto);
		
		return "modify_form";
				
	}
	
	@PostMapping(value="modifyOk")
	public String modifyOk(HttpServletRequest request, Model model) {
		
		MemberDao dao = sqlSession.getMapper(MemberDao.class);
		
		dao.modifyInfoDao(request.getParameter("mid"), request.getParameter("mpw"), request.getParameter("mname"), request.getParameter("memail"));
		
		MemberDto dto = dao.memberInfoDao(request.getParameter("mid"));
		model.addAttribute("memberDto", dto);
		
		return "modifyOk";
		
	}
	
}
