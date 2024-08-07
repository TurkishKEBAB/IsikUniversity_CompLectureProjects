//
package Project;

class Contract {
   private Player player;
   private Team team;
   private String type;
   private double value;

   public Contract(Player player, Team team, String type, double value) {
      setPlayer(player);
      setTeam(team);
      setType(type);
      setValue(value);
   }

   public Player getPlayer() {
      return player;
   }

   private void setPlayer(Player player) {
      this.player = player;
   }

   public Team getTeam() {
      return team;
   }

   private void setTeam(Team team) {
      this.team = team;
   }

   public String getType() {
      return type;
   }

   private void setType(String type) {
      if (isValidType()) {
         this.type = type;
      } else {
         System.out.println("Invalid position");
      }
   }

   public double getValue() {
      return value;
   }

   private void setValue(double value) {
      this.value = value;
   }

   private boolean isValidType() {
      return type.equals("Permanent") || type.equals("Rented");
   }
}