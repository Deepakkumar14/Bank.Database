package bank.database;

public class Customer_details {
	   private int customer_id;
	   private String full_name,city;

	    public int getCustomer_id() {
	        return this.customer_id;
	    }

	    public void setCustomer_id(int customer_id) {
	        this.customer_id = customer_id;
	    }

	    public String getName() {
	        return this.full_name;
	    }

	    public void setName(String full_name) {
	        this.full_name = full_name;
	    }
	    
	    public String getCity() {
	        return this.city;
	    }

	    public void setCity(String city) {
	        this.city = city;
	    }
	   
	}


