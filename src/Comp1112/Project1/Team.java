package Project;

class Team {
   private final String shortName;
   private final String fullName;
   private double totalValue;
   private int size;
   public static final int maxTeamSize = 22;

   public Team(String shortName, String fullName, double totalValue, int size) {
      this.shortName = shortName;
      this.fullName = fullName;
      this.totalValue = totalValue;
      this.size = size;
//    recalculateTotalValue();
   }

   public String getShortName() {
      return shortName;
   }

   public String getFullName() {
      return fullName;
   }

   public double getTotalValue() {
      return totalValue;
   }

   public void setTotalValue(double totalValue) {
      this.totalValue = totalValue;
   }

   public int getSize() {
      return size;
   }

   public void setSize(int size) {
      this.size = size;
   }

   public String toString() {
      return STR."\{shortName}, name=\{fullName}, value: \{totalValue}, size: \{size}";
   }
}