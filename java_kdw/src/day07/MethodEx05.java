package day07;

public class MethodEx05 {

	public static void main(String[] args) {
		// 1부터 10까지의 합을 구하는 코드를 작성하세요. 단 메소드 이용
		int start = 1,end = 10;
		System.out.println(start+"부터 "+end+"까지의 합 : "+sum1(end, start));
	}
	/* 기능 : 두정수를 입력받아 두 정수 사이의 숫자의 합을 구하는 코드
	 * 매개변수 : 두정수=>int
	 * 리턴타입 : 두정수의 합=>int
	 * 메소드명 : sum
	 * */
	public static int sum(int num1,int num2) {
		int sum=0;
		for(int i=num1;i<=num1||i<=num2;i++) {
			sum=sum+i;
		}
		return sum;
	}
	/* 기능 : 시작숫자부터 끝숫자 사이의 모든 정수를 더하고, 더한 결과를 알려주는 메소드
	 * 매개변수 : 시작숫자, 끝숫자 =>int start, int end
	 * 리턴타입 : 더한 결과 =>정수 => int
	 * 메소드명 : sum1
	 * */
	public static int sum1(int start,int end) {
		if(start>end) {
			int tmp = start;
			start = end;
			end=tmp;
		}
		int sum1=0;
		for(int i=start;i<=start||i<=end;i++) {
				sum1+=i;
		}
		return sum1;
	}
	
}
