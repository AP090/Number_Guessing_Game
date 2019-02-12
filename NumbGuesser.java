package number_guesser;

import java.util.Random;
import java.util.Scanner;

public class NumbGuesser {

	static Scanner sc = new Scanner(System.in);
	static Random rand = new Random();
	public static int myNum, guessNum, i;

	public static void main(String[] args) {
		// establish the random number
		myNum = rand.nextInt(100) + 1;
		System.out.println("Guess my integer between 1 and 100, inclusive.");
		// begin the guess loop
		i = 0;
		do {
			guessNum = sc.nextInt();
			i++;
			if (guessNum < 1 || guessNum > 100) {
				System.out.println("You guessed out of bounds! Try again.");
			} else if (guessNum > myNum) {
				System.out.println("Your number was too high! Try again.");
			} else if (guessNum < myNum) {
				System.out.println("Your number was too low. Try again.");
			} else if (guessNum == myNum) {
				System.out.println("You guessed correctly in " + i + " tries!");
			} else {
				System.out.println("Something went wrong. Try again.");
			}
		} while (guessNum != myNum && i < 7);

		if (guessNum != myNum) {
			System.out.println("Sorry, but you weren't able to guess in 7 tries or less.");
			System.out.println("My number was " + myNum + ".");
		}
	}

}
