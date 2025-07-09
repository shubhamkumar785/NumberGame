import java.util.Scanner;

public class game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int MAX_ATTEMPTS = 5;
        int totalScore = 0;
        boolean keepPlaying = true;

        System.out.println("Welcome to the Game!");
        System.out.println("You have " + MAX_ATTEMPTS + " chances to guess the number between 1 and 100.\n");

        while (keepPlaying) {
            int secretNumber = generateRandomNumber(1, 100);
            boolean isGuessedCorrectly = playRound(sc, secretNumber, MAX_ATTEMPTS);

            if (isGuessedCorrectly) {
                totalScore++;
                System.out.println("Great! You guessed the number correctly.");
            } else {
                System.out.println("You have used all attempts. The correct number was: " + secretNumber);
            }

            System.out.print("Do you want to play again (Yes/No)? ");
            String userChoice = sc.next();
            keepPlaying = userChoice.equalsIgnoreCase("Y");
            System.out.println();
        }

        System.out.println("Game Over! Thanks for playing.");
        System.out.println("Your final score: " + totalScore);
        sc.close();
    }

    public static boolean playRound(Scanner sc, int target, int attempts) {
        for (int i = 1; i <= attempts; i++) {
            System.out.print("Attempt " + i + ": Enter your guess → ");
            int userGuess = sc.nextInt();

            if (userGuess == target) {
                return true;
            } else if (userGuess > target) {
                System.out.println("Too high! Try a smaller number.");
            } else {
                System.out.println("Too low! Try a bigger number.");
            }
        }
        return false;
    }

    public static int generateRandomNumber(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }
}
