package day25;

import java.util.Scanner;

public class Ex04_3 {
	/* 컴퓨터와 가위, 바위, 보를 하는 프로그램을 작성하세요.
	 * -사용자가 연속 3번 이길때까지 반복(비기거나 지면 다시)
	 * 예 : 
	 * 사용자 : 가위
	 * 컴퓨터 : 보
	 * 사용자 : 가위
	 * 컴퓨터 : 주먹
	 * */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = 0;
		do {
			try {
				System.out.print("가위,바위,보 : ");
				RPS user = RPS.valueOf(sc.next());
				RPS com = randomRPS();
				System.out.println("컴퓨터 : "+com);
				State state = resultState(user,com);
				printState(state);
				count = state == State.WIN ? count+1 : 0;
				if(count == 2) {
					System.out.println("사용자 "+count+"회 우승!");
					sc.close();
					break;
				}
			}catch(IllegalArgumentException e) {
				System.out.println("잘못 입력하였습니다.");
			}
		}while(true);
	}

	private static void printState(State state) {
		switch(state) {
		case WIN :
			System.out.println("사용자가 이겼습니다.");
			break;
		case LOSE : 
			System.out.println("컴퓨터가 이겼습니다.");
			break;
		default :
			System.out.println("비겼습니다.");
		}
		
	}

	private static State resultState(RPS user,RPS com) {
		if(user == com) {
			return State.DRAW;
		}
		switch(user) {
		case 가위 :
			return com==RPS.보? State.WIN:State.LOSE;
		case 바위 :
			return com==RPS.가위? State.WIN:State.LOSE;
		default : 
			return com==RPS.바위? State.WIN:State.LOSE;
		}
	}

	private static RPS randomRPS() {
		RPS [] rpss = RPS.values();
		int r = (int)(Math.random()*3);
		return rpss[r];
	}

}
//열거형

