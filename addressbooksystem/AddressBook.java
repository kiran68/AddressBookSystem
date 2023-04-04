package com.bridgelabz.addressbooksystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBook extends Contacts {

	Contacts contacts = new Contacts();
	Scanner scanner = new Scanner(System.in);
	List<Contacts> Contacts = new ArrayList<Contacts>();

	public void addContacts() {

		System.out.println("Enter First Name : ");
		String firstName = scanner.nextLine();
		contacts.setFirstName(firstName);

		System.out.println("Enter Last Name : ");
		String lastName = scanner.nextLine();
		contacts.setLastName(lastName);

		System.out.println("Enter Address :");
		String address = scanner.nextLine();
		contacts.setAddress(address);

		System.out.println("Enter City : ");
		String city = scanner.nextLine();
		contacts.setCity(city);

		System.out.println("Enter State : ");
		String state = scanner.nextLine();
		contacts.setState(state);

		System.out.println("Enter Email : ");
		String email = scanner.nextLine();
		contacts.setEmail(email);

		System.out.println("Enter ZIP : ");
		int zip = scanner.nextInt();
		contacts.setZip(zip);

		System.out.println("Enter Phone Number");
		long phoneNumber = scanner.nextLong();
		contacts.setPhoneNumber(phoneNumber);

		Contacts.add(contacts);
		System.out.println("Person is Created Scussfully");

	}

	public void displayContacts() {
		if (Contacts.isEmpty()) {
			System.out.println("Address Book Is Empty");
		}
		System.out.println("Address book");
		for (Contacts contacts : Contacts) {
			System.out.println(contacts.address);
			System.out.println(contacts.getLastName());
			System.out.println(contacts.getAddress());
			System.out.println(contacts.getCity());
			System.out.println(contacts.getState());
			System.out.println(contacts.getEmail());
			System.out.println(contacts.getZip());
			System.out.println(contacts.getPhoneNumber());
		}

	}
public void editPerson( String firstName, String lastName) {
	System.out.println("Enter the First name you want to edit. \n");
	
	 firstName = scanner.nextLine();
	
	for (int i = 0; i < Contacts.size();i++) {
		if(Contacts.get(i).getFirstName().equals(firstName)) {
			Contacts.get(i).setFirstName(firstName);
			
			System.out.println("Enter Last Name : ");
			 lastName = scanner.nextLine();
			Contacts.get(i).setLastName(lastName);

			System.out.println("Enter Address :");
			String address = scanner.nextLine();
			Contacts.get(i).setAddress(address);

			System.out.println("Enter City : ");
			String city = scanner.nextLine();
			Contacts.get(i).setCity(city);

			System.out.println("Enter State : ");
			String state = scanner.nextLine();
			Contacts.get(i).setState(state);

			System.out.println("Enter Email : ");
			String email = scanner.nextLine();
			Contacts.get(i).setEmail(email);

			System.out.println("Enter ZIP : ");
			int zip = scanner.nextInt();
			Contacts.get(i).setZip(zip);

			System.out.println("Enter Phone Number");
			long phoneNumber = scanner.nextLong();
			Contacts.get(i).setPhoneNumber(phoneNumber);
			
			System.out.println("Person Edited Succesfully");
			}
		else {
			System.out.println("Person Not Found in Address Book ");
		}
	}
}
}
