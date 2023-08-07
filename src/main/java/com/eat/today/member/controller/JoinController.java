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
 * Servlet implementation class JoinController
 */
@WebServlet("/member/join.do")
public class JoinController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/member/join.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
//		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String memberId = request.getParameter("joinId");
		String memberPw = request.getParameter("joinPW");
		String memberPwRe = request.getParameter("joinPwRe");
		String memberName = request.getParameter("joinName");
		String memberPhone = request.getParameter("joinPhone");
		String memberEmail = request.getParameter("joinEmail");
		String memberAddress = request.getParameter("joinAddr");
		String memberGender = request.getParameter("gender");
		String mBirthDay = request.getParameter("joinBir");
		// SimpleDateFormat
//		Date memberBirthday =  Date.valueOf(request.getParameter("joinBir"));
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate date = LocalDate.parse(mBirthDay, format);
		Date memberBirthday = Date.valueOf(date);
		
		Member member = new Member(memberId, memberPw, memberPwRe, memberName, memberPhone, memberEmail, memberAddress, memberGender, memberBirthday);
		MemberService service = new MemberService();
		int result = service.insertMember(member);
		if(result > 0) {
			// 성공 -> 로그인 화면으로 이동
			request.setAttribute("msg", "회원가입 성공!");
			request.setAttribute("url", "/index.jsp");
			request.getRequestDispatcher("/WEB-INF/views/common/serviceSuccess.jsp").forward(request, response);
		} else {
			// 실패 -> 실패 alert 창 띄우기
			request.setAttribute("msg", "회원가입 실패!");
			request.setAttribute("url", "/member/join.do");
			request.getRequestDispatcher("/WEB-INF/views/common/serviceFailed.jsp")
			.forward(request, response);
		}
	}

}
