package day27;

import lombok.Data;

@Data
public class User {
	private String id,pw;

	public User(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}
	
}
