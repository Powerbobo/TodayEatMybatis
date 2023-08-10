package com.eat.today.member.controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eat.today.member.model.service.MemberService;
import com.eat.today.member.model.vo.Member;

/**
 * Servlet implementation class UpdateController
 */
@WebServlet("/member/update.do")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/member/myPage.jsp")
		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		String memberPwRe = request.getParameter("memberPwRe");
		String memberName = request.getParameter("memberName");
		String memberPhone = request.getParameter("memberPhone");
		String memberEmail = request.getParameter("memberEmail");
		String memberAddress = request.getParameter("memberAddress");
		String memberGender = request.getParameter("memberGender");
		String mBirthDay = request.getParameter("memberBirthday");
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate date = LocalDate.parse(mBirthDay, format);
		Date memberBirthday = Date.valueOf(date);
		
		Member member = new Member(memberId, memberPw, memberPwRe, memberName, memberPhone, memberEmail, memberAddress, memberGender, memberBirthday);
		MemberService service = new MemberService();
		int result = service.updateMember(member);
		if(result > 0) {
			// 성공 -> 수정된 페이지 다시 띄우기
			request.setAttribute("msg", "정보 수정 성공!");
			request.setAttribute("url", "/member/myPage.do?memberId="+member.getMemberId());
			request.getRequestDispatcher("/WEB-INF/views/common/serviceSuccess.jsp")
			.forward(request, response);
		} else {
			// 실패 -> alert 창에 실패메세지 띄우고, 다시 페이지로 돌아가기
			request.setAttribute("msg", "정보 수정 실패!");
			request.setAttribute("url", "/member/update.do?memberId="+member.getMemberId());
			request.getRequestDispatcher("/WEB-INF/views/common/serviceFailed.jsp")
			.forward(request, response);
		}
	}

}
