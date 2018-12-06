package hackerRank;

import java.util.Arrays;

public class Anagram {

	public Anagram() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String word1 = "listen";
		String word2 = "silentt";
		
//		replace white spaces
		word1 = word1.replaceAll("//s", "");
		word2 = word2.replaceAll("//s", "");
		
		System.out.println("word1: " + word1);
		System.out.println("word2: " + word2);
		
//		convert to char array
		char[] word_1 = word1.toCharArray();
		char[] word_2 = word2.toCharArray();
		
		System.out.println("char1: " + new String(word_1));
		System.out.println("char2: " + new String(word_2));
		
//		Sort char array
		Arrays.sort(word_1);
		Arrays.sort(word_2);
		
//		Compare char arrays
		if (Arrays.equals(word_1, word_2)) 
			System.out.println("true");
		else System.out.println("false");
		
	}

}
