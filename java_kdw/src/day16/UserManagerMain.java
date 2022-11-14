package day16;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;

import lombok.Data;

public class UserManagerMain {

	public static void main(String[] args) {
		/* 회원정보를 관리하는 프로그램을 작성하세요.
		 * - 회원정보는 아이디, 비번, 이름, 나이, 주민번호
		 * - 기능1 : 회원 추가
		 * - 기능2 : 회원 검색
		 * - 기능3 : 회원 정보 수정
		 * - 기능4 : 회원 삭제
		 * */
		Scanner scan = new Scanner(System.in);
		HashMap<String, Object> users = new HashMap<String, Object>();
		int menu = -1;
		do {
			printMenu();
			menu=scan.nextInt();
			runMenu(users, menu);
		}while(menu !=5);
	}

	private static void runMenu(HashMap<String, Object> users,int menu) {
		Scanner sc = new Scanner(System.in);
		switch(menu) {
		case 1 :
			//회원 추가
			System.out.println("아이디를 입력하세요");
			String id = sc.next();
			System.out.println("비밀번호를 입력하세요");
			String pw = sc.next();
			System.out.println("이름을 입력하세요");
			String name = sc.next();
			System.out.println("주민번호를 입력하세요");
			String number = sc.next();
			System.out.println("나이를 입력하세요");
			int age = sc.nextInt();
			users.put(id,new Users(id,pw, name, number, age));
			break;
		case 2 :
			//회원 검색
			Set<Entry<String, Object>> entrySet = users.entrySet();
			for(Entry<String, Object> tmp : entrySet) {
				System.out.println(tmp.getKey()+" : "+tmp.getValue());
			}
			break;
		case 3 :
			//회원 수정
			entrySet = users.entrySet();
			for(Entry<String, Object> tmp : entrySet) {
				System.out.println(tmp.getKey()+" : "+tmp.getValue());
			}
			System.out.print("수정할 회원의 id를 입력하세요 : ");
			int index = sc.nextInt();
			System.out.println("수정할 곳을 선택하세요");
			String x = sc.next();
			System.out.println("수정할 내용을 입력하세요");
			String y = sc.next();
			
			break;
		case 4 :
			//회원 삭제
			entrySet = users.entrySet();
			for(Entry<String, Object> tmp : entrySet) {
				System.out.println(tmp.getKey()+" : "+tmp.getValue());
			}
			System.out.print("삭제할려는 회원의 id를 입력하세요 : ");
			users.remove(sc.next());
			break;
		default :
		}
		
	}

	private static void printMenu() {
		System.out.println("메뉴");
		System.out.println("1. 회원 추가");
		System.out.println("2. 회원 검색");
		System.out.println("3. 회원 정보 수정");
		System.out.println("4. 회원 삭제");
		System.out.println("5. 종료");
		System.out.print("메뉴선택 : ");
	}

}

@Data
class Users{
	private String name,id, pw, number;
	private int age; 
	
	@Override
	public String toString() {
		return "[이름=" + name +", id="+id+", pw=" + pw + ",주민번호 =" + number + ", 나이=" + age + "]";
	}
	public void userinfo(String pw1, String name1, String number1, int age1) {
		this.pw = pw1;
		this.name= name1;
		this.number = number1;
		this.age = age1;
	}
	public Users(String id, String pw, String name, String number, int age) {
		this.id= id;
		this.pw = pw;
		this.name = name;
		this.number = number;
		this.age = age;
	}
	
}