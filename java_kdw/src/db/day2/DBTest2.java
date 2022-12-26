package db.day2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import lombok.Data;

public class DBTest2 {

	Connection con;
	ResultSet rs;
	Statement stmt;
	PreparedStatement pstmt;
	
	public static void main(String[] args) {
		DBTest2 dbTest2 = new DBTest2();
		ArrayList<CourseVO> list = new ArrayList<CourseVO>();
		
		CourseDAOImp courseDao = null;
		

		try {
			String ur1 = "jdbc:mysql://localhost/university";
			String id = "root" , pw = "root";
			dbTest2.connect(ur1,id,pw);
			
			courseDao = new CourseDAOImp(dbTest2.con);
			list = courseDao.selectAllCourse();
			System.out.println(list);
		} catch (SQLException e) {
			System.out.println("연결실패");
		}finally {
			dbTest2.closeConnect();
		}
		System.out.println("연결성공");
		
	}
	public void connect(String ur1, String id, String pw)throws SQLException {
		con = DriverManager.getConnection(ur1, id, pw);
		stmt = con.createStatement();
	}
	public void closeConnect() {
		try {
			if( con != null && !con.isClosed()) {
				con.close();
			}
			if( stmt != null && !stmt.isClosed()) {
				stmt.close();
			}
			if( rs != null && !rs.isClosed()) {
				rs.close();
			}
			if( pstmt != null && !pstmt.isClosed()) {
				pstmt.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
@Data
class CourseVO{
	int co_num;
	String co_st_num;
	int co_le_num;
	String co_type;
	String co_grade;
	
	public CourseVO(int co_num, String co_st_num, int co_le_num, String co_type, String co_grade) {
		this.co_num = co_num;
		this.co_st_num = co_st_num;
		this.co_le_num = co_le_num;
		this.co_type = co_type;
		this.co_grade = co_grade;
	
	}

	@Override
	public String toString() {
		return "[수강번호 : " + co_num + ", 학생번호 : " + co_st_num + ", 교수번호 : " + co_le_num + ", 종류"
				+ co_type + ", 학점 : " + co_grade + "]";
	}
	
}