package bank.database;

import java.util.Scanner;

public class BalanceChecking {
	private static Scanner input;

	public static void userChoice() throws Exception{
		
		Boolean flag=true;
		do {

			System.out.println("1.Existing user-Need to check Balance");
			System.out.println("2.Existing user-Need to add new account");
			System.out.println("3.New Customer-Need to Enter both Customer and account details");
			System.out.println("4. Exit");
			System.out.println("");
			input = new Scanner(System.in);
			System.out.println("Enter your choice");
			int choice = input.nextInt();
			
			switch(choice){
				case 1 :
					DatabaseManagement.dataStorageInMap();
					ValueRetrieval.retrieveValues();
					System.out.println("");
					break;
				
				case 2 :
					 InsertAccountInfo.account_info();
					 DatabaseManagement.dataStorageInMap();
					 System.out.println("");
					 break;
				
				case 3:
					 InsertCustomerInfo.customer_info();
					 DatabaseManagement.dataStorageInMap();
					 System.out.println("");
					 break;
					
				case 4:
					flag=false;
					break;	
					
				default :
					System.out.println("Enter valid choice");
					break;
			}
				
		}while(flag);
	
	}
}
