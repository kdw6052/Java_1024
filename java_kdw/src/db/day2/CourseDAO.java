package db.day2;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CourseDAO {
	ArrayList<CourseVO> selectAllCourse() throws SQLException;
	CourseVO selectCourseByCo_num(int co_num) throws SQLException;
	boolean insertCourse(CourseVO cou);
	boolean deleteCourse(int co_num);
	boolean updateCourse(CourseVO cou, int submenu);
	
}
