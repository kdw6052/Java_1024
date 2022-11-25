package day25;

import java.util.Random;
import java.util.Scanner;

public class Ex04 {
	/* 컴퓨터와 가위, 바위, 보를 하는 프로그램을 작성하세요.
	 * 예 : 
	 * 사용자 : 가위
	 * 컴퓨터 : 보
	 * 사용자가 이겼습니다. 더하겠습니까?(y/n) : y
	 * 사용자 : 가위
	 * 컴퓨터 : 주먹
	 * 컴퓨터가 이겼습니다. 더 하겠습니까?(y/n) : n
	 * */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String [] com= {"가위" , "바위", "보"};
		int min = 0, max= 2;
		
		String user ="";
		while(true) {
			int r = random(min,max);
			System.out.print("가위, 바위, 보 :");
			user = sc.next();
			if(!user.equals("가위") && !user.equals("바위") && !user.equals("보")) {
				System.out.println("다시 입력하세요.");
				continue;
			}
			System.out.println("컴퓨터 : "+com[r]);
			runGame(user, com, r);
			char a = sc.next().charAt(0);
			if(a == 'n') {
				System.out.println("게임을 종료합니다.");
				break;
			}	
		}
		sc.close();

	}
	private static void runGame(String user, String [] com, int r) {
		switch(user) {
		case "가위" :
			if(com[r].equals("보")) {
				System.out.print("사용자가 이겼습니다. 더 하겠습니까?(y/n) : ");
			}else if(com[r].equals("바위")) {
				System.out.print("컴퓨터가 이겼습니다. 더 하겠습니까?(y/n) : ");
			}else {
				System.out.print("비겼습니다. 더 하겠습니까?(y/n) : ");
			}
			break;
		case "바위" :
			if(com[r].equals("보")) {
				System.out.print("컴퓨터가 이겼습니다. 더 하겠습니까?(y/n) : ");
			}else if(com[r].equals("바위")) {
				System.out.print("비겼습니다. 더 하겠습니까?(y/n) : ");
			}else {
				System.out.print("사용자가 이겼습니다. 더 하겠습니까?(y/n) : ");
			}
			break;
		case "보" :
			if(com[r].equals("보")) {
				System.out.print("비겼습니다. 더 하겠습니까?(y/n) : ");
			}else if(com[r].equals("바위")) {
				System.out.print("사용자가 이겼습니다. 더 하겠습니까?(y/n) : ");
			}else {
				System.out.print("컴퓨터가 이겼습니다. 더 하겠습니까?(y/n) : ");
			}
			break;
		}
		
	}
	public static int random(int min, int max) {
		if(max<min) {
			int tmp = max;
			max = min;
			min = tmp;
		}
		Random r = new Random();
		return r.nextInt(max - min +1)+min;
	}
}
