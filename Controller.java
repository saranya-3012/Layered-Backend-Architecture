package layers;

public class Controller {

    Service service = new Service();

 // Create Wallet Account 
    public void createWallet(String user) throws Exception {
        service.createWallet(user);
        System.out.println("Wallet created");
    }

 // Update Transaction
    public void addFunds(String user, double amount) throws Exception {
        service.addMoney(user, amount);
        System.out.println("Money added");
    }

 // Transfer Money
    public void transferMoney(String from, String to, double amount) throws Exception {
        service.transfer(from, to, amount);
        System.out.println("Transfer successful");
    }

 // Check Balance
    public void showBalance(String user) throws Exception {
        System.out.println("Balance: " + service.checkBalance(user));
    }
}