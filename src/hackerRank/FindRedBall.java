package hackerRank;

import java.util.ArrayList;

public class FindRedBall {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> balls = new ArrayList<String>();
		balls.add("blue");
		balls.add("blue");
		balls.add("black");
		balls.add("blue");
		balls.add("red");
		FindRedBall frb = new FindRedBall();
		frb.findRedBall(balls);
	}
	
	void findRedBall(ArrayList<String> list) {
		int length = list.size();
		int counter = 0;
		ArrayList<String> firstHalf = new ArrayList<String>();
		ArrayList<String> secondHalf = new ArrayList<String>();
		for ( String str : list) {
			// System.out.println("List :" + str);
			if (counter < length/2) {
				firstHalf.add(str);
				counter++;
				// System.out.println("first half :" + firstHalf.toString());
				// System.out.println("counter :" + counter);
			} else { 
				secondHalf.add(str);
				counter++;
				// System.out.println("second half :" + secondHalf.toString());
				// System.out.println("counter :" + counter);
			}
		}
		System.out.println("first half :" + firstHalf.toString());
		System.out.println("second half :" + secondHalf.toString());
		if (containsRedBall(firstHalf)) {
			if (firstHalf.size() == 1) {
				System.out.println("red ball found in first half.");
				System.exit(0);
			} else {
				findRedBall(firstHalf);
			}
		} else if (containsRedBall(secondHalf)) {
			if (secondHalf.size() == 1) {
				System.out.println("red ball found in second half.");
				System.exit(0);
			} else {
				findRedBall(secondHalf);
			}
		}
	}
	
	boolean containsRedBall(ArrayList<String> list) {
		boolean flag = false;
		if (list.contains("red")) {
			flag = true;
		}
		return flag;
	}

}