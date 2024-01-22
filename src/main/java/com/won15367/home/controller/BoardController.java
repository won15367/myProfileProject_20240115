package com.won15367.home.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.won15367.home.dao.BoardDao;
import com.won15367.home.dao.MemberDao;
import com.won15367.home.dto.Criteria;
import com.won15367.home.dto.MemberDto;
import com.won15367.home.dto.PageDto;
import com.won15367.home.dto.QAboardDto;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class BoardController {
	
	@Autowired
	private SqlSession sqlSession;
	
	@GetMapping(value="test")
	public String test(Model model) {
		
		BoardDao dao = sqlSession.getMapper(BoardDao.class);
		String fbtitle = dao.testDao("1");
		
		model.addAttribute("title", fbtitle);
		
		return "test";
	}

	
	@GetMapping(value="")
	public String root() {

		return "index";
	}
	
	@GetMapping(value="index")
	public String index() {

		return "index";
	}
	
	@GetMapping(value="board")
	public String board(HttpServletRequest request, Model model, Criteria criteria) {
		
		if(request.getParameter("pageNum") != null) {
			criteria.setPageNum(Integer.parseInt(request.getParameter("pageNum")));
		}
		
		BoardDao dao = sqlSession.getMapper(BoardDao.class);
		
		int total = dao.boardAllCountDao();  // 게시판에 등록된 총 글의 개수
		
		PageDto pageDto = new PageDto(criteria, total);
		
		List<QAboardDto> dtos = dao.listDao(criteria.getAmount(), criteria.getPageNum());
		
		model.addAttribute("list", dtos);
		model.addAttribute("pageDto", pageDto);
		model.addAttribute("currPage", criteria.getPageNum());
		
		// System.out.println(pageDto.getStartPage());
		
		return "list";
	}
	
	@GetMapping(value="write_form")
	public String write_form(HttpSession session, Model model, HttpServletResponse response) {
		
		String sessionId = (String) session.getAttribute("sessionId");
		
		if(sessionId == null) {  // 로그인을 안한상태로 작성을 누른 경우

			response.setContentType("text/html;charset=utf-8");
			response.setCharacterEncoding("utf-8");
			try {
				PrintWriter printout = response.getWriter();
	  		    printout.println("<script>alert('"+ "글작성은 로그인한 상태에서만 가능합니다." +"');location.href='"+"login"+"';</script>");
	  		    printout.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			return "list";
			
		} else {
			MemberDao dao = sqlSession.getMapper(MemberDao.class);
			
			MemberDto memberDto = dao.memberInfoDao(sessionId);
			model.addAttribute("memberDto", memberDto);
			
			return "write_form";
		}
	}
	
	@GetMapping(value="write")
	public String write(HttpServletRequest request, Model model) {
		
		String qbmid = request.getParameter("qbmid");
		String qbmname = request.getParameter("qbmname");
		String qbemil = request.getParameter("qbemail");
		String qbtitle = request.getParameter("qbtitle");
		String qbcontent = request.getParameter("qbcontent");
		
		BoardDao dao = sqlSession.getMapper(BoardDao.class);
		
		dao.writeDao(qbmid, qbmname, qbemil, qbtitle, qbcontent);
		
		return "redirect:board";
	}
	
	@GetMapping(value="contentView")
	public String content_view(HttpServletResponse response, HttpServletRequest request, Model model) {
		
		BoardDao dao = sqlSession.getMapper(BoardDao.class);
		QAboardDto dto = dao.contentViewDao(request.getParameter("qbnum"));
		
		if(dto == null) {
			
			response.setContentType("text/html;charset=utf-8");
			response.setCharacterEncoding("utf-8");
			try {
				PrintWriter printout = response.getWriter();
	  		    printout.println("<script>alert('"+ "해당글이 존재하지 않습니다." +"');location.href='"+"board"+"';</script>");
	  		    printout.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
						
		} else {
			model.addAttribute("boardDto", dto);
		}			
			return "content_view";
		}
		
	@GetMapping(value="content_modify")
	public String content_modify(HttpServletResponse response, HttpServletRequest request, Model model, HttpSession session) {
		
		BoardDao dao = sqlSession.getMapper(BoardDao.class);
		
		String sid = (String) session.getAttribute("sessionId");
		QAboardDto boardDto = dao.contentViewDao(request.getParameter("qbnum"));
		
		if (sid.equals(boardDto.getQbmid())) {  // 글을쓴 회원과 로그인 중인 아이디가 같은 경우
			
			model.addAttribute("boardDto", boardDto);
			
		} else {
			response.setContentType("text/html;charset=utf-8");
			response.setCharacterEncoding("utf-8");
			try {
				PrintWriter printout = response.getWriter();
	  		    printout.println("<script>alert('"+ "작성자만 수정이 가능합니다." +"');location.href='"+"board"+"';</script>");
	  		    printout.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return "content_modify";
	
	}
	
	@GetMapping(value="content_modifyOk")
	public String content_modifyOk(HttpServletRequest request, Model model) {
		
		BoardDao dao = sqlSession.getMapper(BoardDao.class);
		dao.contentModifyDao(request.getParameter("qbnum"), request.getParameter("qbtitle"), request.getParameter("qbcontent"));
		
		QAboardDto dto = dao.contentViewDao(request.getParameter("qbnum"));
		model.addAttribute("boardDto", dto);
		
		return "content_view";
	}

	@GetMapping(value="content_delete")
	public String content_delete(HttpServletResponse response, HttpServletRequest request, Model model, HttpSession session) {
		
		BoardDao dao = sqlSession.getMapper(BoardDao.class);
		String sid = (String) session.getAttribute("sessionId");
		QAboardDto dto = dao.contentViewDao(request.getParameter("qbnum"));
		
		if (sid.equals(dto.getQbmid())) {
			dao.contentDeleteDao(request.getParameter("qbnum"));
		} else {
			response.setContentType("text/html;charset=utf-8");
			response.setCharacterEncoding("utf-8");
			try {
				PrintWriter printout = response.getWriter();
	  		    printout.println("<script>alert('"+ "작성자만 삭제가 가능합니다." +"');location.href='"+"board"+"';</script>");
	  		    printout.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
						
		return "redirect:board";
	}

	@GetMapping(value="profile")
	public String profile() {
		return "profile";
	}
	
	@GetMapping(value="contact")
	public String contact() {
		return "contact";
	}

}
