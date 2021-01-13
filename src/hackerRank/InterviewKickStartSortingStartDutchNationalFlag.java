package hackerRank;

/*

Dutch National Flag
Given some balls of three colors arranged in a line, rearrange them such that all the red balls go first, then green and then blue ones.
Do rearrange the balls in place. A solution that simply counts colors and overwrites the array is not the one we are looking for.
This is an important problem in search algorithms theory proposed by Dutch computer scientist Edsger Dijkstra. Dutch national flag has three colors (albeit different from ones used in this problem).
Example
Input: [G, B, G, G, R, B, R, G]
Output: [R, R, G, G, G, G, B, B]
There are a total of 2 red, 4 green and 2 blue balls. In this order they appear in the correct output.
Notes
Input Parameters: An array of characters named balls, consisting of letters from {‘R’, ‘G’, ‘B’}.
Output: Return type is void. Modify the input character array by rearranging the characters in-place.
Constraints:
1 <= n <= 100000
Do this in ONE pass over the array - NOT TWO passes, just one pass.
Solution is only allowed to use constant extra memory.
Custom Input
Input Format: The first line of input should contain an integer n, denoting the number of balls. In the next n lines, i-th line should contain one letter from {'R', 'G', 'B'}, balls[i], denoting the color of the i-th ball. If balls = [G, B, G, G, R, B, R, G], then input should be:
8
G
B
G
G
R
B
R
G
Output Format: There will be n lines of output. i-th line contains a character balls[i], denoting character at index i of balls. Here, balls is the character array after the function that you are going to complete is called. For input balls = [G, B, G, G, R, B, R, G], output will be:
R
R
G
G
G
G
B
B



Dutch National Flag
Given some balls of three colors arranged in a line, rearrange them such that all the red balls go first, then green and then blue ones.
Do rearrange the balls in place. A solution that simply counts colors and overwrites the array is not the one we are looking for.
This is an important problem in search algorithms theory proposed by Dutch computer scientist Edsger Dijkstra. Dutch national flag has three colors (albeit different from ones used in this problem).
Example
Input: [G, B, G, G, R, B, R, G]
Output: [R, R, G, G, G, G, B, B]

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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InterviewKickStartSortingStartDutchNationalFlag {

    public static void main(String[] args) {

//        char[] arr = {'G','B','G','G','R','B','R','G'};
//        char[] arr = {'G','B','G','G','R','B','R','G'};
        char[] arr = {'G','R'};

        quickSort(arr, 0, arr.length);
        for ( char ch : arr) System.out.println(ch);

    }

    public static void quickSort(char[] arr, int start, int end) {
        if(end - start < 2) return;
        int pivot_index = quickSortHelper(arr, start, end);
        quickSort(arr, start, pivot_index);
        quickSort(arr, pivot_index+1, end);

    }

    public static int quickSortHelper(char[] arr, int start, int end) {
        char pivot_element = arr[start];
        int i = start;
        int j = end;

        while (i<j) {
            while (i<j && arr[--j] <= pivot_element);
            arr[i] = arr[j];
            while (i<j && arr[++i] >= pivot_element);
            arr[j] = arr[i];
        }

        arr[j] = pivot_element;
        return j;
    }
}
