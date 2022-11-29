package day27;

import lombok.Data;

@Data
public class Notice {
	private static int count=0;
	private int num;
	private String title,content;
	public Notice(String title, String content) {
		this.title = title;
		this.content = content;
		++count;
		num=count;
	}
	@Override
	public String toString() {
		return "[공지사항"+num+". 제목 : "+ title + ", 내용 :" + content + "]";
	}
	
}
