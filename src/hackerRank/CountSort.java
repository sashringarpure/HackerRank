package hackerRank;

public class CountSort {

	public static void main(String[] args) {
		int[] intArray = {2,5,9,8,2,8,7,10,4,3} ;  //unsorted array
		
		countSort(intArray, 1, 10 ) ;
		
		for (int i = 0 ; i < intArray.length ; i++ ) {
			System.out.println(intArray[i]);
		}
		
	}
	
	public static void countSort(int[] input,int min, int max ) {
		
		int[] countArray = new int[input.length];
		
		//count the number of 2's, 3's, 4's in the input array.
		for (int i = 0 ; i < input.length ; i++ ) {
			countArray[input[i]-min]++;
		}
		//print count array
		for (int i = 0 ; i < countArray.length ; i++ ) {
			System.out.println(countArray[i]);
		}
		System.out.println("here");
		
		//iterate length of the input array and if the value in countArray >= min value 
		//then replace the values in the input array with the number of count of digits from countArray
		int j = 0 ;
		for (int i = 0; i < input.length ; i++ ) {
			int k = 0 ;
			while ( countArray[i] >= min && k < countArray[i] ) {
				input[j++] = i+1 ;
				k++ ;
			}
		}
		
		
	}

}
