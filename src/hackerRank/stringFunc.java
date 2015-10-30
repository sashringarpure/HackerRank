//finds consecutive numbers in a string and sums up the integer.
package hackerRank;

public class stringFunc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "123abc456def123.456";
		StringBuilder temp;
		int result = 0, out = 0;
		float f;
		temp = new StringBuilder(); 
		for (int i = 0; i < input.length(); i++) {
			if (Character.isDigit(input.charAt(i)) || input.charAt(i) == '.') { //check if char is a digit.
				temp.append(input.charAt(i)); //append to stringbuilder if char is a digit.
			} else {
				if (temp.length() > 0) {
					if ( temp.toString().contains(".")) {
						f = Float.parseFloat(temp.toString());	//convert a string to float.
						out = (int) f; //convert from float to int.
					} else {
						out = Integer.parseInt(temp.toString()); //convert from string to int.
					}
					 //convert stringbuilder to int
					result = result + out; //sum up integer values
					temp.setLength(0); //initialise stringbuilder to 0
					} //IF
				} //IF
			} //for
		if (temp.length() > 0) { //if last element is a int then check if temp > 0 for summation.
			if ( temp.toString().contains(".")) {
				f = Float.parseFloat(temp.toString());	//convert a string to float.
				out = (int) f; //convert from float to int.
			} else {
				out = Integer.parseInt(temp.toString()); //convert from string to int.
			}
			result = result + out;
		} //IF
		System.out.println(result); 

		
	}
}
