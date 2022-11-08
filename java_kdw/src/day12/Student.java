package day12;

public class Student {

	public int grade,claaNum,num;
	public String name;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + claaNum;
		result = prime * result + grade;
		result = prime * result + num;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		//같은 객체 공유
		if (this == obj)
			return true;
		//null과 비교 불가능
		if (obj == null)
			return false;
		//obj가 같은 클래스의 객체가 아닌 경우
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (claaNum != other.claaNum)
			return false;
		if (grade != other.grade)
			return false;
		if (num != other.num)
			return false;
		return true;
	}
	//멤버들을 하나의 문자열로 만들어줌
	@Override
	public String toString() {
		return "Student [grade=" + grade + ", claaNum=" + claaNum + ", num=" + num + ", name=" + name + "]";
	}
	
}
