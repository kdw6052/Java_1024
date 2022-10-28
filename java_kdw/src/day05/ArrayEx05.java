package day05;

public class ArrayEx05 {

	public static void main(String[] args) {
		/* 5개짜리 배열을 생성하여 2부터 5개의 소수를 배열에 저장하고 출력하세요.
		 * 반복횟수 : num가 2부터 1씩 증가
		 * 규칙성 : 
		 * 	1.num가 소수이면 배열 i번지에 num를 저장
		 * 	2.i를i증가
		 * 	3.i가 배열의 크기와 같으면 반복문 종료
		 * 반복문 종료 후 : 배열의 값을 출력(반복문 이용)
		 * */
		int num1;
		int num[] = new int[5];
		int i,b=0;//약수를 찾기 위해 1부터 num까지 증가시키려는 수
		int count;//num의 약수 개수를 저장하는 수
		for(num1=2;;num1++) {
			for(i=1,count=0;i<=num1;i++) {
				if(num1%i==0) {
				count++;
				}
			}
			if(count ==2) {
				num[b]=num1;
				b++;
			}
			if(b==num.length) {
				break;
			}
		}
		for(int tmp:num) {
			System.out.print(tmp+ " ");
		}
		
		
		
		

	}

}
