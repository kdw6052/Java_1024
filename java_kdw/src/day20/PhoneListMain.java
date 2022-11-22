package day20;

import java.util.ArrayList;
import java.util.Scanner;

import example.phonebook.PhoneBook;
import example.phonebook.PhoneNumber;

public class PhoneListMain {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		/* 전화번호를 관리하는 프로그램을 작성하세요.
		 * 1. 전화번호 추가(성, 이름,직장, 전화번호들(이름 : 번호)
		 * 2. 전화번호 수정
		 *  - 이름으로 검색(성+이름)
		 *  - 검색된 사람들 중에서 선택
		 *  - 성, 이름을 수정할건지, 기존 등록된 전화번호를 수정할건지,
		 *    새 전화번로를 등록할건지를 선택하여 동작
		 * 3. 전화번호 삭제
		 *  - 이름으로 검색(성+이름)
		 *  - 검색된 사람들 중에서 선택
		 *  - 선택된 사람의 연락처를 삭제
		 * 4. 전화번호 조회
		 *  - 이름으로 검색
		 *  - 검색된 사람들 중에서 선택
		 *  - 선택된 사람의 연락처를 출력
		 * */
		ArrayList<PhoneBook> list = new ArrayList<PhoneBook>();
		
		int menu = -1;
		do {
			//메뉴 출력
			printMenu();
			//메뉴 선택
			menu = sc.nextInt();
			//선택한 메뉴에 대한 기능 실행
			runMenu(menu,list);
		}while(menu !=5);
	}
	private static void runMenu(int menu,ArrayList<PhoneBook> list) {
		String name, pName,company;
		String phoneNumber;
		ArrayList<PhoneNumbers> numbers = new ArrayList<PhoneNumbers>();
		switch(menu) {
		case 1 :
			//전화번호 추가(성, 이름,직장, 전화번호들(이름 : 번호)
			//성명, 직장 입력
			System.out.print("성명 : ");
			name = sc.next();
			sc.nextLine();
			System.out.print("직장 : ");
			company = sc.nextLine();
			//전화 번호를 입력(이름 : 번호) => PhoneNumber
			int select = -1;
			do{
				System.out.print("이름 : ");
				pName = sc.next();
				System.out.print("전화번호 : ");
				phoneNumber = sc.next();
				numbers.add(new PhoneNumbers(phoneNumber, pName));
				sc.nextLine();
				System.out.println(numbers);
				//전화번호를 더 입력할건지 물어봄
				System.out.println("추가로 전화번호를 추가 하시겠습니가?");
				System.out.print("1. 예");
				System.out.print("2. 아니요");
				select = sc.nextInt();
			}while(select !=2);
			//전화번호부에 추가 =>PhoneBook 개체를 생성
			
			//PhoneBook book = new PhoneBook(name, company, numbers)
			//list.add(book);
			System.out.println(list);
			break;
		case 2 :
			/*//이름을 입력
			System.out.print("수정할 이름 : ");
			String pName1 = sc.next();
			ArrayList<PhoneBook>list2 = new ArrayList<PhoneBook>();
			//이름이 포함된 전화번호부를 검색하여 출력(번호와 함께)
			for(PhoneBook tmp : list) {
				for(int i = 0;i<list.size();i++) {
					if(tmp.getpName().contains(pName1)||tmp.getPnList().contains(pName1)||tmp.getCompany().contains(pName)) {
						System.out.println(i+1+". "+tmp);
						list2.add(tmp);
					}
				}
			}
			//수정할 전화번호부를 선택
			System.out.print("수정할 전화번호부 : ");
			int index = sc.nextInt()-1;
			//서브 메뉴 출력
			printSubMenu();
			//서브 메뉴 선택
			int subMenu = sc.nextInt();
			//서브 메뉴 실행
			switch(subMenu){
			case 1 : //1.이름,직장 수정
				//이름 직장 입력
				sc.nextLine();
				System.out.print("수정할 성명 : ");
				String pName = sc.nextLine();
				System.out.print("수정할 직장 : ");
				String company1 = sc.nextLine();
				//이름,직장 수정
				
				list2.get(index).getCompany().indexOf(company1);
				System.out.println(list);
				
				break;
			case 2 : //2.기존 전화번호 수정
				//기존 전화번로들을 출력
				//수정할 전화번호를 선택
				//이름, 번호를 입력
				//선택한 전화번호 이름, 번호를 수정
				break;
			case 3 : //3.새 전화번호 추가
				//이름 번호를 입력
				//새 전화번호를 추가
				break;
			}
			break;*/
		case 3 :
			//이름이 포함된 전화번호부를 검색하여 번지를 확인
			/* ArrayList<PhoneBook>list2 = new ArrayList<PhoneBook>();
			 * for(PhoneBook tmp : list) {
				for(int i = 0;i<list.size();i++) {
					if(tmp.getpName().contains(name)||tmp.getPnList().contains(name)||tmp.getCompany().contains(name)) {
						System.out.println(i+1+". "+tmp);
						list2.add(tmp);
					}
				}
			}
			//확인된 번지에 있는 번호들을 출력(번호와 함께)
			//삭제할 전화번호부를 선택
			System.out.print("삭제할 전화번호부 : ");
			int index = sc.nextInt()-1;
			//전화번호 삭제
			list.remove(list2.get(index));
			System.out.println(list);*/
			break;
		case 4 :
			//전화번호 조회
				//이름을 입력
				//이름이 포함된 전화번호부를 검색하여 출력(번호와 함께)
				//수정할 전화번호부를 선택
				//전화번호 조회
			break;
		case 5 :
			System.out.println("프로그램을 종료합니다");
			break;
		default :
			System.out.println("잘못된 메뉴입니다.");
		}
		
	}
	public static void printSubMenu() {
		System.out.println("=====수정 메뉴=====");
		System.out.println("1.이름,직장 수정");
		System.out.println("2.기존 전화번호 수정");
		System.out.println("3.새 전화번호 추가");
		System.out.println("=================");
		System.out.print("메뉴 선택 : ");
		
	}
	public static void printMenu() {
		System.out.println("=====전화번호부=====");
		System.out.println("1.전화번호 추가");
		System.out.println("2.전화번호 수정");
		System.out.println("3.전화번호 삭제");
		System.out.println("4.전화번호 조회");
		System.out.println("5.프로그램 종료");
		System.out.println("==================");
		System.out.print("메뉴 선택 : ");
		
		
	}

}
