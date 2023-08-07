package todayeat.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import todayeat.model.vo.Inquiry;

public class InquiryDAO {

	public int insertInquiry(SqlSession session, Inquiry inquiry) {
		int result = session.insert("NoticeMapper.insertInquiry", inquiry);
		return result;
	}
	// 문의글 조회
	public List<Inquiry> selectInquiryList(SqlSession session) {
		List<Inquiry> iList = session.selectOne("NoticeMapper.selectInquiryList");
		return iList;
	}
	// 데이터 상세 조회
	public Inquiry selectOneByNo(SqlSession session, int inquiryNo) {
		Inquiry inquiry = session.selectOne("NoticeMapper.selectOneByNo", inquiryNo);
		return inquiry;
	}
	// 데이터 삭제
	public int deleteInquiry(SqlSession session, int inquiryNo) {
		int result = session.delete("NoticeMapper.deleteInquiry", inquiryNo);
		return result;
	}
	
	
}
