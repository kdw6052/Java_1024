package day32;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MathEx01 {

	public static void main(String[] args) {
		double pi = 3.141592;
		//소수점 첫째자리에서 반올림
		double pi1 = Math.round(pi);
		System.out.println(pi1);
		//소수점 둘째자리에서 반올림
		double pi2 = Math.round(pi*10)/10.0;
		System.out.println(pi2);
		//소수점 셋째자리에서 반올림
		double pi3 = Math.round(pi*100)/100.0;
		System.out.println(pi3);
		//소수점 넷째자리에서 반올림
		double pi4 = Math.round(pi*1000)/1000.0;
		System.out.println(pi4);
		int num = 4;
		double pi4_2 = Math.round(pi*Math.pow(10, num-1))/Math.pow(10,num-1);
		System.out.println(pi4_2);
		String str = "13.45";
		Date date = new Date();
		SimpleDateFormat f = new SimpleDateFormat("yyyy년MM월dd일 hh시mm분ss초");

		String dateser = f.format(date);
		System.out.println(dateser);
	}

}
