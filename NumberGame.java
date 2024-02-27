package com.NumberGame;

import java.util.*;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        int minRange = 1;
        int maxRange = 100;
        int attemptsLimit = 5;
        int rounds = 0;
        int score = 0;

        System.out.println("Welcome to Guess the Number!");

        boolean playAgain = true;
        while (playAgain) {
            int numberToGuess = rand.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nRound " + (rounds++));
            System.out.println("A random number between " + minRange + " and " + maxRange + " has been generated.");
            System.out.println(!guessedCorrectly);
            while (!guessedCorrectly && attempts < attemptsLimit) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    guessedCorrectly = true;
                    score += attemptsLimit - attempts + 1;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've used all your attempts. And the correct number is " + numberToGuess);
            }
            
            System.out.print("Do you want to play again? (yes/no): ");
            String playChoice = scanner.next();
            playAgain = playChoice.equalsIgnoreCase("yes");
        }

        System.out.println("Game over! You played " + rounds + " rounds and your total score is " + score);
        scanner.close();
    }
}