package hackerRank;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class fraudPrevention {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fileName="D:\\hackerRank\\fraudPrevention.txt";
		String line="";
		String[] temp; //declare array.
		int idx = 0;
		StringTokenizer st = null;
		try {
			
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			ArrayList emailId = new ArrayList<String>(); //declare array-list
			ArrayList<String> rec = new ArrayList<String>(); 
			Set<String> set = new HashSet<String>(); //declare set
			while ((line = br.readLine()) != null) {
				temp = line.split(","); //Split CSV string based on delimiter and fetch into array-list.
				emailId.add(temp[2]); //  fetch into array-list the emailId.
				set.add(temp[2]); //fetch into set the emailId.
				rec.add(line);
			} //WHILE
			for ( String element: set ) { //find duplicates.
				int i1 = emailId.indexOf(element);
				int i2 = emailId.lastIndexOf(element);
				if ( i1 == i2 ) {
					System.out.println("Element is not duplicate : " + element );
				} else {
					
					for ( String element_1 : rec) {
						if ( element_1.contains(element) ) {
							System.out.println("Record is duplicate :" + element_1);
						}
					}
				}
			} 
		} //TRY
		catch(FileNotFoundException e) {
			System.out.println("File not found exception :" + e.getMessage());
		}//catch
		catch(IOException e) {
			System.out.println("IO exception :" + e.getMessage());
		}//catch
		catch(Exception e) {
			System.out.println("Other exception :" + e.getMessage());
		}
	} //MAIN

}
