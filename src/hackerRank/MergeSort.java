package hackerRank;

import java.util.Arrays;

public class MergeSort {
	
	
	public static void main(String[] args) {
		int[] intArray = {20,35,-15,7,55,1,-22};
		mergeSort(intArray,0,intArray.length);
	}

	public static void mergeSort(int[] input, int start, int end) {
		System.out.println(" In method - start index :" + start + " end index:" + end );
		if (end - start < 2 )  {
			System.out.println("In If loop...Returning" + " start : " + start + " end: " + end);
			return ;
		}
		int mid = (start + end)/2;
		System.out.println(" ************* mid index: " + mid);
		mergeSort(input,start,mid);
		System.out.println("b4 second merge sort.");
		mergeSort(input,mid,end);
		merge(input,start,mid,end);
	}
	
	public static void merge(int[] input, int start, int mid, int end ) {
		
		System.out.println("***In method Merge" + Arrays.toString(input));
		if (input[mid-1] <= input[mid]) return;
		
		int i = start;
		int j = mid;
		int tempIndex = 0;
		
		int[] temp = new int[end - start];
		while (i < mid && j < end) {
			temp[tempIndex++] = input[i] <= input[j] ? input[i++] : input[j++] ;
		}
		
		System.arraycopy(input,i,input,start+tempIndex,mid-i);
		System.arraycopy(temp,0,input,start,tempIndex);
		System.out.println("***Out method Merge" + Arrays.toString(input));
	}

}
