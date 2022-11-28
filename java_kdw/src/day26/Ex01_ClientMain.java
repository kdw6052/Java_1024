package day26;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Ex01_ClientMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Socket socket = null;
		
		try {
			socket = new Socket();
			socket.connect(new InetSocketAddress(5001));
			System.out.println("[연결 완료]");
			//Output 스트림 연결
			OutputStream os = socket.getOutputStream();
			//보내려는 문자열을 byte 배열로 변환
			System.out.println("문자를 입력하세요.");
			String str = sc.nextLine();
			byte [] bytes = str.getBytes("UTF-8");
			//전송
			os.write(bytes);
			os.flush();
			//서버에서 문자열을 입력받아
			bytes = new byte[1024];
			InputStream is = socket.getInputStream();
			int readCount = is.read(bytes);
			str = new String(bytes,0,readCount,"UTF-8");
			System.out.println(str);
			System.out.println("[전송완료]");
			//콘솔에 출력
			//Output 스트림 객체 닫음
			os.close();
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		sc.close();
	}

}
/* 서버소켓 생성
 * ServerSocket serversocket = null;
 * 
 * 		try { serversocket = new ServerSocket(); 
 * 			serversocket.bind(new
 * 			InetSocketAddress(5001)); 
 * 			while(true) { 
 * 			System.out.println("[연결 대기 중]");
 * 			Socket socket = serversocket.accept(); 
 * 			InetSocketAddress isa =
 * 				(InetSocketAddress)socket.getRemoteSocketAddress();
 * 			System.out.println("[연결 수락 함]" + isa.getAddress()); 
 * 			} 
 * 		} catch (IOException e){
 * 		 	e.printStackTrace(); 
 * 		}
 */