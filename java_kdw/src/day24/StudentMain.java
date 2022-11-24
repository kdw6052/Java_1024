package day24;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentMain {
	
	/* 학생 정보를 관리하는 프로그램을 작성하세요.
	 * 1. 학생 추가(이름, 학년, 반, 번호)
	 * 2. 학생 출력
	 * 3. 종료
	 * - 프로그램 시작 전 학생 정보를 읽어오는 기능 추가(load)
	 * - 프로그램 종료 전 학생 정보를 저장하는 기능 추가(save)
	 * 
	 * */
	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args){
		String fileName = "student.txt";
		ArrayList<Student> list = new ArrayList<Student>();
		load(list, fileName);
		int menu=-1;
		do {
			printMenu();
			menu = sc.nextInt();
			runMenu(menu,list);
		}while(menu !=3);
		save(list,fileName);
	}
	
	private static void load(ArrayList<Student> list,String fileName) {
		
		try(ObjectInputStream ois = 
				new ObjectInputStream(new FileInputStream(fileName))) {
			
				while(true) {
					Student std = (Student) ois.readObject();
					list.add(std);
				}
				
			
		} catch (FileNotFoundException e) {
			System.out.println(fileName + "이 없어서 불러오기에 실패했습니다.");
		} catch (EOFException e) {
			System.out.println("불러오기 완료.");
		} catch (Exception e) {
			System.out.println("불러오기 실패.");
		} 
		
	}
	private static void save(ArrayList<Student> list,String fileName) {
		if(list == null)
			throw new RuntimeException("학생을 관리할 리스트가 생성되지 않았습니다.");
		
		try(ObjectOutputStream oos = 
				new ObjectOutputStream(new FileOutputStream(fileName))) {
			for(Student std : list) {
				oos.writeObject(std);
			}
			System.out.println("저장했습니다.");
		} catch (FileNotFoundException e) {
			System.out.println(fileName+ "을 생성할 수 없어서 저장에 실패했습니다.");
		} catch (IOException e) {
			System.out.println("저장에 실패했습니다.");;
		}
			
		
		
	}
	private static void runMenu(int menu,ArrayList<Student> list) {
		switch(menu) {
		case 1 : //학생 추가(이름, 학년, 반, 번호)
			addStudent(list);
			break;
		case 2 : //학생 출력
			printStudent(list);
			break;
		case 3 : 
			System.out.println("프로그램을 종료합니다.");
			System.out.println("=================");
			break;
		default : 
			System.out.println("잘못된 메뉴입니다.");
			System.out.println("=================");
		}
		
	}
	private static void printStudent(ArrayList<Student> list) {
		if(list == null)
			throw new RuntimeException("학생을 관리할 리스트가 생성되지 않았습니다.");
		if(list.size() ==0) {
			System.out.println("등록된 학생이 없습니다.");
			System.out.println("=================");
			return;
		}
		for(Student tmp : list) {
			System.out.println(tmp);
		}
		
	}
	private static void addStudent(ArrayList<Student> list) {
		if(list == null)
			throw new RuntimeException("학생을 관리할 리스트가 생성되지 않았습니다.");
		System.out.print("이름 : ");
		String name = sc.next();
		System.out.print("학년 : ");
		int grade = sc.nextInt();
		System.out.print("반 : ");
		int classNum = sc.nextInt();
		System.out.print("번호 : ");
		int number = sc.nextInt();
		Student std = new Student(name, grade, classNum, number);
		for(Student tmp : list) {
			if(tmp.getGrade()==grade && 
					tmp.getClassNum() ==classNum && tmp.getNumber() == number) {
				System.out.println("이미 등록된 학생입니다");
				System.out.println("=================");
				return;
			}
		}
		list.add(std);
		System.out.println("학생을 등록했습니다.");
		System.out.println("=================");
		
	}
	private static void printMenu() {
		System.out.println("=======메뉴=======");
		System.out.println("1. 학생 추가");
		System.out.println("2. 학생 출력");
		System.out.println("3. 종료");
		System.out.println("=================");
		System.out.print("메뉴 선택 : ");
		
	}
	
}

