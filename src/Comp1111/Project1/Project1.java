
/*
 * @author of this code Yigit Okur (23Soft1040)
 * github.com/TurkishKEBAB
 */

/*
Hata Yönetimi: Kullanıcıların yanlış girişler yapabileceğini göz önünde bulundurarak, yanlış girişlere karşı daha iyi bir hata yönetimi ekleyin. Örneğin, menü seçeneklerinde harf yerine sayı girişi yapılırsa, bu durumu ele alacak bir hata mesajı ekleyebilirsiniz.

Zaman Biçimlendirme: Zamanı biçimlendirme işlemini daha esnek hale getirebilirsiniz. Kullanıcıya farklı zaman dilimlerini veya biçimleri seçme seçeneği ekleyebilirsiniz.

Metin Mesajları ve Arama Geçmişi: Kullanıcıların metin mesajları göndermesine ve çağrı geçmişini görüntülemesine izin veren işlevsellik ekleyebilirsiniz.

Kişi Rehberi Yönetimi: Kullanıcıların kişi rehberine kişi eklemesine, görüntülemesine, düzenlemesine ve silmesine izin veren bir bölüm ekleyebilirsiniz.

Oyun Geliştirme: Var olan "GuessNumber" oyununu geliştirebilir veya farklı oyunlar ekleyebilirsiniz.

Güvenlik ve Verimlilik İyileştirmeleri: Kodu daha güvenli ve verimli hale getirmek için gereksiz döngülerden kaçınabilir, kodu daha modüler hale getirebilir ve tekrar kullanılabilir fonksiyonlar ekleyebilirsiniz.

Kullanıcı Arayüzü Geliştirmeleri: Kullanıcı arayüzünü daha interaktif ve kullanıcı dostu hale getirebilirsiniz. Örneğin, kullanıcıya her adımda ne yapması gerektiği konusunda daha açık talimatlar verebilirsiniz.
 */

package Comp1111.Project1;

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
               // Call/Send Text MesajlarÄ±
               break;
            case 4:
               // Arama GeÃ§miÅŸi
               break;
            case 5:
               // Add/View/Edit/Delete Telefon Rehberi
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
