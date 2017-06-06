package hackerRank;

public class InsSort{
	  public static void main(String a[]){
	  int i;
	  int array[] = {5,4,3,2,1,0};
	  System.out.println("\n\n RoseIndia\n\n");
	  System.out.println(" Selection Sort\n\n"); 
	  System.out.println("Values Before the sort:\n");  
	  for(i = 0; i < array.length; i++)
	  System.out.print( array[i]+"  ");
	  System.out.println();
	  insertion_srt(array, array.length);  
	  System.out.print("Values after the sort:\n");  
	  for(i = 0; i <array.length; i++)
	  System.out.print(array[i]+"  ");
	  System.out.println(); 
	  System.out.println("PAUSE"); 
	  }

	  public static void insertion_srt(int array[], int n){
	  for (int i = 1; i < n; i++){
	  int j = i;
	  int B = array[i];
	  while ((j > 0) && (array[j-1] > B)){
	  array[j] = array[j-1];
	  j--;
	  }
	  array[j] = B;
	  }
	  }
	}