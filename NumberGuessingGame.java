package intern;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

  public static void main(String[] args) {
    String s = "y";
    int round = 1;
    
    while (s.equalsIgnoreCase("y")) {
      System.out.println("Round " + round);
      Random rand_num = new Random();
      int right_guess = rand_num.nextInt(100);
      int maxattempts = 4;
      int attempts = 1;
      int turns = 0;

      Scanner sc = new Scanner(System.in);

      System.out.println("Hey Buddy! Guess a number between 1 to 100. You have 5 turns.");
      System.out.println("All the Best Buddy!");
      boolean win = false;
      
      while (!win) {
        int guess = sc.nextInt();
        turns++;

        if (guess == right_guess) {
          win = true;
        } else if (attempts > maxattempts) {
          System.out.println("Opps Buddy! The right answer was: " + right_guess);
          System.out.println("Hey Buddy You Want to play again Enter (y/n)");
          s = sc.next();
          break;
        } else if (guess < right_guess) {
          attempts++;
          System.out.println("Lower than the right guess Buddy! Turns left: " + (5 - (attempts - 1)));
        } else if (guess > right_guess) {
          attempts++;
          System.out.println("Higher than the right guess Buddy! Turns left: " + (5 - (attempts - 1)));
        }
      }
      
      if (win) {
        System.out.println("Hurray.. You Win!");
        System.out.println("The number was " + right_guess);
        System.out.println("You used " + turns + " turns to guess the right number");
        System.out.println("Your score is " + ((6 - turns) * 10) + " out of 50");
        System.out.println("You Want to play again Enter(y/n)");
        s = sc.next();
      }
      
      round++;
    }
    
    if (s.equalsIgnoreCase("n")) {
      System.out.println("GAME OVER! Thank you for Playing Buddy!");
    }
  }
}