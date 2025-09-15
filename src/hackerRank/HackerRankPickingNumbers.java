package hackerRank;

import java.util.*;

public class HackerRankPickingNumbers {

    public static int pickingNumbers(List<Integer> a) {
        int tmp = 0;
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        SortedSet ss = new TreeSet<Integer>();
        int result = 0;
        //Stores the frequency of repitition of each number in the list.
        //Prepares a unique list/set based on the input.
        for (Integer i : a ){
            if (! hm.containsKey(i)) {
                hm.put(i, 1);
            }
            else {
                tmp = hm.get(i);
                hm.put(i, ++tmp);
            }
            ss.add(i);
        }
        //Convert the set to a list for iteration.
        List<Integer> l = new ArrayList<Integer>(ss);
        //Iterate over the list to fetch the maximum sub-array.
        //Checks if the difference between the adjacent elements is <=1
        //Adds the frequency of repitition for the adjacent elements.
        for (int i = 0; i< l.size() - 1; i++) {
            if (Math.abs(l.get(i) - l.get(i+1)) <= 1) {
                tmp = hm.get(l.get(i)) + hm.get(l.get(i+1));
                result = Math.max(result, tmp);
            }
        }
        //Edge cases where the input list contains only one repetitive number
        //or is like {1: 5, 3: 1, 4: 1} where the above loop will fail.
        for (Integer i : hm.keySet()) {
            result = Math.max(result, hm.get(i));
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(1, 1, 1, 1, 1, 3, 4);
        System.out.println(pickingNumbers(input));
    }
}
