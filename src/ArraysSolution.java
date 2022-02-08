import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

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
	/*
	 * Delete duplicates from Array.
	 * Time complexity is O(n).
	 */
	
	public static int deleteDuplicates(List<Integer> nums) {
		if(nums.isEmpty()) {
			return 0;
		}
		
		int writeIndex = 1;
		for(int i=1;i<nums.size();++i) {
			if(!nums.get(writeIndex-1).equals(nums.get(i))){
				nums.set(writeIndex++,nums.get(i));
			}
		}
		return writeIndex;
		}
	/*
	 * Program that takes Arrays that consists of stock prices and return max profit that could be made by buying and then selling one share of that stock.
	 * Time complexity is O(n)
	 */
	public static double computeMaxProfit(List<Double> prices) {
		// double minPrice = Double.MAX_VALUEはPythonでいうINFのようなもので、for文の最初では必ずprice-minPriceを代入するための仕組み
		double minPrice = Double.MAX_VALUE,maxProfit = 0.0;
		for(Double price: prices) {
			maxProfit = Math.max(maxProfit,price-minPrice);
			minPrice = Math.min(minPrice, price);
		}
		return maxProfit;
	}
	
	public static double buyAndSellStockTwice(List<Double> prices) {
		double maxTotalProfit = 0.0;
		List<Double> firstBuySellProfits = new ArrayList<>();
		double minPriceSoFar = Double.MAX_VALUE;
		
		// Forward phase. for each day, we record maximum profit if we sell on that day.
		for(int i=0;i < prices.size();++i) {
			minPriceSoFar = Math.min(minPriceSoFar, prices.get(i));
			maxTotalProfit = Math.max(maxTotalProfit, prices.get(i)-minPriceSoFar);
			firstBuySellProfits.add(maxTotalProfit);
		}
		
		// Backword phase. for each day,find the maximum profit if we make the second buy on that day.
		double maxPriceSoFar = Double.MIN_VALUE;
		for(int i=prices.size()-1;i>0;--i) {
			maxPriceSoFar = Math.max(maxPriceSoFar, prices.get(i));
			maxTotalProfit = Math.max(maxTotalProfit, maxPriceSoFar-prices.get(i)+firstBuySellProfits.get(i-1));
		}
		return maxTotalProfit;
	}
	
	/*
	 * Program that takes integer argument and returns all the primes between 1 and that integer.
	 * Time complexity is O(nloglogn).
	 */
	
	// Given nums,return all primes up to and including n.
	public static List<Integer> generatePrimes(int num){
		List<Integer> primes = new ArrayList<>();
		// isPrime.get(p) represents if p is prime or not. Initially, set each to true, expecting 0 and 1. Then use sieving to eliminate nonprimes.
		List<Boolean> isPrime = new ArrayList<>(Collections.nCopies(num+1, true));
		isPrime.set(0,false);
		isPrime.set(1,false);
		
		for(int p=2;p<=num;++p) {
			if(isPrime.get(p)) {
				primes.add(p);
				for(int j=p;j<=num;j+=p) {
					isPrime.set(j,false);
				}
			}
		}
		return primes;
	}
	
	/*
	 *  Arranged program that takes integer argument and returns all the primes between 1 and that integer.
	 */
	public static List<Integer> arrangedGeneratePrimes(int num){
		final int size = (int)Math.floor(0.5*(num-3)) + 1;
		List<Integer> primes = new ArrayList<>();
		primes.add(2);
		
		List<Boolean> isPrime = new ArrayList<>(Collections.nCopies(size, true));
		for(int i=0;i<size;++i) {
			if(isPrime.get(i)) {
				int p = ((i*2)+3);
				primes.add(p);
				for(long j=((i*i)*2)+6*i+3;j<size;j+=p) {
					isPrime.set((int)j, false);
				}
			}
		}
		return primes;
	}	
	/*
	 * Program that takes an Array A and an index i into A, and rearranges the elements suchh that all elements less than A[i] appear first, followed by elements equal to the pivot,followed by elements greater than pivot.
	 */
	
	public static enum Color{RED,WHITE,BLUE}
	
	public static void dutchFlagPartition(int pivotIndex,List<Color> A) {
		Color pivot = A.get(pivotIndex);
		// First pass: group elements smaller than pivot
		for(int i=0;i<A.size();++i) {
			// Look for a smaller element.
			for(int j=i+1;j<A.size();++j) {
				if(A.get(i).ordinal() < pivot.ordinal()) {
					Collections.swap(A,i,j);
					break;
				}
			}
		}
		// Second pass: group elements larger than pivot.
		for(int i=A.size()-1;i>=0 && A.get(i).ordinal() >= pivot.ordinal();--i) {
			// Look for a larger element. Stop when we reach an element less than pivot. since first pass has moved them to the start of A.
			for(int j=i-1;j>=0 && A.get(j).ordinal() >= pivot.ordinal();--j) {
				if(A.get(j).ordinal() > pivot.ordinal()) {
					break;
				}
			}
		}
	}
	
	public static void applyPermutation(List<Integer> perm,List<Integer> A) {
		for(int i=0;i<A.size();++i) {
			int next = i;
			while(perm.get(next)>=0) {
				Collections.swap(A, i,perm.get(i));
				int temp = perm.get(next);
				perm.set(next, perm.get(next)-perm.size());
				next = temp;
			}
		}
		for(int i=0;i<perm.size();i++) {
			perm.set(i, perm.get(i)+perm.size());
		}
	}
	public static void randomSampling(int k,List<Integer> A) {
		Random gen = new Random();
		for(int i=0;i<k;++i) {
			// Generate a random int in [i,A.size()-1]
			Collections.swap(A, i, i+gen.nextInt(A.size()-i));
		}
	}
	
}
