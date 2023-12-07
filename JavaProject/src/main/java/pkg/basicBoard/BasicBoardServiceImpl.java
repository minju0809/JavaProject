package pkg.basicBoard;

public class BasicBoardServiceImpl implements BasicBoardService {
	BasicBoardDao dao = null;
	
	BasicBoardServiceImpl() {
		dao = new BasicBoardDaoImpl();
	}

	@Override
	public void insert(BasicBoardVO vo) {
		dao.insert(vo);
	}

}
