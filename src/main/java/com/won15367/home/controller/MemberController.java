package com.won15367.home.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.won15367.home.dao.MemberDao;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MemberController {
	
	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping(value="join")
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

}
