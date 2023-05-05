package com.bridgelabz.advaddressbook;

	import java.sql.Connection;
	import java.util.Date;
	import java.sql.Driver;
	import java.sql.DriverManager;
	import java.sql.SQLException;
	import java.util.Enumeration;
	import java.time.LocalDate;


	public class BaseDemo {

		public static Connection connection;

		public static void main(String[] args) throws SQLException {

			listOfDrivers();
			setUpDatabase();
		   
			AddressBookSystemJDBC addressBookSystemJdbc = new AddressBookSystemJDBC();
			addressBookSystemJdbc.retrieveData();
			//addressBookSystemJdbc.updateContactInformation(8);
			AddressBookSystem addressBookSystem = new AddressBookSystem();
		
			LocalDate startDate = LocalDate.of(2021, 05, 01);
			LocalDate endDate = LocalDate.of(2022, 12, 31);
			addressBookSystemJdbc.retrieveData(startDate, endDate);
			addressBookSystemJdbc.getContactsCountByCityOrState("Aurangabad");
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

