package day30;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KioskMain {
	/* 제품을 관리하는 프로그램을 작성하세요.
	 * -구매가격, 판매가격은 변동이 없음
	 * 기능
	 * -제품 등록(분류, 제품명, 수량, 구매가격, 판매가격)
	 * -제품 수정
	 * -제품 삭제
	 * -제품 구매(관리자가 구매, 입고)
	 * -제품 판매
	 * -매출액 확인
	 * 	-년별
	 * 		-제품별
	 * 		-전체
	 * 	-월별
	 * 		-제품별
	 * 		-전체
	 * 	-일별
	 * 		-제품별
	 * 		-전체
	 * */
	private static Scanner sc = new Scanner(System.in);
	private static List<Goods>list = new ArrayList<Goods>();
	public static void main(String[] args) {
		int menu = -1;
		do {
			printMenu();
			menu = sc.nextInt();
			sc.nextLine();
			runMenu(menu);
		}while(menu != 7);
		
	}
	private static void runMenu(int menu) {
		switch(menu) {
		case 1://제품 등록
			insertGoodsList();
			break;
		case 2://제품 수정
			updateGoodsList();
			break;
		case 3://제품 삭제
			break;
		case 4://제품 구매
			//수량 증가
			//매출액 감소
			break;
		case 5://제품 판매
			//수량 감소
			//매출액 증가
			break;
		case 6://매출액 확인
			break;
		case 7://종료
			System.out.println("프로그램을 종료합니다.");
			break;
		default :
			System.out.println("잘못된 메뉴입니다.");
		}
		
	}
	private static void updateGoodsList() {
		String name = insertGoodsName();
		
		if(list.size()==0) {
			System.out.println("등록된 제품이 없습니다.");
		}
		for(Goods tmp : list) {
			if(!tmp.getName().equals(name)) {
				System.out.println("일치하는 제품이 없습니다.");
				return;
			}
		}
		System.out.print("분류 : ");
		String division = sc.nextLine();
		System.out.print("수량 : ");
		int numbers = sc.nextInt();
		System.out.print("구매가격 : ");
		int buyPrice = sc.nextInt();
		System.out.print("판매가격 : ");
		int sellPrice = sc.nextInt();
	}
	private static String insertGoodsName() {
		System.out.print("제품명 : ");
		String name = sc.nextLine();
		return name;
	}
	private static Goods insertGoods(String name) {
		System.out.print("분류 : ");
		String division = sc.nextLine();
		System.out.print("수량 : ");
		int numbers = sc.nextInt();
		System.out.print("구매가격 : ");
		int buyPrice = sc.nextInt();
		System.out.print("판매가격 : ");
		int sellPrice = sc.nextInt();
		
		return new Goods(division,name, numbers, buyPrice, sellPrice);
	}
	private static void insertGoodsList() {
		String name = insertGoodsName();
		
		Goods goods = insertGoods(name);
		
		for(Goods tmp : list) {
			if(tmp.equals(goods)) {
				System.out.println("이미 등록된 제품입니다.");
				return;
			}
		}
		list.add(goods);
		System.out.println("제품이 등록되었습니다.");
		
	}
	private static void printMenu() {
		System.out.println("===제품관리 프로그램===");
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
