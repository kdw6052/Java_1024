package day15;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import lombok.Data;
@Data
public class ListEx01 {

	public static void main(String[] args) {
		/* 리스트를 이용하여 다음 기능을 갖는 오늘의 할일 프로그램을 작성하세요.
		 * 메뉴
		 * 1. 할일 추가
		 * 2. 할일 확인
		 * 3. 할일 삭제
		 * 4. 종료
		 * 메뉴 선택 : 1
		 * -------------------
		 * 할일 입력 : 오후 수업 참여(nextLine)
		 * --------------------
		 * 메뉴
		 * 1. 할일 추가
		 * 2. 할일 확인
		 * 3. 할일 삭제
		 * 4. 종료
		 * 메뉴 선택 : 1
		 * --------------------
		 * 할일 입력 : 저녁
		 * --------------------
		 * 메뉴
		 * 1. 할일 추가
		 * 2. 할일 확인
		 * 3. 할일 삭제
		 * 4. 종료
		 * 메뉴 선택 : 3
		 * 삭제할 할일 번호 선택 : 1
		 * 1번 할일이 삭제되었습니다. 
		 * --------------------
		 * 1. 오후 수업 참여
		 * 2. 저녁
		 * -------------------
		 * 메뉴
		 * 1. 할일 추가
		 * 2. 할일 확인
		 * 3. 할일 삭제
		 * 4. 종료
		 * 메뉴 선택 : 4
		 * 프로그램 종료
		 * */
		int menu=-1;
		Scanner sc = new Scanner(System.in);
		ArrayList<String> todoList = new ArrayList<String>();
		do {
			//메뉴 출력
			printMenu();
			try {
			//메뉴 선택
			menu = sc.nextInt();
			//선택한 메뉴 실행
			runMenu(todoList,menu);
			
			}catch(InputMismatchException e) {
				System.out.println("----예외발생----");
				System.out.println("정수를 입력하세요.");
				System.out.println("--------------");
				sc.nextLine();
			}catch(Exception e) {
				System.out.println("----예외발생----");
				System.out.println(e.getMessage());
				System.out.println("-------------");
			}
		}while(menu !=4);
		sc.close();
	}
	private static void runMenu(ArrayList<String> todoList,int menu) throws Exception {
		Scanner sc = new Scanner(System.in);
		switch(menu){
		case 1 : 
			//할일을 입력(공백 포함해서 입력)
			//리스트에 입력된 할일을 추가
			System.out.print("할 일 입력 : ");
			todoList.add(sc.nextLine());
			break;
		case 2 :
			System.out.println("할일 확인");
			printTodoList(todoList);
			break;
		case 3 :
			//삭제할 할 일 번호 입력
			System.out.println("삭제할 할 일의 번호를 선택하세요");
			//할 일 확인
			printTodoList(todoList);
			//삭제할 할일 번호를 입력
			int index= sc.nextInt();
			//잘못된 번호를 입력한 경우
			if(index<0 || index >= todoList.size()) {
				throw new Exception("삭제할 번호를 잘못입력했습니다");
			}
			todoList.remove(index-1);
			System.out.println(index+"번 할 일이 삭제되었습니다.");
			break;
		case 4 : 
			System.out.println("프로그램 종료");
			break;
		default : 
			throw new Exception("잘못된 메뉴입니다.");
		}
	}
	private static void printTodoList(ArrayList<String> todoList) {
		if(todoList==null || todoList.size()==0) {
			System.out.println("저장된 할 일이 없습니다.");
			return;
		}
		for(int i=0;i<todoList.size();i++) {
			System.out.println((i+1)+". "+todoList.get(i));
		}
	}
	private static void printMenu() {
		System.out.println("-----메뉴-----");
		System.out.println("1. 할 일 추가");
		System.out.println("2. 할 일 확인");
		System.out.println("3. 할 일 삭제");
		System.out.println("4. 종료");
		System.out.println("-------------");
		System.out.print("메뉴 선택 : ");
	}
}
