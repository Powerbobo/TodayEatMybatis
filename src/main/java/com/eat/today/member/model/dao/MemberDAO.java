package com.eat.today.member.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.eat.today.member.model.vo.Member;

public class MemberDAO {

	public int insertMember(SqlSession session, Member member) {
		int result = session.insert("MemberMapper.insertMember", member);
		return result;
	}
	// 로그인
	public Member selectLongin(SqlSession session, Member member) {
		Member mOne = session.selectOne("MemberMapper.selectLongin", member);
		return mOne;
	}
	// 이메일로 아이디 찾기
	public Member selectOneByEmail(SqlSession session, Member member) {
		Member mOne = session.selectOne("MemberMapper.selectOneByEmail", member);
		return mOne;
	}
	// 전화번호로 아이디 찾기
	public Member selectOneByPhone(SqlSession session, Member member) {
		Member mOne = session.selectOne("MemberMapper.selectOneByPhone", member);
		return mOne;
	}
	// 전화번호로 비밀번호 찾기
	public Member selectPwOneByPhone(SqlSession session, Member member) {
		Member mOne = session.selectOne("MemberMapper.selectPwOneByPhone", member);
		return mOne;
	}
	// 이메일로 비밀번호 찾기
	public Member selectPwOneByEmail(SqlSession session, Member member) {
		Member mOne = session.selectOne("MemberMapper.selectPwOneByEmail", member);
		return mOne;
	}
	// 마이페이지 정보수정
	public int updateMember(SqlSession session, Member member) {
		int result = session.update("MemberMapper.updateMember", member);
		return result;
	}
	// 마이페이지 조회
	public Member selectOneById(SqlSession session, String memberId) {
		Member member = session.selectOne("MemberMapper.selectOneById", memberId);
		return member;
	}

}
