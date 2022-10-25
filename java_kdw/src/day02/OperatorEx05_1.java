package day02;

import java.util.Scanner;

public class OperatorEx05_1 {

	public static void main(String[] args) {
		//국어,영어,수학,총점,평균
		int kor, eng, math, sum;
		double avg;
		//Scanner를 통해 성적을 입력
		Scanner scan = new Scanner(System.in);
		System.out.print("국어 성적을 입력하세요 : ");
		kor = scan.nextInt();
		System.out.print("영어 성적을 입력하세요 : ");
		eng = scan.nextInt();
		System.out.print("수학 성적을 입력하세요 : ");
		math = scan.nextInt();
		
		scan.close();
		//총점을 계산
		sum = kor + eng + math;
		//평균을 계산
		avg = (double)sum / 3;
		//평균을 출력
		System.out.println("평균은 " + avg + "입니다.");
		//통과입니까? true/false 
		//평균이 60점 이상이면 true, 아니면 false
		//System.out.println("통과 입니까? : "+(avg>=60)); =내가 짜본코드
		//통과를 알려주는 변수, 실패를 알려주는 변수, 강사님이 짜신 코드
		boolean isPass = avg>=60;
		boolean isFail = avg<60;
		System.out.println("통과입니까? "+ isPass);
		System.out.println("통과입니까? "+ !isFail);
	}

}
