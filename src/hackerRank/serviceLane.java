package hackerRank;
import java.io.*;
import java.util.*;

public class serviceLane {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fileName="D:\\hackerRank\\serviceLane.txt";
		String line="";
		int ctr = 0;
		ArrayList al1 = null;
		String[] outputArray;
		String[] widthArray,testcaseArray;
		TreeSet set;
		try {
			al1 = new ArrayList<String>();
			widthArray = null;
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			while ((line = br.readLine()) != null) {
				ctr++;
				al1.add(line);
				if ( ctr == 2) {
					widthArray = line.split(" ");
				} //If
				if ( ctr >= 3 ) {
					set = new TreeSet<String>();
					testcaseArray = line.split(" ");
					for (int i = Integer.parseInt(testcaseArray[0]); i <= Integer.parseInt(testcaseArray[1]); i++) {
						set.add(widthArray[i]);
					} //for
					set.descendingSet();
					System.out.println("Vehicle allowed is: " + set.first());
				} //if 
			} //while
			br.close();
		} //try
		catch(FileNotFoundException e) {
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
