package bank.database;
public class MainClass {

	public static void main(String[] args) throws Exception  {
		
		DatabaseManagement.getConnection();
		BalanceChecking.userChoice();
		DatabaseManagement.closeConnection();
		
	}

}
