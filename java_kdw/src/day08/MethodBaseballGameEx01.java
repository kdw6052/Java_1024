package day08;

import java.util.Scanner;

public class MethodBaseballGameEx01 {

	public static void main(String[] args) {
		/* 1~9사이의 중복되지 않은 3개의 숫자가 랜덤으로 생성이 되고,
		 * 생성된 숫자를 맞추는 게임
		 * 규칙
		 *  -숫자가 같은 자리에 있으면 strike
		 *  -숫자가 있지만 다른 자리에 있으면 ball
		 *  -일치하는 숫자가 하나도 없으면 out
		 * 예시(랜덤숫자 : 5 9 8)
		 * 입력 : 1 2 3 
		 * O
		 * 입력 : 4 5 6 
		 * 1B
		 * 입력 : 7 8 9 
		 * 2B
		 * 입력 : 7 9 8
		 * 2S
		 * 입력 : 7 9 5 
		 * 1S 1B
		 * 입력 : 5 9 8
		 * 3S
		 * 게임종료
		 * */ 
		int min = 1,max= 9;
		int size = 3;
		Scanner sc = new Scanner(System.in);
		int[] random = createRandomArray(min, max, size);
		int[] user = new int[size];
		System.out.print("랜덤 숫자를 맞추세요");
		printArray(random);
		
		for(;user!=random;) {
			System.out.print("랜덤 숫자 3개를 입력하세요 : ");
			
			for(int i = 0;i<user.length;i++) {
				user[i]= sc.nextInt();
				
			}
			String str = strike(random, user)+"S";
			String bal = ball(random, user)+"B";
			String ou = out(random, user)+"OUT";
			System.out.println(str+" "+bal+" "+ou);
			if(strike(random, user)==3) {
				System.out.println("정답입니다");
				break;
			}
		}sc.close();
	}
	//두 배열의 일치갯수
	public static int strike(int[]arr1,int[]arr2) {
		if(arr1 == null||arr2 == null) {
			return 0;
		}
		int strike = 0;
		for(int i =0;i<arr1.length;i++) {
			for(int j=0;j<arr2.length;j++) {
				if(arr1[i]==arr2[j]) {
					if(i==j) {
						strike++;
					}
				}
			}
		}
		return strike;
	}
	public static int ball(int[]arr1,int[]arr2) {
		if(arr1 == null||arr2 == null) {
			return 0;
		}
		int ball = 0;
		for(int i =0;i<arr1.length;i++) {
			for(int j=0;j<arr2.length;j++) {
				if(arr1[i]==arr2[j]) {
					if(i!=j) {
						ball++;
					}
				}
			}
		}
		return ball;
	}
	public static int out(int[]arr1,int[]arr2) {
		if(arr1 == null||arr2 == null) {
			return 0;
		}
		int out = 0;
		for(int tmp : arr1) {
			if(!contain(arr2, tmp)) {
				out++;
			}
		}
		return out;
	}
	//배열 출력코드
	public static void printArray(int arr[]) {
		if(arr==null) {
			return;
		}
		for(int i =0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	//배열에 랜덤한수를 입력하는 코드
	public static int [] createRandomArray(int min, int max, int size) {
		if(max - min + 1 <=size) {
			return null;
		}
		int arr[]=new int[size];
		//i는 0부터 i가 배열의 크기보다 작을때까지 1씩증가
		//=>i는 0부터 i가 배열의 크기보다 작을때까지
		for(int i=0;i<arr.length;) {
			int r=random(min,max);
			//배열에 r이 없으면 [배열i번지에 r을 저장한 후, i를 증가]
			if(!contain(arr,r)) {//r이 배열 arr에 있지 않다면
				arr[i]=r;
				i++;
			}
		}
		return arr;
	}
	//랜덤한 수를 생성하는코드
	public static int random(int min,int max) {
		if(min>max) {
			int tmp = min;
			min = max;
			max = tmp;
		}
		return (int)(Math.random()* (max - min + 1)+min);
	}
	//num가 배열에 있는지 확인하는 코드
	public static boolean contain(int[]arr,int num) {
		if(arr==null||arr.length==0) {
			return false;
		}
		for(int tmp : arr) {
			if(num==tmp) {
				return true;
			}
		}
		return false;
	}
}
