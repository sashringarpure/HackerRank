package hackerRank;
//4403
import java.util.*;
import java.util.LinkedList;

public class CountDuplicateChars {

	String s = "aaskjdhsdsdasfjkdfsjfdsjkdsdfdf";
	public CountDuplicateChars() {
		// TODO Auto-generated constructor stub
	}
	
	public void findDuplicateChars() {
		int counter = 0;
		char[] ch = s.toCharArray();
		HashMap<Character, Integer> m1 = new HashMap<Character,Integer>() ;  //hashmap to store duplicate char count
		for (int i = 0 ; i < ch.length; i++ ) {
			if (m1.containsKey( ch[i]) ) { // if char is present in the hashmap, then, increment the count
				counter = m1.get(ch[i]);
				m1.put(ch[i], ++counter);
			} else {
				m1.put(ch[i], 1); //if char is not present, insert the char
			}
		}
		
		System.out.println(m1);


		//Display characters in sorted manner. (Sort by hashmap keys)

		Map<Character,Integer> m3 = new TreeMap<Character,Integer>(m1);
		Set s1 = m3.entrySet();
		Iterator it = s1.iterator();
		while (it.hasNext()) {
			Map.Entry me = (Map.Entry) it.next();
			System.out.print(me.getKey()+"="+me.getValue());
		}
		System.out.println();

//		Sort by hashmap values.


		List<Map.Entry<Character,Integer>> ll = new LinkedList<Map.Entry<Character, Integer>>(m1.entrySet()); //Convert to map entry set

		Collections.sort(ll, new Comparator<Map.Entry<Character, Integer>>() {   // Invoke Comparable
			public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
				return ((Comparable) ((Map.Entry) (o1)).getValue()).compareTo(((Map.Entry) (o2)).getValue());
			}
		});

	//convert to hash-map
		HashMap<Character,Integer> m4 = new LinkedHashMap<Character, Integer>();
		Iterator it1 = ll.iterator();
		while (it1.hasNext()) {
			Map.Entry entry = (Map.Entry) it1.next();
			m4.put((Character) entry.getKey(), (Integer) entry.getValue());
		}

		System.out.println(m4);
		
	}
	
	public static void main(String[] args) {
		CountDuplicateChars cdc = new CountDuplicateChars();
		cdc.findDuplicateChars();
	}
	

}
