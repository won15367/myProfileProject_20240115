package com.won15367.home.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.won15367.home.dao.BoardDao;

@Controller
public class BoardController {
	
	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping(value="test")
	public String test(Model model) {
		
		BoardDao dao = sqlSession.getMapper(BoardDao.class);
		String fbtitle = dao.testDao("1");
		
		model.addAttribute("title", fbtitle);
		
		return "test";
	}

	
	@RequestMapping(value="")
	public String root(Model model) {

		return "index";
	}
	
	@RequestMapping(value="index")
	public String index(Model model) {

		return "index";
	}

}
