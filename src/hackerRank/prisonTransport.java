package hackerRank;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class prisonTransport {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fileName="D:\\hackerRank\\prisonTransport.txt";
		String line="";
		ArrayList<String> al = new ArrayList<String>();
		/* UNIQUE SET */
		Set<Integer> set1 = new HashSet<Integer>();
		int cost = 0;
		int notPairedPrisoners = 0;
		
		try {
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			while (( line = br.readLine()) != null) {
				al.add(line);
			}
			// System.out.println(al);
			for (int i = 2; i < al.size(); i++) {
				line = al.get(i);
				if ( line != "") {
				/* TypeCast from String to Integer. */
				set1.add(Integer.parseInt(line.substring(0,1))); //TypeCast from String to Integer.
				set1.add(Integer.parseInt(line.substring(2,3)));
				}
			}
			
			
			for (int i = 1; i < set1.size(); i++) {
				
				if ( i*i >= set1.size() ) {
					cost = i;
					break;
				}
			}
			
			// System.out.println(cost);
		if ( ( Integer.parseInt(al.get(0)) - set1.size() ) > 1 ) {
			
				for (int i = 1; i < Integer.parseInt(al.get(0)) - set1.size(); i++) {
				
				if ( i*i >= Integer.parseInt(al.get(0)) - set1.size() ) {
					cost = cost+i;
					break;
				}
			}

		} else if ( ( Integer.parseInt(al.get(0)) - set1.size() ) == 1 )  {
			cost = cost + 1;
		}
			System.out.println("Total Cost :" + cost);
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
