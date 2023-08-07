package com.eat.today.inquiry.model.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.eat.today.inquiry.model.vo.Inquiry;

public class InquiryDAO {

	public int insertInquiry(SqlSession session, Inquiry inquiry) {
		int result = session.insert("InquiryMapper.insertInquiry", inquiry);
		return result;
	}
	// 문의글 조회
	public List<Inquiry> selectInquiryList(SqlSession session, int currentPage) {
		int limit = 10;
		int offset = (currentPage-1)*limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Inquiry> iList = session.selectList("InquiryMapper.selectInquiryList", null, rowBounds);	// 쿼리문 WHERER 조건절이 있을 경우에 null 자리에 들어감.
		return iList;
	}
	// 데이터 상세 조회
	public Inquiry selectOneByNo(SqlSession session, int inquiryNo) {
		Inquiry inquiry = session.selectOne("InquiryMapper.selectOneByNo", inquiryNo);
		return inquiry;
	}
	// 데이터 삭제
	public int deleteInquiry(SqlSession session, int inquiryNo) {
		int result = session.delete("InquiryMapper.deleteInquiry", inquiryNo);
		return result;
	}
	// 게시판 네비
	public String generatePageNavi(SqlSession session,int currentPage) {
		// 전체 게시물의 갯수
		int totalCount = getTotalCount(session);
		// 한 페이지당 보여줄 게시물 갯수
		int recordCountPerPage = 10;
		// 한 페지이당 보여줄 네이게이션 갯수
		int naviCountPerPage = 5;	
		// 네비게이션 범위의 총 갯수
		int totalNaviCount = 0;
		// 전체 게시물수 % 한페이지에 보여줄 게시글 수가 0보다 크면
		if(totalCount % recordCountPerPage > 0) {
			// 페이지 개수 = 전체 게시물수 / 한페이지에 보여줄 게시글 수 + 1 (소수점 있을 경우)
			totalNaviCount = totalCount / recordCountPerPage + 1;
		} else {
			// 페이지 개수 = 전체 게시물수 / 한페이지에 보여줄 게시글 수
			totalNaviCount = totalCount / recordCountPerPage;
		}
		// currentPage			startNavi
		// 1,2,3,4,5				1
		// 6,7,8,9,10				6
		// 11,12,13,14,15			11
		
		// currentPage			endNavi
		// 1,2,3,4,5				5
		// 6,7,8,9,10				10
		// 11,12,13,14,15			15
		
		int startNavi = ((currentPage -1)/naviCountPerPage) * naviCountPerPage + 1;
		int endNavi = startNavi + naviCountPerPage - 1;
		// endNavi값이 총 범위의 갯수보다 커지는 것을 막아주는 식
		if(endNavi > totalNaviCount) {
			endNavi = totalNaviCount;
		}
		StringBuffer result = new StringBuffer();
		// 이전/다음 페이지 여부
		boolean needPrev = true;
		boolean needNext = true;
		// 네비게이션이 1부터 시작할 경우 needPrev 노출 안되게끔 함.
		if(startNavi == 1) {
			needPrev = false;
		}
		// 네비게이션의 마지막이 전체 네비게이션 카운트와 같다면 needNext 노출 안되게끔 함.
		if(endNavi == totalNaviCount) {
			needNext = false;
		}
		
		if(needPrev) {
			result.append("<a href='/inquiry/list.do?currentPage="+(startNavi-1)+"'>[이전]</a> ");
		}
//		if(startNavi != 1) {
//			result.append("<a href=/inquiry/list.do?currentPage="+(startNavi-1)+"'>[이전]</a>");
//		}
		
		for(int i = startNavi; i <= endNavi; i++) {
			result.append("<a href='/inquiry/list.do?currentPage="+i+"'>"+i+"</a>&nbsp;&nbsp;");
		}
//		if(endNavi != totalNaviCount) {
//			result.append("<a href=/inquiry/list.do?currentPage="+(endNavi+1)+"'>[다음]</a>");
//		}
		if(needNext) {
			result.append("<a href='/inquiry/list.do?currentPage="+(endNavi+1)+"'>[다음]</a>");
		}
		return result.toString();
	}
	// SELECT 로 전체 COUNT 가져오기
	private int getTotalCount(SqlSession session) {
		int totalCount = session.selectOne("InquiryMapper.getTotalCount");
		return totalCount;
	}
	// 데이터 수정(업데이트)
	public int updateInquiry(SqlSession session, Inquiry inquiry) {
		int result = session.update("InquiryMapper.updateInquiry", inquiry);
		return result;
	}
	

}
