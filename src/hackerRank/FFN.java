package hackerRank;

import java.util.HashMap;
import java.util.Iterator;

public class FFN {

    public static void main(String[] args) {

        String[][] s1 = { {"www.ebay.com/shoes", "1" },
                {"www.ebay.com/shoes", "2" },
                {"www.ebay.com/shoes", "3" },
                {"www.ebay.com/clothes", "1" },
                {"www.ebay.com/toys", "5" },
        };
        HashMap<String,Integer> hm = new HashMap<String,Integer>();

        for (String[] s : s1 ) {
            if ( ! hm.containsKey(s[0]) ) {
                hm.put(s[0], Integer.parseInt(s[1]));
            } else {
                int i = hm.get(s[0]);
                i = i + Integer.parseInt(s[1]);
                hm.put(s[0],i);
            }
        }

        Iterator itr = hm.keySet().iterator();
        while ( itr.hasNext() ) {
            String key = (String) itr.next();
            int val = hm.get(key);
            System.out.println("Domain : " + key + " Value : " + val);

        }

    }
}
