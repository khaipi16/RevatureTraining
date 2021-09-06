package BankApp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Scanner;

public class DataBase implements Serializable{

	static String first, last, user, passW, ssn;
	static Scanner in = new Scanner(System.in);
	static HashMap<String, String> userEmployees = new HashMap<>();
	static HashMap<String, Customer> userCustomers = new HashMap<>();
	static File fileCustomers = new File("files/customers.txt");
	public static boolean state;


	//Writing the customer data into userCustomers
	public static void writeCustomers() {
		System.out.print("Please enter your first name: ");
		first = in.nextLine();

		System.out.print("Please enter your last name: ");
		last = in.nextLine();

		System.out.print("Please enter your username: ");
		user = in.nextLine();

		System.out.print("Please enter your password: ");
		passW = in.nextLine();

		System.out.print("Please enter your SSN: ");
		ssn = in.nextLine();
		
		userCustomers.put(passW, new Customer(first, last, user, passW, ssn));

		FileOutputStream fileOut;
		try {
			fileOut = new FileOutputStream(fileCustomers);
			ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
			System.out.println("Username is: " + first);
			System.out.println("Password is: " + passW);
			objOut.writeObject(userCustomers);
			fileOut.flush();
			fileOut.close();
			objOut.close();

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	//method to read the customer data from the save file of userCustomers
	@SuppressWarnings("unchecked")
	public static HashMap<String, Customer> readCustomers() {
//		HashMap<String, Customer> returnThis = new HashMap<String, Customer>();
		try {
			FileInputStream fileIn = new FileInputStream(fileCustomers);
			ObjectInputStream objIn = new ObjectInputStream(fileIn);
			userCustomers = (HashMap<String, Customer>)objIn.readObject();
			//String[] userN = returnThis.toString().split(returnThis.size(), "=");
		//	System.out.println("returning values are: " + userInput + "user might be: "); //)+ Arrays.toString(userN));

		} catch (IOException i) {
			System.out.println("error! there is no account with that username/password in our data base!");

		}catch (ClassNotFoundException e) {
			System.out.println("error 2: " + e.getMessage());
		}
		System.out.println(userCustomers.toString());
		return userCustomers;

	}
	
	//loading customers data
		@SuppressWarnings("unchecked")
		public static void loadCustomers() {
			try {
				FileInputStream fileIn = new FileInputStream(fileCustomers);
				ObjectInputStream in = new ObjectInputStream(fileIn);
				userCustomers = (HashMap<String, Customer>)in.readObject();
				in.close();
				fileIn.close();
			} catch (IOException i) {
				i.printStackTrace();
				return;
			} catch (ClassNotFoundException c) {
				c.printStackTrace();
				return;
			}
		}
		
		//saving the customers data
		public static void saveCustomers() {
			try {
				FileOutputStream fileOut = new FileOutputStream(fileCustomers);
				ObjectOutputStream out = new ObjectOutputStream(fileOut);
				out.writeObject(userCustomers);
				out.close();
				fileOut.close();
			} catch (IOException i) {
				i.printStackTrace();
			}
		}
	
	
	//FOR EMPLOYEES
	@SuppressWarnings("unchecked")
	public static HashMap<String, String> readEmployees() {
		userEmployees.put("jsmoey", "joesmoe123");
		userEmployees.put("dpup", "dainty321");
		userEmployees.put("bduck", "babyD21");
//		try {
//			FileInputStream fileIn = new FileInputStream("files/employees.txt");
//			ObjectInputStream objIn = new ObjectInputStream(fileIn);
//			userEmployees = (HashMap<String, String>)objIn.readObject();
//			//String[] userN = returnThis.toString().split(returnThis.size(), "=");
//			//System.out.println("returning values are: " + userInput + "user might be: "); //)+ Arrays.toString(userN));
//		} catch (IOException i) {
//			System.out.println("error! there is no account with that username/password in our data base!");
//
//		}catch (ClassNotFoundException e) {
//			System.out.println("error 2: " + e.getMessage());
//		}
		System.out.println(userEmployees.toString());
		return userEmployees;

	}

	//verifying login system for the customer account
	public static void verifyLogin(String username, String password) {		
		if(DataBase.readCustomers().get(password) != null) {
			state = true;
			
		}
		else {
			state = false;
			System.out.println("Wrong username/password!");
		}
	}
	
	//verifying the employees account 
	public static boolean verifyEmployees(String username, String password) {
		if(readEmployees().containsKey(username) && readEmployees().containsValue(password)) {
			return true;
		}
		else {
			System.out.println("Wrong username/password!");
			return false;
		}
	}
//	public static void setApprovalStatus() {
//		if(Employee.acceptAcc() == true) {
//			Customer customer = DataBase.readCustomers().;
//			
//		}
//		
//	}



	//	public boolean addAccount() {
	//		
	//	}

	//	public static void main(String[] args) {
	//		testSerialize t1 = new testSerialize();
	//		t1.Serialize();
	//		t1.readCustomers();
	//		t1.verifyLogin();
	//
	//	}

}
