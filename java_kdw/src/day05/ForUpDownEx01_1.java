package day05;

import java.util.Scanner;

public class ForUpDownEx01_1 {

	public static void main(String[] args) {
		/*	랜덤한 수를 생성하여 해당 수를 맞추는 코드를 작성하세요.
		 * 	예시 : (생성한 랜덤한 수 70)
		 * 	1~100사이의 랜덤한 수를 맞추세요.
		 * 	up
		 * 	숫자를 입력하세요
		 *  
		 *  #랜덤수를 맞추기
		 *  반복횟수 : 맞출때까지 => 랜덤수 r과 입력한 수가 일치하지 않을때까지
		 *  규칙성 :
		 *   1.숫자를 입력하세요 : 안내문구 출력
		 *   2.정수를 입력받음
		 *   3.입력받은 정수가 r과 같으면 정답입니다.라고 출력하고
		 *     입력받은 정수가r보다 크면 DOWN이라고 출력하고 아니면 UP이라고 출력한다.
		 *  반복문 종료 후 : 없음
		 * */
		int min =1, max=100;
		int r = (int)(Math.random()* (max - min + 1)+min);
		int num = min-1;
		Scanner sc = new Scanner(System.in);
		for(;r!=num;) {
			// 1.숫자를 입력하세요 : 안내문구 출력
			System.out.print("숫자를 입력하세요 : ");
			//2.정수를 입력받음
			num = sc.nextInt();
			if(num==r) {
				System.out.println("정답입니다.");
			}else if(num>r) {
				System.out.println("DOWN");
			}else {
				System.out.println("up");
			}
		}
		
	}

}
