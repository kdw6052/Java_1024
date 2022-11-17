package day19;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.function.Predicate;

public class BookManagerServicelmp implements BookManagerService{
	
	@Override
	public void printMenu() {
		System.out.println("-----메뉴-----");
		System.out.println("1. 도서 추가");
		System.out.println("2. 도서 조회");
		System.out.println("3. 프로그램 종료");
		System.out.println("-------------");
		System.out.print("메뉴 선택 : ");
		
	}

	@Override
	public void runMenu(ArrayList<BookInfo> book,int menu) {
		Scanner sc = new Scanner(System.in);
		switch(menu) {
		case 1: 
			//도서 추가 도서명, 저자(여러명, 엮은이, 옮긴이 다 포함), 가격, 출판사, 분류, ISBN
			addbook(book);
			break;
		case 2: 
			//도서 조회
			printSubMenu();
			int subMenu =sc.nextInt();
			selectSubMenu(book,subMenu);
			break;
		case 3: 
			System.out.println("프로그램을 종료합니다.");
			break;
		default : 
		}
		
	}
	@Override
	public void addbook(ArrayList<BookInfo> book) throws InputMismatchException{
		Scanner sc = new Scanner(System.in);
		System.out.print("도서명 : ");
		String bookName = sc.nextLine();
		System.out.print("저자 : ");
		String author = sc.next();
		System.out.print("가격 : ");
		int price = sc.nextInt();
		sc.nextLine();
		System.out.print("출판사 : ");
		String publisher = sc.nextLine();
		System.out.print("분류 : ");
		String type = sc.next();
		book.add(new BookInfo(bookName, author, price, publisher, type));
		
	}

	@Override
	public void printBook(ArrayList<BookInfo> book, Predicate<BookInfo> p) {
		for(BookInfo tmp : book) {
			if(p.test(tmp)) {
				System.out.println(tmp);
			}
		}
		
	}

	@Override
	public void printSubMenu() {
		System.out.println("----도서 도회-----");
		System.out.println("1. 도서명으로 조회");
		System.out.println("2. 저자로 조회");
		System.out.println("3. 출판사로 조회");
		System.out.println("4. 분류로 조회");
		System.out.println("----------------");
		
	}

	@Override
	public void selectSubMenu(ArrayList<BookInfo> book, int subMenu) {
		Scanner sc = new Scanner(System.in);
		switch(subMenu){
		case 1 :// 도서명으로 조회
			System.out.print("도서명 입력 : ");
			String nameTmp = sc.nextLine();
			
			//if() {
			//	System.out.println("등록되지 않은 도서명입니다.");
			//}
			printBook(book, s->s.getBookName().equals(nameTmp));
			break;
		case 2 :// 저자로 조회
			System.out.print("저자 입력 : ");
			String authorTmp = sc.next();
			printBook(book, s->s.getAuthor().equals(authorTmp));
			break;
		case 3 : // 출판사로 조회
			System.out.print("출판사 입력 : ");
			String publisherTmp = sc.nextLine();
			printBook(book, s->s.getPublisher().equals(publisherTmp));
			break;
		case 4 :// 분류로 조회
			System.out.print("분류 입력 : ");
			String typeTmp = sc.next();
			printBook(book, s->s.getType().equals(typeTmp));
			break;
		default :
			
		}
		
	}

	
}
