package day20;

import lombok.Data;

@Data
public class PhoneNumbers {
	private String phoneNumber,name;

	public PhoneNumbers(String phoneNumber, String name) {
		this.phoneNumber = phoneNumber;
		this.name = name;
	}

	@Override
	public String toString() {
		return name + " : "  + phoneNumber;
	}

	
}
