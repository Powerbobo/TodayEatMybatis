package todayeat.model.vo;

import java.sql.Date;

public class Inquiry {
	private int inquiryNo;
	private String inquirySubject;
	private String inquiryContent;
	private String inquiryWriter;
	private Date inquiryDate;
	private String inquiryYN;
	
	
	public Inquiry() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Inquiry(String inquirySubject, String inquiryContent) {
		super();
		this.inquirySubject = inquirySubject;
		this.inquiryContent = inquiryContent;
	}
	
	public Inquiry(String inquirySubject, String inquiryContent, String inquiryWriter) {
		super();
		this.inquirySubject = inquirySubject;
		this.inquiryContent = inquiryContent;
		this.inquiryWriter = inquiryWriter;
	}

	public int getInquiryNo() {
		return inquiryNo;
	}
	public void setInquiryNo(int inquiryNo) {
		this.inquiryNo = inquiryNo;
	}
	public String getInquirySubject() {
		return inquirySubject;
	}
	public void setInquirySubject(String inquirySubject) {
		this.inquirySubject = inquirySubject;
	}
	public String getInquiryContent() {
		return inquiryContent;
	}
	public void setInquiryContent(String inquiryContent) {
		this.inquiryContent = inquiryContent;
	}
	public String getInquiryWriter() {
		return inquiryWriter;
	}
	public void setInquiryWriter(String inquiryWriter) {
		this.inquiryWriter = inquiryWriter;
	}
	public Date getInquiryDate() {
		return inquiryDate;
	}
	public void setInquiryDate(Date inquiryDate) {
		this.inquiryDate = inquiryDate;
	}
	public String getInquiryYN() {
		return inquiryYN;
	}
	public void setInquiryYN(String inquiryYN) {
		this.inquiryYN = inquiryYN;
	}
	
	@Override
	public String toString() {
		return "문의하기 [번호=" + inquiryNo + ", 제목=" + inquirySubject + ", 내용="
				+ inquiryContent + ", 작성자=" + inquiryWriter + ", 문의일=" + inquiryDate + ", 답변여부="
				+ inquiryYN + "]";
	}
	
}
