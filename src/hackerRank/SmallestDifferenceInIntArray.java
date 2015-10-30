package hackerRank;

import java.util.SortedSet;
import java.util.TreeSet;

public class SmallestDifferenceInIntArray {
	
	public static void main(String[] args) {
		int[] a1 = {-2,-1,0,1,2,3};
		SortedSet<Integer> s1 = new TreeSet<Integer>();
		
		for (int i = 0; i < a1.length; i++) {
			for (int j = 0; j < a1.length; j++) {
				if ( i != j) {
					s1.add(a1[i]-a1[j]);
				}
			}
		}
		
		System.out.println(s1);
		System.out.println(s1.first());
	}
	
	
	

}
