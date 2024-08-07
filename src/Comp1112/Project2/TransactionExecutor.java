package Comp1112.Project2;

import java.util.List;

public class TransactionExecutor {
   public static void deposit(Account account, double amount) {
      double currentBalance = account.getBalance();
      account.setBalance(currentBalance + amount);
      Transaction transaction = new Transaction("DEPOSIT", amount, "Deposit");
      account.getTransactionHistory().add(transaction);
   }

   public static void withdraw(Account account, double amount) {
      double currentBalance = account.getBalance();
      if (currentBalance >= amount) {
         account.setBalance(currentBalance - amount);
         Transaction transaction = new Transaction("WITHDRAW", amount, "Withdraw");
         account.getTransactionHistory().add(transaction);
      } else {
         throw new IllegalArgumentException("Insufficient balance for withdrawal.");
      }
   }

   public static void transfer(Account fromAccount, Account toAccount, double amount) {
      if (fromAccount.getBalance() >= amount) {
         fromAccount.setBalance(fromAccount.getBalance() - amount);
         toAccount.setBalance(toAccount.getBalance() + amount);
         Transaction transaction = new Transaction("TRANSFER", amount, "Transfer");
         fromAccount.getTransactionHistory().add(transaction);
         toAccount.getTransactionHistory().add(transaction);
      } else {
         throw new IllegalArgumentException("Insufficient balance for transfer.");
      }
   }

   public static Transaction getTransaction(Account account, int index) {
      List<Transaction> transactionHistory = account.getTransactionHistory();
      if (index >= 0 && index < transactionHistory.size()) {
         return transactionHistory.get(index);
      } else {
         throw new IndexOutOfBoundsException("Invalid transaction index.");
      }
   }
}