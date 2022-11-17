package day18;
import java.util.Scanner;
import java.util.regex.Pattern;

public class RegexEx02 {

	public static void main(String[] args) {
		String idRegex = "^[a-z0-9_\\-]{5,20}$";
		Scanner sc = new Scanner(System.in);
		System.out.print("아이디 입력 : ");
		String id = sc.next();
		if(Pattern.matches(idRegex, id)) {
			System.out.println("올바른 아이디입니다.");
		}else {
			System.out.println("아이디는 5~20자의 영문 소문자, 숫자와 특수기호_와-만 사용가능합니다");
		}
	}

}
