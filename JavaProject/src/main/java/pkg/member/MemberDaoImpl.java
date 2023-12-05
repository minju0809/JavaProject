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
	public boolean isIdDuplicated(String id) {
		try {
			conn = DBConnection.getConnection();
			String select_sql = "select count(*) as count from member where id = ?";
			pstmt = conn.prepareStatement(select_sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				int count = rs.getInt("count");
				return count > 0; // count가 0보다 크면 이미 존재하는 것으로 판단
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(rs, pstmt, conn);
		}
		return false;
	}

	@Override
	public void insert(MemberVO vo) {
		try {
			conn = DBConnection.getConnection();
			String insert_sql = "insert into member (memberCount, id, password, age, phone, region, desired_field, study_period) "
					+ " values (?, ?, ?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(insert_sql);
			pstmt.setInt(1, vo.getMemberCount());
			pstmt.setString(2, vo.getId());
			pstmt.setString(3, vo.getPassword());
			pstmt.setString(4, vo.getAge());
			pstmt.setString(5, vo.getPhone());
			pstmt.setString(6, vo.getRegion());
			pstmt.setString(7, vo.getDesired_field());
			pstmt.setString(8, vo.getStudy_period());
			pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(pstmt, conn);
		}
	}

	@Override
	public void update(MemberVO vo) {
		try {
		    conn = DBConnection.getConnection();
		    String update_sql;
		        update_sql = "UPDATE member SET password=?, age=?, phone=?, region=?, desired_field=?, study_period=? WHERE id=?";
		        pstmt = conn.prepareStatement(update_sql);

		        pstmt.setString(1, vo.getPassword());
		        pstmt.setString(2, vo.getAge());
		        pstmt.setString(3, vo.getPhone());
		        pstmt.setString(4, vo.getRegion());
		        pstmt.setString(5, vo.getDesired_field());
		        pstmt.setString(6, vo.getStudy_period());
		        pstmt.setString(7, vo.getId());
		        pstmt.executeUpdate();

		} catch (Exception e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		} finally {
		    DBConnection.close(pstmt, conn);
		}
	}

	@Override
	public void delete(String id) {
		try {
			conn = DBConnection.getConnection();
			String delete_sql = "delete from member where id=?";
			pstmt = conn.prepareStatement(delete_sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(pstmt, conn);
		}
	}

//	@Override
//	public String selectFileName(String id) {
//		String photo = null;
//		try {
//			conn = DBConnection.getConnection();
//			String SQL = "select photo from member where id=?";
//			pstmt = conn.prepareStatement(SQL);
//			pstmt.setString(1, id);
//			rs = pstmt.executeQuery();
//
//			rs.next();
//			photo = rs.getString("photo");
//
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return photo;
//	}

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
		} finally {
			DBConnection.close(rs, pstmt, conn);
		}
		return memberCount;
	}

	@Override
	public List<MemberVO> select(MemberVO vo) {
		List<MemberVO> li = new ArrayList<>();
		try {
			conn = DBConnection.getConnection();
			String select_sql = "select * from member order by memberCount desc";
			pstmt = conn.prepareStatement(select_sql);
			rs = pstmt.executeQuery();
			MemberVO memberVO = null;
			while (rs.next()) {
				memberVO = new MemberVO();
				memberVO.setMemberCount(rs.getInt("memberCount"));
				memberVO.setId(rs.getString("id"));
				memberVO.setPassword(rs.getString("password"));
				memberVO.setAge(rs.getString("age"));
				memberVO.setPhone(rs.getString("phone"));
				memberVO.setRegion(rs.getString("region"));
				memberVO.setDesired_field(rs.getString("desired_field"));
				memberVO.setStudy_period(rs.getString("study_period"));
				memberVO.setGrade(rs.getString("grade"));
				memberVO.setJoin_date(rs.getString("join_date"));
				li.add(memberVO);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(rs, pstmt, conn);
		}

		return li;
	}

	@Override
	public MemberVO edit(String id) {
		MemberVO m = null;
		try {
			conn = DBConnection.getConnection();
			String edit_sql = "select * from member where id=?";
			pstmt = conn.prepareStatement(edit_sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				m = new MemberVO();
				m.setMemberCount(rs.getInt("memberCount"));
				m.setId(rs.getString("id"));
				m.setPassword(rs.getString("password"));
				m.setAge(rs.getString("age"));
				m.setPhone(rs.getString("phone"));
				m.setRegion(rs.getString("region"));
				m.setDesired_field(rs.getString("desired_field"));
				m.setStudy_period(rs.getString("study_period"));
				m.setGrade(rs.getString("grade"));
				m.setJoin_date(rs.getString("join_date"));
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(rs, pstmt, conn);
		}
		return m;
	}
}
