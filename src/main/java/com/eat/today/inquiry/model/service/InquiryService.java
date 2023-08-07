package com.eat.today.inquiry.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.eat.today.common.SqlSessionTemplate;
import com.eat.today.inquiry.model.dao.InquiryDAO;
import com.eat.today.inquiry.model.vo.Inquiry;
import com.eat.today.inquiry.model.vo.PageData;

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
	public PageData selectInquiryList(int currentPage) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		List<Inquiry> iList = iDao.selectInquiryList(session, currentPage);
		String pageNavi = iDao.generatePageNavi(session, currentPage);
		PageData pd = new PageData(iList, pageNavi);
		session.close();
		return pd;
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
	// 문의 수정
	public int updateInquiry(Inquiry inquiry) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		int result = iDao.updateInquiry(session, inquiry);
		if(result > 0) {
			// 업데이트 성공하면 커밋
			session.commit();
		} else {
			// 업데이터 실패하면 롤백
			session.rollback();
		}
		// conn 자원 해제
		session.close();
		return result;
	}
	
	

}
