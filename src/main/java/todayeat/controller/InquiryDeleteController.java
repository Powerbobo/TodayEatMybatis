package todayeat.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todayeat.model.service.InquiryService;

/**
 * Servlet implementation class InquiryDeleteController
 */
@WebServlet("/inquiry/delete.do")
public class InquiryDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InquiryDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// DELETE FROM INQUIRY_TBL WHERE INQUIRY_NO = ?
		InquiryService service = new InquiryService();
		int inquiryNo = Integer.parseInt(request.getParameter("inquiryNo"));
		int result = service.deleteInquiry(inquiryNo);
		if(result > 0) {
			request.setAttribute("msg", "문의가 삭제되었습니다!");
			request.setAttribute("url", "/inquiry/list.do");
			request.getRequestDispatcher("/WEB-INF/views/common/serviceSuccess.jsp").forward(request, response);
		} else {
			request.setAttribute("msg", "문의 삭제를 실패했습니다.");
			request.setAttribute("url", "/inquiry/detail.do");
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
