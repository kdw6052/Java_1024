package day04;

public class NestingForStarEx02 {

	public static void main(String[] args) {
		/*	*
		 * 	**
		 * 	***
		 *  ****
		 * 	*****
		 * */
		int i,j;
		/*for(i=1;i<=5;i++) {
			//*을 i개 출력
			for(j=1;j<=5;j++) {
				if(i>=j) {
					System.out.print("*");
				}
			}System.out.println();
		}*/
		for(i=1;i<=5;i++) {
			for(j=1;j<=i;j++) {
				System.out.print("*");
			}System.out.println();
		}
		/*	    *
		 *	   **
		 *	  ***
		 *	 ****
		 *	*****   
		 * */
		for(i=1;i<=5;i++) {
			//공백 출력 : 5-i
			for(j=1;j<=5-i;j++) {
				System.out.print(" ");
			}
			//*출력 : i개
			for(j=1;j<=i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		/*     *	공백4 *1 *0
		 *    ***	공백3	 *2 *1
		 *   *****	공백2	 *3 *2
		 *  ******* 공백1 *4 *3
		 * *********공백0 *5 *4
		 * */
		for(i=1;i<=5;i++) {
			for(j=1;j<=5-i;j++) {
				System.out.print(" ");
			}
			for(j=1;j<=2*i-1;j++) {
				System.out.print("*");
			}
			
			System.out.println();
		}
	}

}
