package day10;

import java.util.Scanner;

public class UpDownGameManager {

	public static void main(String[] args) {
		/* Updown게임을 구현하세요.
		 * 1. 플레이
		 * 2. 기록확인
		 * 3. 종료
		 * */ 
		int menu;
		Record[] records = new Record[5];
		do {
		//메뉴출력
		printMenu();
		//메뉴선택
		menu =selectMenu();
		//메뉴 실행 : 선택한 메뉴, 기록정보
		runMenu(menu,records);
		}while(menu != 3);
		
		
	}
	/**
	 * 주어진 기록 정보를 이용하여 메뉴에 따른 기능을 실행하는 메소드.
	 * @param records 기록 정보들
	 * @param menu 선택한 메뉴
	 * */
	private static void runMenu(int menu,Record[] records) {
		
		switch(menu) {
		case 1 ://플레이
			int r,num,min=1,max=9;
			int tryCoin =0;
			Scanner sc = new Scanner(System.in);
			System.out.println(min+"에서 "+max+"까지의 랜덤한 숫자 찾기");
			//랜덤으로 숫자생성
			r=(int)(Math.random()*(max-min+1)+min);
			//반복
			do {
				//사용자 입력
				System.out.print("숫자를 입력하세요 : ");
				num = sc.nextInt();
				tryCoin++;
				if(num==r) {
					//updown판별
					System.out.println("정답입니다.");
					}else if(num>r) {
					System.out.println("DOWN");
					}else {
					System.out.println("UP");
					}
				//기록된 최대 등수 찾기
				int recordCount = getRecordCount(records);
				//기록된 최대 랭크 찾기
				int recordRank = getRecordRank(records);
				//기존 기록보다 좋으면 기록을 추가
				if(tryCoin<recordCount && recordRank<5) {
					addrecord(records,tryCoin);
				}
			}while(num!=r);
			break;
		case 2 ://2.기록확인
			//기록된 순위를 출력
			break;
		case 3 ://종료
			System.out.println("프로그램을 종료합니다.");
			break;
		default :
			System.out.println("잘못된 메뉴입니다.");
		}
		
		
	}
	private static void addrecord(Record[] records, int tryCoin) {
		Scanner sc = new Scanner(System.in);
		System.out.print("이름을 적으세요 (예 : kdw ) : ");
		String name = sc.next();
		for(int i=records.length-1;i<tryCoin;i--) {
			
		}
		
	}
	private static int getRecordRank(Record[] records) {
		int rank = 0;
		for(Record record : records) {
			rank++;
		}
		return rank;
	}
	private static int getRecordCount(Record[] records) {
		int count = 999999;
		for(Record record : records) {
			if(records != null) {
				count = record.getCount();
			}
		}
		return count;
	}
	/**
	 * 고정된 메뉴를 출력하는 메소드
	 * */
	private static void printMenu() {
		System.out.println("-----------");
		System.out.println("UpDown게임");
		System.out.println("1. 플레이");
		System.out.println("2. 기록확인");
		System.out.println("3. 종료");
		System.out.println("-----------");
		System.out.print("메뉴를 선택하세요 : ");
	}
	/**
	 * 콘솔에서 정수를 입력받아 입력받은 정수를 알려주는 메소드
	 * @param 입력받은 정수, 메뉴
	 * */
	public static int selectMenu() {
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}
		
	
}
