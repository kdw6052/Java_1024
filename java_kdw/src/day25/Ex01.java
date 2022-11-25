package day25;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex01 {

	/* 정수를 입력받아 입력받은 정수가 0이상이면 0부터 입력받은 수까지 합을 구하고,
	 * 입력받은 정수가 0미만이면 0부터 입력받은 수까지 차를 구하는 코드를 작성하세요.
	 * 예 : 정수입력 : 3
	 * 0부터 3까지 누적합 : 6
	 * 정수 입력 : -3
	 * 0부터 -3까지 누적차 : 6
	 * */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		try {
			int num = sc.nextInt();
			sum(num);
		}catch(InputMismatchException e) {
			System.out.println("정수가 아닙니다.");
		}
		sc.close();
	}
	private static void sum(int num) {
		int sum = 0;
		if(num >=0) {
			for(int i =0 ; i <= num ; i++) {
				sum += i;
			}
			System.out.println("0부터 "+ num + "까지의 누적합 : "+ sum);
		}else if(num < 0) {
			for(int i = 0 ; i >= num ; i--) {
				sum -= i;
			}
			System.out.println("0부터 "+ num +"까지의 누적차 : "+sum);
		}
		
	}

}
