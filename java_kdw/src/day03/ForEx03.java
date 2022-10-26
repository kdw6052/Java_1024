package day03;

public class ForEx03 {

	public static void main(String[] args) {
		//	구구단 2단을 출력하는 코드를 작성하세요.
		/*	반복횟수 : i는 1부터 9까지 1씩 증가
		 * 	규칙성 : 2 x ? = ??를 출력
		 * */
		int i;
		int num = 3;
		for( i=1 ; i<=9 ; i++) {
			System.out.println(num+" x "+i+" = "+(num*i));
			
		}

	}

}
