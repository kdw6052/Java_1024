package day11;

public class StringEx03 {

	public static void main(String[] args) {
		/* 주어진 파일명들 중에서 이미지 파일들을 찾아 파일명을 출력하세요
		 * 이미지 파일 확장자는 jpg, png*/
		String[] list = {
				"이미지1.jpg", "음악1.bmp", "이미지2.mp4", "이미지3.png", "예제.txt"
		};
		for(String tmp : list) {
			int index= tmp.lastIndexOf(".");
			String search = tmp.substring(index);
			if(search.equals(".jpg")||search.equals(".png")) {
				System.out.println(tmp);
			}
		}
		//반복문
			//확장자 추출 :lastIndexOf, subString
			//확장자가 이미지 확장자인지 확인하여 맞으면 파일명 출력
		
		/*for(String tmp : list) {
			int index = tmp.lastIndexOf(".");
			String extension = tmp.substring(index);
			if(extension.equals(".jpg")||extension.equals(".png")) {
				System.out.println(tmp);
			}
		}*/
	}

}
