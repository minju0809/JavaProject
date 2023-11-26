package pkg.login;

import java.sql.*;

import pkg.DBConnection;

public class LoginDaoImpl implements LoginDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	@Override
	public String login(LoginVO vo) {
		String login_grade = "";
		try {
			conn = DBConnection.getConnection();
			String login_sql = "select * from member where id=? and password=?";
			pstmt = conn.prepareStatement(login_sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPassword());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				login_grade = rs.getString("grade");
			} else {
				login_grade = "F";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return login_grade;
	}

}
