package Comp1112.Project1;

class Player {
   private final int backNumber;
   private final String name;
   private String position;
   private double marketValue;
   private Team currentTeam;
   private Team previousTeam;

   public Player(String name, int backNumber, String position) {
      this.name = name;
      this.backNumber = backNumber;
      setPosition(position);
   }

   public int getBackNumber() {
      return backNumber;
   }

   public String getName() {
      return name;
   }

   public String getPosition() {
      return position;
   }

   private void setPosition(String position) {
      if (isValidPosition(position)) {
         this.position = position;
      } else {
         System.out.println("Invalid position");
      }
   }

   private boolean isValidPosition(String position) {
      return (position.equals("Goalkeeper") || position.equals("Defence") || position.equals("Midfielder") || position.equals("Forward"));
   }

   public double getMarketValue() {
      return marketValue;
   }

   public void setMarketValue(double marketValue) {
      this.marketValue = marketValue;
   }

   public Team getCurrentTeam() {
      return currentTeam;
   }

   public void setCurrentTeam(Team currentTeam) {
      this.currentTeam = currentTeam;
   }

   public Team getPreviousTeam() {
      return previousTeam;
   }

   public void setPreviousTeam(Team previousTeam) {
      this.previousTeam = previousTeam;
   }

   public String toString() {
      return String.format("%s, backNumber=%d, position=%s, marketValue=%.2f, current team=%s, previous team=%s", name, backNumber, getPosition(), getMarketValue(), getCurrentTeam(), getPreviousTeam());
   }
}