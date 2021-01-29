package hackerRank;

public class PushAllZeroesToRight {

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5};
        int[] res = new int[arr.length];

        int j = 0;
        for ( int i = 0; i < arr.length; i++) {
            if ( arr[i] != 0 ) {
                res[j] = arr[i];
                j++;
            }
        }

        for ( int k = j; k < arr.length; k++) {
            res[k] = 0;
        }

        for (int k : res) {
            System.out.print(k);
        }
    }
}
