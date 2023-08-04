package todayeat.model.service;

import java.sql.*;
import java.util.List;

import todayeat.common.JDBCTemplate;
import todayeat.model.dao.InquiryDAO;
import todayeat.model.vo.Inquiry;

public class InquiryService {
	private InquiryDAO iDao;
	private JDBCTemplate jdbcTemplate;
	
	public InquiryService() {
		iDao = new InquiryDAO();
		jdbcTemplate = JDBCTemplate.getInstance();
	}
	
	// 데이터 INSERT
	public int insertInquiry(Inquiry inquiry) {
		Connection conn = jdbcTemplate.createConnection();
		int result = iDao.insertInquiry(conn, inquiry);
		if(result > 0) {
			// 성공시 커밋
			jdbcTemplate.commit(conn);
		} else {
			// 실패시 롤백
			jdbcTemplate.rollback(conn);
		}
		jdbcTemplate.close(conn);
		return result;
	}
	// 전체 문의글
	public List<Inquiry> selectInquiryList() {
		Connection conn = jdbcTemplate.createConnection();
		List<Inquiry> iList = iDao.selectInquiryList(conn);
		return iList;
	}
	// 상세 조회
	public Inquiry selectOneByNo(int inquiryNo) {
		Connection conn = jdbcTemplate.createConnection();
		Inquiry inquiry = iDao.selectOneByNo(conn, inquiryNo);
		jdbcTemplate.close(conn);
		return inquiry;
	}
	// 문의 삭제
	public int deleteInquiry(int inquiryNo) {
		Connection conn = jdbcTemplate.createConnection();
		int result = iDao.deleteInquiry(conn, inquiryNo);
		if(result > 0) {
			jdbcTemplate.commit(conn);
		} else {
			jdbcTemplate.rollback(conn);
		}
		jdbcTemplate.close(conn);
		return result;
	}
	
	

}
