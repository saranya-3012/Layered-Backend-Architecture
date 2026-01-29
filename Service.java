package layers;

public class Service {

    DAO dao = new DAO();

    // Create Wallet Account 
    public void createWallet(String username) throws Exception {
        dao.createWallet(username);
        
    }

    
    // Update Transaction
    public void addMoney(String username, double amount) throws Exception {
        double balance = dao.getBalance(username);
        dao.updateBalance(username, balance + amount);
        dao.saveTransaction(dao.getWalletId(username), "ADD", amount, balance + amount);
    }

    
    // Transfer Money
    public void transfer(String fromUser, String toUser, double amount) throws Exception {
    	int senderId = dao.getWalletId(fromUser);
    	int receiverId = dao.getWalletId(toUser);
        double senderBalance = dao.getBalance(fromUser);
        double receiverBalance = dao.getBalance(toUser);

        if (senderBalance < amount) {
            throw new RuntimeException("Insufficient Balance");
        }        
        else {
        	 dao.updateBalance(fromUser, senderBalance - amount);
             dao.updateBalance(toUser,  receiverBalance + amount);

             dao.saveTransaction(senderId, "TRANSFER", -amount, senderBalance - amount);
             dao.saveTransaction(receiverId, "TRANSFER", amount, receiverBalance + amount);
        }      
    }

    
    // Check Balance
    public double checkBalance(String username) throws Exception {
        return dao.getBalance(username);
    }
}