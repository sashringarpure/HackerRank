package hackerRank;

public class FindConsecutiveDuplicateChars {

	public static void main(String[] args) {
		int index = 0;
		boolean dupeFound = false;
		String s = "aaabccdeffffgg";
		char[] c = s.toCharArray(); //convert to char array
		for (int i = 0; i < c.length; i++) {  //loop through each char
			//System.out.print("C[i] : " + c[i] + " ");
			if ( i < c.length - 1 ) {  // limit the looping till the second to last char to avoid exception in the inner loop
				for (int j = i+1; j < c.length; j++ ) {  //Inner loop to detect consecutive duplicate char
					if ( c[i] == c[j] ) {  //check to find out if consecutive char are duplicates
						//System.out.print("C[J] : " + c[j]);
						index = i;  //store the index if two consecutive char are the same
						dupeFound = true;  //set a flag
						continue ;  //continue the loop to check if the next char is a dupe
					}
					else {
						i = j-1 ;  //if char is not a dupe then reset the outer loop to the index of the inner loop. I will be incremented to the value of J by the for loop.
						break;  //break from the inner loop
					}   
				}
			}
			if (dupeFound) {
				System.out.print("index is : " + index);
				System.out.println(" and Alphabet is : " + c[index]);
			}
	      index = 0;
	      dupeFound = false;
	}
}

}
