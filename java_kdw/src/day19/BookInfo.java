package day19;

import lombok.Data;

@Data

public class BookInfo {//도서명, 저자(여러명, 엮은이, 옮긴이 다 포함), 가격, 출판사, 분류, ISBN
	private static int count;
	private String bookName,author,publisher,type;
	private int price,bookNumber;
	
	public BookInfo(String bookName, String author, int price, String publisher, String type) {
		this.bookName = bookName;
		this.author = author;
		this.price = price;
		this.publisher = publisher;
		this.type = type;
		++count;
		bookNumber = count;
		
	}

	@Override
	public String toString() {
		return "[도서명 : " + bookName + ", 저자 : " + author + ", 출판사 : " + publisher + ", 분류 : " + type
				+ ", 가격 : " + price + ", ISBN : " + bookNumber + "]";
	}
	
}
