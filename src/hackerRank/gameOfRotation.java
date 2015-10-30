package hackerRank;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class gameOfRotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fileName="D:\\hackerRank\\GameOfRotation.txt";
		String line="";
		int[] rotateIn = {};
		int[] result = {};
		String[] rotateStr;
		int[] mult = {1,2,3};
		int temp,k=0;
		try {
				FileReader fr = new FileReader(fileName);
				BufferedReader br = new BufferedReader(fr);
				while ( (line = br.readLine()) != null ) {
					rotateStr = new String[line.length()];
					rotateStr = line.split(" ");
					rotateIn = new int[rotateStr.length];
					result = new int[rotateStr.length];
					for ( int i = 0; i < rotateStr.length; i++) {
						rotateIn[i] = Integer.parseInt(rotateStr[i]); //Convert String to Int array.
					} //for
					for (int i : rotateIn) { //Rotate Int Array elements.
						temp = rotateIn[0];
						rotateIn[0] = rotateIn[1];
						rotateIn[1] = rotateIn[2];
						rotateIn[2] = temp;
						result[k] = (1*rotateIn[0])+(2*rotateIn[1])+(3*rotateIn[2]); //Multiply and store in result Int array.
						k++;
						/* for ( int j : rotateIn) {
							System.out.println(j);
						} *///for
					} //for
				} //while
				Arrays.sort(result);
				System.out.println(result[(result.length-1)]);
		} catch (FileNotFoundException e) {
			System.out.println("File not found exception :" + e.getMessage());
		} //catch
		catch(IOException e) {
			System.out.println("IO exception :" + e.getMessage());
		} //catch
		catch(Exception e) {
			System.out.println("Other exception :" + e.getMessage());
		} //catch
		} //main	
	}