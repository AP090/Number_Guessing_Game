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
			getCustomRange();
		}

		System.out.println("How many tries would you like?");
		tries = getInt("Why do I spend my time doing this?");

		// establish the random number
		int myNum = rand.nextInt(rangeHigh) + rangeLow;
		System.out.println("Guess my integer between " + rangeLow + " and " + rangeHigh + ", inclusive.");
		guessLoop(tries, myNum, rangeLow, rangeHigh);
	}

	public static void getCustomRange() {
		System.out.println("Choose the low end of your range.");
		rangeLow = getInt("Enter a number, you can do that on the keyboard.");

		System.out.println("Choose the high end of your range.");
		rangeHigh = getInt("Enter a NUMBER! Not a roman numberal, not in words, a normal, universal **number**.");

		if (rangeLow > rangeHigh) {
			System.out.println("When I said 'low', I meant 'less than'.\n*sigh* I'll reverse it for you.");

			int _tempLow = rangeLow;
			rangeLow = rangeHigh;
			rangeHigh = _tempLow;
		}
	}

	public static void guessLoop(int tries, int myNum, int rangeLow, int rangeHigh) {
		int guessNum;

		for (int i = 0; i < tries; i++) {
			guessNum = getInt("Just... why?! Is it that hard to enter a number?");

			if (guessNum < rangeLow || guessNum > rangeHigh) {
				System.out.println("You guessed out of bounds! Try again.");
			} else if (guessNum > myNum) {
				System.out.println("Your number was too high! Try again.");
			} else if (guessNum < myNum) {
				System.out.println("Your number was too low. Try again.");
			} else if (guessNum == myNum) {
				System.out.println("You guessed correctly in " + i + " tries!");
				return;
			} else {
				System.out.println("Something went wrong. Try again.");
			}
		}

		System.out.println("Sorry, but you weren't able to guess in " + tries + " tries or less.");
		System.out.println("My number was " + myNum + ".");
	}

	private static int getInt(String failMessage) {
		while (true) {
			try {
				return sc.nextInt();
			} catch (Exception fail) {
				System.out.println(failMessage);
				sc.nextLine();
			}
		}
	}
}