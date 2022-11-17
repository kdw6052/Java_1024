package day19;
import java.util.function.Consumer;

public class LambdaEx02 {

	public static void main(String[] args) {
		//람다식이 인터페이스 오버라이딩
		Sum sum = ( a, b)-> a+b;
		System.out.println(sum.run(1, 2));
		Print<Integer> print = a -> System.out.println(a);;
		print.run(10);
		Consumer<String> print2 = str -> System.out.println(str);
		print2.accept("10");
	}

}
interface Sum{
	double run(double a, double b);
}
interface Print<T>{ // 제네릭을 이용하여 다양한 타입 사용가능
	void run(T num);
}