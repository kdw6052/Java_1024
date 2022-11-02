package day08;

import java.util.Arrays;
import java.util.Scanner;

public class MethodLottoEx01 {

	public static void main(String[] args) {
		/**/ 
		int min = 1, max = 45;
		int size = 6;
		//로또 번호 생성
		int [] lotto =createRandomArray(min, max, size);
		System.out.print("로또 번호 : ");
		//로또 번호 정렬
		Arrays.sort(lotto);
		//로또 번호 출력
		printArray(lotto);
		//보너스 번호 생성
		int bonus;
		//배열에 r이 없으면 [배열i번지에 r을 저장한 후, i를 증가]
		do{
			bonus=random(min,max);
		}while(contain(lotto, bonus));
		System.out.print("보너스 번호 : "+ bonus);
		System.out.println();
		//로또 번호 입력
		int []user = new int[size];
		System.out.print("입력번호 : ");
		Scanner sc = new Scanner(System.in);
		for(int i = 0;i<user.length;i++) {
			user[i]=sc.nextInt();
		}
		int rank = getRank(lotto, bonus, user);
		printRank(rank);
		System.out.println();
		//count(lotto, bonus, user);
		sc.close();
		//당첨 등수를 알려주는 코드를 작성.단 메소드 이용해서
	}
	/* 기능 : 주어진 두 배열에서 일치하는 숫자의 개수를 알려주는 메소드
	 * 매개변수 : 두 배열 => int[]arr1,int[]arr2
	 * 리턴타입 : 일치하는 숫자의 개수 => int
	 * 메소드명 : countLotto
	 * */
	public static int countLotto(int[]arr1,int[]arr2) {
		if(arr1 == null||arr2 == null) {
			return 0;
		}
		int count = 0;
		for(int tmp : arr1) {
			if(contain(arr2, tmp)) {
				count++;
			}
		}
		return count;
		/*for(int i=0;i<arr1.length;i++) {
			for(int j=0;j<arr2.length;j++) {
				if(arr1[i]==arr2[j]) {
					samecount++;
				}
			}
		}
		return samecount;*/
	}
	/* 기능 : 로또 번호(보너스 번호 포함)와 입력번호가 주어지면 등수를 알려주는 메소드
	 * 매개변수 : 로또번호, 입력번호 => int[]lotto, int bonus, int[] user
	 * 리턴타입 : 등수 => 정수 => int
	 * 메소드명 : getRank
	 * */
	public static int getRank(int[]lotto, int bonus, int[] user) {
		int count = countLotto(lotto, user);
		switch(count) {
		case 6 : return 1;//return이 break역할을 함
		case 5 : return contain(user, bonus)? 2 : 3;
		case 4 : return 4;
		case 3 :return 5;
		default : return -1;
		}
	}
	/* 기능 : 등수가 주어지면 등수를 콘솔에 출력하는 메소드
	 * 매개변수 : 등수 => 정수 => int rank
	 * 리턴타입 : 없음 => void
	 * 메소드명 : printRank
	 * */
	public static void printRank(int rank) {
		switch(rank) {
		case 1 : System.out.println("1등!"); break;
		case 2 : System.out.println("2등!"); break;
		case 3 : System.out.println("3등!"); break;
		case 4 : System.out.println("4등!"); break;
		case 5 : System.out.println("5등!"); break;
		case -1 : System.out.println("꽝!"); break;
		}
	}
	/* 기능 : 일치하는 숫자의 개수를 받아 등수를 출력하는 코드
	 * 매개변수 : 일치하는 숫자의 개수 => int num
	 * 리턴타입 : 없음
	 * 메소드명 : count
	 * */
	/*public static void count(int[]lotto,int bonus, int []user) {
		int count = countLotto(lotto, user);
		switch(count) {
		case 6 :
			System.out.println("1등입니다.");
			break;
		case 5 :
			if(contain(user, bonus)) {
				System.out.println("2등");
			}
			System.out.println("3등");
			break;
		case 4 : System.out.println("4등");
		case 3 : System.out.println("5등");
		default : System.out.println("꽝");
		}
	}*/
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
