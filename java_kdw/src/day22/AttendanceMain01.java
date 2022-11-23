package day22;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.function.Predicate;

public class AttendanceMain01 {
	private static Scanner sc = new Scanner(System.in);
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
	 * 
	 * 학생 클래스(Student) : 이름, 생년월일
	 * 학생 일지 클래스(StudentLog) : 이름, 생년월일, 출결
	 * 일지 클래스(Log) : 날짜, 학생일지(이름, 생년월일, 출결)
	 * 출석부 클래스(Attendance) : 학생들, 일지들*/
	public static void main(String[] args) {
		
		int menu = -1;
		Attendance attendance = new Attendance();
		
		do {
			try {
				printMenu();
				menu = sc.nextInt();
				sc.nextLine();
				printBar();
				runMenu(menu, attendance);
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}while(menu !=3);
	}
	private static void printBar() {
		System.out.println("=================");
	}
	
	private static void printStr(String str) {
		System.out.println(str);{
			printBar();
		}
	}
	
	private static void printMenu() {
		System.out.println("=======메뉴=======");
		System.out.println("1. 학생 관리");
		System.out.println("2. 출석 관리");
		System.out.println("3. 프로그램 종료");
		System.out.println("=================");
		System.out.print("메뉴 선택 : ");
		
	}
	
	private static void printSubMenu(int menu) {
		switch(menu) {
		case 1 : 
			System.out.println("===학생 관리 메뉴===");
			System.out.println("1. 학생 추가");
			System.out.println("2. 학생 수정");
			System.out.println("3. 학생 삭제");
			System.out.println("4. 취소");
			System.out.println("=================");
			System.out.print("메뉴 선택 : ");
			break;
		case 2 : 
			System.out.println("===출석 관리 메뉴===");
			System.out.println("1. 출석 체크 - 전체");
			System.out.println("2. 출석 확인 - 개별");
			System.out.println("3. 출석 확인 - 날짜별");
			System.out.println("4. 출석 수정");
			System.out.println("5. 출석 삭제");
			System.out.println("6. 취소");
			System.out.println("=================");
			System.out.print("메뉴 선택 : ");
			break;
		default :
			printStr("잘못된 메뉴입니다.");
		}
	}
	
	private static void runMenu(int menu, Attendance attendance) {
		ArrayList<Student> stds = attendance.getStds();
		ArrayList<Log>logs = attendance.getLogs();
		switch(menu) {
		case 1 ://1. 학생 관리
			managementStudents(stds);
			break;
		case 2 ://2. 출석관리
			managementLogs(logs, stds);
			break;
		case 3 :
			printStr("프로그램을 종료합니다.");
			break;
		default : 
			printStr("잘못된 메뉴입니다.");
		}
		
	}
	
	private static void managementStudents(ArrayList<Student> stds) {
		printSubMenu(1);
		int subMenu = sc.nextInt();
		sc.nextLine();
		printBar();
		switch(subMenu) {
		case 1 ://학생 추가
			addStudent(stds);
			break;
		case 2 ://학생 수정
			updateStudent(stds);
			break;
		case 3 ://학생 삭제
			deleteStudent(stds);
			break;
		case 4 ://취소
			printStr("취소했습니다");
			break;
		default :
			printStr("메뉴를 잘못입력했습니다.");
		}
	}
	
	private static void addStudent(ArrayList<Student> stds) {
		if(stds == null)
			throw new RuntimeException("예외발생 : 학생 정보를 관리하는 리스트가 없습니다.");
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("생년월일 : ");
		String birthday = sc.nextLine();
		Student std = new Student(name, birthday);
		if(stds.indexOf(std) != -1) {
			printStr("학생 정보를 추가하지 못했습니다.");
			return;
		}
		stds.add(std);
		printStr("학생 정보를 추가했습니다.");
	}
	
	private static void updateStudent(ArrayList<Student> stds) {
		if(stds == null)
			throw new RuntimeException("예외발생 : 학생 정보를 관리하는 리스트가 없습니다.");
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("생년월일 : ");
		String birthday = sc.nextLine();
		Student std = new Student(name, birthday);
		int index = stds.indexOf(std);
		if(index == -1) {
			printStr("입력 정보와 일치하는 학생이 없습니다.");
			return;
		}
		System.out.print("수정할 이름 : ");
		name = sc.nextLine();
		System.out.print("수정할 생년월일 : ");
		birthday = sc.nextLine();
		
		std = new Student(name, birthday);
		stds.set(index, std);
		printStr("학생 정보를 수정했습니다.");
		
	}

	private static void deleteStudent(ArrayList<Student> stds) {
		if(stds == null)
			throw new RuntimeException("예외발생 : 학생 정보를 관리하는 리스트가 없습니다.");
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("생년월일 : ");
		String birthday = sc.nextLine();
		Student std = new Student(name, birthday);
		int index = stds.indexOf(std);
		if(index == -1) {
			printStr("입력 정보와 일치하는 학생이 없습니다.");
			return;
		}
		stds.remove(index);
		printStr("학생 정보를 삭제했습니다.");
	}
	
	private static void managementLogs(ArrayList<Log> logs, ArrayList<Student> stds) {
		printSubMenu(2);
		int subMenu = sc.nextInt();
		sc.nextLine();
		printBar();
		switch(subMenu){
		case 1://1. 출석 체크 - 전체
			checkLog(logs,stds);
			sortLogs(logs);//일지 정렬
			break;
		case 2://2. 출석 확인 - 개별
			printLogsByStudent(logs);
			break;
		case 3://3. 출석 확인 - 날짜별
			printLogsByDate(logs);
			break;
		case 4://4. 출석 수정
			updateLogs(logs);
			
			break;
		case 5://5. 출석 삭제
			deleteLogs(logs);
			break;
		case 6://취소
			printStr("취소합니다.");
			break;
		default :
			printStr("잘못된 메뉴입니다.");
		}
	}
	
	private static void checkLog(ArrayList<Log> logs, ArrayList<Student> stds) {
		//날짜 입력 : 2022-11-22
		System.out.print("출석 일자(예:yyyy.MM.dd) : ");
		String date = sc.nextLine();
		printBar();
		//이미 입력된 날짜인지 확인
		if(checkLogDate(logs,date)) {
			printStr("이미 출석 체크한 일자입니다.");
			return;
		}
		//출석 상태 정보 출력(결석 : X, 출석 : O, 지각 : /, 조퇴 : \)
		printStr("결석 : X, 출석 : O, 지각 : /, 조퇴 : \\");
		//StudentLog를 리스트로 생성
		ArrayList<StudentLog>stdLogs = new ArrayList<StudentLog>();
		//반복 
		for(Student std : stds) {
			//학생 이름과 생일 출력
			System.out.print(std.getName()+"("+std.getBirthday()+") : ");
			//출석 상태 입력
			String state = sc.nextLine();
			//StudentLog를 생성
			StudentLog stdlog = new StudentLog(std, state);
			//StudentLog 리스트에 추가
			stdLogs.add(stdlog);
		}
		//StudentLog 리스트와 날짜를 이용하여 Log객체를 생성
		Log log = new Log(stdLogs, date);
		//Log 리스트에 생성된 Log객체를 추가
		logs.add(log);
	}
	
	private static boolean checkLogDate(ArrayList<Log> logs,String date) {
		if(logs == null || date==null) 
			throw new RuntimeException("일지 리스트가 없거나 날짜가 없습니다.");
		if(logs.size() ==0)
			return false;
		for(Log log : logs) {
			if(log.getDate().equals(date))
				return true;
		}
		return false;
	}

	private static void sortLogs(ArrayList<Log> logs) {
		if(logs == null || logs.size() == 0 )
			return;
		Collections.sort(logs, (o1,o2)-> o1.getDate().compareTo(o2.getDate()));
	}

	private static void printLogsByStudent(ArrayList<Log> logs) {
		if(logs == null || logs.size() == 0) {
			printStr("등록된 출석체크가 없습니다.");
			return;
		}
		//이름 입력
		System.out.print("확인할 학생 이름 : ");
		String name = sc.nextLine();
		printBar();
		//입력받은 이름과 일치하는 출석체크 목록을 확인
		//2022.11.23 : O
		for(Log log : logs) {
			for(StudentLog slog : log.getSlogs()) {
				if(slog.getStd().getName().equals(name)) {
					System.out.println(log.getDate()+ " : "+ slog.getState());
				}else{
					printStr("일치하는 학생이 없습니다.");
				}
			}
		}
	}

	private static void printLogsByDate(ArrayList<Log> logs) {
		if(logs == null || logs.size() == 0) {
			printStr("등록된 출석체크가 없습니다.");
			return;
		}
		//날짜 입력
		System.out.print("확인할 날짜 : ");
		String date = sc.nextLine();
		printBar();
		
		//날짜와 일치하는 출석 기록 확인
		//학생명(생일) : O
		for(Log log : logs) {
			if(log.getDate().equals(date)) {
				for(StudentLog slog : log.getSlogs()) {
					String name = slog.getStd().getName();
					String birth = slog.getStd().getBirthday();
					System.out.println(name+"("+birth+") : "+slog.getState());
				}
			}else {
				printStr("등록된 출석체크가 없습니다.");
			}
		}
	}
	
	private static void updateLogs(ArrayList<Log> logs) {
		//날짜를 입력
		System.out.print("날짜 : ");
		String date = sc.nextLine();
		printBar();
		
		if(!checkLogDate(logs, date)) {
			printStr("해당 일자에 등록된 출석체크가 없습니다.");
			return;
		}
		//이름과 생년월일을 입력
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("생년월일 : ");
		String birth = sc.nextLine();
		//상태를 입력
		System.out.print("출석상태 : ");
		String state = sc.nextLine();
		printBar();
		//입력한 정보와 일치하는 출석 정보를 수정
		for(Log log : logs) {
			if(log.getDate().equals(date)) {
				for(StudentLog slog : log.getSlogs()) {
					String tmpName = slog.getStd().getName();
					String tmpBirth = slog.getStd().getBirthday();
					if(tmpName.equals(name) && tmpBirth.equals(birth)) {
						slog.setState(state);
					}
				}
				printStr("수정이 완료됐습니다.");
				return;
			}
		}
	}
	
	private static void deleteLogs(ArrayList<Log> logs) {
		//날짜를 입력
		System.out.print("날짜 : ");
		String date = sc.nextLine();
		printBar();
		
		if(!checkLogDate(logs, date)) {
			printStr("해당 일자에 등록된 출석체크가 없습니다.");
			return;
		}
		for(int i =0 ; i<logs.size();i++) {
			if(logs.get(i).getDate().equals(date)) {
				logs.remove(i);
				printStr("삭제가 완료됐습니다.");
				return;
			}
		}
	}
	
}
