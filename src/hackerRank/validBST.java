package hackerRank;

import java.util.*;

public class validBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int temp = 0;
		
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(1);
		al.add(3);
		al.add(4);
		al.add(2);

		for (int i = 1; i < al.size(); i++) {
			temp = i;
			if ( ( al.get(i) <  al.get(i-1) || al.get(i) > al.get(i-1) ) && al.get(i) < al.get(0)) {
				System.out.println("Parsed node :" + al.get(i) + " on left BTree.");
				continue;
			} else {
				System.out.println("left btree parsed successfully.");
				break;
			}
			
		} //FOR
		
		for (int i = temp; i < al.size(); i++) {
			System.out.println("Current node: "+ al.get(i));
			if ( (al.get(i) > al.get(i-1) || al.get(i) < al.get(i-1)) && al.get(i) > al.get(0)) {
				System.out.println("Parsed node :" + al.get(i) + " on right BTree.");
				continue;
			} else {
				System.out.println("Invalid BST.");
				break;
			}
			
		}

		/*
		for (int i = temp; i < al.size(); i++) {
			temp++;
			if ( ( al.get(i) <  al.get(i-temp) || al.get(i) > al.get(i-temp) ) && al.get(i) > al.get(0)) {
				System.out.println("current node is:" + al.get(i));
				continue;
			} else {
				System.out.println("right btree ended at node:" + al.get(i));
				System.out.println("right btree parsed successfully.");
				break;
			}
			
		} //FOR */

	}

}
