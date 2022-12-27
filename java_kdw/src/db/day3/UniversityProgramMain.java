package db.day3;

public class UniversityProgramMain {
	/*
	 * 컨트롤러 -> 학생서비스 -> 학생 다오/매퍼
	 * 		  -> 교수서비스 -> 교수 다오/매퍼
	 * 		  -> 수강서비스 -> 수강 다오/매퍼
	 * */
	public static void main(String[] args) {
		UniversityController uc = new UniversityController();
		uc.run();

	}

}
