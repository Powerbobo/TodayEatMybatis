package com.eat.today.inquiry.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eat.today.inquiry.model.service.InquiryService;
import com.eat.today.inquiry.model.vo.Inquiry;

/**
 * Servlet implementation class InquiryDetailController
 */
@WebServlet("/inquiry/detail.do")
public class InquiryDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InquiryDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// SELECT * FROM INQUIRY_TBL WHERE INQUIRY_NO = ?
		int inquiryNo = Integer.parseInt(request.getParameter("inquiryNo"));
		InquiryService service = new InquiryService();
		Inquiry inquiry = service.selectOneByNo(inquiryNo);
		if(inquiry != null) {
			// 상세페이지로 이동
			request.setAttribute("inquiry", inquiry);
			request.getRequestDispatcher("/WEB-INF/views/inquiry/detail.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
