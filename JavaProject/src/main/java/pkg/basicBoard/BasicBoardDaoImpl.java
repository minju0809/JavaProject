package pkg.basicBoard;

import java.sql.*;

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

}
