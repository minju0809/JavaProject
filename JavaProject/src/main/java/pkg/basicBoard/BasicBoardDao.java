package pkg.basicBoard;

import java.util.List;

public interface BasicBoardDao {
	void insert(BasicBoardVO vo);
	
	List<BasicBoardVO> getBoardList();
	
	void delete(int boardNumber);
	
	BasicBoardVO getBoard(int boardNumber);
}


