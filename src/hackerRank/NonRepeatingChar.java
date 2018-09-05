package hackerRank;

public class NonRepeatingChar {

	private String s = "atress"; //teeter;stress;atressa
	public NonRepeatingChar() {
		// TODO Auto-generated constructor stub
	}
	
	public void firstNonRepeatingChar() {
		char[] ch = s.toCharArray();
		boolean repeat ;
		for (int i = 0; i < ch.length; i++) {  // loop through each char of input string
			repeat = false; 
			for ( int j = 0 ; j < ch.length ; j++  ) { //scan the input string for duplicate char
				if ( i != j ) { // skip comparison if inner and outer loop indices are the same
					if ( ch[i] != ch[j] ) continue ; //continue comparison if dupe is not found
					else {
						repeat = true; 
						break; //exit inner loop if dupe is found
					}
				}
			}
			if (!repeat) {
				System.out.println("first non-repeating char is : " + ch[i]);
				break;
			}
		}
	}
	
	public void lastNonRepeatingChar() {
		char[] ch = s.toCharArray();
		boolean repeat ;
		
		for (int i = ch.length-1 ; i >= 0 ; i--) {
			
			repeat = false;
			
			for ( int j = ch.length-1 ; j  >= 0 ; j--  ) {
				if ( i != j ) {
					if ( ch[i] != ch[j] ) continue ; 
					else {
						repeat = true;
						break;
					}
				}	
			}
			if (!repeat) {
				System.out.println("last non-repeating char is : " + ch[i]);
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		NonRepeatingChar nrc = new NonRepeatingChar();
		nrc.firstNonRepeatingChar();
		nrc.lastNonRepeatingChar();
	}

}
