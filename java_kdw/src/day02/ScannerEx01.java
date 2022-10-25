package day02;

import java.util.Scanner;

public class ScannerEx01 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);//Scanner은 다른곳에서 가져오는 예약어, 
											//ctrl+shift+o 누르고 import java.util.Scanner; 가져오기 
		                                    //그후 new Scanner(System.in);입력
		System.out.println("정수를 입력하세요 : ");//입력후 엔터치기
		int num = scan.nextInt();
		System.out.println(num);
		
		System.out.println("실수를 입력하세요 : ");
		double num2 = scan.nextDouble();
		System.out.println(num2);
		
		System.out.println("정수A와 정수B를 입력하세요 : ");
		int numA = scan.nextInt();
		int numB = scan.nextInt();
		System.out.println(numA);
		System.out.println(numB);
		scan.close();
	}

}
