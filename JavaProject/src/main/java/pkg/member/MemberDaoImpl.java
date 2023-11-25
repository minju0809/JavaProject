package pkg.member;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import pkg.DBConnection;

public class MemberDaoImpl implements MemberDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	@Override
	public void insert(MemberVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(MemberVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(MemberVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<MemberVO> select(MemberVO vo) {
		System.out.println("select 확인");
		List<MemberVO> li = new ArrayList<>();
		try {
			conn = DBConnection.getConnection();
			String select_sql = "select * from member";
			pstmt = conn.prepareStatement(select_sql);
			rs = pstmt.executeQuery();
			MemberVO memberVO = null;
			while(rs.next()) {
				memberVO = new MemberVO();
				memberVO.setId(rs.getString("id"));
				memberVO.setPassword(rs.getString("password"));
				memberVO.setAge(rs.getString("age"));
				memberVO.setPhone(rs.getString("phone"));
				memberVO.setArea(rs.getString("area"));
				memberVO.setDesired_field(rs.getString("desired_field"));
				memberVO.setStudy_period(rs.getString("study_period"));
				memberVO.setPhoto(rs.getString("photo"));
				memberVO.setGrade(rs.getString("grade"));
				memberVO.setJoin_date(rs.getString("join_date"));
				li.add(memberVO);
				System.out.println("@@@ li: "+li);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return li;
	}

	@Override
	public MemberVO edit(MemberVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

}
