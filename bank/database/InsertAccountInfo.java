package bank.database;
import java.util.Scanner;

public class InsertAccountInfo {
	
		private static Scanner input;

		public static void account_info() throws Exception{
		Account_details account_details = new Account_details();
		input = new Scanner(System.in);
		
		System.out.println("Enter the customer_id to store in accounts table");
		account_details.setCustomer_id(input.nextInt());
		
		input.nextLine();
	    System.out.println("Enter the user name to store in accounts table");
		account_details.setName(input.nextLine());
	
		System.out.println("Enter the number of accounts for a single user");
		int accounts=input.nextInt();
		
		while(accounts-->0) {
		System.out.println("Enter the account number and balance");
		account_details.setAccount_number(input.nextInt());
		account_details.setBalance(input.nextInt());
		System.out.println("values to be stored in table");
		 DatabaseManagement.insertAccountInfoToTable(account_details);
		}
		}
		
		public static void account_info(int id, String name) throws Exception{
			Account_details account_details = new Account_details();
			input = new Scanner(System.in);
			
			account_details.setCustomer_id(id);
		
			account_details.setName(name);
		
			System.out.println("Enter the number of accounts for a single user");
			int accounts=input.nextInt();
			
			while(accounts-->0) {
			System.out.println("Enter the account number and balance");
			account_details.setAccount_number(input.nextInt());
			account_details.setBalance(input.nextInt());
			System.out.println("values to be stored in table");
			 DatabaseManagement.insertAccountInfoToTable(account_details);
			}
			
			}
		
		
	}



