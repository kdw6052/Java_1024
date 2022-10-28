package day05;

import java.util.Scanner;

public class ForUpDownEx02_2 {

	public static void main(String[] args) {
		int min =1, max=100;
		int r,num;
		Scanner sc = new Scanner(System.in);
		for(;;) {
			r = (int)(Math.random()* (max - min + 1)+min);
			System.out.println(min+"~"+max+"사이의 랜덤한 수를 맞추세요");
			num = min-1;
			for(;r!=num;) {
				System.out.print("숫자를 입력하세요 : ");
				num = sc.nextInt();
				if(num==r) {
				System.out.println("정답입니다.");
				}else if(num>r) {
				System.out.println("DOWN");
				}else {
				System.out.println("up");
				}
			}
			System.out.println("더하시겠습니까?(y/n) : ");
			if(sc.next().charAt(0) == 'n'){
				break;
			}
		
		}
		
		System.out.println("프로그램을 종료합니다.");
		sc.close();
	}
	
}
