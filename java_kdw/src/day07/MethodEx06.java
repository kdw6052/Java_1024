package day07;

public class MethodEx06 {

	public static void main(String[] args) {
		int[] arr = {1,3,5};
		test(arr);
		for(int tmp : arr) {
			System.out.print(tmp+" ");
		}

	}
	public static void test(int[]arr) {
		arr=new int[3];//이코드에 의해 main에 있는 arr가 바뀌지 않음,새로운 arr를 만들어버림
		arr[0]=10;
	}
}
