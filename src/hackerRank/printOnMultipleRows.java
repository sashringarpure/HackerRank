package hackerRank;

public class printOnMultipleRows {
	  
	public static void main(String[] args) {
		String[] s = {"a", "b", "c", "d", "e", "f", "g", "h"};
		int ctr = 0;
		
		for (int i = 0; i < 3; i++) {
			for (int k = ctr; k < s.length; k=k+3) {
				System.out.print(s[k] +" ");
			}
			ctr++;
			System.out.println("");
		}
	}
}

