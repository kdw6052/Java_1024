package day05;

import java.util.Scanner;

public class ArrayEx04 {

	public static void main(String[] args) {
		/* 학생 5명의 국어 성적을 입력받고 출력하는 코드를 작성하세요.
		 * 반복횟수 : i는 0부터 배열의 크기보다 작을때까지 1씩증가
		 * 규칙성 : 콘솔에서 입력받은 정수를 배열i번지에 저장 후 배열 i번지에 있는 값을 출력
		 * */
		int score[] = new int[5];
		System.out.println("학생 5명의 국어 성적을 입력 하세요.");
		Scanner sc = new Scanner(System.in);
		for(int i =0;i<score.length;i++) {
			System.out.print(i+1 +"번째 학생 성적 : ");
			score[i]=sc.nextInt();
			System.out.println(i+1 +"번째 학생 성적 : "+ score[i]);
		}
		/* 학생 성적의 평균을 구하는 코드를 작성하세요.
		 * */
		int sum=0;
		for(int i=0;i<score.length;i++) {
			sum += score[i]; 
		}
		double avg = (double)sum/score.length;
		System.out.println("학생 5명의 평균 성적 : "+avg);
		sum = 0;//향상된 for문
		for(int tmp : score) {
			sum+=tmp;
		}
		System.out.println("학생 5명의 평균 성적 : "+avg);
		sc.close();
	}

}
