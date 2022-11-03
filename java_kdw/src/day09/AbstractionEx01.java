package day09;

public class AbstractionEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
/* 학생 성적 관리 프로그램에서 필요한 학생 클래스를 만들어 보세요.
 * 학생은 학년, 반, 번호, 이름, 성적을 관리
 * 성적은 국어, 영어, 수학 성적만 관리. 각 과목은 100점 만점을 기준으로 관리
 * 학생 정보 출력 기능
 * 성적을 수정하는 기능
 *  - 국어
 *  - 영어
 *  - 수학
 *  - 국어, 영어, 수학
 * 학생정보의 초기값
 *  - 학년 : 1, 반 : 1, 번호 : 1, 이름 : 빈문자열, 성적 : 0
 */
class Student{
	public Student(int grade, int classNumber, int stdNumber,String stdName, int score) {
		grade = 1;
		classNumber = 1;
		stdNumber = 1;
		stdName = "";
		score =0;
		
	}
	
		
	
}