package Comp1112.Project1;

import java.util.ArrayList;

class TransferBoard {
   private ArrayList<Contract> contracts;
   private ArrayList<Player> players;
   private ArrayList<Team> teams;

   public TransferBoard() {
      setPlayers(new ArrayList<>());
      setTeams(new ArrayList<>());
      setContracts(new ArrayList<>());
      populatePlayers();
      populateTeams();
   }

   private void populatePlayers() {
      players.add(new Player("Muslera", 1, "Goalkeeper"));
      players.add(new Player("Kaan", 22, "Defence"));
      players.add(new Player("Toreira", 34, "Midfield"));
      players.add(new Player("Icardi", 99, "Forward"));
      players.add(new Player("Kerem", 7, "Midfield"));
      players.add(new Player("Abdulkerim", 17, "Defence"));
      players.add(new Player("Oliveira", 20, "Midfield"));
      players.add(new Player("Mertens", 10, "Midfield"));
      players.add(new Player("Bakambu", 9, "Forward"));
      players.add(new Player("Nellson", 4, "Defence"));
      players.add(new Player("Boey", 2, "Defence"));
   }

   private void populateTeams() {
      teams.add(new Team("GS", "Galatasaray", 64.00, 21));
      teams.add(new Team("FB", "Fenerbahce", 987654.05, 22));
      teams.add(new Team("BJK", "Besiktas", 58659.0, 19));
      teams.add(new Team("TS", "Trabzonspor", 0.0, 1));
      teams.add(new Team("ANK", "Ankaragucu", 95485.0, 20));
      teams.add(new Team("BSK", "Basaksehir", 128000000000.0, 1));
      teams.add(new Team("KGM", "Karagumruk", 0.0, 10));
   }

   public String makeContract(String playerName, String teamName, String contractType, double contractValue) {
      Player player = findPlayer(playerName);
      if (player == null) return "Unknown player: " + playerName;

      Team team = findTeam(teamName);
      if (team == null) return "Unknown team: " + teamName;

      if (team.getSize() == Team.maxTeamSize) {
         return "Team " + teamName + " has reached the maximum number of players.";
      }

      for (Contract contract : getContracts()) {
         if (contract.getPlayer() == player && contract.getTeam() == team)
            return "Existing contract between " + playerName + " and " + teamName;
      }

      for (Contract contract : getContracts()) {
         if (contract.getPlayer() == player && contract.getType().equals("Rented"))
            return "Player " + playerName + " already has a rented contract.";
      }

      Contract newContract = new Contract(player, team, contractType, contractValue);
      getContracts().add(newContract);
      player.setCurrentTeam(team);
      team.setSize(team.getSize() + 1);
      team.setTotalValue(team.getTotalValue() + contractValue);
      player.setMarketValue(contractValue);

      return "Successfully contracted " + playerName + " to " + teamName;
   }

   public String terminateContract(String playerName, String teamName) {
      Player player = findPlayer(playerName);
      if (player == null) return "Unknown player: " + playerName;

      Team team = findTeam(teamName);
      if (team == null) return "Unknown team: " + teamName;

      Contract contractToRemove = null;
      for (Contract contract : getContracts()) {
         if (contract.getPlayer() == player && contract.getTeam() == team) {
            contractToRemove = contract;
            break;
         }
      }

      if (contractToRemove != null) {
         getContracts().remove(contractToRemove);
         player.setCurrentTeam(null);
         team.setSize(team.getSize() - 1);
         team.setTotalValue(team.getTotalValue() - contractToRemove.getValue());
         return "Contract between " + playerName + " and " + teamName + " terminated successfully.";
      }

      return "No contract found between " + playerName + " and " + teamName;
   }

   public ArrayList<Contract> getContracts() {
      return contracts;
   }

   private void setContracts(ArrayList<Contract> contracts) {
      this.contracts = contracts;
   }

   public ArrayList<Player> getPlayers() {
      return players;
   }

   private void setPlayers(ArrayList<Player> players) {
      this.players = players;
   }

   public ArrayList<Team> getTeams() {
      return teams;
   }

   private void setTeams(ArrayList<Team> teams) {
      this.teams = teams;
   }

   private Player findPlayer(String playerName) {
      for (Player p : getPlayers()) {
         if (p.getName().equals(playerName)) {
            return p;
         }
      }
      return null;
   }

   private Team findTeam(String teamName) {
      for (Team t : getTeams()) {
         if (t.getShortName().equals(teamName)) {
            return t;
         }
      }
      return null;
   }
}