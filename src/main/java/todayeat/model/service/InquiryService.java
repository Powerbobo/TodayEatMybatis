package todayeat.model.service;

import java.sql.*;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import todayeat.common.JDBCTemplate;
import todayeat.common.SqlSessionTemplate;
import todayeat.model.dao.InquiryDAO;
import todayeat.model.vo.Inquiry;

public class InquiryService {
	private InquiryDAO iDao;
//	private JDBCTemplate jdbcTemplate;
	
	public InquiryService() {
		iDao = new InquiryDAO();
//		jdbcTemplate = JDBCTemplate.getInstance();
	}
	
	// 데이터 INSERT
	public int insertInquiry(Inquiry inquiry) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		int result = iDao.insertInquiry(session, inquiry);
		if(result > 0) {
			// 성공시 커밋
			session.commit();
		} else {
			// 실패시 롤백
			session.rollback();
		}
		session.close();
		return result;
	}
	// 전체 문의글
	public List<Inquiry> selectInquiryList() {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		List<Inquiry> iList = iDao.selectInquiryList(session);
		session.close();
		return iList;
	}
	// 상세 조회
	public Inquiry selectOneByNo(int inquiryNo) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		Inquiry inquiry = iDao.selectOneByNo(session, inquiryNo);
		session.close();
		return inquiry;
	}
	// 문의 삭제
	public int deleteInquiry(int inquiryNo) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		int result = iDao.deleteInquiry(session, inquiryNo);
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		return result;
	}
	
	

}
