package hackerRank;

public class RecursionReverseString {

    String str; //holds the input value
    char[] chars; //to hold the to char array for the given str

    public RecursionReverseString(String s) {
        str = s;
        chars = str.toCharArray();
        reverseString(chars); //calls the reverse string function
    }

    public void reverseString(char[] chars){
        System.out.println(reverse(chars, 0, chars.length-1));  //calls the in-place string reversal function
    }

    public char[] reverse(char[] ch, int sIndex, int eIndex) {

        char c;

        c = ch[sIndex];  //swap the characters at the given start and end index positions
        ch[sIndex] = ch[eIndex];
        ch[eIndex] = c;

        sIndex++; //increase the start index by one to swap the next pair of characters
        eIndex--; //decrease the end index by one to swap the next pair of characters

        if ( sIndex < eIndex ) {  //make a recursive call till the string is fully reversed.
            reverse(ch,sIndex,eIndex);
        }

        return ch; //return the reversed string

    }

    public static void main(String[] args) {
        RecursionReverseString rrs = new RecursionReverseString("abhishek");
    }

}
