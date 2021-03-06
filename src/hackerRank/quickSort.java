package hackerRank;

/*

Quick Sort Steps:
1. find the pivot index:
  0. Specify the recursion termination criteria: If the difference between the start and the end index of the array is less than
  2 then terminate the recursion by invoking return statement.
  a. Call a function which returns pivot index (location of the pivot element) with the input array, start and end index as arguments.
  b. Assume the first element of the input to be the pivot element.
  c. Create two pointers to the start and end of the array.
  d. Loop while the start pointer is less than the end pointer(while loop):
    i.(while loop): Traverse the input from right to left till the elements are greater than or equal to the pivot element, i.e. 1st element.
    and the start pointer is less than the end pointer.
    ii.While traversing from right to left, the while loop will stop once it reaches an element which is less than the pivot element.
    iii.Replace the element in the ith location with this element from the jth location.Since we haven't started scanning
    the loop from left to right yet, the element in the ith location is already saved as a pivot element in step # b. Now we have
    copies of the jth element in two locations, the ith location and the jth location. And the original element in ith location
    is saved as a pivot element. Hence, in the next steps, we will iterate from left to right and when we find an element
    which is greater than the pivot element, we will replace it in the jth location
    iv.(while loop): Traverse the input from left to right till the elements are less than the pivot element, i.e. 1st element.
    and the start pointer is less than the end pointer.
    v.While traversing from right to left, the while loop will stop once it reaches an element which is greater than the pivot element.
    vi.Replace the element in the jth location with this element from the ith location. Now, we have copies of the ith element in two places.
    vii.The inner while loops (steps i through vii) continue till the start point is less than the end pointer from the parent while loop.
    And, as a consequence, re-arranges all the elements which are greater than the pivot element to the right and all the elements which
    are less than the pivot element to the left.
  e. After the parent while loop terminates, we have found the location to insert the pivot element, thereby ensuring all the elements to
    the left are less than the pivot element and all the elements to the right are greater than the pivot element.
  f. Return the location of the pivot element.
2. Repeat the above steps recursively for the elements to the left and to the right of the pivot element.
 */
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