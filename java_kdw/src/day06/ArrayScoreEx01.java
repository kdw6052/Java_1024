package day06;

import java.util.Scanner;

public class ArrayScoreEx01 {

	public static void main(String[] args) {
		// 5명 학생의 국어,영어, 수학 성적을 저장하기 위한 배열을 만들고,
		//scanner를 이용하여 입력받아, 국어평균,영어평균, 수학 평균을 구하는 코드를 작성하세요.
		
		int kor[] = new int[5];
		int eng[];
		int math[];
		eng= new int[kor.length];
		System.arraycopy(kor,0,eng,0,kor.length);
		math= new int[kor.length];
		System.arraycopy(kor,0,math,0,kor.length);
		Scanner sc = new Scanner(System.in);
		
		for(int i=0;i<kor.length;i++) {
			System.out.println("학생들의 국어성적을 입력하세요");
			kor[i] = sc.nextInt();
		}
		for(int i=0;i<kor.length;i++) {
			System.out.println("학생들의 영어성적을 입력하세요");
			eng[i] = sc.nextInt();
		}
		for(int i=0;i<kor.length;i++) {
			System.out.println("학생들의 수학성적을 입력하세요");
			math[i] = sc.nextInt();
		}
		double korsum = 0, engsum = 0, mathsum=0;
		
		for(int i=0;i<kor.length;i++) {
			korsum+=kor[i];
			engsum+=eng[i];
			mathsum+=math[i];
		}
		System.out.println("학생들의 국어성적 평균 : "+korsum/3);
		System.out.println("학생들의 영어성적 평균 : "+engsum/3);
		System.out.println("학생들의 수학성적 평균 : "+mathsum/3);

	}

}
