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
	public List<BasicBoardVO> select() {
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

}
