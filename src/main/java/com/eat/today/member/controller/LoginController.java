package com.eat.today.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.eat.today.member.model.service.MemberService;
import com.eat.today.member.model.vo.Member;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/member/login.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/views/member/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String memberId = request.getParameter("user-id");
		String memberPw = request.getParameter("user-pw");
		Member member = new Member(memberId, memberPw);
		MemberService service = new MemberService();
		Member mOne = service.selectLongin(member);
		if(mOne != null) {
			// 성공
			HttpSession session = request.getSession();
			session.setAttribute("userId", mOne.getMemberId());
			session.setAttribute("userName", mOne.getMemberName());
			request.setAttribute("msg", "로그인 성공!");
			request.setAttribute("url", "/index.jsp");
			request.getRequestDispatcher("/WEB-INF/views/common/serviceSuccess.jsp").forward(request, response);
		} else {
			// 실패
			request.setAttribute("msg", "로그인 실패!");
			request.setAttribute("url", "/member/login.do");
			request.getRequestDispatcher("/WEB-INF/views/common/serviceFailed.jsp").forward(request, response);
		}
	}

}
