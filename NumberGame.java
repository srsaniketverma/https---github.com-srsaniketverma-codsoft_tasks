import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int score = 0;
        char playAgain;

        do {
            int number = random.nextInt(100) + 1;
            int maxAttempts = 7;
            boolean guessed = false;

            System.out.println("\n=== NUMBER GUESSING GAME ===");
            System.out.println("Guess a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts.");

            for (int attempt = 1; attempt <= maxAttempts; attempt++) {

                System.out.print("Attempt " + attempt + ": ");
                int guess = sc.nextInt();

                if (guess == number) {
                    System.out.println("Correct! You guessed the number.");
                    score++;
                    guessed = true;
                    break;
                } else if (guess > number) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Too low!");
                }
            }

            if (!guessed) {
                System.out.println("You lost this round.");
                System.out.println("The correct number was: " + number);
            }

            System.out.println("Your score: " + score);

            System.out.print("Do you want to play again? (y/n): ");
            playAgain = sc.next().charAt(0);

        } while (playAgain == 'y' || playAgain == 'Y');

        System.out.println("Thanks for playing!");
        sc.close();
    }
}