package bank.database;

import java.util.Scanner;

public class InsertCustomerInfo {
	
	private static Scanner input;

	public static void customer_info() throws Exception{
		Customer_details customer_details = new Customer_details();
		input = new Scanner(System.in);
		
		System.out.println("Enter the number of new customers");
		int customers=input.nextInt();
		
		while(customers-->0) {
			
		System.out.println("Enter the customer_id");
		customer_details.setCustomer_id(input.nextInt());
		
		input.nextLine();
	    System.out.println("Enter the user name");
		customer_details.setName(input.nextLine());
		
		 System.out.println("Enter the user city");
		 customer_details.setCity(input.nextLine());
	
		 DatabaseManagement.insertCustomerInfoToTable(customer_details);
	     InsertAccountInfo.account_info(customer_details.getCustomer_id(),customer_details.getName());
		
		}
		
		}
	

}
