package hackerRank;

import java.util.List;
import java.util.ArrayList;

//Define a list of lists for the final result
//Define a list for each recursion.
//Start with 0th element.
//Iterate to the next element with a call to recursion.
//Remove the last element from the list and call recursion again to get the next subset.
//Base case: Return the subset and add it to the result set when index position == array length.

public class NeetCodeBacktrackingSubset {
    public static void main(String args[]) {
        int x=10;
        int y=25;
        int z=x+y;
        int[] nums = {1, 2, 3};
        //Define a list of lists for the final result
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        //Define a list for each recursion.
        List<Integer> subset = new ArrayList<>();
        //Start with 0th element.
        dfs(nums,0,res,subset);
        System.out.println("Sum of x+y = " + z);
        System.out.println("All Subsets = " + res);
    }

    public static void dfs(int[] nums, int i, List<List<Integer>> res, List<Integer> subset) {
        //Base case: Return the subset and add it to the result set when index position == array length.
        if ( i >= nums.length ) {
            res.add(new ArrayList<Integer>(subset));
            return;
        }
        subset.add(nums[i]);
        //Iterate to the next element with a call to recursion.
        dfs(nums,i+1,res,subset);
        //Remove the last element from the list and call recursion again to get the next subset.
        subset.remove(subset.size()-1);
        //Call recursion again to get the next subset.
        dfs(nums,i+1,res,subset);
        return;
    }
}
