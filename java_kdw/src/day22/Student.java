package day22;

import lombok.Data;

@Data
public class Student {
	private String name,birthday;

	public Student(String name, String birthday) {
		this.name = name;
		this.birthday = birthday;
	}

	public Student(Student std) {
		this.name = std.name;
		this.birthday = std.birthday;
	}

	public void update(String name, String birthday) {
		this.name = name;
		this.birthday = birthday;
		
	}

	@Override
	public String toString() {
		return "이름 : " + name + ", 생일 : " + birthday ;
	}
	
}
