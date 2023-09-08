package intern;

	import java.util.Scanner;

	public class ATMinterface {
	    private static double balance = 1000.0; // Initial balance (you would load this from a database)
	    private static final String ACCOUNT_NUMBER = "123456"; // Replace with the actual account number
	    private static final String PIN = "1234"; // Replace with the actual PIN

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        System.out.print("Enter account number: ");
	        String accountNumberInput = scanner.nextLine();

	        System.out.print("Enter your PIN: ");
	        String pinInput = scanner.nextLine();

	        if (isValidAccount(accountNumberInput, pinInput)) {
	            boolean isRunning = true;

	            while (isRunning) {
	                displayMenu();

	                int choice = scanner.nextInt();

	                switch (choice) {
	                    case 1:
	                        checkBalance();
	                        break;
	                    case 2:
	                        deposit(scanner);
	                        break;
	                    case 3:
	                        withdraw(scanner);
	                        break;
	                    case 4:
	                        System.out.println("Thank you for using the ATM. Goodbye!");
	                        isRunning = false;
	                        break;
	                    default:
	                        System.out.println("Invalid choice. Please try again.");
	                }
	            }
	        } else {
	            System.out.println("Invalid account number or PIN. Exiting.");
	        }

	        scanner.close();
	    }

	    private static boolean isValidAccount(String accountNumberInput, String pinInput) {
	        return accountNumberInput.equals(ACCOUNT_NUMBER) && pinInput.equals(PIN);
	    }

	    private static void displayMenu() {
	        System.out.println("\nMain Menu");
	        System.out.println("1. Check Balance");
	        System.out.println("2. Deposit");
	        System.out.println("3. Withdraw");
	        System.out.println("4. Exit");
	        System.out.print("Enter your choice: ");
	    }

	    private static void checkBalance() {
	        System.out.println("Your balance is: ₹" + balance);
	    }

	    private static void deposit(Scanner scanner) {
	        System.out.print("Enter the deposit amount: ₹");
	        double amount = scanner.nextDouble();

	        if (amount > 0) {
	            balance += amount;
	            System.out.println("₹" + amount + " deposited successfully.");
	        } else {
	            System.out.println("Invalid deposit amount.");
	        }
	    }

	    private static void withdraw(Scanner scanner) {
	        System.out.print("Enter the withdrawal amount: ₹");
	        double amount = scanner.nextDouble();

	        if (amount > 0 && amount <= balance) {
	            balance -= amount;
	            System.out.println("₹" + amount + " withdrawn successfully.");
	        } else {
	            System.out.println("Invalid withdrawal amount or insufficient funds.");
	        }
	    }
	}


