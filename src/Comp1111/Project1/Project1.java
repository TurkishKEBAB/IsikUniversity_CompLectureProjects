package Comp1111.Project1;

/*
 * @author of this code Yigit Okur (23Soft1040)
 * github.com/TurkishKEBAB
 */

/*
Hata Yönetimi: Kullanıcıların yanlış girişler yapabileceğini göz önünde bulundurarak, yanlış girişlere karşı daha iyi bir hata yönetimi ekle. Örneğin, menü seçeneklerinde harf yerine sayı girişi yapılırsa, bu durumu ele alacak bir hata mesajı ekleyebilirsiniz.

Zaman Biçimlendirme: Zaman biçimlendirme daha esnek hale getir. Kullanıcıya farklı zaman dilimlerini veya biçimleri seçme seçeneği ekle.

Metin Mesajları, Arama Geçmişi: Kullanıcıların metin mesajları göndermesine ve çağrı geçmişini görüntülemeye izin ver.

Kişi Rehberi Yönetimi: Kullanıcıların kişi rehberine kişi eklemesine, görüntülemesine, düzenlemesine ve silmesine izin veren bir bölüm.

Oyun Geliştirme: GuessNumber oyununu geliştir.

Güvenlik ve Verimlilik İyileştirmeleri: Gereksiz döngülerden kaçınabilir.

Kullanıcı Arayüzü Geliştirmeleri: Kullanıcı arayüzünü kullanıcı dostu hale getir.
*/

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;

public class Project1 {

   public static void main(String[] yiit) throws InterruptedException {
      Scanner sc = new Scanner(System.in);
      Random rd = new Random();

      while (true) {
         System.out.println("1. Show Time\n" + "2. Stopwatch\n" + "3. Call/Send Text Message\n" + "4. View Call Logs\n" + "5. Add/View/Edit/Delete Contact\n" + "6. Play Game\n" + "7. Exit\n");

         System.out.print("Enter your option: ");
         int option = sc.nextInt();

         switch (option) {
            case 1:
               LocalDateTime Date = LocalDateTime.now();
               DateTimeFormatter Format = DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm:ss");

               String formattedDate = Date.format(Format);
               System.out.println("Your time and date according to your Personal Computer and location is:  " + formattedDate);
               Thread.sleep(5000);
               System.out.println("Going back to main menu");
               Thread.sleep(1000);
               break;

            case 2:
               long time1, time2, time3;

               while (true) {
                  System.out.println("Stopwatch option's. Please choose one of them. \n" + "1. Start \n" + "2. Pause \n" + "3. Exit \n" + "Plase choose one off them. \n");

                  int opt = sc.nextInt();

                  switch (opt) {
                     case 1:
                        time1 = System.currentTimeMillis();
                        System.out.println("Started...");
                        System.out.println("Stopwatch option's after start. \n" + "1. Stop and show passed time \n" + "2. Pause \n" + "Plase choose one off them. \n");
                        opt = sc.nextInt();

                        switch (opt) {
                           case 1:
                              time2 = System.currentTimeMillis();
                              time1 = time2 - time1;

                              System.out.println("This much time has passed between the time intervals " + "when the stopwatch starts and ends: " + time1);
                              Thread.sleep(2000);
                              System.out.println("Returning to stopwatch main menu...");
                              break;

                           case 2:
                              System.out.println("Paused");
                              System.out.println("Stopwatch option's after pause. \n" + "1. Continue \n" + "2. Stop and show time \n" + "Plase choose one off them. \n");
                              opt = sc.nextInt();

                              switch (opt) {
                                 case 1:
                                    break;

                                 case 2:
                                    time3 = System.currentTimeMillis();
                                    time1 = time3 - time1;

                                    System.out.println("This much time has passed between the time intervals " + "when the stopwatch starts and ends: " + time1);
                                    Thread.sleep(2000);
                                    System.out.println("Returning to stopwatch main menu...");
                                    break;

                                 default:
                                    System.out.println("Invalid option. Please try again.");
                              }
                              break;

                           default:
                              System.out.println("Invalid option. Please try again.");
                        }
                        break;

                     case 2:
                        System.out.println("Stopwatch is already started. Please choose Pause from the menu to pause it.");
                        break;

                     case 3:
                        System.out.println("Exiting...");
                        Thread.sleep(1000);
                        break;

                     default:
                        System.out.println("Invalid option. Please try again.");
                  }
               }
            case 3:
               // Metin Mesajı Gönderme ve Arama Yapma
               while (true) {
                  System.out.println("1. Send Text Message\n" + "2. Make a Call\n" + "3. Go Back\n");
                  System.out.print("Enter your option: ");
                  int commOption = sc.nextInt();

                  if (commOption == 1) {
                     System.out.print("Enter the phone number: ");
                     String phoneNumber = sc.next();
                     System.out.print("Enter your message: ");
                     sc.nextLine();  // Consume newline left-over
                     String message = sc.nextLine();
                     System.out.println("Message sent to " + phoneNumber + ": " + message);
                  } else if (commOption == 2) {
                     System.out.print("Enter the phone number: ");
                     String phoneNumber = sc.next();
                     System.out.println("Calling " + phoneNumber + "...");
                  } else if (commOption == 3) {
                     System.out.println("Going back to main menu...");
                     break;
                  } else {
                     System.out.println("Invalid option. Please try again.");
                  }
               }
               break;

            case 4:
               System.out.println("Viewing call logs...");
               String[] callLogs = {"Call to +1234567890 at 10:30 AM", "Call from +0987654321 at 11:00 AM", "Missed call from +1122334455 at 12:15 PM"};

               for (String log : callLogs) {
                  System.out.println(log);
               }
               System.out.println("Going back to main menu...");
               break;
            case 5:
               String person1 = null, person2 = null, person3 = null, person4 = null, person5 = null;
               int contactCount = 0;

               while (true) {
                  System.out.println("1. Add Contact\n" + "2. View Contacts\n" + "3. Edit Contact\n" + "4. Delete Contact\n" + "5. Go Back\n");
                  System.out.print("Enter your option: ");
                  int contactOption = sc.nextInt();

                  if (contactOption == 1) {
                     if (contactCount < 5) {
                        System.out.print("Enter contact name: ");
                        sc.nextLine();  // Consume newline left-over
                        String contactName = sc.nextLine();
                        if (contactCount == 0) person1 = contactName;
                        else if (contactCount == 1) person2 = contactName;
                        else if (contactCount == 2) person3 = contactName;
                        else if (contactCount == 3) person4 = contactName;
                        else if (contactCount == 4) person5 = contactName;
                        contactCount++;
                        System.out.println("Contact added: " + contactName);
                     } else {
                        System.out.println("Contact list is full. Do you want to delete a contact to add a new one? (yes/no)");
                        String response = sc.next();
                        if (response.equalsIgnoreCase("yes")) {
                           System.out.print("Enter the contact number to delete (1-5): ");
                           int deleteIndex = sc.nextInt();
                           if (deleteIndex >= 1 && deleteIndex <= 5) {
                              if (deleteIndex == 1) person1 = null;
                              else if (deleteIndex == 2) person2 = null;
                              else if (deleteIndex == 3) person3 = null;
                              else if (deleteIndex == 4) person4 = null;
                              else if (deleteIndex == 5) person5 = null;
                              contactCount--;
                              System.out.println("Contact deleted. You can now add a new contact.");
                           } else {
                              System.out.println("Invalid contact number.");
                           }
                        } else {
                           System.out.println("Returning to main menu...");
                        }
                     }
                  } else if (contactOption == 2) {
                     System.out.println("Your contacts:");
                     if (person1 != null) System.out.println("1. " + person1);
                     if (person2 != null) System.out.println("2. " + person2);
                     if (person3 != null) System.out.println("3. " + person3);
                     if (person4 != null) System.out.println("4. " + person4);
                     if (person5 != null) System.out.println("5. " + person5);
                  } else if (contactOption == 3) {
                     System.out.print("Enter the contact number to edit (1-5): ");
                     int editIndex = sc.nextInt();
                     if (editIndex >= 1 && editIndex <= 5) {
                        System.out.print("Enter new contact name: ");
                        sc.nextLine();  // Consume newline left-over
                        String newContactName = sc.nextLine();
                        if (editIndex == 1) person1 = newContactName;
                        else if (editIndex == 2) person2 = newContactName;
                        else if (editIndex == 3) person3 = newContactName;
                        else if (editIndex == 4) person4 = newContactName;
                        else if (editIndex == 5) person5 = newContactName;
                        System.out.println("Contact updated: " + newContactName);
                     } else {
                        System.out.println("Invalid contact number.");
                     }
                  } else if (contactOption == 4) {
                     System.out.print("Enter the contact number to delete (1-5): ");
                     int deleteIndex = sc.nextInt();
                     if (deleteIndex >= 1 && deleteIndex <= 5) {
                        if (deleteIndex == 1) person1 = null;
                        else if (deleteIndex == 2) person2 = null;
                        else if (deleteIndex == 3) person3 = null;
                        else if (deleteIndex == 4) person4 = null;
                        else if (deleteIndex == 5) person5 = null;
                        contactCount--;
                        System.out.println("Contact deleted.");
                     } else {
                        System.out.println("Invalid contact number.");
                     }
                  } else if (contactOption == 5) {
                     System.out.println("Going back to main menu...");
                     break;
                  } else {
                     System.out.println("Invalid option. Please try again.");
                  }
               }
               break;
            case 6:
               boolean GamePlayer = true;

               while (GamePlayer) {
                  System.out.println("Hi, Welcome to the GuessNumber Game ðŸ˜Š ");
                  System.out.println("Do you want to change the range of Computer Number, Ä±f you don't want to change the range is 1 to 10. ");
                  System.out.println("Do you want to change? For yes; please press 9. If you don't want to you can input another integer. ");
                  int answer = sc.nextInt();

                  int min = 1;
                  int max = 10;
                  int random;
                  int temporary;

                  if (answer == 9) {
                     System.out.println("Please input a number for Min range:");
                     min = sc.nextInt();
                     System.out.println("Please input a number for Max range: ");
                     max = sc.nextInt();
                  } else {
                     System.out.println("Ok then we should start");
                  }

                  if (min > max) {
                     System.out.println(" Your min and max must replace each other\n " + "because min is bigger than max" + "Replacing auto right now \n");
                     temporary = min;
                     max = min;
                     min = temporary;
                  }

                  random = rd.nextInt(min, max);

                  System.out.println("Please input a guess number");
                  int inputnumber = sc.nextInt();

                  while (true) {
                     if (inputnumber > max || inputnumber < min) {
                        System.out.println("Your input is invalid ");
                        System.out.println("Please retry");
                        inputnumber = sc.nextInt();
                     }

                     if (inputnumber > random) {
                        System.out.println("It's too high");
                        System.out.println("Please input another number which is lower than " + inputnumber);
                        inputnumber = sc.nextInt();
                     } else if (inputnumber < random) {
                        System.out.println("It's too low");
                        System.out.println("Please input another number which is higher than " + inputnumber);
                        inputnumber = sc.nextInt();
                     } else {
                        System.out.println("Congratulations, you guessed the right number!");
                        System.out.println("Wanna try again? For yes; please press 9 ");
                        answer = sc.nextInt();

                        if (answer == 9) {
                           System.out.println("Starting a new game...");
                           System.out.println(" ");
                        } else {
                           System.out.println("Thank you for playing! Have a nice day!");
                           GamePlayer = false;
                        }

                        break;
                     }
                  }
               }
               break;

            case 7:
               System.out.println("Exiting the simulator...");
               sc.close();
               break;

            default:
               System.out.println("Invalid option. Please try again.");

         }
      }
   }
}
