package Comp1112.Project2;

public interface AccountManager {
   void displayAccountDetails(String accountNumber);

   void updateContactDetails(String accountNumber, String newContactDetails);

   void deposit(String accountNumber, double amount);

   void withdraw(String accountNumber, double amount);

   void transfer(String fromAccountNumber, String toAccountNumber, double amount);

   Account getAccount(String accountNumber);

   double getAccountBalance(String accountNumber);

   void createSavingsAccount(String accountNumber, double initialBalance, Customer owner, double interestRate, String accountStatus);

   void createCheckingAccount(String accountNumber, double initialBalance, Customer owner, double overdraftLimit);
}