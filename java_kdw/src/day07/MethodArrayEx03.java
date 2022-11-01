package day07;

public class MethodArrayEx03 {

	public static void main(String[] args) {
		// 배열에 정수 num가 있는지 없는지 확인하는 코드를 작성하세요. 메소드 이용
		int min =1,max=9;
		int arr1[] =new int[3];
		createRandomArray(arr1, min, max);

	}
	public static void printArray(int arr[]) {
		for(int i =0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	public static void createRandomArray(int arr[], int min, int max) {
		
		for(int i=0;i<arr.length;i++) {
			arr[i]=random(min,max);
		}
	}
	/* 기능 : 배열에 정수 num가 있는지 없는지 알려주는 메소드
	 * 매개변수 :	arr[],num => int arr[],int num 
	 * 리턴타입 : boolean
	 * 메소드명 :	check
	 * */
	/*public static boolean check(int arr[], int num){
		for
	}*/
	public static int random(int min,int max) {
		return (int)(Math.random()* (max - min + 1)+min);
	}
}
