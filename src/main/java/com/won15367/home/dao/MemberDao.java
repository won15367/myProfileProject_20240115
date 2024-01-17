package com.won15367.home.dao;

public interface MemberDao {
	
	public int idCheckDao(String mid);
	
	public void joinDao(String mid, String mpw, String mname, String memail);

}
