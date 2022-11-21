package day20;

import java.util.ArrayList;

import lombok.Data;

@Data
public class PhoneBook {
	private String name,company;
	ArrayList<PhoneNumbers> phoneNumbers;
	
	public PhoneBook(String name, String company, ArrayList<PhoneNumbers> phoneNumbers) {
		this.name = name;
		this.company = company;
		this.phoneNumbers = phoneNumbers;
	}

	@Override
	public String toString() {
		return "[성명 : " + name + ", 직장 : " + company + ", "
				+ phoneNumbers + "]";
	}

		
}
