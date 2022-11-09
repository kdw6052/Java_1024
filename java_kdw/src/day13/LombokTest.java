package day13;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

public class LombokTest {

	public static void main(String[] args) {
		TestA a= new TestA();
		a.setNum(10);
		System.out.println(a.getNum());
		System.out.println(a);//toString()확인
		TestA b  = new TestA();
		b.setNum(10);
		System.out.println(a.equals(b));//equls() 확인
	}

}
@Data // @Getter, @Setter, @ToStoring, @EqualsAnhHashCode, @RequiredArgsConstructo
class TestA{
	private int num;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TestA other = (TestA) obj;
		if (num != other.num)
			return false;
		return true;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + num;
		return result;
	}
}