package com.won15367.home.dto;

public class PageDto {
	
	private int startPage; // 화면에서 보여질 시작 페이지 번호
	private int endPage;   // 화면에서 보여질 마지막 페이지 번호
	private boolean next;  // 더 뒤의 페이지 있는지 여부 '>'
	private boolean prev;  // 더 앞의 페이지 있는지 여부 '<'
	private int total;  // 총 글의 개수
	private Criteria criteria;
	
	public PageDto(int startPage, int endPage, boolean next, boolean prev, int total, Criteria criteria) {
		super();
		this.startPage = startPage;
		this.endPage = endPage;
		this.next = next;
		this.prev = prev;
		this.total = total;
		this.criteria = criteria;
	}
	
	public PageDto(Criteria criteria, int total) {
		this.total = total;
		this.criteria = criteria;
		
		this.endPage = (int) Math.ceil((criteria.getPageNum()/10.0))*10;
		this.startPage = this.endPage - 9;
		int realEndPage = (int) Math.ceil(total*1.0/criteria.getAmount());
		if (realEndPage < this.endPage) {
			this.endPage = realEndPage;
		}
		
		this.prev = this.startPage > 1;
		this.next = this.endPage < realEndPage;
	}
	
	public PageDto() {
		super();
	}
	
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public Criteria getCriteria() {
		return criteria;
	}
	public void setCriteria(Criteria criteria) {
		this.criteria = criteria;
	}
	
	
}
