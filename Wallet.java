package layers;

public class Wallet {
    private int id;
    private String username;
    private double balance;

    public Wallet(int id, String username, double balance) {
        this.id = id;
        this.username = username;
        this.balance = balance;
    }

    public int getId() { 
    	return id; 
    }
    
    public String getUsername() { 
    	return username; 
    }
    
    public double getBalance() {
    	return balance; 
    }
}
