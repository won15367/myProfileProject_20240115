package com.won15367.home.dto;

public class QAboardDto {
	
	private int qbnum;
	private String qbtitle;
	private String qbcontent;
	private String qbmid;
	private String qbmname;
	private String qbmemail;
	private String qbdate;
	
	public QAboardDto(int qbnum, String qbtitle, String qbcontent, String qbmid, String qbmname, String qbmemail,
			String qbdate) {
		super();
		this.qbnum = qbnum;
		this.qbtitle = qbtitle;
		this.qbcontent = qbcontent;
		this.qbmid = qbmid;
		this.qbmname = qbmname;
		this.qbmemail = qbmemail;
		this.qbdate = qbdate;
	}
	public QAboardDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getQbnum() {
		return qbnum;
	}
	public void setQbnum(int qbnum) {
		this.qbnum = qbnum;
	}
	public String getQbtitle() {
		return qbtitle;
	}
	public void setQbtitle(String qbtitle) {
		this.qbtitle = qbtitle;
	}
	public String getQbcontent() {
		return qbcontent;
	}
	public void setQbcontent(String qbcontent) {
		this.qbcontent = qbcontent;
	}
	public String getQbmid() {
		return qbmid;
	}
	public void setQbmid(String qbmid) {
		this.qbmid = qbmid;
	}
	public String getQbmname() {
		return qbmname;
	}
	public void setQbmname(String qbmname) {
		this.qbmname = qbmname;
	}
	public String getQbmemail() {
		return qbmemail;
	}
	public void setQbmemail(String qbmemail) {
		this.qbmemail = qbmemail;
	}
	public String getQbdate() {
		return qbdate;
	}
	public void setQbdate(String qbdate) {
		this.qbdate = qbdate;
	}
	
	

}
