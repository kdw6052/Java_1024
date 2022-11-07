package day11;

public class ClassUpCastingEx01 {

	public static void main(String[] args) {
		/* 자식 클래스인 KiaCar 객체를 부모 클래스인 Car 객체에 저장 : 업 캐스팅
		 * 업 캐스팅은 자동을 동작
		 * */
		//Car car = new KiaCar(4, "K5", 0x00ff00, "12호1234");
		//car.print();
		//Car 배열을 이용하여 여러 종류의 자동차들을 관리할 수 있다.
		Car []carList = new Car[5];//하나의 타입으로 여러타입의 객체 가능
		carList[0] = new KiaCar(4, "K5", 0x00ff00, "12호1234");
		carList[1] = new HyundaiCar(4, "소나타", 0xff0000, "456가1234");
	}
	
}
