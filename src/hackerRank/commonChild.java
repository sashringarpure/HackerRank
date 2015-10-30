/* File IO
 * Convert from String to Char
 * Convert from Char to String
 * For Loop for a Set Collection
 * Search within a collection
 */
package hackerRank;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class commonChild {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fileName="D:\\hackerRank\\commonChild.txt";
		String line="";
		char[] ch;
		Set<String> set = new TreeSet<String>();
		Set<String> set1 = new TreeSet<String>();
		Boolean b = true;
		Iterator it1,it2;
		try {
				FileReader fr = new FileReader(fileName);
				BufferedReader br = new BufferedReader(fr);
				while ((line = br.readLine()) != null) {
					ch = line.toCharArray(); //Convert String to Char
					if (b) {
					for (int i = 0; i<ch.length;i++) {
						String str = new Character(ch[i]).toString(); //Convert Char to String
						set.add(str);
					} //FOR
					b = false;
					} //IF
					else {
						for (int i = 0; i<line.length();i++) {
							String str = new Character(ch[i]).toString();
							set1.add(str);	
						} //FOR
					} //ELSE
					} //WHILE
				for (String s: set) {  //For loop for Set Collection
					for ( String s1 : set1) {
						if ( s.contains(s1)) {  //Search within a collection
							System.out.println(s);
						}
					} //FOR
				} //FOR
		} catch(FileNotFoundException e) {
			System.out.println("File not found exception :" + e.getMessage());
		}//catch
		catch(IOException e) {
			System.out.println("IO exception :" + e.getMessage());
		}//catch
		catch(Exception e) {
			System.out.println("Other exception :" + e.getMessage());
		}//catch
	}
}
