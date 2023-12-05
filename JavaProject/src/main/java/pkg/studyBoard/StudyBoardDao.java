package pkg.studyBoard;

import java.util.List;

public interface StudyBoardDao {
	
	void StudyBoardInsert(StudyBoardVO vo);
	
	List<StudyBoardVO> StudyBoardSelect(StudyBoardVO vo);
	
	StudyBoardVO StudyBoardDetail(String id);
	
	void StudyCommentBoardInsert(StudyCommentBoardVO cvo); 
	
	List<StudyCommentBoardVO> StudyCommentBoardSelect(String id);
}
