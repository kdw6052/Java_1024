package day05;

public class RandomEx01 {

	public static void main(String[] args) {
		// min~max 사이 값을 가지는 랜덤한 정수를 생성하는 예제
		int min = 1, max = 45;
		/* Math.random() : 0이상 1미만의 랜덤한 실수를 생성, 0.XX
		*  0 <= r < 1, (max - min + 1)
		*  0 <= r*(max - min + 1) < max - min + 1, min을 더함
		*  min <= r* (max - min + 1)+min < max + 1
		*/
		int r = (int)(Math.random()* (max - min + 1)+min);
		System.out.println("랜덤한 수 : "+ r);
		
		
		
	}

}
