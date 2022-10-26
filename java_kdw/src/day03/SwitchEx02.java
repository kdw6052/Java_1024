package day03;

import java.util.Scanner;

public class SwitchEx02 {

	public static void main(String[] args) {
		/* 두 정수와 산술 연산자를 입력 받아 산술 연산 결과를 하는 
		 * 코드를 switch문으로 작성하세요.
		 * */
		System.out.print("두 정수와 산술 연산자를 입력하세요 : ");
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		char ch = sc.next().charAt(0);
		int num2 = sc.nextInt();
		
		switch (ch) {
		case '+' :
			System.out.println(""+num1 + ch +num2 + "=" + (num1+num2));
			break;
		case '-' :
			System.out.println(""+num1 + ch +num2 + "=" + (num1-num2));
			break;
		case '*' :
			System.out.println(""+num1 + ch +num2 + "=" + (num1*num2));
			break;
		case '/' :
			System.out.println(""+num1 + ch +num2 + "=" + ((double)num1/num2));
			break;
		case '%' :
			System.out.println(""+num1 + ch +num2 + "=" + (num1%num2));
		default :
			System.out.println(ch+ "는 산술연산자가 아닙니다.");
		}
		sc.close();

		
		
		
	}

}
