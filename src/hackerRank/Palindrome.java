package hackerRank;

public class Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			String palindrome = "Dot saw I was tod";
			char ch1,ch2;
			String result = "String is palindrome";
			int j;
			boolean bool;
			for (int i = 0; i <= palindrome.toCharArray().length-1; i++) {
				 ch1 = palindrome.charAt(i);
				 j = palindrome.toCharArray().length - i - 1;
				 ch2 = palindrome.charAt(j);
				 if ( Character.toLowerCase(ch1) != Character.toLowerCase(ch2) ) { //Converts char to lower case
					 result = "String is not palindrome";
					 break;
				 }
				 else continue;
			}
			System.out.println(result);
			
	}


}
