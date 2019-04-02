package hackerRank;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort {


	public static void main(String[] args) {
		int[] input_array = {54,46,83,66,95,92,43};
		
		bucketSort(input_array);
		
		for (int i = 0 ; i < input_array.length ; i++ ) {
			System.out.println(input_array[i]);
		}
	}
	
	public static void bucketSort(int[] input) {
		List<Integer>[] buckets = new List[10];
		
//		Create empty bucket array list, to store input integer elements in the array list, for sorting.  
//		Like a 2d array.
		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = new ArrayList<Integer>();
		}
		
//	store input integer elements in the appropriate bucket as per the integer value returned by hash function
		for (int i = 0 ; i < input.length ; i++) {
			buckets[Hash(input[i])].add(input[i]);
		}
		
//		Sort each bucket array list
		for (List bucket : buckets) {
			Collections.sort(bucket);
		}
		
//		Puts the value back into the original input array after sorting. 
		int j = 0;
		for (int i = 0 ; i < buckets.length ; i++) {
			for (int value : buckets[i]) {
				input[j++] = value;
			}
		}
		
	}

	private static int Hash(int value) {
		
		return value / (int) 10 ;
	}
}
