package Comp1112.Project2;

import java.util.ArrayList;
import java.util.List;

public abstract class Account {
   private String accountNumber;
   private double balance;
   private Customer owner;
   protected final List<Transaction> TRANSACTION_HISTORY;

   public Account(String accountNumber, double balance, Customer owner) {
      this.accountNumber = accountNumber;
      this.balance = balance;
      this.owner = owner;
      this.TRANSACTION_HISTORY = new ArrayList<>();
   }

   public void deposit(double amount) {
      balance += amount;
      TRANSACTION_HISTORY.add(new Transaction("Deposit", amount));
   }

   public void withdraw(double amount) {
      if (balance >= amount) {
         balance -= amount;
         TRANSACTION_HISTORY.add(new Transaction("Withdrawal", amount));
      } else {
         System.out.println("Insufficient balance.");
      }
   }

   public void transfer(Account toAccount, double amount) {
      if (balance >= amount) {
         balance -= amount;
         toAccount.deposit(amount);
         TRANSACTION_HISTORY.add(new Transaction("Transfer to " + toAccount.getAccountNumber(), amount));
      } else {
         System.out.println("Insufficient balance for transfer.");
      }
   }

   public abstract double calculateProjectedBalance();

   public List<Transaction> getTransactionHistory() {
      return TRANSACTION_HISTORY;
   }

   public String getAccountNumber() {
      return accountNumber;
   }

   public void setAccountNumber(String accountNumber) {
      this.accountNumber = accountNumber;
   }

   public double getBalance() {
      return balance;
   }

   public void setBalance(double balance) {
      this.balance = balance;
   }

   public Customer getOwner() {
      return owner;
   }

   public void setOwner(Customer owner) {
      this.owner = owner;
   }

   @Override
   public String toString() {
      return "Account Number: " + accountNumber + "\n" + "Balance: " + balance + "\n" + "Owner: " + owner.getName() + "\n" + "Transaction History: " + TRANSACTION_HISTORY;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj) return true;
      if (obj == null || getClass() != obj.getClass()) return false;
//      Account account = (Account) obj;
//      return Double.compare(account.balance, balance) == 0 && accountNumber.equals(account.accountNumber) && owner.equals(account.owner);
   }
}

class SavingsAccount extends Account {
   private double interestRate;
   private String accountStatus;

   public SavingsAccount(String accountNumber, double balance, Customer owner, double interestRate, String accountStatus) {
      super(accountNumber, balance, owner);
      this.interestRate = interestRate;
      this.accountStatus = accountStatus;
   }

   @Override
   public double calculateProjectedBalance() {
      return getBalance() * (1 + interestRate);
   }

   public double getInterestRate() {
      return interestRate;
   }

   public void setInterestRate(double interestRate) {
      this.interestRate = interestRate;
   }

   public String getAccountStatus() {
      return accountStatus;
   }

   public void setAccountStatus(String accountStatus) {
      this.accountStatus = accountStatus;
   }
}

class CheckingAccount extends Account {
   private static final double INTEREST_RATE = 0.03; // 3% annual interest rate
   private double overdraftLimit;
   private boolean hasDebitCard;
   private boolean hasATMAccess;
   private boolean hasOnlineBankingAccess;

   public CheckingAccount(String accountNumber, double balance, Customer owner, double overdraftLimit, boolean hasDebitCard, boolean hasATMAccess, boolean hasOnlineBankingAccess) {
      super(accountNumber, balance, owner);
      this.overdraftLimit = overdraftLimit;
      this.hasDebitCard = hasDebitCard;
      this.hasATMAccess = hasATMAccess;
      this.hasOnlineBankingAccess = hasOnlineBankingAccess;
   }

   @Override
   public double calculateProjectedBalance() {
      return getBalance() * (1 + INTEREST_RATE) - overdraftLimit;
   }

   public double getOverdraftLimit() {
      return overdraftLimit;
   }

   public void setOverdraftLimit(double overdraftLimit) {
      this.overdraftLimit = overdraftLimit;
   }

   public static double getInterestRate() {
      return INTEREST_RATE;
   }

   public boolean hasDebitCard() {
      return hasDebitCard;
   }

   public void setDebitCard(boolean hasDebitCard) {
      this.hasDebitCard = hasDebitCard;
   }

   public boolean hasATMAccess() {
      return hasATMAccess;
   }

   public void setATMAccess(boolean hasATMAccess) {
      this.hasATMAccess = hasATMAccess;
   }

   public boolean hasOnlineBankingAccess() {
      return hasOnlineBankingAccess;
   }

   public void setOnlineBankingAccess(boolean hasOnlineBankingAccess) {
      this.hasOnlineBankingAccess = hasOnlineBankingAccess;
   }
}