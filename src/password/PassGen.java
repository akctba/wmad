package password;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Class to generate passwords
 * 
 * @author Alex Kayser
 * 
 *         1) Create a program that generates the alphabet from a to z 2) Extend
 *         that program to create a 'word' that contains random characters 3)
 *         Extend that program to create a 'word' that is between min length and
 *         max length in size 4) Extend that program to include Numbers from 0 -
 *         1 as well 5) Extend that program to only include letters/numbers from
 *         which we specify 6) Create a program that tells if a word is a
 *         palindrome or not 7) Create a program that 'reverses' the word
 *
 */
public class PassGen {

	HashMap<Integer, List<Character>> options = new HashMap<Integer, List<Character>>();
	// List<Character> chars = new ArrayList<Character>();

	/**
	 * Generate a random password following the constructor rules. 3) Extend that
	 * program to create a 'word' that is between min length and max length in size
	 * 
	 * @param minLength Minimum length of the generated password.
	 * @param maxLength Maximum length of the generated password.
	 * @return String random password.
	 */
	public String randomPassword(int minLength, int maxLength) {

		// just in case some programmer put the values in the wrong way
		if (minLength > maxLength) {
			int temp = minLength;
			minLength = maxLength;
			maxLength = temp;
		}

		String tempPassword = "";
		Random random = new Random();

		// random password size
		int pswSize = random.ints(minLength, (maxLength + 1)).findFirst().getAsInt();

		// get random characters to create the password
		for (int i = 0; tempPassword.length() < pswSize; i++) {
			int lx = (i % (options.size()));

			List<Character> l = options.get(lx);
			int x = random.nextInt(l.size() - 1);
			tempPassword += l.get(x);
		}

		//System.out.println("Before:\t" + tempPassword);
		// shuffle the initial password to do not have a sequence pattern
		tempPassword = shuffle(tempPassword);

		//System.out.println("After:\t" + tempPassword);

		return tempPassword;
	}

	/**
	 * Shuffle the word
	 * @param word
	 * @return
	 */
	private static String shuffle(String word) {
		Stream<Integer> boxed = word.chars().boxed();
		List<Character> letters = boxed.map(c -> (char) c.intValue()).collect(Collectors.toList());
		Collections.shuffle(letters);
		StringBuilder t = new StringBuilder(word.length());
		letters.forEach(t::append);
		return t.toString();
	}

	/**
	 * Erase the previous value of the possible characters
	 */
	public void resetRules() {
		// this.chars = new ArrayList<Character>();
		this.options.clear();
	}

	/**
	 * 1) Create a program that generates the alphabet from a to z. Set up the
	 * generator to use lowercase characters.
	 */
	public void setLowercase() {
		List<Character> chars = new ArrayList<Character>();
		// criating an a-z lowercase array
		for (int i = (int) 'a'; i <= (int) 'z'; i++) {
			if (!chars.contains((char) i))
				chars.add((char) i);
		}
		int size = this.options.size();
		this.options.put(size, chars);
	}

	/**
	 * 1) Create a program that generates the alphabet from A to Z Set up the
	 * generator to use uppercase characters.
	 */
	public void setUppercase() {
		List<Character> chars = new ArrayList<Character>();
		// criating an A-Z uppercase array
		for (int i = (int) 'A'; i <= (int) 'Z'; i++) {
			if (!chars.contains((char) i))
				chars.add((char) i);
		}
		int size = this.options.size();
		this.options.put(size, chars);
	}

	/**
	 * 4) Extend that program to include Numbers from 0 - 1 as well. Set up the
	 * generator to use numbers.
	 */
	public void setNumbers() {
		List<Character> chars = new ArrayList<Character>();
		// 0-9 numbers
		for (int i = (int) '0'; i <= (int) '9'; i++) {
			if (!chars.contains((char) i))
				chars.add((char) i);
		}
		int size = this.options.size();
		this.options.put(size, chars);
	}

	public void setSymbols() {
		List<Character> chars = new ArrayList<Character>();
		// simbols
		char[] symbols = { '!', '@', '#', '$', '%', '&', '*', '?' };
		for (char c : symbols) {
			if (!chars.contains(c)) {
				chars.add(c);
			}
		}
		int size = this.options.size();
		this.options.put(size, chars);
	}

	/**
	 * 5) Extend that program to only include letters/numbers from which we specify
	 * 
	 * @param custom An ArrayList of Character
	 */
	public void setCustomSet(ArrayList<Character> custom) {
		if (custom == null || custom.isEmpty())
			return;

		List<Character> chars = new ArrayList<Character>();
		for (char c : custom) {
			if (!chars.contains(c)) {
				chars.add(c);
			}
		}
		int size = this.options.size();
		this.options.put(size, chars);
	}

	public void setCustomSet(char[] custom) {
		ArrayList<Character> list = new ArrayList<Character>();
		for (char c : custom) {
			list.add(c);
		}
		setCustomSet(list);

	}

}
