package day10;

import java.util.Arrays;

public class BaseballGame02 {
	private int[] com;
	private int[] user;
	private int strike;
	private int ball;
	
	public BaseballGame02(int[] com) {
		this.com = Arrays.copyOf(com, com.length);//깊은 복사(값까지 복사)
	}
	public void setUser(int[] user) {
		this.user = Arrays.copyOf(user, user.length);
		calculateResult();
	}
	public void calculateResult() {
		calculateStrike();
		calculateBall();
	}
	private void calculateStrike() {
		int count= 0;
		int size = com.length < user.length ? com.length : user.length;
		for(int i=0; i<size;i++) {
			if(com[i]==user[i]) {
				count++;
			}
		}strike = count;
	}
	private void calculateBall() {
		int count = 0;
		for(int i=0;i<com.length;i++) {
			for(int j =0;j<user.length;j++) {
				if(com[i]==user[j] && i!=j) {
					count++;
				}
			}
		}ball=count;
	}
	public int getStrike() {
		return strike;
	}
	public void printResult() {
		if(strike != 0) {
			System.out.print(strike+"S ");
		}
		if(ball != 0 ) {
			System.out.print(ball+"B ");
		}
		if(strike==0 && ball == 0) {
			System.out.print("OUT");
		}
		System.out.println();
	}
	
}
