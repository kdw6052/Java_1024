package day12;

import java.util.Scanner;

public class StudentManagerTest {

	public static void main(String[] args) {
		
		/* 1.프로그램에 필요한 기능을 정리
		 * 메뉴
		 * 1.학생 정보 추가
		 * 2.학생 성적 추가
		 * 3.학생 정보 출력
		 * 2.프로그램 실행 과정은 어떻게 할 건지
		 * 기능
		 *  1. 학생정보 추가
		 *   - 학년, 반, 번호, 이름을 입력하여 학생 정보 추가
		 *   - 학년, 반, 번호가 같은 학생이 이미 있으면 추가하지 않음
		 *  2. 학생 성적 추가
		 *   - 학년, 반, 번호로 학생을 검색 한 후 있으면 성적을 추가
		 *   - 성적 추가시 과목명, 학기, 중간, 기말, 수행 평가를 입력하여 추가한다
		 *   - 이미 추가된 과목(학기랑 과목명이 같으면)이면 추가하지 않음
		 *  3. 학생 정보 출력
		 * 3.정보를 효율적으로 관리하기 위해 클래스를 만들것인가? 만든다면 어떤 클래스를 만들건지
		 *  -학생클래스 HighStudent
		 *  -성적클래스 Score
		 * 4.프로그램 실행 과정을 주석으로 작성
		 * */
		//반복
		int menu;
		HighStudent[] list = new HighStudent[30];
		int count=0;
		do {
			//메뉴출력
			printMenu();
			//메뉴선택
			menu=selectMenu();
			//선택한메뉴에 따른 기능실행
			runMenu(menu,list,count);
		}while(menu!=4);
	}
	public static void runMenu(int menu,HighStudent[]list,int count) {
		int grade,classNum,num;
		String name;
		Scanner sc = new Scanner(System.in);
		count=0;
		switch(menu) {
		case 1 :
			//학생 정보 추가
			System.out.println("학생 정보를 입력하세요 : 학년, 반, 번호, 이름순");
			grade=sc.nextInt();
			classNum = sc.nextInt();
			num=sc.nextInt();
			name = sc.next();
			//학생 정보를 입력(학년,반,번호,이름)
			
			
			//입력한 학생 정보가 없으면 추가
			//학생 정보들 중에서 하나씩 비교하여 학년,반, 번호가 같은 학생이 있는지 확인해서
			//없으면 마지막 학생 뒤에 추가
			for(HighStudent tmp : list) {
				if(tmp==null) {
					break;
				}
				if(tmp.equals(list[count])) {
					System.out.println("이미 등록된 학생입니다.");
					continue;
				}
				list[count]= new HighStudent(grade,classNum,num,name);
			}
			
			count++;
			break;
		case 2 :
			//학생 성적 추가
			//학생 정보를 입력(학년,반,번호)
			System.out.println("성적을 추가할 학생 정보 입력하세요 : 학년, 반, 번호");
			grade=sc.nextInt();
			classNum = sc.nextInt();
			num=sc.nextInt();
			//입력한 학생 정보가 없으면 끝
			//학생 정보들 중에서 하나씩 비교하여 학년,반,번호가 같은 학생이 있는지 확인
			//없으면 조건문 종료
			//성적 정보를 입력(과목, 학기, 중간, 기말, 수행평가)
			System.out.println("성적 정보를 입력하세요.");
			System.out.println("과목 : ");
			String title = sc.next();
			System.out.println("중간 : ");
			int midScore = sc.nextInt();
			System.out.println("기말 : ");
			int finalScore = sc.nextInt();
			System.out.println("수행평가 : ");
			int performace = sc.nextInt();
			//입력한 성적 정보가 없으면 추가
			//선택한 학생의 성적 정보들 중에서 과목, 학기가 같은 성적 정보가 없으면 추가
			break;
		case 3 :
			//학생 정보 출력
			for(int i = 0;i<list.length;i++) {
				System.out.println(list[i]);
				System.out.println("-------------");
			}
			//저장된 학생 정보를 출력
			break;
		case 4 :
			System.out.println("프로그램을 종료합니다");
			break;
		default :
			System.out.println("잘못된 입력입니다.");
			break;
		}
	}
	public static void printMenu() {
		System.out.println("=====메뉴=====");
		System.out.println("1.학생 정보 추가");
		System.out.println("2.학생 성적 추가");
		System.out.println("3.학생 정보 출력");
		System.out.println("4.프로그램 종료");
		System.out.println("=============");
		System.out.print("메뉴 선택 : ");
	}
	public static int selectMenu() {
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}
}

class HighStudent {
	public int grade,classNum,num;
	public String name;
	public void print() {
		System.out.println(grade+"학년 "+classNum+"반 "+num+"번 "+name);
	}
	
	

	public HighStudent(int grade, int classNum, int num, String name) {
		this.grade = grade;
		this.classNum = classNum;
		this.num = num;
		this.name = name;
	}
	
}
class Score{
	public int kor,eng,math;
}