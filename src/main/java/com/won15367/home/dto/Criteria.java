package com.won15367.home.dto;

public class Criteria {
	
	private int amount = 9; // 한 페이지당 출력할 글의 수
	private int pageNum = 1; // 현재 페이지 번호가 저장될 변수(초기값은 1)
	private int startNum; // 선택한 페이지에서 시작할 글의 번호
	
	public Criteria(int amunt, int pageNum, int startNum) {
		super();
		this.amount = amunt;
		this.pageNum = pageNum;
		this.startNum = startNum;
	}

	public Criteria() {
		super();
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getStartNum() {
		return startNum;
	}

	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}
	
	
	
}
