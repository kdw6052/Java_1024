package day20;

import java.util.ArrayList;
import java.util.Scanner;

public class BookManagerMain {

	public static void main(String[] args) {
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
		Scanner sc = new Scanner(System.in);
		ArrayList<Book>list = new ArrayList<Book>();
		do {
			//메뉴를 출력
			System.out.println("=====메뉴======");
			System.out.println("1. 도서 추가");
			System.out.println("2. 도서 조회");
			System.out.println("3. 프로그램 종료");
			System.out.println("==============");
			System.out.print("메뉴 선택 : ");
			//메뉴를 선택
			menu = sc.nextInt();
			String title,author,publisher,genre,isbn;
			int price;
			//선택한 메뉴에 따른 기능 실행
			switch(menu) {
			case 1 :
				//선택 메뉴가 1번이면 도서 추가
				//도서명, 저자(여러명, 엮은이, 옮긴이 다 포함), 가격, 출판사, 분류, ISBN
				sc.nextLine();//엔터 처리
				System.out.print("도서명 : ");
				title = sc.nextLine();
				System.out.print("저자 : ");
				author = sc.nextLine();
				System.out.print("가격 : ");
				price = sc.nextInt();
				sc.nextLine();
				System.out.print("출판사 : ");
				publisher = sc.nextLine();
				System.out.print("분류 : ");
				genre = sc.nextLine();
				System.out.print("ISBN :");
				isbn = sc.next();
				//도서 목록에 새 도서를 추가
				//위에서 입력받은 도서 정보를 이용하여 도서 객체를 생성
				Book book = new Book(title, author, publisher, genre, isbn, price);
				//생성된 도서 객체를 리스트에 추가
				//isbn 중복체크해서 중복되면 건너뜀
				if(list.contains(book)) {
					System.out.println("이미 등록된 ISBN 번호입니다.");
					System.out.println("========================");
					continue;
				}
				//중복되지 않으면 추가
				list.add(book);
				System.out.println("도서 추가가 완료됐습니다.");
				System.out.println("===================");
				break;
			case 2 :
				//선택 메뉴가 2번이면 도서 조회
				/*도서 조회
				 *  - 도서명으로 조회
				 *  - 저자로 조회
				 *  - 출판사로 조회
				 *  - 장르로 조회*/
				//서브 메뉴 출력
				System.out.println("=====조회 메뉴=====");
				System.out.println("1. 도서명으로 조회");
				System.out.println("2. 저자로 조회");
				System.out.println("3. 출판사로 조회");
				System.out.println("4. 장르로 조회");
				System.out.println("5. 취소");
				System.out.println("=================");
				System.out.print("메뉴 선택 : ");
				//서브 메뉴 선택
				int subMenu = sc.nextInt();
				System.out.println("=================");
				//선택한 서브 메뉴 실행
				int count=0;
				switch(subMenu) {
				case 1 :
					sc.nextLine();
					System.out.print("도서명 : ");
					title = sc.nextLine();
					System.out.println("=================");
					for(Book tmp : list) {
						if(tmp.getTitle().contains(title.trim())) {
							System.out.println(tmp);
							count++;
						}
					}
					if(count==0) {
						System.out.println("검색 결과가 없습니다.");
						System.out.println("=================");
					}
					break;
				case 2 :
					sc.nextLine();
					System.out.print("저자 : ");
					author = sc.nextLine();
					System.out.println("=================");
					for(Book tmp : list) {
						if(tmp.getAuthor().contains(author.trim())) {
							System.out.println(tmp);
							System.out.println("=================");
							count++;
						}
					}
					if(count==0) {
						System.out.println("검색 결과가 없습니다.");
						System.out.println("=================");
					}
					break;
				case 3 :
					sc.nextLine();
					System.out.print("출판사 : ");
					publisher = sc.nextLine();
					System.out.println("=================");
					for(Book tmp : list) {
						if(tmp.getPublisher().contains(publisher.trim())) {
							System.out.println(tmp);
							System.out.println("=================");
							count++;
						}
					}
					if(count==0) {
						System.out.println("검색 결과가 없습니다.");
						System.out.println("=================");
					}
					break;
				case 4 :
					sc.nextLine();
					System.out.print("장르 : ");
					genre = sc.nextLine();
					System.out.println("=================");
					for(Book tmp : list) {
						if(tmp.getGenre().contains(genre.trim())) {
							System.out.println(tmp);
							System.out.println("=================");
							count++;
						}
					}
					if(count==0) {
						System.out.println("검색 결과가 없습니다.");
						System.out.println("=================");
					}
					break;
				case 5 :
					System.out.println("조회를 취소했습니다.");
					System.out.println("=================");
					break;
				default :
					System.out.println("잘못된 메뉴입니다.");
					System.out.println("=================");
				}
				break;	
			case 3 :
				//선택 메뉴가 3번이면 프로그램 종료 출력
				System.out.println("프로그램을 종료합니다.");
				System.out.println("=================");
				break;	
			default : //선택 메뉴가 1,2,3이 아니면 잘못된 메뉴라고 출력
				System.out.println("잘못된 메뉴입니다.");
				System.out.println("=================");
			}
		}while(menu !=3);
		sc.close();
	}

}
