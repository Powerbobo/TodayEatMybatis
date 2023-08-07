package com.eat.today.inquiry.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eat.today.inquiry.model.service.InquiryService;
import com.eat.today.inquiry.model.vo.Inquiry;
import com.eat.today.inquiry.model.vo.PageData;

/**
 * Servlet implementation class InquiryController
 */
@WebServlet("/inquiry/list.do")
public class InquiryListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InquiryListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		InquiryService service = new InquiryService();
		// 삼항 연산자 이용해서 오류 방지
		String page = request.getParameter("currentPage") != null ? request.getParameter("currentPage") : "1";
		int currentPage = Integer.parseInt(page);
		PageData pd = service.selectInquiryList(currentPage);
		List<Inquiry> iList = pd.getiList();
//		String pageNavi = pd.getPageNavi();
		if(!iList.isEmpty()) {
			request.setAttribute("iList", iList);
			request.setAttribute("pageNavi", pd.getPageNavi());
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/inquiry/list.jsp");
			view.forward(request, response);
		} else {
			request.setAttribute("msg", "데이터 조회가 완료되지 않았습니다.");
			request.setAttribute("url", "/WEB-INF/views/inquiry/list.jsp");
			request.getRequestDispatcher("/WEB-INF/views/common/serviceFailed.jsp").forward(request, response);
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
