package day02;

import java.util.Scanner;

public class OperatorEx08 {

	public static void main(String[] args) {
		/* 정수를 입력받아 입력받은 정수가 홀수인지 짝수인지 출력하는 코드를 작성하세요.
		 * 예시)
		 * 정수를 입력하세요 : 5
		 * 5는 홀수입니다.
		 * 짝수는 정수를 2로 나누었을 때 나머지가 0과 같은수
		 * */
		
		Scanner scan = new Scanner(System.in);
		System.out.print("정수를 입력하시오 : ");
		int num = scan.nextInt();
		scan.close();
		
		String result = (num%2) ==0 ? "짝수" : "홀수";
		System.out.println(num + "는" + result + "입니다.");
	}

}
