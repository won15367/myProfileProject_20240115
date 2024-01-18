package com.won15367.home.dao;

import java.util.List;

import com.won15367.home.dto.QAboardDto;

public interface BoardDao {
	
	public String testDao(String fbnum);
	
	public List<QAboardDto> listDao();
	
}
