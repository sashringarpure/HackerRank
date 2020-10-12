package hackerRank;

public class LeetCodeProductOfArrayExceptSelf {

    public static void main(String[] args) {
    int[] nums = {0,1};
    int temp = 1 ;
    int[] output = new int[nums.length];
    int index = 0;

        while ( index < nums.length ){
            for (int i = 0; i < output.length; i++) {

                if ( index != i )
                    temp = temp * nums[i];

            }

            output[index] = temp;
            System.out.println(output[index]);
            index++;
            temp = 1;
        };

    }
}
