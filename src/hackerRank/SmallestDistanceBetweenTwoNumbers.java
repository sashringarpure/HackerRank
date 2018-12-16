package hackerRank;

import java.util.Arrays;

public class SmallestDistanceBetweenTwoNumbers {

	public SmallestDistanceBetweenTwoNumbers() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] i1 = {5,4,3,2,1,0};

		//		Array copy by value
		int[] i2 = new int[i1.length];
		System.arraycopy(i1, 0, i2, 0, i1.length);
		
		System.out.println("I1 :" + Arrays.toString(i1));
		System.out.println("I2 :" + Arrays.toString(i2));
		
		Arrays.sort(i2);
		
		System.out.println("I1 :" + Arrays.toString(i1));
		System.out.println("I2 :" + Arrays.toString(i2));
		
		for (int i = 0 ; i < i2.length; i++) {
			if (i1[i] == i2[0])
			{
				System.out.println("Index of the first number for smallest difference is :" + i);
				break;
			}
		}

	}

}
