package day19;
import java.util.Scanner;
import java.util.regex.Pattern;

public class RegexPhoneNumberEx01 {

	public static void main(String[] args) {
		/* 전화번호 정규표현식을 작성하여 입력받은 번호가 
		 * 전화번호가 맞는지 출력하는 코드를 작성하세요.
		 * 규칙1.
		 * 010-1235-4568(o)
		 * 01012345678(x)
		 * 011-1234-5678(x)
		 * */ 
		String regex = "^010(-\\d{4}){2}$";
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		if(Pattern.matches(regex, str)) {
			System.out.println(str+"은 전화번호가 맞습니다.");
		}else {
			System.out.println(str+"은 전화번호 형식이 아닙니다.");
		}
	}

}
