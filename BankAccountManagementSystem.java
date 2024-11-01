/*This is my first program*/
/*today we have opede this*/
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * The BankAccountManagementSystem class manages multiple bank accounts.
 * It allows users to create accounts, deposit money, withdraw money, 
 * and check their balance.
 */
/** new comment*/
/**today is october 29*/
/**second comment*/
/**asa comment*/
/**today is november 1*/
public class BankAccountManagementSystem {

    private Map<String, Double> accounts;

    /**
     * Constructor to initialize the BankAccountManagementSystem.
     * Initializes an empty HashMap to store bank accounts.
     */
    public BankAccountManagementSystem() {
        accounts = new HashMap<>();
    }

    /**
     * Creates a new account with a balance of 0.0 if the account does not exist.
     * 
     * @param accountNumber the account number to be created
     */
    public void createAccount(String accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            System.out.println("Account already exists.");
        } else {
            accounts.put(accountNumber, 0.0);
            System.out.println("Account created successfully.");
        }
    }

    /**
     * Deposits money into the specified account if it exists.
     * 
     * @param accountNumber the account number where the money will be deposited
     * @param amount        the amount to be deposited
     */
    public void deposit(String accountNumber, double amount) {
        if (accounts.containsKey(accountNumber)) {
            double balance = accounts.get(accountNumber);
            balance += amount;
            accounts.put(accountNumber, balance);
            System.out.println("Deposit successful.");
        } else {
            System.out.println("Account does not exist.");
        }
    }

    /**
     * Withdraws money from the specified account if it exists and has sufficient balance.
     * 
     * @param accountNumber the account number from which money will be withdrawn
     * @param amount        the amount to be withdrawn
     */
    public void withdraw(String accountNumber, double amount) {
        if (accounts.containsKey(accountNumber)) {
            double balance = accounts.get(accountNumber);
            if (balance >= amount) {
                balance -= amount;
                accounts.put(accountNumber, balance);
                System.out.println("Withdrawal successful.");
            } else {
                System.out.println("Insufficient balance.");
            }
        } else {
            System.out.println("Account does not exist.");
        }
    }

    /**
     * Displays the balance of the specified account if it exists.
     * 
     * @param accountNumber the account number whose balance will be displayed
     */
    public void checkBalance(String accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            double balance = accounts.get(accountNumber);
            System.out.println("Account Balance: " + balance);
        } else {
            System.out.println("Account does not exist.");
        }
    }

    /**
     * The main method runs the Bank Account Management System.
     * It provides a menu for creating accounts, depositing, withdrawing, and checking balances.
     * 
     * @param args unused
     */
    public static void main(String[] args) {
        BankAccountManagementSystem bank = new BankAccountManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nBank Account Management System");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter account number: ");
                    String accountNumber = scanner.nextLine();
                    bank.createAccount(accountNumber);
                    break;
                case 2:
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.nextLine();
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    bank.deposit(accountNumber, depositAmount);
                    break;
                case 3:
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.nextLine();
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    bank.withdraw(accountNumber, withdrawAmount);
                    break;
                case 4:
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.nextLine();
                    bank.checkBalance(accountNumber);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
