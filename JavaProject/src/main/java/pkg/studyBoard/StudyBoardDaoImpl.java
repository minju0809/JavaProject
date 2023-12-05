package pkg.studyBoard;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import pkg.DBConnection;

public class StudyBoardDaoImpl implements StudyBoardDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	@Override
	public void StudyBoardInsert(StudyBoardVO vo) {
		
		try {
			conn = DBConnection.getConnection();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(pstmt, conn);
		}
	}

	@Override
	public List<StudyBoardVO> StudyBoardSelect(StudyBoardVO vo) {
		List<StudyBoardVO> li = new ArrayList<>();
		String sql = "";
		try {
			conn = DBConnection.getConnection();
			sql = "select * from study_board order by study_board_number desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			StudyBoardVO m = null;
			while (rs.next()) {
				m = new StudyBoardVO();
				m.setStudy_board_number(rs.getInt("study_board_number"));
				m.setId(rs.getString("id"));
				m.setStudy_board_title(rs.getString("study_board_title"));
				m.setStudy_board_content(rs.getString("study_board_content"));
				li.add(m);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(rs, pstmt, conn);
		}
		return li;
	}

	@Override
	public StudyBoardVO StudyBoardDetail(String id) {
		StudyBoardVO m = null;
		String sql = "";
		try {
			conn = DBConnection.getConnection();
			sql = "select * from study_board where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				m = new StudyBoardVO();
				m.setStudy_board_number(rs.getInt("study_board_number"));
				m.setId(rs.getString("id"));
				m.setStudy_board_title(rs.getString("study_board_title"));
				m.setStudy_board_content(rs.getString("study_board_content"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(rs, pstmt, conn);
		}
		return m;
	}

	@Override
	public void StudyCommentBoardInsert(StudyCommentBoardVO cvo) {
		String sql = "";
		try {
			conn = DBConnection.getConnection();
			sql = "insert into study_comment_board (study_comment_board_number,id,study_comment_id,study_comment_content) values (study_board_comment_sequence,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cvo.getId());
			pstmt.setString(2, cvo.getStudy_comment_id());
			pstmt.setString(3, cvo.getStudy_comment_content());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(rs, pstmt, conn);
		}
	}

	@Override
	public List<StudyCommentBoardVO> StudyCommentBoardSelect(String id) {
		List<StudyCommentBoardVO> commentList = new ArrayList<>();
		String sql = "";
		try {
			conn = DBConnection.getConnection();
			sql = "select * from study_comment_board order by study_comment_board_number desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			StudyCommentBoardVO m = null;
			while (rs.next()) {
				m = new StudyCommentBoardVO();
				m.setStudy_comment_board_number(rs.getInt("study_comment_board_number"));
				m.setId(rs.getString("id"));
				m.setStudy_comment_id(rs.getString("study_comment_id"));
				m.setStudy_comment_content(rs.getString("study_comment_content"));
				commentList.add(m);
				System.out.println("dao commentList: " + commentList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(rs, pstmt, conn);
		}
		return commentList;
	}

}
