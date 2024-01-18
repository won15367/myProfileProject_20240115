package com.won15367.home.dao;

import java.util.List;

import com.won15367.home.dto.QAboardDto;

public interface BoardDao {
	
	public String testDao(String fbnum);
	
	public List<QAboardDto> listDao();
	
	public void writeDao(String qbmid, String qbmname, String qbemil, String qbtitle, String qbcontent);
	
	public QAboardDto contentViewDao(String qbnum);
	
	public void contentModifyDao(String qbnum, String qbtitle, String qbcontent);
	
	public void contentDeleteDao(String qbnum);

}
