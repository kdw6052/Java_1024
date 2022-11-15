package day17;

import day09.ThisEx01;
import lombok.Data;

@Data
public class Board01 {
	private int number,count;
	private String title,content,name,date;
	
	public Board01(int number, String title, String content, String name, String date,int count) {
		this.number = number;
		this.count = count;
		this.title = title;
		this.name = name;
		this.date = date;
		this.content = content;
	}
	public Board01() {}
	@Override
	public String toString() {
		return "[번호 : " + number  + ", 제목 : " + title + ", 내용 : " + content +
				", 작성자 : "+ name + ", 작성일 : " + date + ", 조회수 : " + count+ "]";
	}
	public static int addCount(int count) {
		return count++;
	}
	public  int addNumber() {
		this.number = number++;
		return number;
	}
	public void allBoard(int number, String title, String name, String date) {
		this.number = number;
		this.title = title;
		this.name = name;
		this.date = date;
		
	}
	
}
