package todayeat.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todayeat.model.service.MemberService;
import todayeat.model.vo.Member;

/**
 * Servlet implementation class FindIdEmail
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
		request.getRequestDispatcher("/WEB-INF/views/member/find_id_email.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String memberName = request.getParameter("userName");
		String memberEmail = request.getParameter("userEmail");
		Member member = new Member();
		member.setMemberName(memberName);
		member.setMemberEmail(memberEmail);
		MemberService service = new MemberService();
		
//		Member mOne = service.selectOneByEmail(member);
//		if(mOne != null) {
//			// 성공 -> alert 창으로 아이디/비밀번호 확인
//		} else {
//			// 실패 -> alert 창으로 실패
//		}
	}

}
