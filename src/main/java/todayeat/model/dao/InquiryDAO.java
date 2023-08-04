package todayeat.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import todayeat.model.vo.Inquiry;

public class InquiryDAO {

	public int insertInquiry(Connection conn, Inquiry inquiry) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "INSERT INTO INQUIRY_TBL VALUES(SEQ_INQUIRYNO.NEXTVAL,?,?,?,DEFAULT,'미등록')";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, inquiry.getInquirySubject());
			pstmt.setString(2, inquiry.getInquiryContent());
			pstmt.setString(3, inquiry.getInquiryWriter());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	// 문의글 조회
	public List<Inquiry> selectInquiryList(Connection conn) {
		Statement stmt = null;
		List<Inquiry> iList = null;
		ResultSet rset = null;
		String query = "SELECT * FROM INQUIRY_TBL";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			iList = new ArrayList<Inquiry>();
			// 후처리
			while(rset.next()) {
				Inquiry inquiry = rsetToInquiry(rset);
				iList.add(inquiry);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return iList;
	}
	// 데이터 상세 조회
	public Inquiry selectOneByNo(Connection conn, int inquiryNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Inquiry inquiry = null;
		String query = "SELECT * FROM INQUIRY_TBL WHERE INQUIRY_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, inquiryNo);
			rset = pstmt.executeQuery();
			// 후처리
			if(rset.next()) {
				inquiry = rsetToInquiry(rset);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				rset.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return inquiry;
	}
	// 데이터 삭제
	public int deleteInquiry(Connection conn, int inquiryNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "DELETE FROM INQUIRY_TBL WHERE INQUIRY_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, inquiryNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	// 후처리
	private Inquiry rsetToInquiry(ResultSet rset) throws SQLException {
		Inquiry inquiry = new Inquiry();
		inquiry.setInquiryNo(rset.getInt("INQUIRY_NO"));
		inquiry.setInquirySubject(rset.getString("INQUIRY_SUBJECT"));
		inquiry.setInquiryContent(rset.getString("INQUIRY_CONTENT"));
		inquiry.setInquiryWriter(rset.getString("INQUIRY_WRITER"));
		inquiry.setInquiryDate(rset.getDate("INQUIRY_DATE"));
		inquiry.setInquiryYN(rset.getString("INQUIRY_YN"));
		return inquiry;
	}



	
	
	
}
