import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("========== GAME MENU ==========");
            System.out.println("1. Rock, Paper, Scissors");
            System.out.println("2. Number Guessing Game");
            System.out.println("3. Quit");
            System.out.print("Choose a game (1-3): ");

            int choice;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid input! Please enter a number.\n");
                continue;
            } finally {
                scanner.nextLine(); // consume leftover newline
            }

            switch (choice) {
                case 1:
                    RockPaperScissors.playGame(scanner);
                    break;
                case 2:
                    NumberGuessingGame.playGame(scanner);
                    break;
                case 3:
                    System.out.println("\nThanks for playing! Goodbye!");
                    return;
                default:
                    System.out.println("\nInvalid choice! Please pick 1, 2, or 3.\n");
            }

            System.out.println();
        }
    }
}
