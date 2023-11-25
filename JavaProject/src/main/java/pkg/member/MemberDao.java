package pkg.member;

import java.util.List;

public interface MemberDao {
	void insert(MemberVO vo);
	void update(MemberVO vo);
	void delete(MemberVO vo);
	
	List<MemberVO> select(MemberVO vo);
	MemberVO edit(MemberVO vo);
}
