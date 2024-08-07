package Comp1111.Project3;

/*
 * @author of this code Yigit Okur (23Soft1040)
 * github.com/TurkishKEBAB
 */

/**
 * This is a game called DragonsOrTreasureGame. The game is played on a 7x7 grid, with certain coordinates being valid and others not.
 * The game starts by asking for the number of players. Each player is represented by an array of integers, storing their coordinates, treasure count, game points, and the number of dragons and traps they've encountered.
 * The game also keeps track of which players are still active in the game.
 * <p>
 * The game has dragons, traps, and exits, each with their own coordinates. The coordinates for these elements are randomized at the start of the game.
 * <p>
 * The game continues in a loop until all players are eliminated or a player escapes. In each round of the loop, each player (if they are still active) makes a move. The move is validated, and if it's valid, the player makes the move.
 * <p>
 * After making a move, the player may encounter a dragon, a trap, a treasure, an escape exit, or a cliff exit. Each of these encounters is handled differently:
 * - If the player encounters a dragon and has a treasure, they give the treasure to the dragon and continue playing.
 * - If the player encounters a dragon and doesn't have a treasure, they play a guessing game with the dragon. If they guess correctly, they defeat the dragon and gain points. If they guess incorrectly, they lose points.
 * - If the player encounters a trap, they lose points.
 * - If the player encounters a treasure, they gain the treasure and points.
 * - If the player encounters an escape exit, they escape and the game ends.
 * - If the player encounters a cliff exit, they fall off the cliff, lose all their points, and are eliminated from the game.
 * <p>
 * After each move, the game displays the current status of the player.
 * <p>
 * When the game ends, it displays the final game area and the final status of all players.
 * <p>
 * <p>
 * ███╗   ██╗ ██████╗ ██████╗ ███╗   ███╗    ███████╗███╗   ██╗██████╗ ███████╗██████╗          https://www.youtube.com/watch?v=ukzE8LRAL_c&pp=ygUUbm9ybSBlbmRlciBzb24gdXlrdSA%3D
 * ████╗  ██║██╔═══██╗██╔══██╗████╗ ████║    ██╔════╝████╗  ██║██╔══██╗██╔════╝██╔══██╗         https://www.youtube.com/watch?v=G7e2KlYbFa0
 * ██╔██╗ ██║██║   ██║██████╔╝██╔████╔██║    █████╗  ██╔██╗ ██║██║  ██║█████╗  ██████╔╝         https://youtu.be/kfIiRxVqEbw?si=mbmuAooVxaCZNW3V
 * ██║╚██╗██║██║   ██║██╔══██╗██║╚██╔╝██║    ██╔══╝  ██║╚██╗██║██║  ██║██╔══╝  ██╔══██╗         https://www.youtube.com/watch?v=-dL-hDLTnEE&pp=ygUKbm9ybSBlbmRlcg%3D%3D
 * ██║ ╚████║╚██████╔╝██║  ██║██║ ╚═╝ ██║    ███████╗██║ ╚████║██████╔╝███████╗██║  ██║         https://www.youtube.com/watch?v=iSBIE78hJWg&list=PLEZPsfEhSTbfoC6YtiwmCe8FQ6ORwLUAb&index=3
 * ╚═╝  ╚═══╝ ╚═════╝ ╚═╝  ╚═╝╚═╝     ╚═╝    ╚══════╝╚═╝  ╚═══╝╚═════╝ ╚══════╝╚═╝  ╚═╝         https://www.youtube.com/watch?v=b9QApLJ3TI0
 * <p>
 * ███████╗███████╗██╗     ███████╗██████╗     ███████╗██████╗ ███████╗███████╗███████╗██╗███████╗     ██████╗ ██╗     ██████╗ ██╗   ██╗
 * ██╔════╝╚══███╔╝██║     ██╔════╝██╔══██╗    ██╔════╝██╔══██╗██╔════╝██╔════╝██╔════╝██║╚══███╔╝    ██╔═══██╗██║     ██╔══██╗██║   ██║
 * ███████╗  ███╔╝ ██║     █████╗  ██████╔╝    █████╗  ██████╔╝█████╗  █████╗  ███████╗██║  ███╔╝     ██║   ██║██║     ██║  ██║██║   ██║
 * ╚════██║ ███╔╝  ██║     ██╔══╝  ██╔══██╗    ██╔══╝  ██╔══██╗██╔══╝  ██╔══╝  ╚════██║██║ ███╔╝      ██║   ██║██║     ██║  ██║██║   ██║
 * ███████║███████╗███████╗███████╗██║  ██║    ███████╗██║  ██║███████╗██║     ███████║██║███████╗    ╚██████╔╝███████╗██████╔╝╚██████╔╝
 * ╚══════╝╚══════╝╚══════╝╚══════╝╚═╝  ╚═╝    ╚══════╝╚═╝  ╚═╝╚══════╝╚═╝     ╚══════╝╚═╝╚══════╝     ╚═════╝ ╚══════╝╚═════╝  ╚═════╝
 * <p>
 * This code wrote by @Yigit Okur / 23soft1040
 * github.com/TurkishKEBAB
 */


import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class DragonsOrTreasureGamePart3 {
   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      System.out.println("Enter number of players: ");
      int playerCount = scanner.nextInt();

      int[][] players = new int[playerCount][6]; // Each player has x, y, treasureCount, gamePoints, dragonsVisited, trapsVisited
      boolean[] activePlayers = new boolean[playerCount]; // Each player's active status
      Arrays.fill(activePlayers, true); // All players are initially active


      for (int i = 0; i < playerCount; i++) {
         players[i][0] = 4; // Initial x coordinate
         players[i][1] = 1; // Initial y coordinate
      }

      // Dragon coordinates
      int[][] dragonCoordinates = new int[5][2];
      // Trap coordinates
      int[][] trapCoordinates = new int[3][2];
      // Exit coordinates
      int[][] exitCoordinates = new int[2][2];

      startGame(players, dragonCoordinates, trapCoordinates, exitCoordinates, activePlayers);
   }

   public static void startGame(int[][] players, int[][] dragonCoordinates, int[][] trapCoordinates, int[][] exitCoordinates, boolean[] activePlayers) {
      randomizeCoordinates(dragonCoordinates, trapCoordinates, exitCoordinates);
      Scanner scanner = new Scanner(System.in);
      boolean allPlayersEliminated;
      boolean playerEscaped;
      do {
         allPlayersEliminated = true;
         playerEscaped = false;
         for (int i = 0; i < players.length; i++) {
            if (activePlayers[i]) {
               allPlayersEliminated = false;
               boolean validMove = false;
               while (!validMove) {
                  displayGameStatus(players[i], i);
                  System.out.println("Enter move for player " + (i + 1) + " (w: up, s: down, a: left, d: right): ");
                  char move = scanner.next().charAt(0);
                  if (canMove(players[i], move)) {
                     makeMove(move, players[i]);
                     validMove = true;
                     if (isDragonAndTreasure(players[i][0], players[i][1], dragonCoordinates)) {
                        System.out.println("Player " + (i + 1) + " transferred all the treasure to the dragon to spare the life. You are breathing. FOR NOW");
                        players[i][2]--; // Treasure count decrease
                        players[i][4]++; // Dragons visited increase
                     } else if (isDragon(players[i][0], players[i][1], dragonCoordinates)) {
                        handleDragonEncounter(players[i]);
                     } else if (isTrap(players[i][0], players[i][1], trapCoordinates)) {
                        handleTrapEncounter(players[i]);
                     } else if (isTreasure(players[i][0], players[i][1])) {
                        handleTreasureEncounter(players[i]);
                     } else if (isEscapeExit(players[i][0], players[i][1], exitCoordinates)) {
                        System.out.println("Congratulations! Player " + (i + 1) + " has escaped with " + players[i][3] + " points.");
                        playerEscaped = true;
                        break;
                     } else if (isCliffExit(players[i][0], players[i][1], exitCoordinates)) {
                        System.out.println("Player " + (i + 1) + " fell off the cliff! Game over.");
                        players[i][3] = 0;
                        activePlayers[i] = false;
                        displayGameStatus(players[i], i);
                     }
                  } else {
                     System.out.println("Invalid move! Try again.");
                  }
               }
            }
            if (allPlayersEliminated || playerEscaped) {
               break;
            }
         }
      } while (!allPlayersEliminated && !playerEscaped);
      displayFinalGameArea(players, dragonCoordinates, trapCoordinates, exitCoordinates);
      for (int i = 0; i < players.length; i++) {
         displayGameStatus(players[i], i);
      }
   }


   public static void randomizeCoordinates(int[][] dragonCoordinates, int[][] trapCoordinates, int[][] exitCoordinates) {
      Random rand = new Random();

      // Randomizing the Dragon's location.
      for (int i = 0; i < 5; ) {
         int x = rand.nextInt(7) + 1;
         int y = rand.nextInt(7) + 1;
         if (isValidCoordinate(x, y) && isCoordinateUnique(dragonCoordinates, x, y)) {
            dragonCoordinates[i][0] = x;
            dragonCoordinates[i][1] = y;
            i++;
         }
      }

      // Randomizing the Trap's location.
      for (int i = 0; i < 3; ) {
         int x = rand.nextInt(7) + 1;
         int y = rand.nextInt(7) + 1;
         if (isValidCoordinate(x, y) && isCoordinateUnique(dragonCoordinates, x, y) && isCoordinateUnique(trapCoordinates, x, y)) {
            trapCoordinates[i][0] = x;
            trapCoordinates[i][1] = y;
            i++;
         }
      }

      // Randomizing the Exit's location.
      for (int i = 0; i < 2; ) {
         int x = rand.nextInt(7) + 1;
         int y = rand.nextInt(7) + 1;
         if (isValidCoordinate(x, y) && isCoordinateUnique(dragonCoordinates, x, y) && isCoordinateUnique(trapCoordinates, x, y) && isCoordinateUnique(exitCoordinates, x, y)) {
            exitCoordinates[i][0] = x;
            exitCoordinates[i][1] = y;
            i++;
         }
      }
   }


   public static boolean isCoordinateUnique(int[][] coordinates, int x, int y) {
      for (int[] coord : coordinates) {
         if (coord[0] == x && coord[1] == y) {
            return false;
         }
      }
      return true;
   }


   public static boolean canMove(int[] playerCoordinates, char direction) {
      int newX = playerCoordinates[0], newY = playerCoordinates[1];
      switch (direction) {
         case 'w':
            newY++;
            break;
         case 's':
            newY--;
            break;
         case 'a':
            newX--;
            break;
         case 'd':
            newX++;
            break;
         default:
            return false;
      }
      return isValidCoordinate(newX, newY) && newX >= 1 && newY >= 1;
   }


   public static void makeMove(char direction, int[] playerCoordinates) {
      switch (direction) {
         case 'w':
            playerCoordinates[1]++;
            break;
         case 's':
            playerCoordinates[1]--;
            break;
         case 'a':
            playerCoordinates[0]--;
            break;
         case 'd':
            playerCoordinates[0]++;
            break;
      }
   }

   public static boolean isValidCoordinate(int x, int y) {
      int[][] validCoordinates = {{4, 1}, {3, 2}, {4, 2}, {5, 2}, {2, 3}, {3, 3}, {4, 3}, {5, 3}, {6, 3}, {1, 4}, {2, 4}, {3, 4}, {4, 4}, {5, 4}, {6, 4}, {7, 4}, {2, 5}, {3, 5}, {4, 5}, {5, 5}, {6, 5}, {3, 6}, {4, 6}, {5, 6}, {4, 7}};

      for (int[] validCoordinate : validCoordinates) {
         if (validCoordinate[0] == x && validCoordinate[1] == y) {
            return true;
         }
      }

      return false;
   }


   public static boolean isDragon(int x, int y, int[][] dragonCoordinates) {
      for (int[] coord : dragonCoordinates) {
         if (coord[0] == x && coord[1] == y) {
            return true;
         }
      }
      return false;
   }

   public static boolean isTrap(int x, int y, int[][] trapCoordinates) {
      for (int[] coord : trapCoordinates) {
         if (coord[0] == x && coord[1] == y) {
            return true;
         }
      }
      return false;
   }

   public static boolean isTreasure(int x, int y) {
      return (x % 2 == 1) && (y % 2 == 1);
   }

   public static boolean isEscapeExit(int x, int y, int[][] exitCoordinates) {
      return (x == exitCoordinates[0][0] && y == exitCoordinates[0][1]);
   }

   public static boolean isCliffExit(int x, int y, int[][] exitCoordinates) {
      return (x == exitCoordinates[1][0] && y == exitCoordinates[1][1]);
   }

   public static void handleDragonEncounter(int[] gameStats) {
      System.out.println("You encountered a dragon!");
      if (generate4DigitNum()) {
         System.out.println("You guessed the number correctly and defeated the dragon!");
         gameStats[3] += 50; // Increase points for defeating the dragon
      } else {
         System.out.println("You guessed the number incorrectly and the dragon defeated you!");
         gameStats[3] -= 50; // Decrease points for being defeated by the dragon
      }
      gameStats[4]++; // Increase dragons encountered count
   }

   public static void handleTrapEncounter(int[] gameStats) {
      System.out.println("You fell into a trap!");
      gameStats[1] -= 20; // Trap penalty
   }


   public static void handleTreasureEncounter(int[] gameStats) {
      System.out.println("You found a treasure!");
      gameStats[2]++; // Increase treasure count
      gameStats[3] += 10; // Increase points
   }

   public static boolean generate4DigitNum() {
      Random rd = new Random();
      int randomNumber = 1000 + rd.nextInt(9000);
      System.out.println("Guess the 4-digit number: ");
      Scanner scanner = new Scanner(System.in);
      int guess = scanner.nextInt();
      return (guess == randomNumber);
   }

   public static void displayGameStatus(int[] playerStats, int playerIndex) {
      System.out.println("Player " + (playerIndex + 1) + " status:");
      System.out.println("Coordinates: (" + playerStats[0] + ", " + playerStats[1] + ")");
      System.out.println("Treasures: " + playerStats[2]);
      System.out.println("Game Points: " + playerStats[3]);
      System.out.println("Dragons Encountered: " + playerStats[4]);
      System.out.println("Traps Encountered: " + playerStats[5]);
   }

   public static boolean isDragonAndTreasure(int x, int y, int[][] dragonCoordinates) {
      for (int[] coord : dragonCoordinates) {
         if (coord[0] == x && coord[1] == y) {
            return true;
         }
      }
      return false;
   }

   public static int findWinner(int[][] players) {
      int winnerIndex = 0;
      int maxPoints = players[0][3]; // Initial max points is the points of the first player

      for (int i = 1; i < players.length; i++) {
         if (players[i][3] > maxPoints) {
            maxPoints = players[i][3];
            winnerIndex = i;
         }
      }

      return winnerIndex;
   }

   public static int findTreasureCollector(int[][] players) {
      int collectorIndex = 0;
      int maxTreasures = players[0][2]; // Initial max treasures is the treasures of the first player

      for (int i = 1; i < players.length; i++) {
         if (players[i][2] > maxTreasures) {
            maxTreasures = players[i][2];
            collectorIndex = i;
         }
      }

      return collectorIndex;
   }

   public static void displayFinalGameArea(int[][] players, int[][] dragonCoordinates, int[][] trapCoordinates, int[][] exitCoordinates) {
      System.out.println("Final game area with all elements:");
      for (int y = 7; y >= 1; y--) {
         for (int x = 1; x <= 7; x++) {
            if (!isValidCoordinate(x, y)) {
               System.out.print("  ");
               continue;
            }
            for (int i = 0; i < players.length; i++) {
               if (players[i][0] == x && players[i][1] == y) {
                  System.out.print("\uD83D\uDC68\u200D\uD83D\uDCBB" + (i + 1) + " ");
               }
            }
            int winnerIndex = findWinner(players);
            System.out.println("Player " + (winnerIndex + 1) + " is the winner with " + players[winnerIndex][3] + " points.");

            int collectorIndex = findTreasureCollector(players);
            System.out.println("Player " + (collectorIndex + 1) + " collected the most treasures with " + players[collectorIndex][2] + " treasures.");
            if (isDragon(x, y, dragonCoordinates)) {
               System.out.print("\uD83D\uDC32 ");
            } else if (isTrap(x, y, trapCoordinates)) {
               System.out.print("\uD83D\uDD17 ");
            } else if (isEscapeExit(x, y, exitCoordinates)) {
               System.out.print("\uD83D\uDD4A\uFE0F ");
            } else if (isCliffExit(x, y, exitCoordinates)) {
               System.out.print("⛰\uFE0F ");
            } else if (isTreasure(x, y)) {
               System.out.print("\uD83D\uDC8E ");
            } else {
               System.out.print(". ");
            }
         }
         System.out.println();
      }
   }
}
