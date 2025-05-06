package com;

import java.util.HashMap;
import java.util.Map;

public class BankingSystem {
    private Map<Integer, BankAccount> accounts;
    private static int accountNumberCounter = 1;  // To generate unique account numbers

    // Constructor to initialize the BankingSystem
    public BankingSystem() {
        accounts = new HashMap<>();
    }

    // Method to create a new account with a specified initial balance
    public int createAccount(double initialBalance) {
        BankAccount newAccount = new BankAccount(initialBalance);
        int accountNumber = accountNumberCounter++;
        accounts.put(accountNumber, newAccount);
        return accountNumber;
    }

    // Method to get the balance of an account
    public double getAccountBalance(int accountNumber) {
        BankAccount account = accounts.get(accountNumber);
        if (account == null) {
            throw new IllegalArgumentException("Account not found");
        }
        return account.getBalance();
    }

    // Method to deposit money into an account
    public void depositToAccount(int accountNumber, double amount) {
        BankAccount account = accounts.get(accountNumber);
        if (account == null) {
            throw new IllegalArgumentException("Account not found");
        }
        account.deposit(amount);
    }

    // Method to withdraw money from an account
    public void withdrawFromAccount(int accountNumber, double amount) {
        BankAccount account = accounts.get(accountNumber);
        if (account == null) {
            throw new IllegalArgumentException("Account not found");
        }
        account.withdraw(amount);
    }

    // Method to transfer money between two accounts
    public void transferMoney(int fromAccountNumber, int toAccountNumber, double amount) {
        BankAccount fromAccount = accounts.get(fromAccountNumber);
        BankAccount toAccount = accounts.get(toAccountNumber);
        if (fromAccount == null || toAccount == null) {
            throw new IllegalArgumentException("One or both accounts not found");
        }
        fromAccount.transfer(toAccount, amount);
    }

    // Method to check if an account exists
    public boolean accountExists(int accountNumber) {
        return accounts.containsKey(accountNumber);
    }
}