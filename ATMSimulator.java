import java.util.ArrayList;
import java.util.Scanner;

public class ATMSimulator {
    
    // Variables to hold account details
    private double balance;
    private String pin;
    private ArrayList<String> transactionHistory;

    // Constructor to initialize the ATM machine
    public ATMSimulator(double initialBalance, String initialPin) {
        this.balance = initialBalance;
        this.pin = initialPin;
        this.transactionHistory = new ArrayList<>();
        System.out.println("Welcome to the ATM! Your account has been initialized.");
    }

    // Function to display current balance
    public void checkBalance() {
        System.out.println("Your current balance is: ₹" + balance);
        transactionHistory.add("Balance inquiry: ₹" + balance);
    }

    // Function to withdraw money
    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds. Transaction failed.");
        } else {
            balance -= amount;
            System.out.println("You have successfully withdrawn: ₹" + amount);
            System.out.println("Your new balance is: ₹" + balance);
            transactionHistory.add("Withdrawal: ₹" + amount);
        }
    }

    // Function to deposit money
    public void deposit(double amount) {
        balance += amount;
        System.out.println("You have successfully deposited: ₹" + amount);
        System.out.println("Your new balance is: ₹" + balance);
        transactionHistory.add("Deposit: ₹" + amount);
    }

    // Function to change the PIN
    public void changePin(String oldPin, String newPin) {
        if (oldPin.equals(this.pin)) {
            this.pin = newPin;
            System.out.println("PIN has been successfully changed.");
            transactionHistory.add("PIN changed");
        } else {
            System.out.println("Incorrect old PIN. Please try again.");
        }
    }

    // Function to display transaction history
    public void viewTransactionHistory() {
        System.out.println("Transaction History:");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }

    // Main function to interact with the user
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
			// Initialize ATM with a balance of ₹10000 and a default PIN
			ATMSimulator atm = new ATMSimulator(10000.0, "1234");

			// Simulate user actions
			while (true) {
			    System.out.println("\nATM Machine");
			    System.out.println("1. Check Balance");
			    System.out.println("2. Withdraw Cash");
			    System.out.println("3. Deposit Cash");
			    System.out.println("4. Change PIN");
			    System.out.println("5. View Transaction History");
			    System.out.println("6. Exit");
			    System.out.print("Choose an option: ");
			    int choice = scanner.nextInt();

			    switch (choice) {
			        case 1:
			            atm.checkBalance();
			            break;
			        case 2:
			            System.out.print("Enter amount to withdraw: ₹");
			            double withdrawAmount = scanner.nextDouble();
			            atm.withdraw(withdrawAmount);
			            break;
			        case 3:
			            System.out.print("Enter amount to deposit: ₹");
			            double depositAmount = scanner.nextDouble();
			            atm.deposit(depositAmount);
			            break;
			        case 4:
			            System.out.print("Enter old PIN: ");
			            String oldPin = scanner.next();
			            System.out.print("Enter new PIN: ");
			            String newPin = scanner.next();
			            atm.changePin(oldPin, newPin);
			            break;
			        case 5:
			            atm.viewTransactionHistory();
			            break;
			        case 6:
			            System.out.println("Thank you for using the ATM. Goodbye!");
			            System.exit(0);
			            break;
			        default:
			            System.out.println("Invalid option. Please try again.");
			    }
			}
		}
    }
}
