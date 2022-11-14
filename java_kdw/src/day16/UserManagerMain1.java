package day16;

import java.util.ArrayList;
import java.util.Scanner;

public class UserManagerMain1 {

	public static void main(String[] args) {
		/* 회원정보를 관리하는 프로그램을 작성하세요.
		 * - 회원정보는 아이디, 비번, 이름, 나이, 주민번호
		 * - 기능1 : 회원 추가
		 * - 기능2 : 회원 검색
		 * - 기능3 : 회원 정보 수정
		 * - 기능4 : 회원 삭제
		 * */
		Scanner sc = new Scanner(System.in);
		int menu = -1;
		ArrayList<Member1> list = new ArrayList<Member1>();//회원 리스트
		do {
			//메뉴 출력
			printmenu();
			//메뉴 선택(입력)
			menu = sc.nextInt();
			//선택된 메뉴에 따른 기능 실행
			runMenu(list,menu);
		}while(menu != 5);
		
	}

	private static void runMenu(ArrayList<Member1> list, int menu) {
		Scanner sc= new Scanner(System.in);
		switch(menu) {
		case 1 :
			if(addMember(list)) {
				printStr("입력한 회원 정보를 추가했습니다");
			}else {
				printStr("입력한 아이디가 이미 존재합니다");
			}
			break;
		case 2 :
			Member1 searchTmp = searchMember(list);
			if(searchTmp==null) {
				printStr("아이디 또는 비밀번호가 잘못됐습니다.");
			}else {
				System.out.println(searchTmp);
			}
			break;
		case 3 :
			//수정할 회원 아이디와 비번을 입력하여 일치하는 회원 정보를 가져옴
			Member1 updateTmp = searchMember(list);
			//일치하지 않으면 건너뜀
			if(!updateMember(list,updateTmp)) {
				printStr("아이디 또는 비밀번호가 잘못됐습니다.");
			}else {
				printStr("회원정보 수정이 완료됐습니다.");
			}
			
			break;
		case 4 :
			//삭제할 회원 아이디와 비번을 입력하여 일치하는 회원 정보를 가져옴
			Member1 deleteTmp = searchMember(list);
			//일치하는 회원 정보가 있으면 삭제
			if(list.remove(deleteTmp)) {
				printStr("삭제가 완료됐습니다.");;
			}else {
				printStr("아이디 또는 비밀번호가 잘못됐습니다.");
			}
			break;
		case 5 : 
			System.out.println("프로그램 종료");
			break;
		default :
			System.out.println("잘못된 메뉴");//예외처리
		}
	}

	/*private static boolean retouchMember(ArrayList<Member1> list) {
		Scanner sc = new Scanner(System.in);
		System.out.println("수정할 회원 정보를 입력하세요.");
		System.out.print("아이디 : ");
		//아이디 입력
		String id = sc.next();
		//비밀번호 입력
		System.out.print("비밀번호 : ");
		String pw = sc.next();
		Member1 member = new Member1(id, pw);
		//같은 아이디를 찾음
		int index = list.indexOf(member);
		Member1 tmp = list.get(index);
		//같은 비밀번호 찾기
		if(!tmp.getPw().equals(member.getPw())) {
			return false;
		}
		System.out.println("수정할 회원정보를 입력하세요.");
		System.out.print("비밀번호 : ");
		String pw2 = sc.next();
		System.out.print("이름 : ");
		String name = sc.next();
		System.out.print("주민등록번호 : ");
		String residentNumber = sc.next();
		System.out.print("나이 : ");
		int age = sc.nextInt();
		Member1 tmp2 = new Member1(id, pw2, name, residentNumber, age);
		list.set(index, tmp2);
		return true;
		
	}*/

	/*private static boolean deleteMember(ArrayList<Member1> list) {
		Scanner sc = new Scanner(System.in);
		//아이디 비밀번호 입력
		System.out.println("삭제할 회원 정보를 입력하세요.");
		System.out.print("아이디 : ");
		String id= sc.next();
		System.out.print("비밀번호 : ");
		String pw = sc.next();
		//같은 아이디,비밀번호 찾기
		Member1 member = new Member1(id, pw);
		int index = list.indexOf(member);
		Member1 tmp = list.get(index);
		if(!tmp.getPw().equals(member.getPw())) {
			return false;
		}
		list.remove(index);
		//삭제완료 출력
		return true;
		
	}*/

	public static void printmenu() {
		System.out.println("-----메뉴-----");
		System.out.println("1. 회원 추가");
		System.out.println("2. 회원 검색");
		System.out.println("3. 회원 정보 수정");
		System.out.println("4. 회원 삭제");
		System.out.println("5. 종료");
		System.out.println("-------------");
		System.out.print("메뉴 선택 : ");
		
	}
	public static boolean addMember(ArrayList<Member1>list) {
		Scanner sc = new Scanner(System.in);
		//회원 정보 입력
		//아이디, 비번, 이름, 주민번호, 나이 순으로
		System.out.println("회원 정보를 입력하세요.");
		System.out.print("아이디 : ");
		String id= sc.next();
		System.out.print("비밀번호 : ");
		String pw = sc.next();
		System.out.print("이름 : ");
		String name = sc.next();
		System.out.print("주민등록번호 : ");
		String residentNumber = sc.next();
		System.out.print("나이 : ");
		int age = sc.nextInt();
		//입력한 정보를 이용한 객체를 생성(회원리스트에 비교 및 추가)
		Member1 member = new Member1(id, pw, name, residentNumber, age);
		//회원 리스트에 이미 가입된 아이디이면 안내문구 출력 후 종료, 아니면 회원리스트에 추가
		//회원아디가 같은 회원이 있으면
		if(list.contains(member)) {
			//건너뜀
			return false;
		}
		//아니면 회원리스트에 member 객체를 추가
		list.add(member);
		return true;
	}
	public static void printStr(String str) {
		System.out.println("------------------------");
		System.out.println(str);
		System.out.println("------------------------");
	}
	public static Member1 searchMember(ArrayList<Member1>list) {
		Scanner sc = new Scanner(System.in);
		System.out.println("검색할 회원 정보를 입력하세요.");
		System.out.print("아이디 : ");
		//아이디 입력
		String id = sc.next();
		//비밀번호 입력
		System.out.print("비밀번호 : ");
		String pw = sc.next();
		//아이디, 비번을 이용하여 객체를 만듬
		Member1 member = new Member1(id,pw);
		//회원 리스트에서 아이디가 같은 회원 정보를 가져옴
		int index = list.indexOf(member);
		if(index == -1) {
			return null;
		}
		Member1 tmp = list.get(index);
		//가져온 회원 정보의 비번과 입력한 비번을 비교하여 다르면 종료
		if(!tmp.getPw().equals(member.getPw())) {
			return null;
		}
		//같으면 회원정보를 보여줌
		return tmp;
	}
	public static boolean updateMember(ArrayList<Member1>list, Member1 updateTmp) {
		Scanner sc = new Scanner(System.in);
		if(updateTmp ==null) {
			return false;
		}
		//일치하는 회원 정보가 있으면 비번,이름,주민번호,나이를 입력받음
		System.out.println("수정할 회원 정보를 입력하세요.");
		System.out.print("비밀번호 : ");
		String pw = sc.next();
		System.out.print("이름 : ");
		String name = sc.next();
		System.out.print("주민등록번호 : ");
		String residentNumber = sc.next();
		System.out.print("나이 : ");
		int age = sc.nextInt();
		//입력받은 회원 정보를 이용하여 updateTmp를 수정
		updateTmp.update(pw,name,residentNumber,age);
		return true;
	}
}
