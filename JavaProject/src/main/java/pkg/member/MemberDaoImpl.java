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
		try {
			conn = DBConnection.getConnection();
			String insert_sql = "insert into member (memberCount, id, password, age, phone, area, desired_field, study_period, photo) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(insert_sql);
			pstmt.setInt(1, vo.getMemberCount());
			pstmt.setString(2, vo.getId());
			pstmt.setString(3, vo.getPassword());
			pstmt.setString(4, vo.getAge());
			pstmt.setString(5, vo.getPhone());
			pstmt.setString(6, vo.getArea());
			pstmt.setString(7, vo.getDesired_field());
			pstmt.setString(8, vo.getStudy_period());
			pstmt.setString(9, vo.getPhoto());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	public int memberCount() {
		int memberCount = 1;
		try {
			conn = DBConnection.getConnection();
			String select_sql = "select max(memberCount)+1 as memberCount from member";
			pstmt = conn.prepareStatement(select_sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				memberCount = rs.getInt("memberCount");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return memberCount;
	}

	@Override
	public List<MemberVO> select(MemberVO vo) {
		System.out.println("select 확인");
		List<MemberVO> li = new ArrayList<>();
		try {
			conn = DBConnection.getConnection();
			String select_sql = "select * from member order by memberCount desc";
			pstmt = conn.prepareStatement(select_sql);
			rs = pstmt.executeQuery();
			MemberVO memberVO = null;
			while(rs.next()) {
				memberVO = new MemberVO();
				memberVO.setMemberCount(rs.getInt("memberCount"));
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
				System.out.println("@@@ vo: "+memberVO);
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
