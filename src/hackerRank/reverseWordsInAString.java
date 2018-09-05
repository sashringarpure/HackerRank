package hackerRank;

import java.util.ArrayList;

public class reverseWordsInAString {

	String s = "this$ %is JA&VA";
	public reverseWordsInAString() {
		// TODO Auto-generated constructor stub
	}
	
	public void reverse() {
		String[] s1 = s.split(" ");
		ArrayList<String> al = new ArrayList<String>();
		for (int i = 0 ; i < s1.length; i++) {
			al.add(s1[i]);
		}
		
		for (String s2 : al ) {
			String tempResult = "";
			
			char[] a = s2.toCharArray() ; 
			for (int j = 0; j < a.length; j++ ) {
				if ( Character.isLetter(a[j]) ) {
					tempResult = tempResult + a[j];
				}
			}
		}
		System.out.println(al);
	}

	public static void main(String[] args) {
		reverseWordsInAString r = new reverseWordsInAString();
		r.reverse();
	}
}
