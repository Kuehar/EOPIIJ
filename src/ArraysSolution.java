import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArraysSolution {
	
	/*
	 * This algorithm is for reordering arrays in order of odd to even without additional array.
	 * Time complexity is O(n).
	 */
	public static void evenOdd(int[] A) {
		int nextEven = 0,nextOdd = A.length-1;
		while(nextEven < nextOdd) {
			if(A[nextEven] % 2 == 0) {
				nextEven++;
			}else {
				int temp = A[nextEven];
				A[nextEven] = A[nextOdd];
				A[nextOdd--] = temp;
			}
		}
	}
	
	/*
	 * Function which takes as input an array of digits encoding a decimal number D and updates the array to represent the number D+1
	 * Time complexity is O(N), where n is the length of A
	 */
	public static List<Integer> plusOne(List<Integer> A){
		int n = A.size()-1;
		A.set(n,A.get(n)+1);
		for(int i=n;i>0 && A.get(i) == 10; --i) {
			A.set(i, 0);
			A.set(i-1,A.get(i-1)+1);
		}
		if(A.get(0) == 10) {
			// Need additional digit as the most significant digit (i.e., A.get(0))
			// has a carry-out.
			A.set(0,0);
			A.set(0,1);
			}
		return A;
		}
	
	/*
	 * Program that takes two arrays representing integers and returns an intefer representing their product.
	 */
	public static List<Integer> multiply(List<Integer> num1, List<Integer> num2){
		final int sign = num1.get(0) < 0 ^ num2.get(0) < 0 ? -1 : 1;
		num1.set(0,Math.abs(num1.get(0)));
		num2.set(0,Math.abs(num2.get(0)));
		
		List<Integer> result = new ArrayList<>(Collections.nCopies(num1.size()+num2.size(), 0));
		for(int i=num1.size()-1;i>=0;--i) {
			for(int j=num2.size()-1;j>=0;--j) {
				result.set(i+j+1,result.get((i+j+1)+num1.get(i)*num2.get(j)));
				result.set(i+j,result.get(i+j)+result.get(i+j+1)/10);
				result.set(i+j+1,result.get(i+j+1)%10);
			}
		}
		// Remove the leading zeros.
		int first_not_zero = 0;
		while(first_not_zero < result.size() && result.get(first_not_zero) == 0) {
			++first_not_zero;
		}
		result = result.subList(first_not_zero, result.size());
		if(result.isEmpty()) {
			return Arrays.asList(1);
		}
		result.set(0,result.get(0)*sign);
		return result;
	}
	
	/*
	 * Program that takes an array of n integers, where A[i] denotes the maximum you can advance from index i, and returns whether it is possible to advance to the last index starting from the beginning of the array. 
	 * Time Complexity O(N)
	 */
	public static boolean canReachEnd(List<Integer> maxAdvanceSteps) {
		int furthestReachSoFar = 0,lastIndex = maxAdvanceSteps.size()-1;
		for(int i=0;i <= furthestReachSoFar && furthestReachSoFar < lastIndex;++i) {
			furthestReachSoFar = Math.max(furthestReachSoFar, i+maxAdvanceSteps.get(i));
		}
		return furthestReachSoFar >= lastIndex;
	}
	
}
