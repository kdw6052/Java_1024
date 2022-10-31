package day06;

public class ArrayRandomEx02 {

	public static void main(String[] args) {
		/* 랜덤으로 1~9사이의 숫자를 중복되지 않게3개 생성하여 배열저장하는 코드를 작성.
		 * */
		int min =1,max=9;
		int r;
		int rd[] = new int[3];
		//배열에 저장된 중복되지 않은 수가 3개가 될때까지 반복해야함
		for(int i=0;i<rd.length;i++) {
			//랜덤한 수 생성	
			r=(int)(Math.random()*(max - min + 1)+min);
			//배열에 저장된 수 중에서 랜덤한 수와 일치하는 숫자가 있는지 없는지 확인하여
			for(int j = 0;j<=i;j++) {
				if(r==rd[j]) {
					break;
				}else if(r!=rd[j]){
					rd[i]=r;
				}
				
			}
			//있으면 다시 처음으로,
			//없으면 배열에 저장, 저장된 개수 1 증가
			System.out.print(rd[i]+" ");
		}
	}

}
