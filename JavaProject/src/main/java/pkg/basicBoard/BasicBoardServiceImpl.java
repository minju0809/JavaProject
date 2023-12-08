package pkg.basicBoard;

import java.util.List;

public class BasicBoardServiceImpl implements BasicBoardService {
	BasicBoardDao dao = null;
	
	BasicBoardServiceImpl() {
		dao = new BasicBoardDaoImpl();
	}

	@Override
	public void insert(BasicBoardVO vo) {
		dao.insert(vo);
	}

	@Override
	public List<BasicBoardVO> select() {
		return dao.select();
	}

}
