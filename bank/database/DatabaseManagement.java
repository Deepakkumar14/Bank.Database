package bank.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.HashMap;

public class DatabaseManagement {
	private static final String DRIVER =  "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/bank";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "Deep@2000";
	private static Connection conn = null;	
	static HashMap<Long,Account_details>account_map=new HashMap<Long,Account_details>();
	static HashMap<Integer, HashMap<Long, Account_details>> customer_map = new HashMap<Integer, HashMap<Long,Account_details>>();
	
	static PreparedStatement ps=null;
    static  PreparedStatement ps1=null;
  
	public static Connection getConnection(){
		
		try{
		    Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			if(conn == null){
			   getConnection();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return conn;
	}	
	
	
	public static void dataStorageInMap(){
		try(Statement stmt = conn.createStatement();ResultSet rs1= stmt.executeQuery("select * from account_details")) {
			 
			while(rs1.next()){
				Account_details account_infotoMap=new Account_details();
				 account_infotoMap.setCustomer_id(rs1.getInt("customer_id"));
			     account_infotoMap.setAccount_number(rs1.getLong("account_number"));
				 account_infotoMap.setName(rs1.getString("full_name"));
			     account_infotoMap.setBalance(rs1.getLong("balance"));
				 HashMap<Long,Account_details> account_map = customer_map.getOrDefault(rs1.getInt("customer_id"),new HashMap<Long,Account_details>());
				account_map.put(rs1.getLong("account_number"),account_infotoMap);
				customer_map.put(rs1.getInt("customer_id"),account_map);
				
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}	
	}
	
	
	public static void insertCustomerInfoToTable(Customer_details customer_details) {
		try{
			String query = "insert into customer_details (customer_id,full_name,city) values (?,?,?)";
			 ps = conn.prepareStatement(query);
	                ps.setInt(1,customer_details.getCustomer_id());
	                ps.setString(2,customer_details.getName());
	                ps.setString(3,customer_details.getCity());
	                ps.addBatch();
	                ps.executeBatch();
		}
		catch(Exception e){
			e.printStackTrace();
		}	
		finally {
            if (ps!=null)
                try {
                    ps.close();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
        }
	}
	
	public static void insertAccountInfoToTable(Account_details account_details) {
		try{
			String query1 = "insert into account_details(customer_id,account_number,full_name,balance) values (?,?,?,?)";
			 ps1 = conn.prepareStatement(query1);
	                ps1.setInt(1,account_details.getCustomer_id());
	                ps1.setLong(2,account_details.getAccount_number());
	                ps1.setString(3,account_details.getName());
	                ps1.setLong(4,account_details.getBalance());
	                ps1.addBatch();
	                
	                ps1.executeBatch();
		}
		catch(Exception e){
			e.printStackTrace();
		}finally {
            if (ps1!=null)
                try {
                    ps1.close();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
        }
		System.out.println("Values inserted succesfully");
		System.out.println("");
			}	

	
	public static void closeConnection() throws Exception{
		conn.close();
		Boolean bool=conn.isClosed();
		if(bool) {
			System.out.println("Database is closed: "+bool);
		}
		else {
			conn.close();
			System.out.println("Database is closed");
		}
	}
	
}


