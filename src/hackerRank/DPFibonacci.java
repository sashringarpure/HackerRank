package hackerRank;

import java.util.HashMap;
/*
Logic:
1. Input the first number into hashmap.
2. Decrement the count by one and invoke the recursive function with the number and hashmap as parameters.
3. Recursive function: if the number == 1, input the second number to the hashmap.
4. Recursively invoke the function decrementing the number by one each time.
5. Determine if the nth fibonacci sequence is defined, if not, insert the nth fibonacci sequence in hashmap.

 */
public class DPFibonacci {

    public static void fibRec(int n, HashMap<Integer,Integer> hashMap) {
        if (n == 1) {
            hashMap.put(1, 1);
        } else {
                fibRec(n - 1, hashMap);
                if (!hashMap.containsKey(n)) hashMap.put(n, hashMap.get(n-1)+hashMap.get(n-2));
        }
        return;
    }

    // Driver Code
    public static void main(String[] args)
    {
        int n = 3;
        if ( n <= 0 ) {
            System.out.println("Number should be non-zero integer.");
            System.exit(0);
        }
        if ( n == 1 ) {
            System.out.println("1");
            System.exit(0);
        }
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        hm.put(0,0);
        fibRec(n-1, hm);
        System.out.println(hm.values());
    }
}
