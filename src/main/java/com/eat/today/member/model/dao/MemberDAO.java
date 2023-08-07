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

}
