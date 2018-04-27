import java.util.Scanner;

/*
 * Author Victoria Rush with help from Maurice Tedder, Tim Pieniazek, Allison Farr, and Stack Overflow
 */
public class TranslateToPigLatin {

	public static void main(String[] args) {
		String input;
		String cont = "y";

		// Prompt user for input
		Scanner scan = new Scanner(System.in);

		do {
			System.out.println("Enter a sentence to be translated: ");
			input = scan.nextLine();

			// Convert to lower case
			input = input.toLowerCase();

			// String s = "I want to walk my dog";
			String[] words = input.split(" ");

			for (String word : words) {


			// Translate to pig latin
			String output = "";

			// If vowel, add "way"
				if (isVowel(word) == true) {
					output = translateVowel(word);
			} else {
				// Else, consonant translate
					output = translateConsonant(word);
			}

			// Display result to console
				System.out.print(output + " ");

			}

			// Prompt user to continue
			System.out.println();
			System.out.println("Translate another line? (y/n): ");
			cont = scan.nextLine();
		} while (cont.equalsIgnoreCase("y"));

		System.out.println("Thanks for playing!");

		scan.close();
	}

	private static boolean isVowel(String word) {
		// char firstChar = word.charAt(0);
		if ((word.startsWith("a")) || (word.startsWith("e")) || (word.startsWith("i")) || (word.startsWith("o"))
				|| (word.startsWith("u"))) {
			return true;
		} else {
			return false;
		}
	}

	private static String translateVowel(String word) {
		word = word + "way";
		return word;
	}

	public static String translateConsonant(String word) {
		char a = 'a';
		char e = 'e';
		char iLetter = 'i';
		char o = 'o';
		char u = 'u';

		int start = 0;
		int firstVowel = 0;
		int end = word.length();
		for (int i = 0; i < end; i++) {
			char c = (word.charAt(i));
			if (c == a || c == e || c == iLetter || c == o || c == u) {
				firstVowel = i;
				break;
			}
		}
		if (start != firstVowel) {
			String startString = word.substring(firstVowel, end);
			String endString = word.substring(start, firstVowel) + "ay";
			return startString + endString;
		}
		return word;
	}

}
