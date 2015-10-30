package hackerRank;
import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class insertionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fileName="D:\\hackerRank\\insertionSort.txt";
		String line="";
		String[] arr1;
		int[] int1;
		int insertionCtr = 0;
		try {
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			int ctr = 0;
			String tmp="";
			while ((line = br.readLine()) != null) {
				System.out.println(line);
				ctr = Integer.parseInt(line);
				if ( ctr > 1 ) {
					arr1 = br.readLine().split(" ");
					System.out.println("Original Array :" + Arrays.toString(arr1));
					for ( int i = 0; i < arr1.length - 1; i++) {
						for ( int j = 0; j < arr1.length - 1; j++) {
							if ( Integer.parseInt(arr1[j]) < Integer.parseInt(arr1[j+1]) ) {
								tmp = arr1[j];
								arr1[j] = arr1[j+1];
								arr1[j+1] = tmp;
								insertionCtr++;
							} //If
						} //for
						System.out.println(Arrays.toString(arr1));
					} //for
						System.out.println("Insertion Count is :" + insertionCtr);
				} //If
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