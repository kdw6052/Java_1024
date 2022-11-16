import java.util.Scanner;
import java.util.regex.Pattern;

public class RegexEx01 {

	public static void main(String[] args) {
		String regex = "^...$";
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		boolean res = Pattern.matches(regex, str);
		if(res)
			System.out.println(str + "는 3글자로 되어있습니다.");
		else
			System.out.println(str + "는 3글자가 아닙니다.");
		//아이디 정규표현식 
		//5~20자의 영문 소문자, 숫자와 특수기호(_),(-)만 사용가능
	}

}
