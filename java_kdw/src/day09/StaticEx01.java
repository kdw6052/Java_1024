package day09;
public class StaticEx01 {

	public static void main(String[] args) {
		KiaCar k1 = new KiaCar("모닝");
		KiaCar k2 = new KiaCar("레이");
		KiaCar k3 = new KiaCar("K3");
		k1.print();
		k2.print();
		k3.print();
		k1.name = "K5";
		//k1.logo = "Kia"; //가능은 하지만 일반적이진 않다
		KiaCar.logo = "kia";
		System.out.println();
		k1.print();
		k2.print();
		k3.print();
	}

}
class KiaCar{
	public static String logo = "KIA";
	public String name;
	public KiaCar(String name) {
		this.name = name;
	}
	public void print() {
		System.out.print(logo);
		System.out.println(" : "+name);
	}
	public static void prinLogo() {//메소드에서 static이 붙은 것들만 가능
		System.out.print(logo);
		//System.out.println(" : "+name);//에러발생 : name은 객체가 만들어져야 사용가능
	}
}