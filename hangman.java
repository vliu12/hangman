import java.util.Random;
import java.util.Scanner;
public class Level26 {
	
	static int numWins = 0;
	static int numLosses = 0;

	static double num = 0;
	static Scanner userInput = new Scanner(System.in);
	
	static boolean checkChar(char c, String str) {
		for (int i = 0; i < str.length(); i++) {
			if (c == str.charAt(i)) {
				return true;
			}
		}
		return false;
	}
	
	static String getRandomWord(String[] array) {
		Random rand = new Random();
		int index = rand.nextInt(array.length);
		return array[index];
	}

	static String getRandomWord(String[] array, int len) {
		Random rand = new Random();
		int index = rand.nextInt(array.length);
		if(array[index].length() >= len) {
			return array[index];
		}
		else for (int i = 0; i < 500; i++) {
			while (array[index].length() < len) {
				rand = new Random();
			}
			if(array[index].length() < len) {
				rand = new Random();
			}
		}
		return null;
	}

	static String getRevealedChars (String s1, String s2) {
		int i = 0; 
		String output3 = "";
		while (i < s1.length()) {
			checkChar (s1.charAt(i), s2); 
			if (checkChar (s1.charAt(i), s2) == false) {
				output3 = output3 + " _ ";
			}
			if (checkChar (s1.charAt(i), s2) == true) {
				output3 = output3 + s1.charAt(i);
			}
			i++;
		}
		return output3;
	}

	static void displayHangMan (int numWrong) {		

		System.out.println();

		switch (numWrong) {
		case 0:
			break;
		case 1:
			System.out.print("    _______\n");
			break;
		case 2:
			System.out.print("    _______\n");
			for (int i = 0; i < 6; i++) 
				System.out.println("|        ||");
			break;
		case 3:
			System.out.println("    _______");
			for (int i = 0; i < 6; i++) 
				System.out.println("|        ||");
			System.out.println("|________||");
			break;
		case 4:
			System.out.println("    _______");
			System.out.println("|   |    ||");
			System.out.println("|  \\O/   ||");

			for (int i = 0; i < 4; i++) 
				System.out.println("|        ||");
			System.out.println("|________||");
			break;
		case 5:
			System.out.print("    _______\n");
			System.out.println("|   |    ||");
			System.out.println("|  \\O/   ||");
			System.out.println("|   |    ||");

			for (int i = 0; i < 3; i++) 
				System.out.println("|        ||");
			System.out.println("|________||");
			break;
		case 6:
			System.out.print("    _______\n");
			System.out.println("|   |    ||");
			System.out.println("|  \\O/   ||");
			System.out.println("|   |    ||");
			System.out.println("|  / \\   ||");

			for (int i = 0; i < 2; i++) 
				System.out.println("|        ||");
			System.out.println("|________||");
			break;
		default:
			System.out.println("ERROR: EXCEEDED WRONG NUMBER OF GUESSES!");
		}

		System.out.println("\n");

	}

	static void viewStatistics() {
		System.out.println("NUMBER OF GAMES WON = " + numWins);
		System.out.println("NUMBER OF GAMES LOST = " + numLosses + "\n");
	}

	static void displayMenu() {
		System.out.println("TO PLAY HANGMAN, ENTER 1.");
		System.out.println("TO VIEW GAME STATISTICS, ENTER 2.");
		System.out.println("TO EXIT THE GAME, ENTER 3.");
		
	}

	static void playRound() {
		
		while (num != 3) {
		
			if (num == 2) {
				viewStatistics();
				displayMenu();
				userInput = new Scanner(System.in);
				num = userInput.nextDouble();
			}
			
			else if (num == 1) {
			String[] secretWords = {"brian", "fiona", "victoria", "blackpink", "itzy", "jisoo", "ryujin", "jennie", "xiaoting", "apple", "banana", "orange", "pizza", "hamburger", "iphone"};
			Random rand = new Random();
			int index = rand.nextInt(secretWords.length);
				
			rand = new Random();
			index = rand.nextInt(secretWords.length);

			String randomSecret = secretWords[index];

				int numWrong = 0;
				String guesses = "";

				System.out.println("WELCOME TO MY VERSION OF HANGMAN!\n");

				while (numWrong < 6) {
					System.out.print("GUESS A CHARACTER: ");
					System.out.println();

					userInput = new Scanner(System.in);

					String letter = userInput.next();
					guesses += letter;

					String systemOutput = getRevealedChars(randomSecret, guesses);


					if (checkChar(letter.charAt(0), randomSecret) == true) {
						getRevealedChars(randomSecret, guesses);
						System.out.println("YOUR GUESS WAS CORRECT!\n");
						System.out.println("CHARACTERS REVEALED: " + systemOutput + "\n");

						if (numWrong <6 && systemOutput.equals(randomSecret)) {
							System.out.println("CONGRATS, YOU WIN!\n");
							numWins = 0;
							numWins++;
							displayMenu();
							num = 0;
							userInput = new Scanner(System.in);
							num = userInput.nextDouble();
						}
					}
					else {
						numWrong++;
						displayHangMan(numWrong);
						System.out.println("YOUR GUESS WAS INCORRECT.\n");

						if (numWrong == 6) {
							System.out.println("GAME OVER! \nSORRY, YOU LOSE!");
							System.out.println("THE WORD WAS: " + randomSecret);
							displayMenu();
							numLosses = 0;
							numLosses++;
							userInput = new Scanner(System.in);
							num = userInput.nextDouble();
						}
					}
			}
		}

		}
	}

	public static void main(String[] args) {

		displayMenu();
		
		userInput = new Scanner(System.in);
		num = userInput.nextDouble();
		
		playRound();

		
		if (num == 3) {
			System.out.println("THANKS FOR PLAYING, BYE!");
			userInput.close();
			return;
		}


	}}

