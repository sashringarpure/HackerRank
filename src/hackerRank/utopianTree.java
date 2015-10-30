package hackerRank;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class utopianTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fileName="D:\\hackerRank\\utopianTree.txt";
		String line="";
		int ctr = 0;
		int heightOfTree = 1;
		int noOfCycles = 0;
		try {
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			while ( (line = br.readLine()) != null) {
				ctr++;
				if ( ctr > 1 ) {
					noOfCycles = Integer.parseInt(line);
					System.out.println("Number of Cycles is :" + noOfCycles);
					while ( noOfCycles > 0 ) {
						if ( noOfCycles > 0) {
							noOfCycles--;
							heightOfTree = heightOfTree + heightOfTree;
						} //If
						if ( noOfCycles > 0) {
							noOfCycles--;
							heightOfTree = heightOfTree + 1;
						} //If
					} //while noOfCycles > 0
					System.out.println("Height of Tree is : " + heightOfTree);
				} //IF ctr > 1
				heightOfTree = 1;
			} //while
		} //try
		catch(FileNotFoundException e) {
			System.out.println("File not found exception :" + e.getMessage());
		}//catch
		catch(IOException e) {
			System.out.println("IO exception :" + e.getMessage());
		}//catch
		catch(Exception e) {
			System.out.println("Other exception :" + e.getMessage());
		}
	}

}
