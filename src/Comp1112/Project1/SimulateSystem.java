package Project;

import java.util.Scanner;

public class SimulateSystem {
   private static Project.TransferBoard transferBoard;
   private static Scanner scanner;

   public static void main(String[] args) {
      setTransferBoard(new Project.TransferBoard());
      setScanner(new Scanner(System.in));

      while (true) {
         System.out.println("""
                 Menu:
                 -------------------------------------------------------------------
                 1. List all Players in the system.
                 2. List all Teams in the system.
                 3. List all teamless players.
                 4. Establish a contract between a player and a team.
                 5. Terminate the existing contract between a player and a team.
                 6. Exit.
                 -------------------------------------------------------------------
                 Enter your choice:\s""");
         int choice = getScanner().nextInt();

         switch (choice) {
            case 1:
               System.out.println("All Players:");
               for (Project.Player player : getTransferBoard().getPlayers()) {
                  System.out.println(player);
               }
               break;
            case 2:
               System.out.println("All Teams:");
               for (Project.Team team : getTransferBoard().getTeams()) {
                  System.out.println(team);
               }
               break;
            case 3:
               System.out.println("Teamless Players:");
               boolean hasTeamlessPlayers = false;
               for (Project.Player player : getTransferBoard().getPlayers()) {
                  if (player.getCurrentTeam() == null) {
                     System.out.println(player.getName());
                     hasTeamlessPlayers = true;
                  }
               }
               if (!hasTeamlessPlayers) {
                  System.out.println("No teamless players found.");
               }
               break;
            case 4:
               System.out.println("Enter player name, team name, contract type (Permanent/Rented), and contract value:");
               String playerName = getScanner().next();
               String teamName = getScanner().next();
               String contractType = getScanner().next();
               double contractValue = getScanner().nextDouble();
               String result = getTransferBoard().makeContract(playerName, teamName, contractType, contractValue);
               System.out.println(result);
               break;
            case 5:
               System.out.println("Enter player name and team name to terminate contract:");
               playerName = getScanner().next();
               teamName = getScanner().next();
               String terminationResult = getTransferBoard().terminateContract(playerName, teamName);
               System.out.println(terminationResult);
               break;
            case 6:
               System.out.println("Exiting program...");
               printExitInformation(getTransferBoard());
               System.exit(0);
               break;
            default:
               System.out.println("Invalid choice. Please enter a valid option.");
         }
      }
   }

   private static void printExitInformation(Project.TransferBoard transferBoard) {
      System.out.println("For each player with a contract:");
      for (Project.Player player : transferBoard.getPlayers()) {
         if (player.getCurrentTeam() != null) {
            System.out.println(STR."\{player.getName()} : \{player.getMarketValue()} \{player.getCurrentTeam().getShortName()}");
         }
      }

      System.out.println("For each team:");
      for (Project.Team team : transferBoard.getTeams()) {
         System.out.println(STR."\{team.getShortName()} : \{team.getTotalValue()} \{team.getSize()}");
      }

      System.out.println("For each player without a contract:");
      for (Project.Player player : transferBoard.getPlayers()) {
         if (player.getCurrentTeam() == null) {
            System.out.println(player.getName());

         }
      }
   }

   private static Project.TransferBoard getTransferBoard() {
      return transferBoard;
   }

   private static void setTransferBoard(Project.TransferBoard transferBoard) {
      SimulateSystem.transferBoard = transferBoard;
   }

   private static Scanner getScanner() {
      return scanner;
   }

   private static void setScanner(Scanner scanner) {
      SimulateSystem.scanner = scanner;
   }
}