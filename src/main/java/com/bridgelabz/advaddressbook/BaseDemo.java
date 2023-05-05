package com.bridgelabz.advaddressbook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.util.Date;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDate;

public class BaseDemo {

	public static Connection connection;

	public static void main(String[] args) throws SQLException, IOException {

		listOfDrivers();
		setUpDatabase();

		AddressBookSystemJDBC addressBookSystemJdbc = new AddressBookSystemJDBC();
		addressBookSystemJdbc.retrieveData();
		// addressBookSystemJdbc.updateContactInformation(8);
		AddressBookSystem addressBookSystem = new AddressBookSystem();

		LocalDate startDate = LocalDate.of(2021, 05, 01);
		LocalDate endDate = LocalDate.of(2022, 12, 31);
		addressBookSystemJdbc.retrieveData(startDate, endDate);
		addressBookSystemJdbc.getContactsCountByCityOrState("Aurangabad");
		addressBookSystemJdbc.addContact("Pankaj", "Shinde", "Chalis", "Khandesh", "Chalisgoan",
				"pankajshinde@gmail.com", "8858863271", "768520", "My Friend", "Panku", endDate);
		addressBookSystemJdbc.addContactJS("Karan", "Salve", "Mirzapur", "Bhopal", "MP", "jas@341.com", "9056284571",
				"850234", "My Friend", "Karan", endDate);
	}

	public static Connection setUpDatabase() {
		String jdbcURL = "jdbc:mysql://localhost:3306/address_book_system_service";
		String username = "root";
		String password = "Kiran@68068";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver is loaded successfully");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();

			throw new IllegalStateException("Cannot load the driver successfully" + e);
		}

		try {
			System.out.println("Databases connected to the database: " + jdbcURL);
			connection = DriverManager.getConnection(jdbcURL, username, password);
			System.out.println("Connection established successfully" + connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public static void listOfDrivers() {
		Enumeration<Driver> enumeration = DriverManager.getDrivers();
		while (enumeration.hasMoreElements()) {
			Driver driver = (Driver) enumeration.nextElement();
			System.out.println("  " + driver.getClass().getName());
		}
	}
}
