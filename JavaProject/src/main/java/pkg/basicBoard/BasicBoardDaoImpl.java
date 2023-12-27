package pkg.basicBoard;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import pkg.DBConnection;

public class BasicBoardDaoImpl implements BasicBoardDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	@Override
	public void insert(BasicBoardVO vo) {
		try {
			conn = DBConnection.getConnection();
			String SQL = "insert into basicBoard (boardNumber, id, title, content, cnt) "
					+ " values (basicBoard_sequence.nextval, ?, ?, ?, 0)";
			pstmt = conn.prepareCall(SQL);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<BasicBoardVO> getBoardList() {
		List<BasicBoardVO> li = new ArrayList<>();
		try {
			conn = DBConnection.getConnection();
			String SQL = "select * from basicBoard order by boardNumber desc";
			pstmt = conn.prepareCall(SQL);
			rs = pstmt.executeQuery();
			
			BasicBoardVO m = null;
			while(rs.next()) {
				m = new BasicBoardVO();
				m.setBoardNumber(rs.getInt("boardNumber"));
				m.setId(rs.getString("id"));
				m.setTitle(rs.getString("title"));
				m.setContent(rs.getString("content"));
				m.setRegist_date(rs.getString("regist_date"));
				m.setCnt(rs.getInt("cnt"));
				li.add(m);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public void delete(int boardNumber) {
		try {
			conn = DBConnection.getConnection();
			String SQL = "delete from basicBoard where boardNumber = ?";
			pstmt = conn.prepareCall(SQL);
			pstmt.setInt(1, boardNumber);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	@Override
	public BasicBoardVO getBoard(int boardNumber) {
		BasicBoardVO vo = null;
		try {
			conn = DBConnection.getConnection();
			String SQL = "select * from basicBoard where boardNumber = ?";
			pstmt = conn.prepareCall(SQL);
			pstmt.setInt(1, boardNumber);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo = new BasicBoardVO();
				vo.setBoardNumber(rs.getInt("boardNumber"));
				vo.setId(rs.getString("id"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setRegist_date(rs.getString("regist_date"));
				vo.setCnt(rs.getInt("cnt"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public void update(BasicBoardVO vo) {
		try {
			conn = DBConnection.getConnection();
			String SQL = "update basicBoard set title=?, content=? where boardNumber = ?";
			pstmt = conn.prepareCall(SQL);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(3, vo.getBoardNumber());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void cntUpdate(int boardNumber) {
		try {
			conn = DBConnection.getConnection();
			String SQL = "update basicBoard set cnt = cnt + 1 where boardNumber = ?";
			pstmt = conn.prepareCall(SQL);
			pstmt.setInt(1, boardNumber);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
