package layers;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
    	try {
    		Controller controller = new Controller();
            Scanner sc = new Scanner(System.in);

            System.out.println("=== User Menu ===");
            System.out.println("1. Create Wallet Account");
            System.out.println("2. Transfer Money");
            System.out.println("3. Deposit");
            System.out.println("4. Check Balance");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); 
            
            switch(choice) {
            
            case 1:
            	System.out.println("Username : ");
            	String username = sc.nextLine();
            	controller.createWallet(username);
            	break;
            	
            case 2:
            	System.out.println("Username : ");
            	String sender = sc.nextLine();
            	System.out.println("Receiver Name : ");
            	String receiver = sc.nextLine();
            	System.out.println("Amount : ");
            	double amount = sc.nextDouble();
            	controller.transferMoney(sender, receiver, amount);
            	break;
            	
            case 3:
            	System.out.println("Username : ");
            	String user = sc.nextLine();
            	System.out.println("Amount : ");
            	double money = sc.nextDouble();
            	controller.addFunds(user, money);
            	break;
            	
            case 4:
            	System.out.println("Username : ");
            	String name = sc.nextLine();
            	controller.showBalance(name);
            }           
            sc.close();  
            }
    	catch (Exception e) {
    		e.printStackTrace();
    	}
    	}
}