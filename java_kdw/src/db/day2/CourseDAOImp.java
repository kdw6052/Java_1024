package db.day2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CourseDAOImp implements CourseDAO {
	Connection con;
	ResultSet rs;
	Statement stmt;
	PreparedStatement pstmt;
	
	public CourseDAOImp(Connection con)throws SQLException {
		this.con = con;
		if(con != null) {
			stmt = con.createStatement();
		}
	}
	@Override
	public ArrayList<CourseVO> selectAllCourse() throws SQLException {
		if(stmt == null) {
			return null;
		}
		String sql = "select co_num,co_st_num,co_le_num, "
				+ "co_type,co_grade from course";
		ArrayList<CourseVO> list = new ArrayList<CourseVO>();
		rs = stmt.executeQuery(sql);
		while(rs.next()) {
			int co_num = rs.getInt(1);
			String co_st_num = rs.getString(2);
			int co_le_num = rs.getInt(3);
			String co_type = rs.getString(4);
			String co_grade = rs.getString(5);
			list.add(new CourseVO(co_num, co_st_num, co_le_num, co_type, co_grade));
		}
		
		return list;
	}
	@Override
	public CourseVO selectCourseByCo_num(int co_num) throws SQLException {
		if(con == null) {
			return null;
		}
		String sql = "select co_num, co_st_num, co_le_num, co_type, "
				+ "cograde from course where co_num = ?";
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, co_num);
		rs = pstmt.executeQuery();
		if(rs.next()) {
			String co_st_num = rs.getString(2);
			int co_le_num = rs.getInt(3);
			String co_type = rs.getString(4);
			String co_grade = rs.getString(5);
			CourseVO cou = new CourseVO(co_num, co_st_num, 
					co_le_num, co_type, co_grade);
			return cou;
		}
		return null;
	}
	@Override
	public boolean insertCourse(CourseVO cou) {
		String sql = "insert into course values(?,?,?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, cou.getCo_num());
			pstmt.setString(2, cou.getCo_st_num());
			pstmt.setInt(3, cou.getCo_le_num());
			pstmt.setString(4, cou.getCo_type());
			pstmt.setString(5, cou.getCo_grade());
			int count = pstmt.executeUpdate();
			if(count == 0) {
				return false;
			}
		} catch (SQLException e) {
			return false;
		}
		
		return true;
	}
	@Override
	public boolean deleteCourse(int co_num) {
		String sql = "delete from course where co_num = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, co_num);
			int count = pstmt.executeUpdate();
			if(count == 0 ) {
				return false;
			}
		} catch (SQLException e) {
			return false;
		}
		
		return true;
	}
	@Override
	public boolean updateCourse(CourseVO cou, int submenu) {
		String sql = "update course set co_st_num = ?, co_le_num = ?, "
				+ "co_type = ?, co_grade = ? where co_num = ?";
		try {
			CourseVO dbcou = selectCourseByCo_num(cou.getCo_num());
			switch(submenu) {
			case 1 : dbcou.setCo_st_num(cou.getCo_st_num());break;
			case 2 : dbcou.setCo_le_num(cou.getCo_le_num());break;
			case 3 : dbcou.setCo_type(cou.getCo_type());break;
			case 4 : dbcou.setCo_grade(cou.getCo_grade());break;
			default : return false;
			}
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dbcou.getCo_st_num());
			
		} catch (SQLException e) {
			return false;
		}
		return true;
	}

}
