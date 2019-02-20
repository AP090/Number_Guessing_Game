package number_guesser;

import java.util.Random;
import java.util.Scanner;

public class NumbGuesser {

	static Scanner sc = new Scanner(System.in);
	static Random rand = new Random();
	static int rangeLow, rangeHigh;

	public static void main(String[] args) throws Exception {
		System.out.println(
				"The default range is 1-100. If you would like to change it, enter Y/T. Otherwise, type something random.");
		char customRange = sc.next().charAt(0);
		rangeLow = 1;
		rangeHigh = 100;
		int tries;
		switch (customRange) {
		case 'T':
		case 't':
		case 'Y':
		case 'y':
			while (true) {
				try {
					getCustomRange();
					break;
				} catch (Exception fail) {
					System.out.println("Something went wrong. Inputs have been reset and you must try again.");
					sc.nextLine();
				}
			}
			break;
		}
		System.out.println("How many tries would you like?");
		while (true) {
			try {
				tries = sc.nextInt();
				break;
			} catch (Exception fail) {
				System.out.println("Why do I spend my time doing this?");
				sc.nextLine();
			}
		}
		// establish the random number
		int myNum = rand.nextInt(rangeHigh) + rangeLow;
		System.out.println("Guess my integer between " + rangeLow + " and " + rangeHigh + ", inclusive.");
		guessLoop(tries, myNum, rangeLow, rangeHigh);
	}

	public static void getCustomRange() throws Exception {
		System.out.println("Choose the low end of your range.");
		rangeLow = sc.nextInt();
		System.out.println("Choose the high end of your range.");
		rangeHigh = sc.nextInt();

		if (rangeLow >= rangeHigh) {
			throw new Exception("Just whyyyyyyyy?");
		}
	}

	public static void guessLoop(int tries, int myNum, int rangeLow, int rangeHigh) {
		int guessNum = 0;
		for (int i = 0; i < tries; i++) {
			while (true) {
				try {
					guessNum = sc.nextInt();
					break;
				} catch (Exception fail) {
					System.out.println("Try again.");
					sc.nextLine();
				}
			}
			if (guessNum < rangeLow || guessNum > rangeHigh) {
				System.out.println("You guessed out of bounds! Try again.");
			} else if (guessNum > myNum) {
				System.out.println("Your number was too high! Try again.");
			} else if (guessNum < myNum) {
				System.out.println("Your number was too low. Try again.");
			} else if (guessNum == myNum) {
				System.out.println("You guessed correctly in " + i + " tries!");
				break;
			} else {
				System.out.println("Something went wrong. Try again.");
			}
		}

		if (guessNum != myNum) {
			System.out.println("Sorry, but you weren't able to guess in " + tries + " tries or less.");
			System.out.println("My number was " + myNum + ".");
		}
	}
}
