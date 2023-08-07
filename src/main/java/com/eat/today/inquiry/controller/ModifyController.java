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
 * Servlet implementation class ModifyController
 */
@WebServlet("/inquiry/modify.do")
public class ModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		InquiryService service = new InquiryService();
		int inquiryNo = Integer.parseInt(request.getParameter("inquiryNo"));
		Inquiry inquiry = service.selectOneByNo(inquiryNo);
		request.setAttribute("inquiry", inquiry);
		request.getRequestDispatcher("/WEB-INF/views/inquiry/modify.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int inquiryNo = Integer.parseInt(request.getParameter("inquiryNo"));
		String inquirySubject = request.getParameter("inquirySubject");
		String inquiryContent = request.getParameter("inquiryContent");
		Inquiry inquiry  = new Inquiry(inquiryNo, inquirySubject, inquiryContent);
		InquiryService service = new InquiryService();
		int result = service.updateInquiry(inquiry);
		if(result > 0) {
			// 성공 -> list 로 이동
			request.setAttribute("msg", "문의 수정 성공!");
			request.setAttribute("url", "/inquiry/list.do");
			request.getRequestDispatcher("/WEB-INF/views/common/serviceSuccess.jsp").forward(request, response);
		} else {
			// 실패 -> list 로 이동
			request.setAttribute("msg", "문의 수정 실패!");
			request.setAttribute("url", "/inquiry/list.do");
			request.getRequestDispatcher("/WEB-INF/views/common/serviceFailed.jsp").forward(request, response);
		}
	}

}
