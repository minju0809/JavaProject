package pkg.member;

import java.util.List;

public interface MemberDao {
	boolean isIdDuplicated(String id);
	
	void insert(MemberVO vo);
	void update(MemberVO vo);
	void delete(MemberVO vo);
	
	int memberCount();
	
	List<MemberVO> select(MemberVO vo);
	MemberVO edit(MemberVO vo);
	
	
}
