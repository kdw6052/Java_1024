package day27;

import lombok.Data;

@Data
public class FreeBoard {
	private static int count=0;
	private int num;
	private String title,content;
	public FreeBoard(String title, String content) {
		this.title = title;
		this.content = content;
		++count;
		num=count;
	}
	
	@Override
	public String toString() {
		return "[자유게시판 " + num + ". 제목 :" + title +
				", 내용 :" + content + "]";
	}
	
}
