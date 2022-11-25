package day25;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex02 {

	/* 정수를 5번 입력하여 배열/리스트에 저장하는 코드를 작성하세요.
	 * 정수가 홀수이면 그대로 저장, 정수가 짝수이면 -를 붙여서 저장
	 * */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> arr1 = new ArrayList<Integer>();
		for(int i = 1 ; i<= 5 ; i++) {
			System.out.print("정수 입력 : ");
			int num = sc.nextInt();
			if(num %2 != 0) {
				arr1.add(num);
			}else {
				arr1.add(-num);
			}
		}
		for(int tmp : arr1) {
			System.out.print(tmp + " ");
		}
		sc.close();
	}

}

