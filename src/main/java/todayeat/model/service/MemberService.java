package todayeat.model.service;

import org.apache.ibatis.session.SqlSession;

import todayeat.common.SqlSessionTemplate;
import todayeat.model.dao.MemberDAO;
import todayeat.model.vo.Member;

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
	// 로그인
	public Member selectLongin(Member member) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		Member mOne = mDao.selectLongin(session, member);
		session.close();
		return mOne;
	}
	
	
}
