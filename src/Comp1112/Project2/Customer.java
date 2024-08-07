   package Comp1112.Project2;

   import java.util.ArrayList;
   import java.util.List;

   public class Customer {
      private String name;
      private String address;
      private String contactDetails;
      private final List<Account> accounts;

      public Customer(String name, String address, String contactDetails) {
         this.name = name;
         this.address = address;
         this.contactDetails = contactDetails;
         this.accounts = new ArrayList<>();
      }

      public void addAccount(Account account) {
         this.accounts.add(account);
      }

      public void removeAccount(Account account) {
         this.accounts.remove(account);
      }

      public List<Account> getAccounts() {
         return accounts;
      }

      public String getName() {
         return name;
      }

      public void setName(String name) {
         this.name = name;
      }

      public String getAddress() {
         return address;
      }

      public void setAddress(String address) {
         this.address = address;
      }

      public String getContactDetails() {
         return contactDetails;
      }

      public void setContactDetails(String contactDetails) {
         this.contactDetails = contactDetails;
      }
   }