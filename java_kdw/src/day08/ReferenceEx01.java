package day08;

public class ReferenceEx01 {

	static String str2;
	
	public static void main(String[] args) {
		/* 참조변수 : 주소를 저장하는 변수, 객체, 배열 등
		 * null : 값이 없을을 알려주는 키워드로 참조 변수에서 사용
		 * */ 
		String str = null;//비어있다는 의미로 null로 초기화
		String str1;
		//초기화가 안된 지역 변수들은 값을 활용 할 수 없다
		//System.out.println(str1);//에러발생
		//멤버 변수들은 초기화를 하지 않아도 기본값으로 초기화가 됨
		//정수 : 0, 실수 : 0.0f,0.0f, char : '\u0000', boolean : false
		//참조변수 : null
		if(str2 != null)
			System.out.println(str2.charAt(0));
	}

}
