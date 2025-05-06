package com;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankingSystemTest {

    // 1. Test case for creating a new account with a valid initial balance
    @Test
    public void testCreateAccountWithValidBalance() {
        BankAccount account = new BankAccount(500);
        assertEquals(500, account.getBalance(), "Initial balance should be 500");
    }

    // 2. Test case for creating an account with a negative balance
    @Test
    public void testCreateAccountWithNegativeBalance() {
        assertThrows(IllegalArgumentException.class, () -> new BankAccount(-100),
                     "Should not allow negative initial balance");
    }

    // 3. Test case for depositing money into an account
    @Test
    public void testDepositToAccount() {
        BankAccount account = new BankAccount(500);
        account.deposit(100);
        assertEquals(600, account.getBalance(), "Balance should be 600 after deposit");
    }

    // 4. Test case for depositing an invalid negative amount
    @Test
    public void testDepositNegativeAmount() {
        BankAccount account = new BankAccount(500);
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-100),
                     "Should not allow negative deposit");
    }

    // 5. Test case for withdrawing money from an account
    @Test
    public void testWithdrawFromAccount() {
        BankAccount account = new BankAccount(500);
        account.withdraw(100);
        assertEquals(400, account.getBalance(), "Balance should be 400 after withdrawal");
    }

    // 6. Test case for withdrawing more money than the account balance
    @Test
    public void testWithdrawMoreThanBalance() {
        BankAccount account = new BankAccount(500);
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(600),
                     "Should not allow withdrawal more than balance");
    }

    // 7. Test case for transferring money between two accounts
    @Test
    public void testTransferMoneyBetweenAccounts() {
        BankAccount account1 = new BankAccount(1000);
        BankAccount account2 = new BankAccount(500);
        account1.transfer(account2, 200);
        assertEquals(800, account1.getBalance(), "Account1 balance should be 800 after transfer");
        assertEquals(700, account2.getBalance(), "Account2 balance should be 700 after transfer");
    }

    // 8. Test case for transferring money to a non-existing account
    @Test
    public void testTransferToNonExistingAccount() {
        BankAccount account1 = new BankAccount(1000);
        BankAccount account2 = null;  // No target account
        assertThrows(IllegalArgumentException.class, () -> account1.transfer(account2, 200),
                     "Should not allow transfer to a null account");
    }

    // 9. Test case for checking account existence with a positive balance
    @Test
    public void testAccountExistsWithPositiveBalance() {
        BankAccount account = new BankAccount(500);
        assertTrue(account.accountExists(), "Account should exist with a positive balance");
    }

    // 10. Test case for checking account existence with a zero balance
    @Test
    public void testAccountExistsWithZeroBalance() {
        BankAccount account = new BankAccount(0);
        assertTrue(account.accountExists(), "Account should exist with a zero balance");
    }

    // 11. Test case for checking account existence with a negative balance 
    @Test
    public void testAccountExistsWithNegativeBalance() {
        assertThrows(IllegalArgumentException.class, () -> new BankAccount(-500),
                     "Should not allow creating account with a negative balance");
    }

    // 12. Test case for withdrawing an invalid negative amount 
    @Test
    public void testWithdrawNegativeAmount() {
        BankAccount account = new BankAccount(500);
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(-100),
                     "Should not allow withdrawal of negative amount");
    }

    // 13. Test case for transferring more money than the sender's balance 
    @Test
    public void testTransferMoreThanBalance() {
        BankAccount account1 = new BankAccount(300);
        BankAccount account2 = new BankAccount(200);
        assertThrows(IllegalArgumentException.class, () -> account1.transfer(account2, 500),
                     "Should not allow transferring more than the available balance");
    }

    // 14. Test case for creating multiple accounts and checking balances
    @Test
    public void testMultipleAccounts() {
        BankAccount account1 = new BankAccount(500);
        BankAccount account2 = new BankAccount(1000);
        BankAccount account3 = new BankAccount(200);

        assertEquals(500, account1.getBalance(), "Account1 balance should be 500");
        assertEquals(1000, account2.getBalance(), "Account2 balance should be 1000");
        assertEquals(200, account3.getBalance(), "Account3 balance should be 200");
    }

    // 15. Test case for transferring money and ensuring the balances are correct
    @Test
    public void testComplexTransfer() {
        BankAccount account1 = new BankAccount(1500);
        BankAccount account2 = new BankAccount(1000);
        BankAccount account3 = new BankAccount(250);
    
        // Perform several transfers
        account1.transfer(account2, 300);  // Account1 transfers 300 to Account2
        account2.transfer(account3, 150);  // Account2 transfers 150 to Account3
    
        // Checking final balances
        assertEquals(1200, account1.getBalance(), "Account1 balance should be 1200");
        assertEquals(1150, account2.getBalance(), "Account2 balance should be 1150");
        assertEquals(400, account3.getBalance(), "Account3 balance should be 400");
    }
}
