package BankApp;

import java.io.Serializable;
import java.util.ArrayList;

public class Customer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//	static Scanner in = new Scanner(System.in);
	public String firstName, lastName, userName, passwrd, SSN;
	public String approvalStatus;

	public Customer(String firstName, String lastName, String userName, String passwrd, String SSN) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.passwrd = passwrd;
		this.SSN = SSN;
		this.approvalStatus = "Pending";
		System.out.println(firstName + " " + lastName + " " + userName + " " + passwrd + " " + SSN + " " + approvalStatus);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPasswrd() {
		return passwrd;
	}

	public void setPasswrd(String passwrd) {
		this.passwrd = passwrd;
	}

	public String getSSN() {
		return SSN;
	}

	public void setSSN(String sSN) {
		SSN = sSN;
	}
	
	public String getApprovalStatus() {
		return this.approvalStatus;
	}

	public void setApprovalStatus(String status) {
		this.approvalStatus = status;
	}


	@Override
	public String toString() {
		return "\n"+firstName + "'s Account Summary" + "\nFirst Name: " + firstName + "\nLast Name: " + lastName +  "\nUsername: " + userName + "\nPassword: "
				+ passwrd + "\nSSN: " + SSN + "\nApproval Status: " + approvalStatus;
	}


	
	//Serializing 
	
	
	
	
	
	



}
