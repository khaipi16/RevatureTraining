package BankApp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class mainCustomer {
//	static Scanner in = new Scanner(System.in);
	static String first, last, user, pass, ssn;
	ArrayList<Customer> customers = new ArrayList<Customer>();
	static Scanner in = new Scanner(System.in);

//	public static Map<String, Customer> load(){
//		Map<String, Customer> customerMap = new HashMap<String, Customer>();
//		
//		try {
//			Scanner in = new Scanner(new File("files/customers.txt"));
//			System.out.println("Enter username and password");
//			while(in.hasNext()) {
//				String[] splitString = in.nextLine().split(",");
//				Customer u = new Customer(splitString);
//				customerMap.put(u.userName, u);
//			}
//		}catch(FileNotFoundException e) {
//			System.out.println(e.getMessage());
//		}
//		return customerMap;
//	}
	
//    @SuppressWarnings("unchecked")
//	public HashMap<String, Customer> readCustomers() {
//        HashMap<String, Customer> cus = new HashMap<String, Customer>();
//        
//
//        try {
//            FileInputStream fileIn = new FileInputStream("files/customers.txt");
//            ObjectInputStream in = new ObjectInputStream(fileIn);
//            returnThis = (HashMap<String, Customer>)in.readObject();
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return cus;
//    }
//
//    public void writeCustomers(HashMap<String, Customer> inside) {
//    	 System.out.println("Username: ");
//         String userN = in.nextLine();
//         System.out.println("Password: ");
//         String passW = in.nextLine();
//         
//       //  cus.put(userN, Customer);
//
//        try {
//            FileOutputStream fileOut = new FileOutputStream("files/customers.txt");
//            ObjectOutputStream out = new ObjectOutputStream(fileOut);
//            out.writeObject(in);
//            System.out.println(in);
//            out.flush();
//            out.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    public static void main(String args[]) {
//    	writeCustomers(3,);
//    	
//    }
//	public static boolean verifyLogin() {
//		
//		
//	}

	
	
	
	
//	public void addCustomers() {
//		inputCustomers();
//	}
//
	public static void inputCustomers() {
		boolean registerYes = true;
		System.out.print("Please enter your first name: ");
		 first = in.nextLine();
		
		System.out.print("Please enter your last name: ");
		 last = in.nextLine();
		
		System.out.print("Please enter your username: ");
		 user = in.nextLine();
		
		System.out.print("Please enter your password: ");
		 pass = in.nextLine();
		
		System.out.print("Please enter your SSN: ");
		 ssn = in.nextLine();
	}
    
    
    
    
	//serialize data
	public static void saveCustomers(){
		//massive object to store all objects
		System.out.print("Please enter your first and last name, username, password, and SSN: ");
		ArrayList<Customer> data = new ArrayList<Customer>();
		data.add(new Customer(first, last, user, pass, ssn));
	

		try {
			FileOutputStream fileOut = new FileOutputStream("files/customers.txt");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(data);
			out.close();
			fileOut.close();
			System.out.println("Serialzed data is saved in customers.txt");
		}catch(IOException i) {
			System.out.println(i.getMessage());
		}
	}
	
	//deserialize data
	@SuppressWarnings("unchecked")
	public static void loadCustomers() {
		//create arraylist to store deserialize objects
		ArrayList<Customer> deserialized = new ArrayList<Customer>();
		
		try {
			FileInputStream fileIn = new FileInputStream("files/customers.txt");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			deserialized = (ArrayList<Customer>)in.readObject();
			in.close();
			fileIn.close();
			
		}catch(IOException i) {
			System.out.println(i.getMessage());
			return;
		}
		catch(ClassNotFoundException i) {
			System.out.println(i.getMessage());
			return;
		}
	
		System.out.println(deserialized);
		//String retrieveFirst = (String)deserialized.get()
	}
	
//	public static boolean verifyLogin() {
//		System.out.print("Username: ");
//		String cusUser = in.nextLine();
//		System.out.print("Password: ");
//		String cusPass = in.nextLine();
//		if(  ) {
//			System.out.println("Login Verified!");
//			System.out.println("User is: " + user + " Password is: " + pass);
//			return true;
//		}
//		else {
//			System.out.println("Wrong Username/Password!");
//			System.out.println("User is: " + user + " Password is: " + pass);
//			return false;
//		}		
//	}
	
	
	
	
	
	
	


}
