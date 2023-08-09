package com.eat.today.member.model.service;

import org.apache.ibatis.session.SqlSession;

import com.eat.today.common.SqlSessionTemplate;
import com.eat.today.member.model.dao.MemberDAO;
import com.eat.today.member.model.vo.Member;

public class MemberService {
	private MemberDAO mDao;
	
	public MemberService() {
		mDao = new MemberDAO();
	}
	
	// 데이터 추가
	public int insertMember(Member member) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		int result = mDao.insertMember(session, member);
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
	// 마이페이지 정보수정
	public int updateMember(Member member) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		int result = mDao.updateMember(session, member);
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
	// 로그인
	public Member selectLongin(Member member) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		Member mOne = mDao.selectLongin(session, member);
		session.close();
		return mOne;
	}
	// 이메일로 아이디 찾기
	public Member selectOneByEmail(Member member) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		Member mOne = mDao.selectOneByEmail(session, member);
		return mOne;
	}
	// 전화번호로 아이디 찾기
	public Member selectOneByPhone(Member member) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		Member mOne = mDao.selectOneByPhone(session, member);
		return mOne;
	}
	// 전화번호로 비밀번호 찾기
	public Member selectPwOneByPhone(Member member) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		Member mOne = mDao.selectPwOneByPhone(session, member);
		return mOne;
	}
	// 이메일로 비밀번호 찾기
	public Member selectPwOneByEmail(Member member) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		Member mOne = mDao.selectPwOneByEmail(session, member);
		return mOne;
	}
	// 마이페이지 조회
	public Member selectOneById(String memberId) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		Member member = mDao.selectOneById(session, memberId);
		return member;
	}


	
	
	
}
