package com.dsa_series.roadmap.oops.intro_to_oops;

//Your code goes here
class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds!");
        }
    }

    public void displayDetails() {
        System.out.println("Account Number : " + accountNumber);
        System.out.printf("Balance : %.2f\n", balance);
    }
}

// Please Do not change anything below, It is only for your reference.
/*
 * 
 * This is the driver code that will execute and demonstrate the functionality
 * of your `BankAccount` class.
 * 
 * It creates a object of class `BankAccount`, the objects sets the values of
 * accountNumber and balance using the parameterised constructor.
 * Then calls the method addBalance to add the balance in the account.
 * Then it calls the withdrawBalance to withdraw the balance from the account.
 * At end it displays the details of account using the displayDetails method.
 * 
 * 
 * 
 * // Main class to demonstrate the functionality of the Student class
 * public class Main {
 * public static void main(String[] args) {
 * 
 * Scanner sc = new Scanner(System.in);
 * 
 * // Input account number and initial balance
 * String accountNumber = sc.nextLine();
 * double balance = sc.nextDouble();
 * 
 * // Create a BankAccount object with the use of parameterised constructor
 * BankAccount account = new BankAccount(accountNumber, balance);
 * 
 * // Deposit money
 * double addBalance = sc.nextDouble();
 * account.deposit(addBalance);
 * 
 * // Withdraw money
 * double withdrawBalance = sc.nextDouble();
 * account.withdraw(withdrawBalance);
 * 
 * // Display account details
 * account.displayDetails();
 * 
 * sc.close(); // Close the scanner
 * }
 * }
 * 
 */

/*
 * //Below is the output statements
 * 
 * System.out.println("Insufficient funds!");
 * System.out.println("Account Number : " + accountNumber);
 * System.out.println("Balance : " + balance);
 * 
 */
