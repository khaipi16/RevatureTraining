package BankApp;

import java.util.ArrayList;
import java.util.Scanner;

public class accCustomer{
	static Scanner input = new Scanner(System.in);
	private static double balance;
	static ArrayList<Integer> currBalance;

	public static ArrayList<Integer> getCurrBalance() {
		return currBalance;
	}

	//	public static void setCurrBalance(ArrayList<Integer> currBalance) {
	//		accCustomer.currBalance = currBalance;
	//	}



	//  constructor to initialize the initial balance
	public accCustomer(double balance) {
		accCustomer.balance = balance;

	}
	ArrayList<Integer> bankCus = new ArrayList<Integer>();

	public static void setBalance(double balance) {
		accCustomer.balance = balance;
	}

	//getter method
	public static double getBalance() {
		System.out.println("Your balance is: " + balance);
		return balance;

	}

	public static void customerChoice() {
		String[] optionCus = {"1. show balance", "2. withdraw", "3. deposit", "4. transfer"};
		for(int i = 0; i <optionCus.length; i++) {
			System.out.println(optionCus[i]);
		}
	}

	//deposit method: asks user for amount to deposit
	public static void deposit() {
		System.out.print("Please enter amount you would like to deposit: ");
		double amount = input.nextDouble();
		if(amount < 0 || amount == 0) {
			System.out.println("Error! You cannot deposit negative or $0!");
			
		}
		else if(amount > 100000) {
			System.out.println("Sorry, you cannot deposit more than $100,000 per deposit");
		}
		else {
			balance += amount;
		}
		//		while(input.hasNextInt()){
		//			bankCus.add(input.nextInt());
		//			currBalance = bankCus;
		//			//System.out.println(bankCus);
		//		}
		//		//System.out.println("balance is: " + bankCus);
		//		//Integer [] nums = bankCus.toArray(new Integer[0]);
		//		//		for(int i = 0; i < bankCus.size(); i++){
		//		//			System.out.println(bankCus);
		//		//		}
		//		if(bankCus.equals(0) ) {
		//			System.out.println("Error! Cannot deposit negative amount or $0!");
		//			System.out.println("Your balance is: " + currBalance.toString());
		//		}
		//
		//		else{
		//			currBalance = currBalance;
		//			System.out.println("Your balance is: " + currBalance.toString());
		//		}
	}



	@Override
	public String toString() {
		return "accCustomer [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	//withdraw method: asks user for amount to withdraw
	public static void withdraw() {
		System.out.print("Please enter amount you would like to withdraw: ");
		double amount = input.nextDouble();
		if(amount < 0 || amount == 0) {
			System.out.println("Error! Cannot withdraw negative amount!");
		}
		else if(amount > balance) {
			System.out.println("Error! Cannot withdraw more than balance!");
		}
		else {
			balance -= amount;
			System.out.println("Your balance is: " + balance);
		}
	}





}
