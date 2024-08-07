package Comp1112.Project2;

import java.util.ArrayList;
import java.util.List;

public class FinancialPortfolio {
   private final List<Account> accounts;

   public FinancialPortfolio() {
      this.accounts = new ArrayList<>();
   }

   public void addAccount(Account account) {
      this.accounts.add(account);
   }

   public void removeAccount(Account account) {
      this.accounts.remove(account);
   }

   public double getTotalBalance() {
      double totalBalance = 0;
      for (Account account : accounts) {
         totalBalance += account.getBalance();
      }
      return totalBalance;
   }

   public int compareTo(FinancialPortfolio otherPortfolio) {
      double thisTotalBalance = this.getTotalBalance();
      double otherTotalBalance = otherPortfolio.getTotalBalance();

      if (thisTotalBalance > otherTotalBalance) {
         return 1;
      } else if (thisTotalBalance < otherTotalBalance) {
         return -1;
      } else {
         return 0;
      }
   }

   public void displayAccountDetails() {
      for (Account account : accounts) {
         System.out.println(account.toString());
      }
   }
}