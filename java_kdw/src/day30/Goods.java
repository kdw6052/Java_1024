package day30;

import lombok.Data;

@Data
public class Goods {//분류, 제품명, 수량, 구매가격, 판매가격
	private String division, name;
	private int numbers, buyPrice, sellPrice;
	
	public Goods(String division, String name, int numbers, int buyPrice, int sellPrice) {
		this.division = division;
		this.name = name;
		this.numbers = numbers;
		this.buyPrice = buyPrice;
		this.sellPrice = sellPrice;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Goods other = (Goods) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	public void update(String division, String name, int numbers, int buyPrice, int sellPrice) {
		this.division = division;
		this.numbers = numbers;
		this.buyPrice = buyPrice;
		this.sellPrice = sellPrice;
		
	}

	
}
