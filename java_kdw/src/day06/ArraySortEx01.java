package day06;

import java.util.Arrays;
import java.util.Collections;

public class ArraySortEx01 {

	public static void main(String[] args) {
		// 버블 정렬을 이용한 배열 정렬
		int arr[]= {1,3,5,7,2,8,6,9};
		for(int i=0;i<arr.length-1;i++) {
			for(int j=0;j<arr.length-1-i;j++) {
				if(arr[j]>arr[j+1]) {
					int tmp = arr[j];//덮어쓰기 개념
					arr[j]= arr[j+1];
					arr[j+1]=tmp;
				}
			}
			for(int tmp : arr) {
				System.out.print(tmp+" ");
			}
			System.out.println();
		}
		System.out.println("-------------");
		int arr2[]= {1,3,5,7,2,8,6,9};
		Arrays.sort(arr2);
		for(int tmp : arr2) {
			System.out.print(tmp+ " ");
		}
		System.out.println("\n-------------");
		Integer arr3[]= {1,3,5,7,2,8,6,9};
		Arrays.sort(arr3,Collections.reverseOrder());
		for(int tmp : arr3) {
			System.out.print(tmp+ " ");
		}

	}

}
