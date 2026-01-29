package layers;

import java.sql.*;

public class DAO {

	private static Connection conn = DBConnection.getConnection();
	
	// Create Wallet Account 
    public void createWallet(String username) throws Exception {  	
        
    	String sql = "INSERT INTO Wallet(username,balance) VALUES (?,0)";
        try(PreparedStatement ps = conn.prepareStatement(sql)){
        	ps.setString(1, username);
            ps.executeUpdate();
        }
        catch (Exception e) {
        	e.printStackTrace();
        }    
    }

    // Check Balance
    public double getBalance(String username) throws Exception {
        
        String sql = "SELECT balance FROM Wallet WHERE username=?";
        
        try(PreparedStatement ps = conn.prepareStatement(sql)){
        	ps.setString(1, username);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
            	return rs.getDouble("balance");
            }
            else {
            	System.out.println("Invalid Username!");
            	return 0;
            }
        }
        catch (Exception e) {
        	e.printStackTrace();
        	return 0;
        }       
    }

    // Find User ID
    public int getWalletId(String username) throws Exception {
      
        String sql = "SELECT id FROM Wallet WHERE username=?";
        try(PreparedStatement ps = conn.prepareStatement(sql)){
        	ps.setString(1, username);
            
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
            	return rs.getInt("Id");
            }
            else {
            	System.out.println("Invalid Username!");
            	return 0;
            }
        }
        catch (Exception e) {
        	e.printStackTrace();
        	return 0;
        } 
    }

    // Update the Balance
    public void updateBalance(String username, double balance) throws Exception {
       
        String sql = "UPDATE Wallet SET balance=? WHERE username=?";
        try(PreparedStatement ps = conn.prepareStatement(sql)){
        	ps.setDouble(1, balance);
            ps.setString(2, username);
            ps.executeUpdate();
        }
        catch (Exception e) {
        	e.printStackTrace();
        } 
        
    }

    // Save Transaction Details 
    public void saveTransaction(int walletId, String type, double amount, double totalamount) throws Exception {
     
        String sql = "INSERT INTO Transaction(wallet_id, type, amount, total_amount) VALUES (?, ?, ?, ?)";
        try(PreparedStatement ps = conn.prepareStatement(sql)){
        	ps.setInt(1, walletId);
            ps.setString(2, type);
            ps.setDouble(3, amount);
            ps.setDouble(4, totalamount);
            ps.executeUpdate();
        }       
    }
}