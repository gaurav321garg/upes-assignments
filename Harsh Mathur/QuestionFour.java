/**
 * The QuestionFour implements GCD to find the product of GCD's of all possible subsets
 * of an given array
 * 
 * @author Harsh Mathur
 */
import java.util.*;
public class QuestionFour {
	
	/**
	 * This function returns the Greatest common divisor of two numbers
	 * @param a Number need to be compared
	 * @param b Number need to be compared
	 * @return Greatest common divisor of a and b
	 */
	static long gcd(long a, long b) {
		if (a == 0)
            return b;
		else if (b == 0)
			return a;
		else 
			return gcd(b%a, a);                        // use of recursion to find GCD of 2 values
	}
	
	
	/**
	 * This function first makes all sub-sets including empty subset from passed array
	 * then for each subset GCD is calculated
	 *  
	 * @param arr Given array (super set)
	 * @param n Length of array
	 * @return product of GCD of each sub-set
	 */
	static long getGCDProduct(int[] arr, int n) {
		int modulo = (int) (1e9 + 7);                  // modulus final answer to maker value small
		long ans = 1;                                  // initialize product of GCD's with 1
		int possibleComb = (int) Math.pow(2, n);       // maximum number of subsets possible of a given set
		List<List<Integer>> allSets = new ArrayList<List<Integer>>();       //2D ArrayList to store each subset as a list of list
		List<Integer> current_row ;                    // to store 1 list from 2D ArrayList at a time
		long gcd_of_row;                               // to store GCD of current row
		
		// performing bit wise shift to get all combinations of elements in array
		for (int i = 0; i < (1<<n); i++){
			current_row = new ArrayList<Integer>();
			for (int j = 0; j < n; j++)
	               if ((i & (1 << j)) > 0)
	            	   current_row.add(arr[j]);        // add each element to current_row
			 allSets.add(current_row);				   // add each current_row to allSets list
		 }
		
		for(int i = 1; i < possibleComb; i++){         // Start i from 1 to ignore empty-set
			current_row = allSets.get(i);              // select one row (sub set) at a time
			gcd_of_row = current_row.get(0);           // choose 1st value of each sub-set as initial GCD
			for (int j=1; j<current_row.size(); j++)
					gcd_of_row = gcd(current_row.get(j), gcd_of_row);    //compare elements of a sub-set in pairs
		
			ans *= gcd_of_row;						   // Get GCD multiplied to final answer
		}
		return ans%modulo;							   // If answer is too big
	}
	
	
	/**
	 * This main function makes the use of method getGCDProduct to get the product of
	 * GCD's of each sub-set for the given array of Integers
	 * 
	 * @param args Unused
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of test cases");
		int t = sc.nextInt();						   // accept number of test cases needs to be tested			
		for(int j = 0; j < t; j++){
			System.out.println("Enter the length of Array");
			int N = sc.nextInt();					   // accept length of array
			int[] arr = new int[N];
			System.out.println("Enter "+N+" elements :");
			for(int i = 0; i < N; i++){
				arr[i] = sc.nextInt();
			}
			System.out.println(getGCDProduct(arr, N)); 
		}
		sc.close();
	}
}
