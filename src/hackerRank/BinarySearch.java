package hackerRank;

public class BinarySearch {

	public static void main(String[] args) {
//		Assumes the array is sorted. 
//		If array is not sorted, then, we have to sort the array before using this Binary Search.
		int[] intArray = {-22, -15, 1, 7, 20, 35, 55 } ;
		
		System.out.println(iterativeBinarySearch(intArray, 8888));
		System.out.println(iterativeBinarySearch(intArray, -15));
		
		System.out.println(recursiveBinarySearch(intArray, -15));
	}

	public static int iterativeBinarySearch(int[] input, int value) {
		
		int start = 0;
		int end = input.length;
		
//		Defines a criteria to stop the search. 
//		If start becomes > end, then, we have searched the entire array.
		while ( start < end ) {
			int midPoint = (start + end) / 2;
			
			if ( input[midPoint] == value )
				return midPoint ;
//			this means the number to be searched is on the RHS of the array.
			else if ( input[midPoint] < value ) {
				start = midPoint + 1 ;
			}
			else {
				end = midPoint ;
			}
		}
		
		return -1;
	}
	
	public static int recursiveBinarySearch(int[] input, int value) {
		return recursiveBinarySearch(input, 0, input.length, value);
	}
	
	public static int recursiveBinarySearch(int[] input, int start, int end, int value) {
//		Termination criteria for recursion.
		if ( start >= end )
			return -1;
		
		int midPoint = (start + end) / 2;
		
		if ( input[midPoint] == value ) 
			return midPoint;
		else if ( input[midPoint] < value ) 
			return recursiveBinarySearch(input, midPoint+1, end, value) ;
		else
			return recursiveBinarySearch(input, start, midPoint, value) ;
	}
}
