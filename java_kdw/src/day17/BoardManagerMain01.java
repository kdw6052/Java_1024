package day17;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public class BoardManagerMain01 {
	
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		/* 게시글 관리 프로그램을 작성하세요.
		 * 1. 게시글 작성
		 * 2. 게시글 조회
		 * 3. 게시글 수정
		 * 4. 게시글 삭제
		 * 5. 프로그램 종료
		 * - 게시글은 번호, 제목, 내용, 작성자, 작성일, 조회수로 구성
		 * - 게시글 전체 조회는 나중에 작성된 게시글이 상단에 조회
		 * - 게시글 상세 조회는 게시글 번호를 입력하여 게시글 내용을 확인
		 * - 게시글 상세 조회를 하면 조회수가 1 증가
		 * - 게시글 수정은 게시글 번호를 선택하면 해당 게시글의 제목, 내용을 수정
		 * - 게시글 삭제는 게시글 번호를 선택하면 해당 게시글을 삭제
		 * */
		ArrayList<Board01> bd = new ArrayList<Board01>();
		int menu=-1;
		do {
			printMenu();
			menu = sc.nextInt();
			switch(menu) {
			case 1 :
				int number = sc.nextInt();
				System.out.println("제목을 입력하세요");
				String title = sc.next();
				System.out.println("내용을 입력하세요");
				String contents = sc.nextLine();
				sc.nextLine();
				System.out.println("이름을 입력하세요");
				String name = sc.next();
				String date = dates();
				bd.add(new Board01(number, title, contents, name, date,0));
			case 2 :
				int select=sc.nextInt(); 
				
				if(select ==1) {
					for(Board01 tmp : bd) {
					System.out.println(tmp);
					}
				}else if(select ==2) {
					int index = sc.nextInt();
					if(bd.equals(index)) {	
						
					}
					
				}
				break;
			case 3 :
				break;
			case 4 :
				break;
			case 5 :
				printStr("프로그램 종료!");
				break;
			default : 
				printStr("잘못된 메뉴입니다.");
			}
			
		}while(menu != 5);
	}

	private static String dates() {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String dateStr = format.format(date);
		return dateStr;
		
	}
	public static void printStr(String str) {
		System.out.println("-------------------");
		System.out.println(str);
		System.out.println("-------------------");
	}
	
	public static void printMenu() {
		System.out.println("-----메뉴-----");
		System.out.println("1. 게시글 작성");
		System.out.println("2. 게시글 조회");
		System.out.println("3. 게시글 수정");
		System.out.println("4. 게시글 삭제");
		System.out.println("5. 프로그램 종료");
		System.out.println("-------------");
		System.out.print("메뉴 선택 : ");
		
	}

}
