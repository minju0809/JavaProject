package pkg.member;

import java.util.List;

public class MemberServiceImpl implements MemberService {
	MemberDao dao = null;
	
	public MemberServiceImpl () {
		dao = new MemberDaoImpl();
	}
	
	@Override
	public void insert(MemberVO vo) {
		dao.insert(vo);
	}

	@Override
	public void update(MemberVO vo) {
		dao.update(vo);
	}

	@Override
	public void delete(MemberVO vo) {
		dao.delete(vo);
	}

	@Override
	public List<MemberVO> select(MemberVO vo) {
		return dao.select(vo);
	}

	@Override
	public MemberVO edit(MemberVO vo) {
		return dao.edit(vo);
	}

	@Override
	public int memberCount() {
		return dao.memberCount();
	}

}
