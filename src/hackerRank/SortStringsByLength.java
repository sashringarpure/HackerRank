package hackerRank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SortStringsByLength {

	public SortStringsByLength() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		List<String> unSortedArrayList = new ArrayList<String>();
		List<String> sortedArrayList = new ArrayList<String>();
		HashMap toSort = new HashMap<Integer, String>();
		unSortedArrayList.add("abcde");
		unSortedArrayList.add("abcd");
		unSortedArrayList.add("abc");
		unSortedArrayList.add("ab");
		unSortedArrayList.add("a");
		
		System.out.println(unSortedArrayList);
		
		for (String temp : unSortedArrayList) {
			toSort.put(temp.length(), temp);
		}
		
		for (int i = 1 ; i <= unSortedArrayList.size() ; i++) {
			sortedArrayList.add(toSort.get(i).toString());
		}
		
		System.out.println(sortedArrayList);
		
		
	}

}
