package day04;

public class NestingForEx01 {

	public static void main(String[] args) {
		/*	구구단 3단을 출력하는 코드를 작성하세요.
		 * 
		 * */
		int i;
		int num=3;
		for(num =2;num<=9;num++) {
			for(i=1;i<=9;i++) {
				System.out.println(num+" x "+i+" = "+(num*i));
			}
		}
		
	}

}
