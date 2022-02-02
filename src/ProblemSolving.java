import java.util.Collections;
import java.util.List;

public class ProblemSolving {
	
	
	/*
	 * This function is for searching smallest number which is not to the sum of a subset of elements of the array.  
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
	
	
	/*
	 * to count the number of bits that are set to 1 in an integer is a good way to get up to speed with primitive type
	 * Time complexity is O(n).
	 */
	public static short countBits(int x) {
		short numBits = 0;
		while(x != 0) {
			numBits += (x & 1);
			x >>>= 1;
		}
		return numBits;
	}
	
	/*
	 * Straightforward implementation of parity check.parity checks are used to detect single bit errors in data storage and communication.
	 */
	public static short parity(long x) {
		short result = 0;
		while(x != 0) {
			result ^= 1;
			x &= (x-1); // Drops the lowest set bit of x.
		}
		return result;
	}
}
