package Comp1112.Project2;

import java.util.HashMap;
import java.util.Map;

public class AccountManagerImpl implements AccountManager {
   private final Map<String, Account> accounts;

   public AccountManagerImpl() {
      this.accounts = new HashMap<>();
   }

   public void createAccount(String accountNumber, double initialBalance, Customer owner, String accountType) {
      Account newAccount;
      switch (accountType) {
         case "Savings":
            newAccount = new SavingsAccount(accountNumber, initialBalance, owner, 0, "Active");
            break;
         case "Checking":
            newAccount = new CheckingAccount(accountNumber, initialBalance, owner, 0, false, false, false);
            break;
         default:
            System.out.println("Invalid account type.");
            return;
      }
      accounts.put(accountNumber, newAccount);
   }

   @Override
   public void deposit(String accountNumber, double amount) {
      Account account = accounts.get(accountNumber);
      if (account != null) {
         account.deposit(amount);
      } else {
         System.out.println("Account not found.");
      }
   }

   @Override
   public void withdraw(String accountNumber, double amount) {
      Account account = accounts.get(accountNumber);
      if (account != null) {
         account.withdraw(amount);
      } else {
         System.out.println("Account not found.");
      }
   }

   @Override
   public void transfer(String fromAccountNumber, String toAccountNumber, double amount) {
      Account fromAccount = accounts.get(fromAccountNumber);
      Account toAccount = accounts.get(toAccountNumber);
      if (fromAccount != null && toAccount != null) {
         if (fromAccount.getBalance() >= amount) {
            fromAccount.withdraw(amount);
            toAccount.deposit(amount);
            System.out.println("Transfer successful.");
         } else {
            System.out.println("Insufficient balance for transfer.");
         }
      } else {
         System.out.println("One or both accounts not found.");
      }
   }

   public Map<String, Account> getAccounts() {
      return accounts;
   }

   @Override
   public Account getAccount(String accountNumber) {
      return accounts.get(accountNumber);
   }

   @Override
   public double getAccountBalance(String accountNumber) {
      Account account = accounts.get(accountNumber);
      if (account != null) {
         return account.getBalance();
      } else {
         System.out.println("Account not found.");
         return 0;
      }
   }

   @Override
   public void createSavingsAccount(String accountNumber, double initialBalance, Customer owner, double interestRate, String accountStatus) {
      Account newAccount = new SavingsAccount(accountNumber, initialBalance, owner, interestRate, accountStatus);
      accounts.put(accountNumber, newAccount);
   }

   @Override
   public void createCheckingAccount(String accountNumber, double initialBalance, Customer owner, double overdraftLimit) {
      Account newAccount = new CheckingAccount(accountNumber, initialBalance, owner, overdraftLimit, false, false, false);
      accounts.put(accountNumber, newAccount);
   }

   @Override
   public void displayAccountDetails(String accountNumber) {
      Account account = accounts.get(accountNumber);
      if (account != null) {
         System.out.println(account);
      } else {
         System.out.println("Account not found.");
      }
   }

   @Override
   public void updateContactDetails(String accountNumber, String newContactDetails) {
      Account account = accounts.get(accountNumber);
      if (account != null) {
         account.getOwner().setContactDetails(newContactDetails);
         System.out.println("Contact details updated successfully.");
      } else {
         System.out.println("Account not found.");
      }
   }
}