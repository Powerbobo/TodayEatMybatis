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
 * Servlet implementation class InquiryInsertController
 */
@WebServlet("/inquiry/insert.do")
public class InquiryInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InquiryInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/inquiry/insert.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		InquiryService service = new InquiryService();
		String inquirySubject = request.getParameter("inquirySubject");
		String inquiryContent = request.getParameter("inquiryContent");
		Inquiry inquiry = new Inquiry(inquirySubject, inquiryContent);
		int result = service.insertInquiry(inquiry);
		if(result > 0) {
			// 성공하면 성공 팝업창 띄우고 목록으로 이동
			request.setAttribute("msg", "문의 등록 성공!");
			request.setAttribute("url", "/inquiry/list.do");
			request.getRequestDispatcher("/WEB-INF/views/common/serviceSuccess.jsp").forward(request, response);
		} else {
			// 실패하면 실패 팝업창 띄우고 목록으로 이동
			request.setAttribute("msg", "문의 등록 실패");
			request.setAttribute("url", "/inquiry/list.do");
			request.getRequestDispatcher("/WEB-INF/views/common/serviceFailed.jsp").forward(request, response);
		}
		
	}

}
