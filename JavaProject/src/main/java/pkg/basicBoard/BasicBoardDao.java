package pkg.basicBoard;

import java.util.List;

public interface BasicBoardDao {
	void insert(BasicBoardVO vo);
	
	List<BasicBoardVO> select();
	
	void delete(int boardNumber);
}


