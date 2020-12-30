package hackerRank;

/*
For int[] arr = {5,4,3,2,1} :-

First Merge Sort
Start/mid, right
1)0,4
2)0,2
3)0,1
4)0,0
9)3,3


Second Merge Sort
5)1,1
7)2,2
10)4,4


Merge Call:
Left,mid,right
6)0,0,1
8)0,1,2
11)3,3,4
12)0,2,4

Explanation:
1. In the mersort function, make two recursive calls to this function.
2. Before making a recursive call, split, the array into two (start+end/2). Make the first recursive call with end = mid
and make the second recursive call with start = mid+1.
3. The termination criteria for recursion would be that this function body should get executed only if start input param
is less than the end input param. What this does is the recursive calls repeatedly split the input array into small sizes
till we have one element from the LHS and the RHS of the array.
4. In the merge function, we copy the elements into two new arrays, one for the LHS of the input array and the other
for the RHS of the input array. We do this using a for loop till the length of the LHS and RHS of the array.
5. We have a while loop to traverse the lengths of the LHS and RHS of the array, and in this loop, we compare the elements
from the LHS and RHS arrays and substitute the smaller element in the main array. We increment the array index by one
of the LHS or the RHS array after successful substitution. We also increment the array index of the main array after
successfull substitutions.
6. We, then have two while loops which run till the length of the LHS and RHS arrays for any residual elements. For e.g.
the LHS array had more smaller elements than the RHS array, hence, the LHS array will get exhausted first by copying it's
contents to the main array. Then, in one of the two residual arrays, the remaining elements of the LHS/RHS shall get
copied to the main array.
 */

import java.util.Arrays;

public class MergeSort {
	
	
	public static void main(String[] args) {
//		int[] arr = {20,35,-15,7,55,1,-22};
		int[] arr = {5,4,3,2,1};
		mergeSort(arr,0,arr.length-1);
		System.out.println(Arrays.toString(arr));
	}

	public static void mergeSort(int[] arr, int start, int right) {
		if (start < right) {

			int mid = (start + right) / 2;

			mergeSort(arr, start, mid);
			mergeSort(arr, mid + 1, right);

			merge(arr, start, mid, right);
		}
	}

	public static void merge(int[] arr, int left, int mid, int right) {


		int len1 = mid - left + 1;
		int len2 = right - mid;

		int leftArr[] = new int[len1];
		int rightArr[] = new int[len2];

		for (int i = 0; i < len1; i++)
			leftArr[i] = arr[left + i];
		for (int j = 0; j < len2; j++)
			rightArr[j] = arr[mid + 1 + j];

		int i, j, k;
		i = 0;
		j = 0;
		k = left;

		while (i < len1 && j < len2) {
			if (leftArr[i] <= rightArr[j]) {
				arr[k] = leftArr[i];
				i++;
			} else {
				arr[k] = rightArr[j];
				j++;
			}
			k++;
		}

		while (i < len1) {
			arr[k] = leftArr[i];
			i++;
			k++;
		}

		while (j < len2) {
			arr[k] = rightArr[j];
			j++;
			k++;
		}

	}

}
