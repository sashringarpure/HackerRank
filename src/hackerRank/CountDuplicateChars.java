package hackerRank;
//4403
import java.util.HashMap;
import java.util.Map;

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
		
	}
	
	public static void main(String[] args) {
		CountDuplicateChars cdc = new CountDuplicateChars();
		cdc.findDuplicateChars();
	}
	

}
