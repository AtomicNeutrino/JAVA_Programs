//9. .Create a BankAccount class with the following:
 /*
Fields: accountNumber (String), accountHolder (String), balance (double)
A constructor to initialize all fields.
Methods:
deposit(double amount): Adds the amount to the balance.
withdraw(double amount): Deducts the amount if sufficient funds exist; otherwise, prints an
error message.
displayAccountInfo(): Displays account details.
Test:
Create a bank account object and perform deposit, withdrawal, and display operations. */

import java.util.ArrayList;
import java.util.Scanner;

class BankAccount {
    // Fields
    private String accountNumber;
    private String accountHolder;
    private double balance;

    // Constructor to initialize all fields without requiring an initial balance
    public BankAccount(String accountNumber, String accountHolder) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = 0.0;
    }

    // Method to deposit an amount
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful! New balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Method to withdraw an amount
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful! New balance: " + balance);
        } else if (amount > balance) {
            System.out.println("Insufficient funds.");
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    // Method to display account information
    public void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: " + balance);
    }

    // Main method to test the class using Scanner for user input
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<BankAccount> accounts = new ArrayList<>();

        boolean exit = false;
        while (!exit) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Create a new account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Display Account Info");
            System.out.println("5. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    // Create a new account
                    System.out.print("Enter account number: ");
                    String accountNumber = scanner.nextLine();
                    System.out.print("Enter account holder name: ");
                    String accountHolder = scanner.nextLine();
                    BankAccount newAccount = new BankAccount(accountNumber, accountHolder);
                    accounts.add(newAccount);
                    System.out.println("New account created successfully!");
                    break;
                case 2:
                    // Deposit into an existing account
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.nextLine();
                    BankAccount accountToDeposit = findAccount(accounts, accountNumber);
                    if (accountToDeposit != null) {
                        System.out.print("Enter deposit amount: ");
                        double depositAmount = scanner.nextDouble();
                        accountToDeposit.deposit(depositAmount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 3:
                    // Withdraw from an existing account
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.nextLine();
                    BankAccount accountToWithdraw = findAccount(accounts, accountNumber);
                    if (accountToWithdraw != null) {
                        System.out.print("Enter withdrawal amount: ");
                        double withdrawAmount = scanner.nextDouble();
                        accountToWithdraw.withdraw(withdrawAmount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 4:
                    // Display account information
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.nextLine();
                    BankAccount accountToDisplay = findAccount(accounts, accountNumber);
                    if (accountToDisplay != null) {
                        accountToDisplay.displayAccountInfo();
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 5:
                    // Exit
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    // Method to find an account by account number
    private static BankAccount findAccount(ArrayList<BankAccount> accounts, String accountNumber) {
        for (BankAccount account : accounts) {
            if (account.accountNumber.equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }
}
