package bank.database;
import java.util.Scanner;
import java.util.HashMap;

public class ValueRetrieval {
        private static Scanner input;

		public static void retrieveValues() {
			
        	input = new Scanner(System.in);
        	System.out.println("Enter customer_id");
			int id = input.nextInt();
			if(DatabaseManagement.customer_map.containsKey(id)){
				HashMap<Long,Account_details> account_map =DatabaseManagement.customer_map.get(id);
				
				for(Account_details account : account_map.values()){
					System.out.println(account.toString());
					
				}
			}
			
       }
}
