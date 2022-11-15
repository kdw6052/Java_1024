package day17;

import java.util.HashMap;
import java.util.Scanner;

import day16.Member1;

public class UserManagerMapMain {

	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		int menu =-1;
		HashMap<String, Member>map = new HashMap<String, Member>();
		do {
			printMenu(menu);
			menu = sc.nextInt();
			
			switch(menu) {
			case 1 :
				if(addMember(map)) {
					System.out.println("회원 정보가 추가됐습니다.");
				}else {
					System.out.println("이미 가입된 아이디입니다.");
				}
				break;
			case 2 :
				if(!searchMember(map)) {
					System.out.println("회원 정보가 없습니다.");
				}
				//다르면 종료
				break;
			case 3 :
				if(updateMember(map)) {
					System.out.println("회원 정보를 수정했습니다.");
				}else {
					System.out.println("아이디 또는 비번이 일치하지 않습니다.");
				}
				
				break;
			case 4 :
				if(deleteMember(map)) {
					System.out.println("회원 정보를 삭제했습니다.");
				}else {
					System.out.println("아이디 또는 비번이 일치하지 않습니다.");
				}
				break;
			case 5 :
				System.out.println("프로그램을 종료합니다.");
				break;
			default : 
				System.out.println("잘못된 메뉴입니다.");
			}
		}while(menu!=5);

	}
	private static void printMenu(int menu) {
		System.out.println("-----메뉴-----");
		System.out.println("1. 회원 추가");
		System.out.println("2. 회원 검색");
		System.out.println("3. 회원 정보 수정");
		System.out.println("4. 회원 삭제");
		System.out.println("5. 종료");
		System.out.println("-------------");
		System.out.print("메뉴 선택 : ");
		
		
	}
	private static boolean deleteMember(HashMap<String, Member> map) {
		System.out.println("삭제할 회원 정보를 입력하세요.");
		System.out.print("아이디 : ");
		String id = sc.next();
		System.out.print("비밀번호 : ");
		String pw = sc.next();
		Member deleteTmp = map.get(id);
		if(deleteTmp == null || !deleteTmp.getPw().equals(pw)) {
			return false;
		}
		map.remove(id);
		return true;
		
	}
	public static boolean updateMember(HashMap<String, Member> map) {
		System.out.println("검색할 회원 정보를 입력하세요.");
		System.out.print("아이디 : ");
		String id = sc.next();
		System.out.print("비밀번호 : ");
		String pw = sc.next();
		
		Member updateTmp = map.get(id);
		if(updateTmp == null || !updateTmp.getPw().equals(pw)) {
			return false;
		}
		System.out.println("수정할 회원 정보를 입력하세요.");
		System.out.print("새 비밀번호 : ");
		String newPw = sc.next();
		System.out.print("새 이름 : ");
		String name = sc.next();
		System.out.print("새 주민등록번호 : ");
		String residentNumber = sc.next();
		System.out.print("새 나이 : ");
		int age = sc.nextInt();
		updateTmp.update(newPw, name, residentNumber, age);
		return true;
		
	}
	public static boolean searchMember(HashMap<String, Member> map) {
		System.out.println("검색할 회원 정보를 입력하세요.");
		System.out.print("아이디 : ");
		String id = sc.next();
		System.out.print("비밀번호 : ");
		String pw = sc.next();
		//아이디를 이용하여 회원정보를 가져옴
		Member searchTmp = map.get(id);
		//일치하는 회원 정보가 없으면 건너뜀
		if(searchTmp ==null) {
			return false;
		}
		//가져온 회원정보에서 비번이 같은지를 확인하여 다르면 건너뜀
		if(!searchTmp.getPw().equals(pw)) {
			return false;
		}
		System.out.println(id+" : "+searchTmp);
		return true;
	}
	public static boolean addMember(HashMap<String, Member> map) {
		if(map==null) {
			throw new RuntimeException("예외발생 : Map이 null입니다.");
		}
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
		//map에 있는지 확인
		Member addtmp = map.get(id);
		//있으면 건너뜀
		if(addtmp != null) { //if(map.get(id) != null)
			return false;
		}
		//없으면 추가
		map.put(id, new Member(pw, name, residentNumber, age));
		return true;
	}
}
