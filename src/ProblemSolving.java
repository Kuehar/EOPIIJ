import java.util.Collections;
import java.util.List;

public class ProblemSolving {
	public static int smallestNonconstructibleValue(List<Integer> A) {
	    Collections.sort(A);
	    int maxConstructibleValue = 0;
	    for(int a: A){
	        if(a > maxConstructibleValue+1){
	            break;
	        }
	    }    
	    return maxConstructibleValue+1;
	}
	
	
}
