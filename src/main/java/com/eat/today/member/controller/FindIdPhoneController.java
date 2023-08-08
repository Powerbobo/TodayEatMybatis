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
 * Servlet implementation class FindIdPhone
 */
@WebServlet("/member/findIdPhone.do")
public class FindIdPhoneController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindIdPhoneController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/member/find_id_phone.jsp")
		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String memberName = request.getParameter("memberName");
		String memberPhone = request.getParameter("memberPhone");
		Member member = new Member();
		member.setMemberName(memberName);
		member.setMemberPhone(memberPhone);
		MemberService service = new MemberService();
		Member mOne = service.selectOneByPhone(member);
		if(mOne != null) {
			// 성공 -> alert 창 띄우고 로그인 페이지로 이동
			request.setAttribute("msg", "찾으신 아이디는 "+mOne.getMemberId()+"입니다.");
			request.setAttribute("url", "/member/login.do");
			request.getRequestDispatcher("/WEB-INF/views/common/serviceSuccess.jsp")
			.forward(request, response);
		} else {
			// 실패 -> alert 창 띄우고 아이디 찾기 페이지(전화번호)로 다시 이동
			request.setAttribute("msg", "아이디 조회에 실패하였습니다.");
			request.setAttribute("url","/member/findIdPhone.do");
			request.getRequestDispatcher("/WEB-INF/views/common/serviceFailed.jsp")
			.forward(request, response);
		}
	}

}
