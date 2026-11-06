import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void playGame(){
        Random random = new Random();
        Scanner sc  = new Scanner(System.in);

        int guessLimit = 3;
        int guessCount = 0;
        int magicNumber = random.nextInt(10);

        while(guessCount < guessLimit){
            System.out.println("\nGuess the magic number(0-10): ");
            int userInput = sc.nextInt();
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
