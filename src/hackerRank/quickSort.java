package hackerRank;

public class quickSort {

	public static void main(String[] args) {
		int[] intArray = {20,35,-15,7,55,1,-22} ;  //unsorted array
		
		quicksort(intArray,0,intArray.length);
		
	}
	
	public static void quicksort(int[] input, int start, int end) {
		if(end - start < 2) return;
		
		int pivotIndex = partition(input, start, end); //find pivot element
		
		quicksort(input, start, pivotIndex);	
		quicksort(input, pivotIndex+1, end);
	}
	
	public static int partition(int[] input, int start, int end) {
		int pivot = input[start] ; //use first element as the pivot.
		int i = start;
		int j = end;
		
		while (i<j) {
			while (i<j && input[--j] >= pivot); //empty loop body
			if (i<j) input[i] = input[j];
			while (i<j && input[++i] <= pivot); //empty loop body
			if (i<j) input[j] = input[i];
		}
		
		input[j] = pivot;
		return j;
			
	}
	
}