package hackerRank;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class PathwithMaximumProbability {

    public static void main(String[] args) {
        int n = 3;
        double[] succProb = {0.5, 0.5, 0.2};
        int start = 0;
        int end = 2;
        int[][] edges = {{0,1}, {1,2}, {0,2}};
        HashMap<Integer,Integer> hm = new HashMap<Integer, Integer>();
        int key = 0;
        int value = 0;
        Iterator it;
        double success = 1;

        for (int i = 1; i < edges.length; i++) {
                if ( edges[i][0] == start && edges[i][1] == end) {
                    success = succProb[i];
                } else if ( (edges[i-1][0] >= start ||  edges[i][0] >= start) && (edges[i-1][0] < end ||  edges[i][0] < end) &&
                        (edges[i-1][1] <= end || edges[i][1] <= end) && (edges[i-1][1] > start || edges[i][1] > start) ) {

                }
                hm.put(edges[i][0],edges[i][1]);
        }

        it = hm.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            key = Integer.parseInt(pair.getKey().toString());
            value = Integer.parseInt(pair.getValue().toString());
            if ( key >= start && key < end) {

            }
        }
    }
}
