package hackerRank;

public class Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			String palindrome = "Dot saw I was tod";
			char ch1,ch2;
			String result = "String is palindrome";
			int j;
			boolean bool;
		
//			Remove spaces		
			palindrome = palindrome.replace(" ", "");

//			Compare the 1,2,3 and nth,n-1th,n-2nd chars of the string to determine whether it is palindrome.
			for (int a = 0, b = palindrome.toCharArray().length-1;a <= palindrome.toCharArray().length-1;a++,b--) {
				ch1 = palindrome.charAt(a);
				ch2 = palindrome.charAt(b);
				if (Character.toLowerCase(ch1) != Character.toLowerCase(ch2)) {
					result = "String is not palindrome";
					break;
				}
				
			}
			System.out.println(result);
			
			
			for (int i = 0; i <= palindrome.toCharArray().length-1; i++) {
				 ch1 = palindrome.charAt(i);
//				 Get the corresponding character from end of the string.
				 j = palindrome.toCharArray().length - i - 1;
				 ch2 = palindrome.charAt(j);
				 if ( Character.toLowerCase(ch1) != Character.toLowerCase(ch2) ) { //Converts char to lower case
					 result = "String is not palindrome";
					 break;
				 }
				 else continue;
			}
			System.out.println(result);
			
//			Uses LIFO stack to push characters of a string and pop characters in reverse order to compare 
			java.util.LinkedList<Character> stack = new java.util.LinkedList<Character>();
			StringBuilder palindromeString = new StringBuilder();
			for(int i = 0; i <= palindrome.toCharArray().length-1;i++) {
				ch1 = palindrome.toLowerCase().charAt(i);
				if (ch1 >= 'a' && ch1 <= 'z') {
					stack.push(ch1);
					palindromeString.append(ch1);
				}
			}
			
			StringBuilder palindromeReversedString = new StringBuilder();
			while (!stack.isEmpty()) {
				palindromeReversedString.append(stack.pop());
			}
			
			if (palindromeString.toString().equals(palindromeReversedString.toString())) {
				System.out.println("String is palindrome");
			}
			else {
				System.out.println("String is not a palindrome");
			}
				
			
	}


}
