package day02;

import java.util.Scanner;

public class OperatorEx05 {

	public static void main(String[] args) {
		/* 홍길동 학생의 국어,영어,수학 점수를 콘솔에 입력받고(Scanner)
		 * 홍길동 학생 평균 성적을 콘솔에 출력(sysout)하는 코드를 작성하세요.
		 */
		Scanner scan = new Scanner(System.in);
		
		System.out.println("홍길동 학생의 국어 성적은?");//print를 사용했었으면 일일이 움직일 필요가 없었다(다음줄로 넘어갈 필요가 없었으므로)
		int num1 = scan.nextInt();
		System.out.println(num1);//필요가 없었다. 내가 썻던 점수가 다시 필요하지않다.
		
		System.out.println("홍길동 학생의 영어 성적은?");
		int num2 = scan.nextInt();
		System.out.println(num2);
		
		System.out.println("홍길동 학생의 수학 성적은?");
		int num3 = scan.nextInt();
		System.out.println(num3);
		
		scan.close();
		
		System.out.println("홍길동 학생의 평균 점수는? "+ ((double)(num1+num2+num3) / 3));
	}

}
