package Comp1112.Project2;

public class IndividualCustomer extends Customer {
   private String gender;
   private String idInfo;
   private String occupation;

   public IndividualCustomer(String name, String address, String contactDetails, String gender, String identificationInformation, String occupation) {
      super(name, address, contactDetails);
      this.gender = gender;
      this.idInfo = identificationInformation;
      this.occupation = occupation;
   }

   public String getGender() {
      return gender;
   }

   public void setGender(String gender) {
      this.gender = gender;
   }

   public String getIdInfo() {
      return idInfo;
   }

   public void setIdInfo(String idInfo) {
      this.idInfo = idInfo;
   }

   public String getOccupation() {
      return occupation;
   }

   public void setOccupation(String occupation) {
      this.occupation = occupation;
   }
}