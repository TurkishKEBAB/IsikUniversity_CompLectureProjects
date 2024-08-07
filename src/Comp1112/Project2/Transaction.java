package Comp1112.Project2;
/*
 * @author of this code Yigit Okur (23Soft1040)
 * github.com/TurkishKEBAB
 */

import java.time.LocalDate;

public class Transaction {
   private String transactionID;
   private double amount;
   private LocalDate date;
   private String type;

   public Transaction(String transactionID, double amount, String type) {
      this.transactionID = transactionID;
      this.amount = amount;
      this.date = LocalDate.now();
      this.type = type;
   }

   public String getTransactionID() {
      return transactionID;
   }

   public void setTransactionID(String transactionID) {
      this.transactionID = transactionID;
   }

   public double getAmount() {
      return amount;
   }

   public void setAmount(double amount) {
      this.amount = amount;
   }

   public LocalDate getDate() {
      return date;
   }

   public void setDate(LocalDate date) {
      this.date = date;
   }

   public String getType() {
      return type;
   }

   public void setType(String type) {
      this.type = type;
   }
}