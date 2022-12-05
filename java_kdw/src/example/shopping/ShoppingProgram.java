package example.shopping;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShoppingProgram {
	
	private List<Product> productList = new ArrayList<Product>();
	private List<Sales> salesList = new ArrayList<Sales>();
	private ProductController pc = new ProductController(productList);
	private SalesController sc = new SalesController(salesList, productList);
	private Scanner scan = new Scanner(System.in);
	
	public void run() {
		int menu = -1;
		final int exit = 7;
		do {
			try {
				printMenu();
				menu = inputInt();
				exemenu(menu);
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}while(menu != exit);
	}

	private void exemenu(int menu) {
		switch(menu) {
		case 1://제품 등록(분류, 제품명, 수량, 구매가격, 판매가격)
			pc.insertProduct();
			break;
		case 2://제품 수정
			pc.updateProduct();
			break;
		case 3://제품 삭제
			pc.deleteProduct();
			break;
		case 4://제품 구매(관리자가 구매, 입고)
			sc.sales("구매");
			break;
		case 5://제품 판매
			sc.sales("판매");
			break;
		case 6://매출액 확인
			sc.print();
			break;
		case 7:
			System.out.println("프로그램을 종료합니다.");
			break;
		default :
			System.out.println("잘못된 메뉴선택입니다.");
		}
		
	}

	private int inputInt() {
		int num = scan.nextInt();
		scan.nextLine();
		return num;
	}

	private void printMenu() {
		System.out.println("========메뉴========");
		System.out.println("1.제품 등록");
		System.out.println("2.제품 수정");
		System.out.println("3.제품 삭제");
		System.out.println("4.제품 구매");
		System.out.println("5.제품 판매");
		System.out.println("6.매출액 확인");
		System.out.println("7.프로그램 종료");
		System.out.println("===================");
		System.out.print("메뉴 선택 : ");
		
		
	}
}
