package day22;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;

public class AttendanceMain {
	static Scanner sc = new Scanner(System.in);
	/* 출석부 관리 프로그램
	 * 1. 학생 등록
	 * 		- 이름과 생년월일
	 * 2. 학생 수정
	 * 		- 이름과 생년월일로 검색해서 이름과 생년월일 수정
	 * 3. 학생 삭제
	 * 		- 이름과 생년월일로 검색해서 삭제
	 * 4. 학생 출결 확인
	 * 		- 이름과 생년월일로 검색해서 해당 학생의 모든 출결을 확인
	 * 		- 2022-11-22 : O
	 * 5. 출석 확인
	 *		- 날짜 입력 : 2022-11-22
	 * 		- 출석 : O, 지각 : /, 조퇴 : \, 결석 : X
	 * 홍길동 출석현황 : X
	 * 고길동 출석현황 : O
	 * 임꺽정 출석현황 : /
	 * 6. 출석 수정
	 * 		- 날짜 입력
	 * 		- 수정할 학생의 이름과 생년월일 입력
	 * 7. 출석 삭제
	 * 		- 날짜 입력하여 해당 날짜 출석 삭제
	 * 8. 날짜별 출석 확인
	 * 		- 날짜 입력하여 해당 날짜의 모든 학생의 출석 여부를 확인
	 * 9. 프로그램 종료 
	 * */
	//학생 클래스(Student) : 이름, 생년월일
	//학생 일지 클래스(StudentLog) : 이름, 생년월일, 출결
	//일지 클래스(Log) : 날짜, 학생일지(이름, 생년월일, 출결)
	//출석부 클래스(Attendance) : 학생들, 일지들
	public static void main(String[] args) {
		
		int menu = -1;
		
		ArrayList<Student>list = new ArrayList<Student>();
		ArrayList<StudentLog>stdLog = new ArrayList<StudentLog>();
		do {
			printMenu();
			menu = sc.nextInt();
			switch(menu) {
			case 1 ://1. 학생 관리
				runMenu(list);
				break;
			case 2 : //2. 출결 관리
				runMenu2(list);
				break;
			case 3 : 
				System.out.println("프로그램을 종료합니다.");
			default :
				System.out.println("잘못된 메뉴입니다.");
			}
			
		}while(menu !=3);
	}
	
	
	private static void runMenu2(ArrayList<Student>list) {
		ArrayList<StudentLog>slog = new ArrayList<StudentLog>();
		ArrayList<Log> log = new ArrayList<Log>();
		printSubMenu2();
		int subMenu = sc.nextInt();
		sc.nextLine();
		switch(subMenu) {
		case 1 : //5. 출석 확인
		 	//날짜 입력 : 2022-11-22
		  	//출석 : O, 지각 : /, 조퇴 : \, 결석 : X
			//홍길동 출석현황 : X
			// 고길동 출석현황 : O
			//임꺽정 출석현황 : /
			;
			System.out.print("날짜 입력 : ");
			String date = sc.nextLine();
			for(Student tmp : list) {
				String name = tmp.getName();
				System.out.print(name+". 출석 : ");
				String state = sc.next();
				slog.add(new StudentLog(tmp, state));
			}
			
			
			//log.add(new Log(list, date));
			System.out.println(log);
			
			break;
		case 2 : //6. 출석 수정
			//날짜 입력
			System.out.print("날짜 입력");
			date = sc.nextLine();
			//수정할 학생의 이름과 생년월일 입력
			for(Log tmp : log) {
				
			}
			break;
		case 3 : //7. 출석 삭제
			//날짜 입력하여 해당 날짜 출석 삭제
			System.out.print("날짜 입력");
			date = sc.nextLine();
			break;
		case 4 : //8. 날짜별 출석 확인
			//날짜 입력하여 해당 날짜의 모든 학생의 출석 여부를 확인
			System.out.print("날짜 입력");
			date = sc.nextLine();
			break;
		default :
			System.out.println("잘못된 메뉴입니다.");
			
		}
		
	}


	private static void printSubMenu2() {
		System.out.println("======학생 관리======");
		System.out.println("1. 출석 확인");
		System.out.println("2. 출석 수정");
		System.out.println("3. 출석 삭제");
		System.out.println("4. 날짜별 출결 확인");
		System.out.println("====================");
		System.out.print("메뉴 선택 : ");
		
	}


	private static void runMenu(ArrayList<Student>list) {
		
		printSubMenu();
		String name,birth;
		int subMenu = sc.nextInt();
		sc.nextLine();
		switch(subMenu) {
		case 1 : //1. 학생 등록
			 //이름과 생년월일
			System.out.print("이름 : ");
			name = sc.nextLine();
			System.out.print("생년월일 : ");
			birth = sc.nextLine();
			list.add(new Student(name, birth));
			
			break;
		case 2 : //2. 학생 수정
			//이름과 생년월일로 검색해서 이름과 생년월일 수정
			if(updateStudent(list)) {
				System.out.println("수정이 완료되었습니다.");
			}else {
				System.out.println("등록된 학생이 없습니다.");
			}
			
			break;
		case 3 : //3. 학생 삭제
			//이름과 생년월일로 검색해서 삭제
			if(deleteStudent(list)) {
				System.out.println("삭제가 완료되었습니다.");
			}else {
				System.out.println("등록된 학생이 없습니다.");
			}
			break;
		case 4 : //4. 학생 출결 확인
			//이름과 생년월일로 검색해서 해당 학생의 모든 출결을 확인
			//2022-11-22 : O
			System.out.print("이름 : ");
			name = sc.nextLine();
			System.out.print("생년월일 : ");
			birth = sc.nextLine();
			
			
			break;
		default :
			System.out.println("잘못된 메뉴입니다.");
			
		}
	}
	private static boolean deleteStudent(ArrayList<Student> list) {
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("생년월일 : ");
		String birthday = sc.nextLine();
		
		if(list == null || list.size() == 0) {
			return false;
		}
		for(Student tmp : list) {
			if(tmp.getName().contains(name)&&tmp.getBirthday().contains(birthday)) {
				list.remove(tmp);
			}
		}
		return true;
	}
	private static boolean updateStudent(ArrayList<Student> list) {
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("생년월일 : ");
		String birthday = sc.nextLine();
		if(list == null || list.size() == 0) {
			return false;
		}
		for(Student tmp : list) {
			if(tmp.getName().contains(name)&&tmp.getBirthday().contains(birthday)) {
				System.out.print("이름 : ");
				name = sc.nextLine();
				System.out.print("생년월일 : ");
				birthday = sc.nextLine();
				tmp.update(name, birthday);
			}
		}	
		return true;
	}


	private static void printSubMenu() {
		System.out.println("======학생 관리======");
		System.out.println("1. 학생 등록");
		System.out.println("2. 학생 수정");
		System.out.println("3. 학생 삭제");
		System.out.println("4. 학생 출결 확인");
		System.out.println("====================");
		System.out.print("메뉴 선택 : ");
	}


	private static void printMenu() {
		System.out.println("==출석부 관리 프로그램==");
		System.out.println("1. 학생 관리");
		System.out.println("2. 출결 관리");
		System.out.println("3. 프로그램 종료");
		System.out.println("====================");
		System.out.print("메뉴 선택 : ");
		
	}

}
