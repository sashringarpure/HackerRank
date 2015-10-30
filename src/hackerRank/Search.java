package hackerRank;

public class Search {
	
	public static void main(String args[]) {
		
		String mainString = "cdefghiab";
		String searchString = "abc";
		
		searchString(mainString, searchString);
		
	}
	
	public static String rotateString(String mainString) {
		return mainString.substring(mainString.length()-1).concat(mainString.substring(0, mainString.length()-1));
	}
	
	public static boolean searchString(String mainString, String searchString) {
		int counter = 0;
		String subStr = "";
		boolean result = true;
		int rotateCounter = 0;
		
		while (rotateCounter < mainString.length()) {
			counter = 0;
			do {
				subStr = mainString.substring(counter, counter+3);
				System.out.println("substring : " + subStr);
				System.out.println("	search String : " + searchString);
				for (int i = 0; i < searchString.length(); i++) {
					if (searchString.substring(i, i+1).equalsIgnoreCase(subStr.substring(i, i+1))) {
						result = true;
						continue;
					} else {
						result = false;
						break;
					}
				}
				if (result == true) {
					break;
				} else {
					counter++;
				}
			} while ( counter <= (mainString.length()-searchString.length()));
				if (result == true) {
					break;
				} else {
					rotateCounter++;
					mainString = rotateString(mainString);	
				}
				
		};
		
		if (result == true) {
			System.out.println("found");
		} else {
			System.out.println("not found");
		}
		
		return result;
	}

}
