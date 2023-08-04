package todayeat.model.service;

import java.sql.*;
import java.util.List;

import todayeat.common.JDBCTemplate;
import todayeat.model.dao.MemberDAO;
import todayeat.model.vo.Member;

public class MemberService {
	// 데이터 추가
	public int insertMember(Member member) {
		JDBCTemplate jdbcTemplate = JDBCTemplate.getInstance();
		Connection conn = jdbcTemplate.createConnection();
		MemberDAO mDao = new MemberDAO();
		int result = mDao.insertMember(conn, member);
		if(result > 0) {
			// 성공시 커밋
			jdbcTemplate.commit(conn);
		} else {
			// 실패시 롤백
			jdbcTemplate.rollback(conn);
		}
		return result;
	}
	// 로그인
	public Member selectLongin(Member member) {
		JDBCTemplate jdbcTemplate = JDBCTemplate.getInstance();
		Connection conn = jdbcTemplate.createConnection();
		MemberDAO mDao = new MemberDAO();
		member = mDao.selectLongin(conn, member);
		return member;
	}
	
	
}
