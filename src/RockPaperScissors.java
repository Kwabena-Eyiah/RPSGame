import java.util.Random;
import java.util.Scanner;

/**
 * A simple Rock, Paper, Scissors game.
 * The player plays against the computer until they choose to quit.
 */
public class RockPaperScissors {

    public static void playGame() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] choices = {"rock", "paper", "scissors"};
        int playerScore = 0;
        int computerScore = 0;

        System.out.println("=== Rock, Paper, Scissors ===");
        System.out.println("Type rock, paper, or scissors to play (or 'quit' to exit).");

        while (true) {
            System.out.print("\nYour move: ");
            String playerChoice = scanner.nextLine().trim().toLowerCase();

            // Let the player quit
            if (playerChoice.equals("quit") || playerChoice.equals("exit")) {
                break;
            }

            // Validate the move
            if (!playerChoice.equals("rock")
                    && !playerChoice.equals("paper")
                    && !playerChoice.equals("scissors")) {
                System.out.println("Invalid move! Please type rock, paper, or scissors.");
                continue;
            }

            // Computer picks a random move
            String computerChoice = choices[random.nextInt(3)];
            System.out.println("Computer chose: " + computerChoice);

            // Decide the winner
            if (playerChoice.equals(computerChoice)) {
                System.out.println("It's a tie!");
            } else if (playerWins(playerChoice, computerChoice)) {
                System.out.println("You win this round!");
                playerScore++;
            } else {
                System.out.println("Computer wins this round!");
                computerScore++;
            }

            System.out.println("Score -> You: " + playerScore + " | Computer: " + computerScore);
        }

        // Final results
        System.out.println("\n=== Game Over ===");
        System.out.println("Final score -> You: " + playerScore + " | Computer: " + computerScore);
        if (playerScore > computerScore) {
            System.out.println("Congratulations, you won the match!");
        } else if (computerScore > playerScore) {
            System.out.println("Better luck next time, the computer wins!");
        } else {
            System.out.println("It's a draw. Well played!");
        }

        scanner.close();
    }

    /**
     * Returns true if the player's move beats the computer's move.
     * Rock beats scissors, scissors beats paper, paper beats rock.
     */
    private static boolean playerWins(String player, String computer) {
        return (player.equals("rock") && computer.equals("scissors"))
                || (player.equals("scissors") && computer.equals("paper"))
                || (player.equals("paper") && computer.equals("rock"));
    }
}
