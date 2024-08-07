package Comp1112.Project2;

public class TestDriver {
   private static final AccountManagerImpl accountManager = new AccountManagerImpl();

   public static void main(String[] args) {
      testAccountCreation();
      testDepositWithdrawTransfer();
      testDisplayAccountDetails();
      testFinancialPortfolio();
      testAdditionalFeatures();
   }

   public static void testAccountCreation() {
      IndividualCustomer customer1 = new IndividualCustomer("John Doe", "123 Main St", "john@example.com", "Male", "123456789", "Engineer");
      InstitutionalCustomer customer2 = new InstitutionalCustomer("Acme Corp", "456 Market St", "acme@example.com", "Acme Corp", "456 Market St", "acme@example.com", "Corporation", "Manufacturing", 1000000);

      accountManager.createSavingsAccount("111111", 1000, customer1, 0.02, "Active");
      accountManager.createCheckingAccount("222222", 2000, customer2, 500);
   }

   public static void testDepositWithdrawTransfer() {
      accountManager.deposit("111111", 500);
      accountManager.withdraw("222222", 300);
      accountManager.transfer("111111", "222222", 200);
   }

   public static void testDisplayAccountDetails() {
      accountManager.displayAccountDetails("111111");
      accountManager.displayAccountDetails("222222");
   }

   public static void testFinancialPortfolio() {
      FinancialPortfolio portfolio1 = new FinancialPortfolio();
      FinancialPortfolio portfolio2 = new FinancialPortfolio();

      portfolio1.addAccount(accountManager.getAccount("111111"));
      portfolio2.addAccount(accountManager.getAccount("222222"));

      int comparisonResult = portfolio1.compareTo(portfolio2);
      if (comparisonResult > 0) {
         System.out.println("Portfolio 1 has a greater total balance than Portfolio 2.");
      } else if (comparisonResult < 0) {
         System.out.println("Portfolio 2 has a greater total balance than Portfolio 1.");
      } else {
         System.out.println("Portfolio 1 and Portfolio 2 have the same total balance.");
      }
   }

   public static void testAdditionalFeatures() {
      IndividualCustomer customer3 = new IndividualCustomer("Jane Doe", "456 Main St", "jane@example.com", "Female", "987654321", "Doctor");
      accountManager.createSavingsAccount("333333", 3000, customer3, 0.03, "Active");
      FinancialPortfolio portfolio3 = new FinancialPortfolio();
      portfolio3.addAccount(accountManager.getAccount("333333"));

      accountManager.deposit("333333", 1000);

      accountManager.transfer("333333", "111111", 500);
   }
}