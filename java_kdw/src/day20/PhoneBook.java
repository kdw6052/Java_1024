package day20;

import java.util.ArrayList;

import lombok.Data;

@Data
public class PhoneBook {
	private String lastName, name,rectal;
	public ArrayList<PhoneNumbers> phoneNumbers;
	
	public PhoneBook(String lastName, String name, String rectal, ArrayList<PhoneNumbers> phoneNumbers) {
		this.lastName = lastName;
		this.name = name;
		this.rectal = rectal;
		this.phoneNumbers = phoneNumbers;
	}

	@Override
	public String toString() {
		return "[성 : " + lastName + ", 이름 : " + name + ", 직장 : " + rectal + ", 전화번호 : "
				+ phoneNumbers + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhoneBook other = (PhoneBook) obj;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (rectal == null) {
			if (other.rectal != null)
				return false;
		} else if (!rectal.equals(other.rectal))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((rectal == null) ? 0 : rectal.hashCode());
		return result;
	}

	
}
