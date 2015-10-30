package hackerRank;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class markAndToys {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fileName="D:\\hackerRank\\markAndToys.txt";
		String line="";
		int ctr = 0;
		int insertionCtr = 0;
		int budget = 0;
		int maxToys = 0;
		String[] arr1;
		String tmp = "";
		try {
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			while ((line = br.readLine()) != null) {
				System.out.println(line);
				if ( ctr == 0 ) {
					budget = Integer.parseInt(line.substring(line.lastIndexOf(" ")+1)) ; //retrieves last word from a string.
					System.out.println("budget is: " + budget);
				} //IF
				if ( ctr > 0 ) {
					arr1 = line.split(" ");
					System.out.println("Original Array :" + Arrays.toString(arr1));
					for ( int i = 0; i < arr1.length - 1; i++) {
						for ( int j = 0; j < arr1.length - 1; j++) {
							if ( Integer.parseInt(arr1[j]) > Integer.parseInt(arr1[j+1]) ) {
								tmp = arr1[j];
								arr1[j] = arr1[j+1];
								arr1[j+1] = tmp;
								insertionCtr++;
							} //If
						} //for
						System.out.println(Arrays.toString(arr1));
					} //for
						System.out.println("Insertion Count is :" + insertionCtr);
						for ( String s : arr1 ) {
							maxToys = maxToys +  Integer.parseInt(s);
							if ( maxToys < budget ) {
								System.out.println(s);
							} else {
								System.out.println("limit reached.");
								break;
							}
						} //for
				} //If
				ctr++;
			}//while
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
