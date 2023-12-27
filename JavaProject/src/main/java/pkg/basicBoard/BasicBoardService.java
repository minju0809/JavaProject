package pkg.basicBoard;

import java.util.List;

public interface BasicBoardService {
	void insert(BasicBoardVO vo);
	
	List<BasicBoardVO> getBoardList();
	
	void delete(int boardNumber);
	
	BasicBoardVO getBoard(int boardNumber);
	
	void update(BasicBoardVO vo);
	
	void cntUpdate(int boardNumber);
}


