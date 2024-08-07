package Comp1112.Project2;

public class InstitutionalCustomer extends Customer {
   private String businessName;
   private String businessAddress;
   private String businessContact;
   private String typeOfInstitution;
   private String industrySector;
   private double annualRevenue;

   public InstitutionalCustomer(String name, String address, String contactDetails, String businessName, String businessAddress, String businessContact, String typeOfInstitution, String industrySector, double annualRevenue) {
      super(name, address, contactDetails);
      this.businessName = businessName;
      this.businessAddress = businessAddress;
      this.businessContact = businessContact;
      this.typeOfInstitution = typeOfInstitution;
      this.industrySector = industrySector;
      this.annualRevenue = annualRevenue;
   }

   public String getBusinessName() {
      return businessName;
   }

   public void setBusinessName(String businessName) {
      this.businessName = businessName;
   }

   public String getBusinessAddress() {
      return businessAddress;
   }

   public void setBusinessAddress(String businessAddress) {
      this.businessAddress = businessAddress;
   }

   public String getBusinessContact() {
      return businessContact;
   }

   public void setBusinessContact(String businessContact) {
      this.businessContact = businessContact;
   }

   public String getTypeOfInstitution() {
      return typeOfInstitution;
   }

   public void setTypeOfInstitution(String typeOfInstitution) {
      this.typeOfInstitution = typeOfInstitution;
   }

   public String getIndustrySector() {
      return industrySector;
   }

   public void setIndustrySector(String industrySector) {
      this.industrySector = industrySector;
   }

   public double getAnnualRevenue() {
      return annualRevenue;
   }

   public void setAnnualRevenue(double annualRevenue) {
      this.annualRevenue = annualRevenue;
   }
}