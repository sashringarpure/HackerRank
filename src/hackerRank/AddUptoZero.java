package hackerRank;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddUptoZero {

	public static void main(String[] args) {
		int[] addUptoZero = {-10,-9,-9,-8,-7,-6,-5,-4,-3,-2,-1,0,10,11,12,13,14,15,16,17,18,19,20};
		List<Integer> temp = new ArrayList<Integer>();
		int index = 0;
		int counter = 0;
		
		for (int i : addUptoZero) {
			temp.add(Integer.valueOf(i));
		}
		
		for (Integer i : temp) {
			System.out.println("Array element :" + temp.get(counter));
			if (i < 0) {
				if (temp.contains(Math.abs(i))) {
					index = temp.indexOf(Math.abs(i));
					System.out.println("index is : " + index);
					System.out.println("following numbers add upto zero : " + temp.get(counter) + " and " + temp.get(index));
					break;
				}
			} else if ( i > 0) {
				if(temp.contains(i*(-1))) {
					index = temp.indexOf(i*(-1));
					System.out.println("index is : " + index);
					System.out.println("following numbers add upto zero : " + temp.get(counter) + " and " + temp.get(index));
					break;
				}
			}
			counter++;
		}
		
		
		
		

	}

}
