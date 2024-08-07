package Project;

//This class is created for creating player objects
class Player {
   private final int backNumber; // player's back number
   private final String name; // player's name
   private String position; // player's position
   private double marketValue; // player's market value
   private Team currentTeam; //player's current team
   private Team previousTeam; // player's previous team

   // Constructor for Player class
   // This constructor has 3 parameters: player's name, back number, position
   public Player(String name, int backNumber, String position) {
      this.name = name; // This method for object's name
      this.backNumber = backNumber; // This method for object's back number
      setPosition(position); // calling this method for checking is the position valid
   }

   // Getter method for the player's back number
   public int getBackNumber() {
      return backNumber;
   }

   // Getter method for the player's name
   public String getName() {
      return name;
   }

   // Getter method for the player's position
   public String getPosition() {
      return position;
   }

   // Setter method for the player's position
   private void setPosition(String position) {
      if (isValidPosition(position)) { // If the isValidPosition method true then position can be set
         this.position = position;
      } else { //Otherwise it will print the "Invalid position" sentence
         System.out.println("Invalid position");
      }
   }

   // This method created for check is the input of value acceptable
   private boolean isValidPosition(String position) {
      return (position.equals("Goalkeeper") || position.equals("Defence") ||
              position.equals("Midfielder") || position.equals("Forward")); // If the position is a valid value, then the method will return true. Otherwise, it will be false
   }

   // Getter method for the player's market value
   public double getMarketValue() {
      return marketValue;
   }

   // Setter method for the player's market value
   public void setMarketValue(double marketValue) {
      this.marketValue = marketValue;
   }

   // Getter method for the player's current team
   public Team getCurrentTeam() {
      return currentTeam;
   }

   // Setter method for the player's current team
   public void setCurrentTeam(Team currentTeam) {
      this.currentTeam = currentTeam;
   }

   // Getter method for the player's previous team
   public Team getPreviousTeam() {
      return previousTeam;
   }

   // Setter method for the player's previous team
   public void setPreviousTeam(Team previousTeam) {
      this.previousTeam = previousTeam;
   }

   // This method created for printing the player's values (properties)
   public String toString() {
      return STR."\{name}, backNumber=\{backNumber}, position=\{getPosition()}, marketValue=\{getMarketValue()} current team=\{getCurrentTeam()} previus team =\{getPreviousTeam()}";
   }
}