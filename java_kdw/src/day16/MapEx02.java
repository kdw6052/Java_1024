package day16;

import java.util.HashMap;
import java.util.Set;
import java.util.Map.Entry;

import lombok.Data;

public class MapEx02 {

	public static void main(String[] args) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("user", new User("abc", "def"));
		map.put("age", 22);
		map.put("address", "서울시");
		System.out.println(map.get("user"));
		System.out.println(map.get("age"));
		System.out.println(map.get("address"));
		System.out.println(map.get("123"));
	
		Set<Entry<String, Object>> entrySet = map.entrySet();
		for(Entry<String, Object> tmp : entrySet) {
			System.out.println(tmp.getKey()+" : "+tmp.getValue());
		}
	}
}
@Data
class User{
	private String id, pw;
	public User(String id, String pw) {
		this.id = id;
		this.pw = pw;
	
	}
}