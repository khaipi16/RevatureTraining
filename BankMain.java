package BankApp;

import java.io.Serializable;
import java.util.Scanner;

public class BankMain implements Serializable{
	static Scanner in = new Scanner(System.in);
	private String bankName = "Infinite Bank";
	private static String user, password;
	private static boolean cusChoice;
	
	/*
	Project-0 Definition-
	Project 0: Banking App

	Part 1
	Description
	Leveraging Java 8, create an application that simulates simple banking transactions
	Requirements
	Build the application using Java 8
	+All interaction with the user should be done through the console using the Scanner class
	+Customers of the bank should be able to register with a username and password, and apply to open an account.
	//Customers should be able to apply for joint accounts
	-->Once the account is open, customers should be able to withdraw, deposit, and transfer funds between accounts
	-->All basic validation should be done, such as trying to input negative amounts, overdrawing from accounts etc.
	+Employees of the bank should be able to view all of their customers information. This includes:
	+Account information
	-->Account balances
	+Personal information
	-->Employees should be able to approve/deny open applications for accounts
	//Bank admins should be able to view and edit all accounts
	This includes:
	Approving/denying accounts
	withdrawing, depositing, transferring from all accounts
	canceling accounts
	All information should be persisted using text files and serialization
	100% test coverage is expected using JUnit
	You should be using TDD
	Logging should be accomplished using Log4J
	All transactions should be logged
	 */

	//	Integer moneyAmount;
	//	BankMain(int moneyAmount){
	//		this.moneyAmount = moneyAmount;
	//		
	//		
	//	}
	//	
	//	public String toString() {
	//		return moneyAmount.toString();
	//	}

	//method welcome: welcoming the user and asking what they wanna do

	static boolean newCustomer;
	public void welcomePage(DataBase data) {

		boolean change = false;
		int counter = 0;

		do {
			System.out.println("Welcome to Deez Bank! Please select from one of the following option");
			String[] choices = {"a. Customer-Login", "b. Employee-Login", "c. Register", "d. Exit"};
			for(int i = 0; i < choices.length; i++) {
				System.out.println(choices[i]);
			}
			String choice = in.nextLine();
			switch(choice) {

			//"a" == logging in existing customers
			case "a": System.out.println("*-*-*-Customer-*-Login-*-*-*"); {
				//DataBase.readCustomers();
				System.out.print("Username: ");
				user = in.nextLine();
				System.out.print("Password: ");
				password = in.nextLine();
				if(data.state==true) {
					if( Employee.status == false) {
						cusChoice = true;
						System.out.println("Welcome!");
						accCustomer.customerChoice();
						int chooseCus = in.nextInt();
						do {switch(chooseCus) {
						case 1:{
							accCustomer.getBalance();
							break;
						}
						case 2:{
							accCustomer.withdraw();
							break;
						}

						case 3:{
							accCustomer.deposit();
							break;
						}
						case 4:System.out.println("4. Return to main menu");{
							cusChoice = false;
							break;
						}
						default: 
							System.out.println("Error!");
							break;
						}
						break;
						//DataBase.writeCustomers();
							
						}while(cusChoice);
					
					}
					else if(Employee.status == false) {
						System.out.println("Sorry your application has been rejected!");
						break;
					}
					else if((data.userCustomers.containsKey(password) )){
						accCustomer.customerChoice();
						break;

					}
					else{
						System.out.println("Sorry for the inconvenience, but your account is still pending!");
						break;
					}
		
				}
				else if(data.state == false) {
					System.out.println("Incorrect username/passowrd!");
					break;

				}
				break;
			

			}
			case "b": System.out.println("*-*-*-Employee-*-Login-*-*-*"); {
				System.out.print("Username: ");
				String userE = in.nextLine();
				System.out.print("Password: ");
				String passwordE = in.nextLine();
				if(data.verifyEmployees(userE, passwordE) == true) {
					System.out.println("Welcome!");
					data.readCustomers();
					if(Employee.acceptAcc() == true) {
						data.state = true;
						System.out.println("Account Accepted!");
					}
				}
				break;
			}
			case "c": System.out.println("Welcome new coming customer! Please enter a username and password you would like for your new account!");{
				data.writeCustomers();
				newCustomer = true;
				break;

			}
			case "d":{
				System.exit(0);
			}

			default:{
				System.out.println("Please pick from the following options above");
				//System.exit(0);
				change = true;
			}
			}

		}while(true);

	}

	public static void main(String[] args) {
		BankMain bank = new BankMain();
		//DataBase.loadCustomers();
		DataBase data = new DataBase();
		//data.readCustomers();
//		DataBase.readCustomers();
		bank.welcomePage(data);
		data.writeCustomers();
		//DataBase.saveCustomers();

	}

}
