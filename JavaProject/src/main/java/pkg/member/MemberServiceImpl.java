package pkg.member;

import java.util.List;

public class MemberServiceImpl implements MemberService {
	MemberDao dao = null;
	
	public MemberServiceImpl () {
		dao = new MemberDaoImpl();
	}

	@Override
	public boolean isIdDuplicated(String id) {
		return dao.isIdDuplicated(id);
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
	public void delete(String id) {
		dao.delete(id);
	}

	@Override
	public List<MemberVO> select(MemberVO vo) {
		return dao.select(vo);
	}

	@Override
	public MemberVO edit(String id) {
		return dao.edit(id);
	}

	@Override
	public int memberCount() {
		return dao.memberCount();
	}

	@Override
	public String selectFileName(String id) {
		return dao.selectFileName(id);
	}

}
