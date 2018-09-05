package hackerRank;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

/*
 * Write a program which creates a concordance of 
 * characters occurring in a string 
 * (i.e., which characters occur where in a string)
 */ 
   
public class ConcordanceCollection {

	String s = "hello world";
	char[] c;
	public ConcordanceCollection() {
		// TODO Auto-generated constructor stub
		
	}
	
	public void getConcordance() {
		char[] ch = s.toCharArray(); // convert string to char array
		char cha ; 
		ArrayList<Integer> al = new ArrayList<Integer>(); // define array list
		al.clear(); 
		SortedSet<Character> ss = new TreeSet<Character>() ; // init sorted set 
		for ( char c : ch ) {
			ss.add(c); // add unique chars from the string to set
		}
		
		Iterator it = ss.iterator(); // get the iterator object
		
		while ( it.hasNext() ) { 
			al.clear();
			Object ele = it.next();  // retrieve each character from the set 
			cha = ele.toString().charAt(0); // convert the object to char
			for ( int i = 0 ; i < ch.length ; i ++ ) {  // loop through the string input
				
				if ( cha == ch[i] ) { //based on match, add the index position to array list
					al.add(i);
				}
			}
			System.out.println("character :" + cha + " is present at : " + al + " location(s)"); 
			// prints the output
		}
		
		
	}
	
	public static void main (String[] args) {
		ConcordanceCollection cc = new ConcordanceCollection();
		cc.getConcordance();
	}

}
