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
	public List<BasicBoardVO> getBoardList() {
		return dao.getBoardList();
	}

	@Override
	public void delete(int boardNumber) {
		dao.delete(boardNumber);
	}

	@Override
	public BasicBoardVO getBoard(int boardNumber) {
		return dao.getBoard(boardNumber);
	}

	@Override
	public void update(BasicBoardVO vo) {
		dao.update(vo);
	}

}


