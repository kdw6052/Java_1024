package example.db.dao;

import java.util.ArrayList;

import example.db.vo.StudentVO;

public interface StudentDAO {

	int insertStudents(StudentVO std);

	int updateStudents(StudentVO std);

	ArrayList<StudentVO> selectAllStudents();

	ArrayList<StudentVO> selectStudentName(String st_name);

	StudentVO selectStudent(String st_num);

}
