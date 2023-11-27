package pkg.member;

import java.util.List;

public interface MemberService {
	boolean isIdDuplicated(String id);
	
	void insert(MemberVO vo);
	void update(MemberVO vo);
	void delete(String id);
	String selectFileName(String id);
	
	int memberCount();
	
	List<MemberVO> select(MemberVO vo);
	MemberVO edit(String id);
}

