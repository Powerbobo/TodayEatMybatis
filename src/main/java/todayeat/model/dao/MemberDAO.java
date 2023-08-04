package todayeat.model.dao;

import java.sql.*;

import todayeat.model.vo.Member;

public class MemberDAO {

	public int insertMember(Connection conn, Member member) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "INSERT INTO MEMBER_TBL VALUES(?,?,?,?,?,?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPw());
			pstmt.setString(3, member.getMemberPwRe());
			pstmt.setString(4, member.getMemberName());
			pstmt.setString(5, member.getMemberPhone());
			pstmt.setString(6, member.getMemberEmail());
			pstmt.setString(7, member.getMemberAddress());
			pstmt.setString(8, member.getMemberGender());
			pstmt.setDate(9, member.getMemberBirthday());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	// 로그인
	public Member selectLongin(Connection conn, Member member) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member mOne = null;
		String query = "SELECT * FROM MEMBER_TBL WHERE MEMBER_ID = ? AND MEMBER_PW = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPw());
			rset = pstmt.executeQuery();
			// 후처리
			if(rset.next()) {
				mOne = rsetToMember(rset);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return mOne;
	}
	// 후처리
	private Member rsetToMember(ResultSet rset) throws SQLException {
		Member member = new Member();
		member.setMemberId(rset.getString("MEMBER_ID"));
		member.setMemberPw(rset.getString("MEMBER_PW"));
		member.setMemberPwRe(rset.getString("MEMBER_PW_RE"));
		member.setMemberName(rset.getString("MEMBER_NAME"));
		member.setMemberPhone(rset.getString("MEMBER_PHONE"));
		member.setMemberEmail(rset.getString("MEMBER_EMAIL"));
		member.setMemberAddress(rset.getString("MEMBER_ADDRESS"));
		member.setMemberGender(rset.getString("MEMBER_GENDER"));
		member.setMemberBirthday(rset.getDate("MEMBER_BIRTHDAY"));
		return member;
	}

}
