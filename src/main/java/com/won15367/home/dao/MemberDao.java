package com.won15367.home.dao;

import com.won15367.home.dto.MemberDto;

public interface MemberDao {
	
	public int idCheckDao(String mid);
	
	public void joinDao(String mid, String mpw, String mname, String memail);
	
	public int loginCheckDao(String mid, String mpw);
	
	public MemberDto memberInfoDao(String mid);
	
	public void modifyInfoDao(String mid, String mpw, String mname, String memail);

}
