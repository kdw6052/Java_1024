package day06;

import java.util.Scanner;

public class ArrayUpDownEx01 {

	public static void main(String[] args) {
		/* up down 게임을 3회 반복해서 플레이하고,
		 * 각 게임당 맞춘 횟수를 배열에 저장하여 출력하는
		 * 코드를 작성하세요.*/
		int min= 1,max = 10, size = 3;
		int r,num,count=0;
		int arr[]=new int[size];
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<size;i++) {
			System.out.print(min+"부터 "+max+"까지 숫자를 입력하세요");
			r=(int)(Math.random()*(max - min + 1)+min);
			num = min-1;
			for(count=1;r!=num;) {
				System.out.print("숫자를 입력하세요 : ");
				num=sc.nextInt();
				if(r>num) {
					count++;
					System.out.println("up");
				}else if(r<num) {
					count++;
					System.out.println("down");
				}else if(r==num) {
					System.out.println("정답입니다.");
				}
			arr[i]=count;
			continue;
			}
		}
		for(int i=0;i<arr.length;i++) {
			System.out.println(i+1+"번째 게임 횟수 : "+arr[i]);
		}
		
		sc.close();
	}

}
