import java.util.List;

public class Arrays {
	
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
	 * 
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
}
