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
