package com.eat.today.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eat.today.member.model.service.MemberService;
import com.eat.today.member.model.vo.Member;

/**
 * Servlet implementation class FindIdEmailController
 */
@WebServlet("/member/findIdEmail.do")
public class FindIdEmailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindIdEmailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/member/find_id_email.jsp")
		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String memberName = request.getParameter("memberName");
		String memberEmail = request.getParameter("memberEmail");
		Member member = new Member();
		member.setMemberName(memberName);
		member.setMemberEmail(memberEmail);
		MemberService service = new MemberService();
		Member mOne = service.selectOneByEmail(member);
		if(mOne != null) {
			// 성공 -> alert창에 아이디 띄우고 로그인 페이지로 이동
			// SELECT MEMBER_ID FROM MEMBER_TBL WHERE MEMBER_NAME = ? AND MEMBER_EMAIL = ?
			request.setAttribute("msg", "찾으신 아이디는 "+ mOne.getMemberId()+"입니다.");
			request.setAttribute("url","/member/login.do");
			request.getRequestDispatcher("/WEB-INF/views/common/serviceSuccess.jsp")
			.forward(request, response);
		} else {
			// 실패 -> 그대로 아이디찾기(이메일) 페이지
			request.setAttribute("msg", "아이디 조회에 실패하였습니다.");
			request.setAttribute("url","/member/findIdEmail.do");
			request.getRequestDispatcher("/WEB-INF/views/common/serviceFailed.jsp")
			.forward(request, response);
		}
	}

}
