import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void playGame(Scanner scanner){
        Random random = new Random();

        int guessLimit = 3;
        int guessCount = 0;
        int magicNumber = random.nextInt(10);

        while(guessCount < guessLimit){
            System.out.println("\nGuess the magic number(0-10): ");
            int userInput;
            try {
                userInput = scanner.nextInt();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number.\n");
                scanner.nextLine();
                continue;
            }
            guessCount++;

            if (userInput == magicNumber){
                System.out.println("Hurray! You guessed right.\n");
                break;
            } else if (userInput != magicNumber && guessCount < guessLimit) {
                String message = String.format("Try again! You have %s guesses left.\n", (guessLimit - guessCount));
                System.out.println(message);
                continue;
            } else {
                System.out.println("You failed. Try again!");
            }

        }
    }
}
