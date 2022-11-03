package day09;

import java.util.Scanner;


public class BaseballManager {

	public static void main(String[] args) {
		/* 숫자 야구게임을 플레이 한 후, 기록을 저장하는 프로그램을 작성하세요.
		 * 메뉴
		 * 1. 플레이
		 * 2. 기록확인
		 * 3. 종료
		 * 메뉴선택 : 2
		 * 1.홍길동 2회
		 * 2.임꺽정 3회
		 * 3.이몽룡 3회
		 * 4.춘향이 4회
		 * */
		
		int menu;
		int min =1,max=9, size =3;
		//BaseballGame [] score 
		do {
			//메뉴를 출력
			gameMenu();
			//메뉴를 선택
			select();
			//선택한 메뉴 실행
			playgame(menu);
		}while(true);
	}
	public static void gameMenu(){
		System.out.println("-----메뉴------");
		System.out.println("1.플레이");
		System.out.println("2.기록확인");
		System.out.println("3.프로그램 종료");
		System.out.println("--------------");
		System.out.print("메뉴를 선택하세요 : ");
	}
	public static int select() {
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}
	public static int playGame (int menu) {
		Scanner sc = new Scanner(System.in);
		int min=1,max=9,size=3;
		int strike = 0,ball;
		String name;
		switch(menu) {
		case 1 :
			int count=0;
			//컴퓨터가 랜덤으로 숫자 생성
			do{
				int [] com = BaseballGame.createRandomArray(min, max, size);
				//사용자가 숫자 입력
				System.out.print("숫자를 입력 : ");
				//판별
				int[] user = BaseballGame.scanArray(sc, size);
				count++;
				strike = BaseballGame.getStrike(com, user);
				ball = BaseballGame.getBall(com, user);
				//3s종료
				BaseballGame.printGame(strike, ball);
				}while(strike<3);
				
			//[new] 회수를 기록(최대 5등) , 5등 기준으로 회수가 동일한 경우 먼저 플레이한 사용자 기록을 유지
			name = sc.next();
			break;
		case 2 :
			//등록된 5위까지의 기록을 확인
			break;
		case 3 :
			break;
		default :
		}
	}
	public static String [] record(Scanner sc, int count) {
		if(count<=0) {
			return null;
		}
		String [] arr = new String [5];
		for(int i =0; i<count; i++) {
			arr[i]=sc.next()+", "+count;
		}
		return arr;
	}
	
	public static boolean contain(int[]arr,int num) {
		if(arr==null||arr.length==0) {
			return false;
		}
		for(int tmp : arr) {
			if(num==tmp) {
				return true;
			}
		}
		return false;
	}
	
	
	
}
