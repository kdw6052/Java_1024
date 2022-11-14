package day16;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class MapEx01 {

	public static void main(String[] args) {
		//map은 세트로 되있기 때문에 향상된 for문 사용불가
		HashMap<String, String> userList = new HashMap<String, String>();
		userList.put("id1", "pw1"); // key = id1(아이디는 중복안됨) , value= pw1(비번은 중복가능
		userList.put("id2", "pw2");
		userList.put("id3", "pw2");
		userList.put("id3", "pw3");//아이디를 중복으로 하면 기존 아이디에 덮어씀
		System.out.println(userList);

		//방법1. keySet을 이용
		//keySet()은 map에 있는 key들을 하나의 set에 담아 반환하는 메소드
		Set<String> keySet = userList.keySet();
		for(String tmp : keySet) {
			//get으로 tmp에 맞는 value를 가져옴
			System.out.println(tmp+ " "+ userList.get(tmp));
		}
		//방법2. EntrySet을 이용
		//entry는 키와 밸류를 객체로 저장
		Set<Entry<String,String>> entrySet = userList.entrySet();
		for(Entry<String, String>tmp : entrySet) {
			System.out.println(tmp.getKey()+" : "+tmp.getValue());
		}
	}

}
