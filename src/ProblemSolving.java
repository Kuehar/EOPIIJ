import java.util.Collections;
import java.util.List;

public class ProblemSolving {
	
	
	/*
	 * This function is for searching smallest number which is not to the sum of a subset of elements  of the array.  
	 * N is the length of array, Time complexity is O(nlogn)
	 */
	public static int smallestNonconstructibleValue(List<Integer> A) {
	    Collections.sort(A);
	    int maxConstructibleValue = 0;
	    for(int a: A){
	        if(a > maxConstructibleValue+1){
	            break;
	        }
	        maxConstructibleValue += a;
	    }    
	    return maxConstructibleValue+1;
	}	
}
