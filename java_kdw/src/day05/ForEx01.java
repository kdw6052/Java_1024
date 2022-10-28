package day05;

public class ForEx01 {

	public static void main(String[] args) {
		int i = 0;
		for(i=1;i<=5;i++); //;에 의해 실행문이 작동하지 않음
		{
			System.out.println(i);
		}
		i=5;
		if( i%2 ==0);//;에 의해 if문 실행문이 짝수 출력이 아니라 없음 
		{
			System.out.println("짝수");
		}
		//에러발생, else는 if문이 필요한데, if문이 없어서
		/*else {
			System.out.println("홀수");
		}*/
		//조건문,반복문은 실행문이 1줄이면 {}가 생략이 가능
		for(i=1;i<=5;i++);
			System.out.println(i);
	}

}
