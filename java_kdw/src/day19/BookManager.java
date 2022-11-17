package day19;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BookManager {
	ArrayList<BookInfo> book = new ArrayList<BookInfo>();
	BookManagerService bookManager = new BookManagerServicelmp();
	Scanner sc;
	public void run() {
		/* 도서 관리 프로그램을 작성하세요.
		 * 도서 정보 
		 * - 도서명, 저자(여러명, 엮은이, 옮긴이 다 포함), 가격, 출판사, 분류, ISBN
		 * 기능
		 * - 도서 추가
		 * 	- ISBN으로 정렬
		 * - 도서 조회
		 *  - 도서명으로 조회
		 *  - 저자로 조회
		 *  - 출판사로 조회
		 *  - 분류로 조회
		 * 
		 * */
		int menu = -1;
		do {
			try {
			bookManager.printMenu();
			menu =sc.nextInt();
			bookManager.runMenu(book,menu);
			}catch(InputMismatchException e) {
				System.out.println("정수를 입력하세요.");
			}
		}while(menu != 3);
	}
	public BookManager(Scanner sc) {
		if(sc == null) {
			this.sc = new Scanner(System.in);
		}else {
		this.sc = sc;
		}
	}
	

}
