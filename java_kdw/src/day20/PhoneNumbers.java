package day20;

import lombok.Data;

@Data
public class PhoneNumbers {
	private String phoneNumber,pName;

	public PhoneNumbers(String phoneNumber, String pName) {
		this.phoneNumber = phoneNumber;
		this.pName = pName;
	}

	@Override
	public String toString() {
		return pName + " : "  + phoneNumber;
	}

	
}
