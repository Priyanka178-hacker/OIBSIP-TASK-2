import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        int minNumber = 1;
        int maxNumber = 100;
        int totalRounds = 3; // You can change this to set the number of rounds
        int totalPoints = 0;

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("You will play " + totalRounds + " rounds.");
        System.out.println("Each round, I will pick a number between " + minNumber + " and " + maxNumber + ".");
        System.out.println("Try to guess the number in minimum attempts to earn more points.");

        for (int round = 1; round <= totalRounds; round++) {
            int secretNumber = random.nextInt(maxNumber - minNumber + 1) + minNumber;
            int numberOfAttempts = 0;
            int maxAttempts = (int) (Math.log(maxNumber - minNumber + 1) / Math.log(2)) + 1;
            int roundPoints = maxAttempts; // Maximum points for this round

            System.out.println("\nRound " + round + ":");
            System.out.println("Guess the number between " + minNumber + " and " + maxNumber + ".");

            while (true) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                numberOfAttempts++;

                if (guess == secretNumber) {
                    System.out.println("Congratulations! You guessed the correct number in " + numberOfAttempts + " attempts.");
                    totalPoints += roundPoints - (numberOfAttempts - 1);
                    System.out.println("You earned " + (roundPoints - (numberOfAttempts - 1)) + " points in this round.");
                    break;
                } else if (guess < secretNumber) {
                    System.out.println("Too low. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }

                if (numberOfAttempts == maxAttempts) {
                    System.out.println("You've reached the maximum number of attempts. The correct number was " + secretNumber + ".");
                    break;
                }
            }
        }

        System.out.println("\nGame Over!");
        System.out.println("Total Score: " + totalPoints);
        scanner.close();
    }
}
