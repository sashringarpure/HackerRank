package hackerRank;

import java.util.ArrayList;
import java.util.Arrays;

public class reverseWordsInAString {

	String s = "thiss$ %is JA&VA";
	String out;
	public reverseWordsInAString() {
		// TODO Auto-generated constructor stub
	}
	
	public void reverse() {
		String[] s1 = s.split(" "); //create an array of words based on space delimiter
		ArrayList<String> al = new ArrayList<String>();
		ArrayList<String> output = new ArrayList<String>();
		for (int i = 0 ; i < s1.length; i++) { //create array list based out of string array.
			al.add(s1[i]);
		}
		
		for (String s2 : al ) { //for each word in a string
			String tempResult = "";
			
			char[] a = s2.toCharArray() ; 
			for (int j = 0; j < a.length; j++ ) { //strip off non alpha characters
				if ( Character.isLetter(a[j]) ) {
					tempResult = tempResult + a[j];
				}

			}

			char[] b = tempResult.toCharArray();

			for (int l = 0, k = b.length-1; l < k; l++, k--) { //reverse one word at a time and store it in an array
				char ch;
				ch = b[k];
				b[k] = b[l];
				b[l] = ch;
			}
			output.add(Arrays.toString(b).substring(1,3*b.length-1).replaceAll(", ",""));


		}
		System.out.println(al);
		System.out.println(output);


	}

	public static void main(String[] args) {
		reverseWordsInAString r = new reverseWordsInAString();
		r.reverse();
	}
}
