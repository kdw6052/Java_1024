package day04;

public class ForGCDEx01 {

	public static void main(String[] args) {
		/*	두 정수의 최대 공약수를 구하는 코드를 작성하세요.
		 * 	약수 : 나누었을 때 나머지가 0이 되게 하는 수
		 * 	공약수 : 두 정수의 약수들 중에서 공통으로 있는 약수
		 * 	최대공약수 : 두 정수의 약수들 중에서 가장 큰 공약수
		 * 	12 : 1 2 3 4 6 12
		 * 	18 : 1 2 3 6 9 18
		 * 	12와 18의 공약수 : 1 2 3 6
		 * 	12와 18의 최대공약수 : 6
		 * 	반복횟수 : i는 1부터 num1까지 1씩 증가
		 * 	규칙성 : i가 num1의 약수이고 i가 num2의 약수이면 gcd(최대공약수)에i를 저장
		 * 	반복문 종료 후 : gcd를 출력
		 * */
		int i, gcd=1;
		int num = 50, num2 = 8;
		for(i=1;i<=num2||i<=num;i++) {
			if(num%i==0 && num2%i ==0) {
				gcd=i;
			}
		}System.out.print(num+"와 "+num2+"의 최대 공약수 : "+gcd);
		
		
		
	}

}
