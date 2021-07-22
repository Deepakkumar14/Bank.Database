package bank.database;

public class Account_details {
	    private int customer_id;
	    private long account_number;
	    private String full_name;
	    private long balance;
	    
	    public int getCustomer_id() {
	        return customer_id;
	    }

	    public void setCustomer_id(int customer_id) {
	        this.customer_id = customer_id;
	    }

	    public long getAccount_number() {
	        return account_number;
	    }
	    
	    public void setAccount_number(long account_number) {
	        this.account_number = account_number;
	    }
	    
	    public String getName() {
	        return full_name;
	    }

	    public void setName(String full_name) {
	        this.full_name = full_name;
	    }
	   
	    public long getBalance() {
	        return balance;
	    }

	    public void setBalance(long balance) {
	        this.balance = balance;
	    }
	    
	    @Override
	    public String toString() {
	        return  "Customer_id: " + customer_id +"\t"+" Name: " + full_name +"\n"+"Account_number: " + account_number +"\t"+"Balance: " + balance+"\n";
	    }
	   
	}


