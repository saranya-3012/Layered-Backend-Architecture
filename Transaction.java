package layers;

public class Transaction {
    private int walletId;
    private String type;
    private double amount;
    private double total_amount;

    public Transaction(int walletId, String type, double amount, double total_amount) {
        this.walletId = walletId;
        this.type = type;
        this.amount = amount;
        this.total_amount = total_amount;
    }
    
    public int getwalletId() { 
    	return walletId; 
    }
    
    public String gettype() { 
    	return type; 
    }
    
    public double getamount() {
    	return amount; 
    }
    
    public double gettotal_amount() {
    	return total_amount; 
    }
}