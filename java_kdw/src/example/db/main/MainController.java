package example.db.main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;

import example.db.dao.StudentDAO;
import example.db.vo.StudentVO;

public class MainController {

	private SqlSession session;
	private StudentDAO studentDao;
	private ArrayList<StudentVO> list;
	private Scanner sc;
	
	public MainController(SqlSession session) {
		this.session = session;
		studentDao = session.getMapper(StudentDAO.class);
		sc = new Scanner(System.in); 
	}

	public void run() {
		/* 학생 추가
		 * 학생 수정
		 * 학생 조회
		 * 프로그램 종료
		 * */
		int menu = -1;
		do {
			try {
				printMenu();
				menu = sc.nextInt();
				sc.nextLine();
				runMenu(menu);
			}catch(InputMismatchException e) {
				System.out.println("잘못된 타입을 입력");
				sc.nextLine();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}while(menu != 4);
	}

	private void runMenu(int menu) {
		switch(menu) {
		case 1 : 
			insertStudent();
			break;
		case 2 : 
			updateStudent();
			break;
		case 3 : 
			selectStudent();
			break;
		case 4 :
			System.out.println("프로그램 종료");
			break;
		default : 
			System.out.println("잘못된 입력입니다.");
		}
		
	}

	private void selectStudent() {
		ArrayList<StudentVO> list = studentDao.selectAllStudents();
		int submenu = -1;
		printSubmenu();
		submenu = sc.nextInt();
		sc.nextLine();
		switch(submenu) {
		case 1 :
			System.out.print("학번 : ");
			String st_num = sc.nextLine();
			StudentVO std = studentDao.selectStudent(st_num);
			System.out.println(std);
			if(std == null) {
				System.out.println("검색 결과가 없습니다.");
				return;
			}
			break;
		case 2 :
			System.out.print("이름 : ");
			String st_name = sc.nextLine();
			ArrayList<StudentVO> list2 = studentDao.selectStudentName(st_name);
			System.out.println(list2);
			if(list2.size() == 0) {
				System.out.println("검색 결과가 없습니다.");
				return;
			}
			break;
		case 3 :
			if(list.size() == 0) {
				System.out.println("검색 결과가 없습니다.");
				return;
			}
			for(StudentVO tmp : list) {
				System.out.println(tmp);
			}
			break;
		case 4 :
			System.out.println("취소합니다");
			break;
		default : 
			System.out.println("잘못된 입력입니다.");
		}
	}
	private void selectAllStudent() {
		
		if(list.size() == 0) {
			System.out.println("검색 결과가 없습니다.");
			return;
		}
		for(StudentVO tmp : list) {
			System.out.println(tmp);
		}
	}
	private void updateStudent() {
		System.out.print("수정할 학생의 학번 : ");
		String st_num = sc.nextLine();
		System.out.print("학기 : ");
		int st_semester = sc.nextInt();
		sc.nextLine();
		System.out.print("상태(재학/휴학/자퇴/퇴학/졸업/수료) : ");
		String st_state = sc.nextLine();
		
		StudentVO std = studentDao.selectStudent(st_num);
		if(std == null) {
			System.out.println("학생 수정 실패");
			return;
		}
		std.setSt_semester(st_semester);
		std.setSt_state(st_state);
		
		if(studentDao.updateStudents(std) != 0) {
			System.out.println("학생 수정 성공");
			session.commit();
		}else {
			System.out.println("학생 수정 실패");
		}
		
	}

	private void insertStudent() {
		System.out.print("학번 : ");
		String st_num = sc.nextLine();
		System.out.print("이름 : ");
		String st_name = sc.nextLine();
		System.out.print("학기 : ");
		int st_semester = sc.nextInt();
		sc.nextLine();
		System.out.print("상태(재학/휴학/자퇴/퇴학/졸업/수료) : ");
		String st_state = sc.nextLine();
		System.out.print("교수번호 : ");
		String st_pr_num = sc.nextLine();
		StudentVO std = new StudentVO(st_num,st_name,st_semester,st_state,st_pr_num);
		if(studentDao.insertStudents(std) != 0) {
			System.out.println("학생 추가 성공");
			session.commit();
		}else {
			System.out.println("학생 추가 실패");
		}
		
	}
	private void printSubmenu() {
		System.out.println("조회 메뉴");
		System.out.println("1. 학번으로 조회");
		System.out.println("2. 이름으로 조회");
		System.out.println("3. 전체 조회");
		System.out.println("4. 취소");
		System.out.print("메뉴 선택 : ");
		
	}

	private void printMenu() {
		System.out.println("메뉴");
		System.out.println("1. 학생 추가");
		System.out.println("2. 학생 수정");
		System.out.println("3. 학생 조회");
		System.out.println("4. 프로그램 종료");
		System.out.print("메뉴 선택 : ");
		
	}

}
