package com.bridgelabz.addressbooksystem;

import java.util.Scanner;

public class AddressBookMain {

	public static void main(String[] args) {

		System.out.println("Welcome To Address Book System");
		AddressBook addressBook = new AddressBook();

		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("Enter 1 to add contacts");
			System.out.println("Enter 2 to display all contacts");
			System.out.println("Enter 3 to edit a contact");
			System.out.println("Enter 0 to exit");

			int choice = scanner.nextInt();

			switch (choice) {
			case 0:
				System.out.println("Exiting Address Book");
				System.exit(0);

			case 1:
				addressBook.addContacts();
				break;
			case 2:
				addressBook.displayContacts();
				break;
			case 3:
				System.out.println("Enter the name of the contact to edit:");
				String firstName = scanner.nextLine();
				System.out.println("Enter the last name of the contact to edit: ");
				String lastName = scanner.nextLine();
				addressBook.editPerson(firstName, lastName);
				break;
			}
		}

	}

}
