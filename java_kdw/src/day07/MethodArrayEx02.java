package day07;

public class MethodArrayEx02 {

	public static void main(String[] args) {
		/* 1~9사이의 랜덤한 수를 배열에 3개 저장하는 코드를 작성하세요.메소드이용할것
		 * */
		int arr[]=new int[3];
		printrandom(1,9,arr);
		for(int tmp : arr) {
			System.out.print(tmp+" ");
		}
	}
		
	/* 기능 : 최소값
	 * 매개변수 : 
	 * 리턴타입 : 
	 * 메소드명 : 
	 * */
	public static void printrandom(int min,int max,int arr[]) {
		for(int i=0;i<arr.length;i++) {
			arr[i]=(int)(Math.random()* (max - min + 1)+min);
		}
		
	}
}

