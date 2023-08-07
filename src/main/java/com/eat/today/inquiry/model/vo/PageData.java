package com.eat.today.inquiry.model.vo;

import java.util.List;

public class PageData {
	private List<Inquiry> iList;
	private String pageNavi;
	
	public PageData() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public PageData(List<Inquiry> iList, String pageNavi) {
		super();
		this.iList = iList;
		this.pageNavi = pageNavi;
	}

	public List<Inquiry> getiList() {
		return iList;
	}
	public void setiList(List<Inquiry> iList) {
		this.iList = iList;
	}
	public String getPageNavi() {
		return pageNavi;
	}
	public void setPageNavi(String pageNavi) {
		this.pageNavi = pageNavi;
	}

	@Override
	public String toString() {
		return "PageData [iList=" + iList + ", pageNavi=" + pageNavi + "]";
	}
	
}
