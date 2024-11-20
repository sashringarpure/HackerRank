package hackerRank;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MetaCafeteria {
    static boolean openSeat;
    public static void main(String[] args) {
        int newDiner = 0;
        int gap = 2;
        HashMap<Integer, String> hm = new HashMap<>(10);
        hm.put(1,null);
        hm.put(2,null);
        hm.put(3,null);
        hm.put(4,null);
        hm.put(5,"d");
        hm.put(6,null);
        hm.put(7,null);
        hm.put(8,null);
        hm.put(9,null);
        hm.put(10,null);
        for (Map.Entry<Integer, String> entry :hm.entrySet()) {
            if (entry.getValue() == null ) {
                openSeat = false;
                newDinerRec(hm, entry.getKey(), gap);
                if ( openSeat ) {
                    hm.put(entry.getKey(), "d");
                    newDiner++;
                }
            }
        }
        System.out.println(hm);
        System.out.println(newDiner);
    }

    public static void newDinerRec(HashMap<Integer, String> hashMap, int seat, int gap ) {
        if ( gap > 0 ) {
            if ( (!Objects.equals(hashMap.get(seat - gap), "d"))
            && (!Objects.equals(hashMap.get(seat + gap), "d") ) )
                openSeat = true;
            else { openSeat = false; return; }
            newDinerRec(hashMap, seat, gap-1);
        } else openSeat = true;
    }
}
