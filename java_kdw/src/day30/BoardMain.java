package day30;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BoardMain {
	
	/* 기능
		 *  -게시글 등록
		 *  -게시글 수정
		 *  -게시글 삭제
		 *  -게시글 목록
		 *  -게시글 확인
		 *   - 댓글 등록
		 *   - 댓글 확인
		 *   - 이전
		 *  -프로그램 종료
		 * */
	private static Scanner sc = new Scanner(System.in);
	private static List<Board> boardList = new ArrayList<Board>();
	
	public static void main(String[] args) {
		
		//메뉴를 출력하고, 입력한 메뉴가 프로그램 종료가 아니면 반복하는 코드를 작성
		int menu = -1;
		while(menu != 6) {
			printMenu();
			menu = sc.nextInt();
			sc.nextLine();
			runMenu(menu);
		}
	}
	/**runMenu
	 * 메뉴가 주어지면 주어진 메뉴에 맞는 기능을 출력하는 메소드
	 * @param menu 선택된 메뉴로 정수
	 * */
	private static void runMenu(int menu) {
		switch(menu) {
		case 1://게시글 등록
			insertBoard();
			break;
		case 2://게시글 수정
			System.out.println("게시글 수정기능");
			break;
		case 3://게시글 삭제
			System.out.println("게시글 삭제기능");
			break;
		case 4://게시글 목록
			System.out.println("게시글 목록기능");
			break;
		case 5://게시글 확인
			System.out.println("게시글 확인기능");
			//댓글 등록
			//댓글 확인
			//이전
			break;
		case 6://프로그램 종료
			System.out.println("프로그램을 종료합니다.");
			break;
		default :
			System.out.println("잘못된 메뉴입니다.");
		}
		
	}
	/**insertBoard
	 * 게시글 정보를 입력받아 게시글을 출력하는 메소드
	 * 메소드 구현에 필요한 필드를 추가해도 됨
	 * */
	public static void insertBoard() { 
		System.out.print("번호 : ");
		int num = sc.nextInt();
		sc.nextLine();
		
		System.out.print("제목 : ");
		String title = sc.nextLine();
		
		System.out.print("내용 : ");
		String contents = sc.nextLine();

		System.out.print("작성자 : ");
		String writer = sc.nextLine();
		
		Board board = new Board(num, title, contents, writer);

		if(boardList.contains(board)) {
			System.out.println("이미 등록된 게시글 번호입니다.");
			return;
		}
		boardList.add(board);
		
	}
	
	/** 메뉴를 출력하는 메소드
	 * */
	public static void printMenu() {
		System.out.println("=====게시글 관리=====");
		System.out.println("1. 게시글 등록");
		System.out.println("2. 게시글 수정");
		System.out.println("3. 게시글 삭제");
		System.out.println("4. 게시글 목록");
		System.out.println("5. 게시글 확인");
		System.out.println("6. 프로그램 종료");
		System.out.println("===================");
		System.out.print("메뉴 선택 : ");
	}
}
