package day27;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class BoardMain {
	/* 게시글 관리 프로그램
	 * -회원가입
	 * 		-처음 가입한 회원이 관리자, 그외 회원인 일반회원
	 * -로그인
	 * -게시글 등록/수정/삭제 => 회원만 가능
	 * -카테고리 관리(공지, 자유)
	 * -카테고리 추가/수정/삭제(관리자만 가능)
	 * 
	 * */
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		ArrayList<User> list = new ArrayList<User>();
		int menu = -1;
		do {
			printMenu();
			menu = sc.nextInt();
			runMenu(menu, list);
			
		}while(menu !=3);
	}
	private static void runMenu(int menu,ArrayList<User> list) {
		sc.nextLine();
		switch(menu) {
		case 1 :// 회원가입
			signUp(list);
			break;
		case 2 :// 로그인
			logIn(list);
			printSubMenu();
			ArrayList<Notice> notice = new ArrayList<Notice>();
			category(notice);
			//categoryManager();
			break;
		case 3 :
			System.out.println("프로그램 종료");
			break;
		default :
			System.out.println("잘못된 입력입니다.");
		}
		
	}
	private static void category(ArrayList<Notice> notice) {
		int subMenu = sc.nextInt();
		switch(subMenu) {
		case 1 ://공지사항(notice)
			if(notice == null || notice.size() == 0) {
				System.out.println("등록된 공지사항이 없습니다");
			}
			notice.sort((o1,o2)->o2.getNum()-o1.getNum());
			for(Notice tmp : notice) {
				System.out.println(tmp);
			}
			break;
		case 2 ://자유게시판(freeBoard)
			break;
		case 3 :
			System.out.println("프로그램 종료");
			break;
		default :
			System.out.println("잘못된 입력입니다.");
		}
		
	}
	private static void printSubMenu() {
		System.out.println("======게시판======");
		System.out.println("1.공지사항");
		System.out.println("2.자유 게시판");
		System.out.println("3.프로그램 종료");
		System.out.println("===============");
		System.out.print("메뉴 선택 : ");
		
	}
	private static void logIn(ArrayList<User> list) {
		System.out.print("아이디 : ");
		String id = sc.next();
		System.out.print("비밀번호 : ");
		String pw = sc.next();
		if(checkId(id, list)||checkPw(pw,list)) {
			System.out.println("아이디 또는 비밀번호가 일치하지 않습니다.");
		}
		System.out.println("로그인 완료");
		
	}
	private static boolean checkPw(String pw, ArrayList<User> list) {
		if(list == null || list.size() ==0) {
			return true;
		}
		for(User tmp : list) {
			if(tmp.getId().equals(pw)) {
				return false;
			}
		}
		return true;
	}
	private static void signUp(ArrayList<User> list) {
		System.out.print("아이디 : ");
		String id = sc.next();
		System.out.print("비밀번호 : ");
		String pw = sc.next();
		if(!checkId(id,list)) {
			System.out.println("이미 등록된 ID입니다.");
		}
		User user = new User(id, pw);
		list.add(user);
		
	}
	private static boolean checkId(String id, ArrayList<User> list) {
		if(list == null || list.size() ==0) {
			return true;
		}
		for(User tmp : list) {
			if(tmp.getId().equals(id)) {
				return false;
			}
		}
		return true;
	}
	private static void printMenu() {
		System.out.println("======메뉴======");
		System.out.println("1.회원가입");
		System.out.println("2.로그인");
		System.out.println("3.종료");
		System.out.println("===============");
		System.out.print("메뉴 선택 : ");
		
	}

}
