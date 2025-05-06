# Banking System Automation

This project simulates banking operations such as account creation, deposits, withdrawals, and transfers. It provides a solid foundation for understanding object-oriented programming and Java development.

## Table of Contents

- [Overview](#overview)
- [Installation](#installation)
- [Usage](#usage)
- [Code Structure](#code-structure)
- [Testing](#testing)
- [Contributing](#contributing)
- [License](#license)

## Overview

This project demonstrates the use of Java for creating a simple banking system that supports account creation, deposits, withdrawals, and transfers between accounts. The system is designed with error handling to prevent issues like overdrafts and negative balances.

## Key Features

- Create bank accounts with positive or zero balances.
- Deposit and withdraw funds with proper error handling.
- Transfer money between multiple bank accounts.
- Basic validation to ensure operations do not exceed account balance.

## Installation

Follow these steps to set up the project locally:

1. Clone the repository:

   ```bash
   git clone https://github.com/xNeTc/BankingSystem.git
   ```

2. Navigate to the project directory:

   ```bash
   cd BankingSystem
   ```

3. Build and run the tests using Maven:

   ```bash
   mvn clean test
   ```

This command will compile the code, run all the test cases, and show the results in the terminal.

## Test Cases

The following tests are included in the project:

1. **Create account with valid balance**: Ensure an account is created with a positive balance.
2. **Create account with negative balance (fails)**: Test to make sure creating an account with a negative balance throws an exception.
3. **Deposit into an account**: Verify depositing money into an account updates the balance correctly.
4. **Deposit negative amount (fails)**: Test depositing a negative amount into the account, which should throw an exception.
5. **Withdraw from an account**: Test withdrawing money from the account and ensure the balance is updated.
6. **Withdraw more than balance (fails)**: Ensure an exception is thrown when trying to withdraw more than the available balance.
7. **Transfer money between two accounts**: Test transferring money between two accounts and verify both accounts' balances are updated.
8. **Transfer to non-existing account (fails)**: Test transferring money to a non-existent account, which should fail and throw an exception.
9. **Check account existence with a positive balance**: Ensure the system correctly identifies an account with a positive balance as existing.
10. **Check account existence with zero balance**: Ensure the system correctly identifies an account with a zero balance as existing.
11. **Check account existence with a negative balance (fails)**: Test an account with a negative balance, which should not exist according to the system.
12. **Withdraw negative amount (fails)**: Ensure withdrawing a negative amount throws an exception.
13. **Transfer more money than the sender’s balance (fails)**: Test transferring more money than the sender's balance, which should throw an exception.
14. **Create multiple accounts and check balances**: Create multiple accounts and verify their balances are correct.
15. **Complex transfer operations**: Test multiple transfer operations and ensure the final balances are accurate across all involved accounts.

## Expected Outcomes

- The system will correctly handle valid transactions (e.g., deposits, withdrawals, transfers).
- Invalid operations (e.g., negative deposit, withdrawal exceeding balance) will throw appropriate exceptions.
- Account balance updates will be correctly reflected after each operation.

## Contributions

Contributions are welcome! Feel free to fork the repository, make improvements, and create pull requests.
