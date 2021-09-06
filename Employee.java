package BankApp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Employee extends accCustomer{

	public Employee(double balance) {
		super(balance);
		// TODO Auto-generated constructor stub
	}

	//	public accEmployee(double balance) {
	//		super(balance);
	//	}
	static Scanner in = new Scanner(System.in);
	static String option;
	String password;
	String user;
	public static boolean status;


	public static boolean acceptAcc() {
		//		System.out.println("What would you like to do?");
		//		DataBase.readCustomers();
		//while(BankMain.newCustomer==true) {
		System.out.println("Would you like to approve new customer: (y)/(n) ");
		option = in.nextLine();
		if(option.equals("y")) {
			status = true;
			return true;
		}
		else if(option.equals("n")) {
			status = false;
			return false;
		}
		else {
			System.out.println("test false");
			return false;
		}
		
		//}
	}

	//	public static boolean acceptAccount(String judgement) {
	//		//		System.out.println("What would you like to do?");
	//		//		DataBase.readCustomers();
	//		System.out.println("Would you like to approve new customer: (y)/(n) ");
	//		option = in.nextLine();
	//		if(option.equals("y")) {
	//			customers.setApprovalStatus("Approved");
	//			return true;
	//		}
	//		else if(option.equals("n")) {
	//			customers.setApprovalStatus("Denied");
	//			return false;
	//		}
	//		else {
	//			System.out.println("test false");
	//			return false;
	//		}
	//		else
	//			return false;
	//	}

	//	public static String customerStatus(String password) {
	//		String customers = DataBase.loadCustomers();
	//		return customers.approvalStatus;
	//	}


	//	public void openAccounts(String username, String password) {
	//		if(acceptAcc() == true) {
	//			
	//			
	//
	//		}
	//	}


	public static void main(String[] args) {
		//Employee.acceptAcc();
		//Customer customers = DataBase.readCustomers().get("444");
		//customers.get(0);
		//System.out.println("This is the real one: " + customers.toString());
		//DataBase.readEmployees().get("dainty321");
		DataBase.readEmployees().containsKey("dpup");

	}



}
