package day32;

import java.util.StringTokenizer;

public class StringTokenizerEx01 {

	public static void main(String[] args) {
		String str = "abc,def,.ghi";
		String[] arr= str.split(",.");//정규표현식으로 적용 ,와 문자하나를 구분자로 봄
		for(String tmp : arr) {
			System.out.println(tmp);
		}
		System.out.println("----------");
		StringTokenizer st = new StringTokenizer(str,".,");
		System.out.println("개수 : "+ st.countTokens());
		while(st.hasMoreTokens()) {
			String tmp = st.nextToken();
			System.out.println(tmp);
		}
		System.out.println("----------");
		st = new StringTokenizer(str, ".,", true);
		System.out.println("개수 : "+ st.countTokens());
		while(st.hasMoreTokens()) {
			String tmp = st.nextToken();
			System.out.println(tmp);
		}
	}

}
