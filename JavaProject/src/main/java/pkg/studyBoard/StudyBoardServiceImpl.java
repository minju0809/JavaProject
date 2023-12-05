package pkg.studyBoard;

import java.util.List;

public class StudyBoardServiceImpl implements StudyBoardService {
	StudyBoardDao dao = null;
	
	public StudyBoardServiceImpl() {
		dao = new StudyBoardDaoImpl();
	}
	
	@Override
	public void StudyBoardInsert(StudyBoardVO vo) {
		dao.StudyBoardInsert(vo);
	}

	@Override
	public List<StudyBoardVO> StudyBoardSelect(StudyBoardVO vo) {
		return dao.StudyBoardSelect(vo);
	}

	@Override
	public StudyBoardVO StudyBoardDetail(String id) {
		return dao.StudyBoardDetail(id);
	}

	@Override
	public void StudyCommentBoardInsert(StudyCommentBoardVO cvo) {
		dao.StudyCommentBoardInsert(cvo);
	}

	@Override
	public List<StudyCommentBoardVO> StudyCommentBoardSelect(String id) {
		return dao.StudyCommentBoardSelect(id);
	}

}
