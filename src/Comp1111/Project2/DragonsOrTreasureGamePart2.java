package Comp1111.Project2;

import java.util.Random;
import java.util.Scanner;

/*
 * @author of this code Yigit Okur (23Soft1040)
 * github.com/TurkishKEBAB
 */

/*
 * DragonsOrTreasureGame is a game played on a 7x7 grid, where players navigate through the grid to collect treasures, avoid traps, and interact with dragons.
 * The game begins by initializing the number of players, each represented by an array of integers that store their coordinates, treasure count, game points, and the number of dragons and traps they've encountered.
 * The game also keeps track of the active status of each player.
 * <p>
 * The game features dragons, traps, and exits, each with their own coordinates. These coordinates are randomized at the start of the game.
 * <p>
 * The game continues in a loop until all players are eliminated or a player escapes. In each round of the loop, each active player makes a move. The move is validated, and if it's valid, the player makes the move.
 * <p>
 * After making a move, the player may encounter a dragon, a trap, a treasure, an escape exit, or a cliff exit. Each of these encounters is handled differently:
 * If the player encounters a dragon and has a treasure, they give the treasure to the dragon and continue playing.
 * If the player encounters a dragon and doesn't have a treasure, they play a guessing game with the dragon. If they guess correctly, they defeat the dragon and gain points. If they guess incorrectly, they lose points.
 * If the player encounters a trap, they lose points.
 * If the player encounters a treasure, they gain the treasure and points.
 * If the player encounters an escape exit, they escape and the game ends.
 * If the player encounters a cliff exit, they fall off the cliff, lose all their points, and are eliminated from the game.
 * <p>
 * After each move, the game displays the current status of the player.
 * <p>
 * When the game ends, it displays the final game area and the final status of all players.
 * <p>
 * <p>
 * ███╗   ███╗ █████╗ ███╗   ██╗ ██████╗  █████╗         ttps://www.youtube.com/watch?v=nSzDOKA4Fh0
 * ████╗ ████║██╔══██╗████╗  ██║██╔════╝ ██╔══██╗        https://www.youtube.com/watch?v=HB_GnnhNz-8
 * ██╔████╔██║███████║██╔██╗ ██║██║  ███╗███████║        https://www.youtube.com/watch?v=Xq3LNXor56k
 * ██║╚██╔╝██║██╔══██║██║╚██╗██║██║   ██║██╔══██║        https://www.youtube.com/watch?v=7FcfSxrRU_o
 * ██║ ╚═╝ ██║██║  ██║██║ ╚████║╚██████╔╝██║  ██║        https://www.youtube.com/results?search_query=manga
 * ╚═╝     ╚═╝╚═╝  ╚═╝╚═╝  ╚═══╝ ╚═════╝ ╚═╝  ╚═╝        https://www.youtube.com/watch?v=6qRQm2QXDAs
 * <p>
 * ███████╗██╗  ██╗   ██╗    ████████╗ ██████╗     ███████╗████████╗ █████╗ ██╗   ██╗     █████╗ ██╗     ██╗██╗   ██╗███████╗
 * ██╔════╝██║  ╚██╗ ██╔╝    ╚══██╔══╝██╔═══██╗    ██╔════╝╚══██╔══╝██╔══██╗╚██╗ ██╔╝    ██╔══██╗██║     ██║██║   ██║██╔════╝
 * █████╗  ██║   ╚████╔╝        ██║   ██║   ██║    ███████╗   ██║   ███████║ ╚████╔╝     ███████║██║     ██║██║   ██║█████╗
 * ██╔══╝  ██║    ╚██╔╝         ██║   ██║   ██║    ╚════██║   ██║   ██╔══██║  ╚██╔╝      ██╔══██║██║     ██║╚██╗ ██╔╝██╔══╝
 * ██║     ███████╗██║          ██║   ╚██████╔╝    ███████║   ██║   ██║  ██║   ██║       ██║  ██║███████╗██║ ╚████╔╝ ███████╗
 * ╚═╝     ╚══════╝╚═╝          ╚═╝    ╚═════╝     ╚══════╝   ╚═╝   ╚═╝  ╚═╝   ╚═╝       ╚═╝  ╚═╝╚══════╝╚═╝  ╚═══╝  ╚══════╝
 * <p>
 * This code wrote by @Yigit Okur / 23soft1040
 * github.com/TurkishKEBAB
 **/


public class DragonsOrTreasureGamePart2 {
   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      Random random = new Random();

      int playerX = 4;
      int playerY = 1;
      int playerTreasures = 0;
      int playerPoints = 0;
      int playerDragons = 0;
      int playerTraps = 0;
      int treasure1X = 3, treasure1Y = 3;
      int treasure2X = 3, treasure2Y = 5;
      int treasure3X = 5, treasure3Y = 3;
      int treasure4X = 5, treasure4Y = 5;

      boolean playerActive = true;
      boolean treasure1Collected = false;
      boolean treasure2Collected = false;
      boolean treasure3Collected = false;
      boolean treasure4Collected = false;
      boolean ejderha1YasiyorMu = true;
      boolean ejderha2YasiyorMu = true;
      boolean ejderha3YasiyorMu = true;
      boolean ejderha4YasiyorMu = true;
      boolean ejderha5YasiyorMu = true;

      int dragon1X = random.nextInt(7) + 1, dragon1Y = random.nextInt(7) + 1;
      while (!isValidCoordinate(dragon1X, dragon1Y)) {
         dragon1X = random.nextInt(7) + 1;
         dragon1Y = random.nextInt(7) + 1;
      }

      int dragon2X = random.nextInt(7) + 1, dragon2Y = random.nextInt(7) + 1;
      while (!isValidCoordinate(dragon2X, dragon2Y) || (dragon2X == dragon1X && dragon2Y == dragon1Y)) {
         dragon2X = random.nextInt(7) + 1;
         dragon2Y = random.nextInt(7) + 1;
      }

      int dragon3X = random.nextInt(7) + 1, dragon3Y = random.nextInt(7) + 1;
      while (!isValidCoordinate(dragon3X, dragon3Y) || (dragon3X == dragon1X && dragon3Y == dragon1Y) || (dragon3X == dragon2X && dragon3Y == dragon2Y)) {
         dragon3X = random.nextInt(7) + 1;
         dragon3Y = random.nextInt(7) + 1;
      }

      int dragon4X = random.nextInt(7) + 1, dragon4Y = random.nextInt(7) + 1;
      while (!isValidCoordinate(dragon4X, dragon4Y) || (dragon4X == dragon1X && dragon4Y == dragon1Y) || (dragon4X == dragon2X && dragon4Y == dragon2Y) || (dragon4X == dragon3X && dragon4Y == dragon3Y)) {
         dragon4X = random.nextInt(7) + 1;
         dragon4Y = random.nextInt(7) + 1;
      }

      int dragon5X = random.nextInt(7) + 1, dragon5Y = random.nextInt(7) + 1;
      while (!isValidCoordinate(dragon5X, dragon5Y) || (dragon5X == dragon1X && dragon5Y == dragon1Y) || (dragon5X == dragon2X && dragon5Y == dragon2Y) || (dragon5X == dragon3X && dragon5Y == dragon3Y) || (dragon5X == dragon4X && dragon5Y == dragon4Y)) {
         dragon5X = random.nextInt(7) + 1;
         dragon5Y = random.nextInt(7) + 1;
      }

      int trapX = random.nextInt(7) + 1, trapY = random.nextInt(7) + 1;
      while (!isValidCoordinate(trapX, trapY) || (trapX == dragon1X && trapY == dragon1Y) || (trapX == dragon2X && trapY == dragon2Y) || (trapX == dragon3X && trapY == dragon3Y)) {
         trapX = random.nextInt(7) + 1;
         trapY = random.nextInt(7) + 1;
      }

      int escapeX = random.nextInt(7) + 1, escapeY = random.nextInt(7) + 1;
      while (!isValidCoordinate(escapeX, escapeY) || (escapeX == dragon1X && escapeY == dragon1Y) || (escapeX == dragon2X && escapeY == dragon2Y) || (escapeX == dragon3X && escapeY == dragon3Y) || (escapeX == trapX && escapeY == trapY)) {
         escapeX = random.nextInt(7) + 1;
         escapeY = random.nextInt(7) + 1;
      }

      int cliffX = random.nextInt(7) + 1, cliffY = random.nextInt(7) + 1;
      while (!isValidCoordinate(cliffX, cliffY) || (cliffX == dragon1X && cliffY == dragon1Y) || (cliffX == dragon2X && cliffY == dragon2Y) || (cliffX == dragon3X && cliffY == dragon3Y) || (cliffX == trapX && cliffY == trapY) || (cliffX == escapeX && cliffY == escapeY)) {
         cliffX = random.nextInt(7) + 1;
         cliffY = random.nextInt(7) + 1;
      }


      while (playerActive) {
         System.out.println("Player Position: (" + playerX + ", " + playerY + ")");
         System.out.println("Treasures Collected: " + playerTreasures);
         System.out.println("Points: " + playerPoints);
         System.out.println("Dragons Encountered: " + playerDragons);
         System.out.println("Traps Encountered: " + playerTraps);

         System.out.println("Enter move (w: up, s: down, a: left, d: right): ");
         char move = scanner.next().charAt(0);

         int newX = playerX;
         int newY = playerY;

         if (move == 'w') newY--;
         else if (move == 's') newY++;
         else if (move == 'a') newX--;
         else if (move == 'd') newX++;

         if (isValidCoordinate(newX, newY)) {
            playerX = newX;
            playerY = newY;

            if ((playerX == dragon1X && playerY == dragon1Y && ejderha1YasiyorMu) || (playerX == dragon2X && playerY == dragon2Y && ejderha2YasiyorMu) || (playerX == dragon3X && playerY == dragon3Y && ejderha3YasiyorMu) || (playerX == dragon4X && playerY == dragon4Y && ejderha4YasiyorMu) || (playerX == dragon5X && playerY == dragon5Y && ejderha5YasiyorMu)) {
               playerDragons++;
               System.out.println("You encountered a dragon! Would you like to bribe it or try your luck? (b: bribe, l: luck)");
               char choice = scanner.next().charAt(0);
               if (choice == 'b') {
                  if (playerPoints > 0) {
                     int bribeAmount = random.nextInt(playerPoints + 1);
                     playerPoints -= bribeAmount;
                     System.out.println("You bribed the dragon and survived! You lost " + bribeAmount + " points.");
                  } else {
                     System.out.println("You don't have enough points to bribe the dragon.");
                     playerPoints -= 5;
                  }
               } else if (choice == 'l') {
                  if (generate4DigitNum()) {
                     System.out.println("You guessed the number correctly and killed the dragon!");
                     if (playerX == dragon1X && playerY == dragon1Y) {
                        ejderha1YasiyorMu = false;
                     } else if (playerX == dragon2X && playerY == dragon2Y) {
                        ejderha2YasiyorMu = false;
                     } else if (playerX == dragon3X && playerY == dragon3Y) {
                        ejderha3YasiyorMu = false;
                     } else if (playerX == dragon4X && playerY == dragon4Y) {
                        ejderha4YasiyorMu = false;
                     } else if (playerX == dragon5X && playerY == dragon5Y) {
                        ejderha5YasiyorMu = false;
                     }
                  } else {
                     System.out.println("You guessed the number incorrectly and the dragon attacked you. You lost 5 points.");
                     playerPoints -= 5;
                  }
               } else {
                  System.out.println("Invalid choice. You lost 5 points.");
                  playerPoints -= 5;
               }
            } else if (playerX == trapX && playerY == trapY) {
               playerTraps++;
               System.out.println("Hit a trap! You have " + playerTraps + " trap encounters.");
            } else if (playerX == escapeX && playerY == escapeY) {
               playerActive = false;
               System.out.println("You found an exit! Game over.");
            } else if ((playerX == treasure1X && playerY == treasure1Y && !treasure1Collected) || (playerX == treasure2X && playerY == treasure2Y && !treasure2Collected) || (playerX == treasure3X && playerY == treasure3Y && !treasure3Collected) || (playerX == treasure4X && playerY == treasure4Y && !treasure4Collected)) {
               playerTreasures++;
               System.out.println("Collected treasure! You have " + playerTreasures + " treasures.");

               if (generate4DigitNum()) {
                  playerPoints += 10;
               } else {
                  playerPoints -= 5;
               }

               if ((playerX == treasure4X) && (playerY == treasure4Y)) {
                  treasure4Collected = true;
               } else if ((playerX == treasure3X) && (playerY == treasure3Y)) {
                  treasure3Collected = true;
               } else if ((playerX == treasure2X) && (playerY == treasure2Y)) {
                  treasure2Collected = true;
               } else if ((playerX == treasure1X) && (playerY == treasure1Y)) {
                  treasure1Collected = true;
               }
            } else if (playerX == cliffX && playerY == cliffY) {
               playerActive = false;
               System.out.println("Oh no! You fell off a cliff and lost the game.");
            }

         } else {
            System.out.println("Invalid move. Try again.");
         }
      }

      System.out.println("Final Map:");
      displayMap(playerX, playerY, treasure1X, treasure1Y, treasure2X, treasure2Y, treasure3X, treasure3Y, treasure4X, treasure4Y, trapX, trapY, escapeX, escapeY, cliffX, cliffY, dragon1X, dragon1Y, dragon2X, dragon2Y, dragon3X, dragon3Y, dragon4X, dragon4Y, dragon5X, dragon5Y, ejderha1YasiyorMu, ejderha2YasiyorMu, ejderha3YasiyorMu, ejderha4YasiyorMu, ejderha5YasiyorMu);

   }


   public static boolean isValidCoordinate(int x, int y) {
      return (x == 4 && y == 1) || (x == 3 && y == 2) || (x == 4 && y == 2) || (x == 5 && y == 2) || (x == 2 && y == 3) || (x == 3 && y == 3) || (x == 4 && y == 3) || (x == 5 && y == 3) || (x == 6 && y == 3) || (x == 1 && y == 4) || (x == 2 && y == 4) || (x == 3 && y == 4) || (x == 4 && y == 4) || (x == 5 && y == 4) || (x == 6 && y == 4) || (x == 7 && y == 4) || (x == 2 && y == 5) || (x == 3 && y == 5) || (x == 4 && y == 5) || (x == 5 && y == 5) || (x == 6 && y == 5) || (x == 3 && y == 6) || (x == 4 && y == 6) || (x == 5 && y == 6) || (x == 4 && y == 7);
   }

   private static void displayMap(int playerX, int playerY, int treasure1X, int treasure1Y, int treasure2X, int treasure2Y, int treasure3X, int treasure3Y, int treasure4X, int treasure4Y, int trapX, int trapY, int escapeX, int escapeY, int cliffX, int cliffY, int dragon1X, int dragon1Y, int dragon2X, int dragon2Y, int dragon3X, int dragon3Y, int dragon4X, int dragon4Y, int dragon5X, int dragon5Y, boolean ejderha1YasiyorMu, boolean ejderha2YasiyorMu, boolean ejderha3YasiyorMu, boolean ejderha4YasiyorMu, boolean ejderha5YasiyorMu) {
      for (int y = 1; y <= 7; y++) {
         for (int x = 1; x <= 7; x++) {
            if (x == playerX && y == playerY) {
               System.out.print("P ");
            } else if ((x == treasure1X && y == treasure1Y) || (x == treasure2X && y == treasure2Y) || (x == treasure3X && y == treasure3Y) || (x == treasure4X && y == treasure4Y)) {
               System.out.print("T ");
            } else if (x == trapX && y == trapY) {
               System.out.print("X ");
            } else if (x == escapeX && y == escapeY) {
               System.out.print("E ");
            } else if (x == cliffX && y == cliffY) {
               System.out.print("C ");
            } else if ((x == dragon1X && y == dragon1Y && ejderha1YasiyorMu) || (x == dragon2X && y == dragon2Y && ejderha2YasiyorMu) || (x == dragon3X && y == dragon3Y && ejderha3YasiyorMu) || (x == dragon4X && y == dragon4Y && ejderha4YasiyorMu) || (x == dragon5X && y == dragon5Y && ejderha5YasiyorMu)) {
               System.out.print("D ");
            } else {
               System.out.print(". ");
            }
         }
         System.out.println();
      }
   }

   public static boolean generate4DigitNum() {
      Random random = new Random();
      int randomNumber = 1000 + random.nextInt(9000);
      System.out.println("Guess the 4-digit number: ");
      Scanner scanner = new Scanner(System.in);
      int guess = scanner.nextInt();
      return (guess == randomNumber);

   }
}
