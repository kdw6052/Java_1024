package example.shopping;

public class Main {

	/* 제품을 관리하는 프로그램을 작성하세요.
	 * -구매가격, 판매가격은 변동이 없음
	 * 기능
	 * -제품 등록(분류, 제품명, 수량, 구매가격, 판매가격)
	 * -제품 수정
	 * -제품 삭제
	 * -제품 구매(관리자가 구매, 입고)
	 * -제품 판매
	 * -매출액 확인
	 * 	-년별
	 * 		-제품별
	 * 		-전체
	 * 	-월별
	 * 		-제품별
	 * 		-전체
	 * 	-일별
	 * 		-제품별
	 * 		-전체
	 * */
	public static void main(String[] args) {
		ShoppingProgram shoppingProgram = new ShoppingProgram();
		shoppingProgram.run();

	}

}
