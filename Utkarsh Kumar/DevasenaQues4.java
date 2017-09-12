import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
class DevasenaQues4{

	/*******************FastReader Template***************************/
	//the methods of this class will be used for any input in this program 
	//considering the faster operations time when compared to Scanner or BufferedReader classes
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader(){
            br = new BufferedReader(new
                     InputStreamReader(System.in));
        }
 
        String next(){
            while (st == null || !st.hasMoreElements()){
                try{
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int nextInt(){
            return Integer.parseInt(next());
        }
 
        long nextLong(){
            return Long.parseLong(next());
        }
 
        double nextDouble(){
            return Double.parseDouble(next());
        }
 
        String nextLine(){
            String str = "";
            try{
                str = br.readLine();
            }
            catch (IOException e){
                e.printStackTrace();
            }
            return str;
        }
    }
 /****************** END OF TEMPLATE **********************/

 /*******************Actual Program************************/
 //The following program is a direct implementation of the given scenario
 // further it can be optimized to reduce the time complexity of overall execution

 //defining global variables for operation in subseqent functions
 static long gcd;
 static int m = (int)(1e9 + 7);

 //the following function calculates the GCD of two numbers by Euclid Theorem
 //as the inputs can be very large numbers
 //the time complexities must be optimal
 static long eGCD(long x, long y){
 	if(x == 0)
 		return y;
 	else
 		return eGCD(y%x,x);
 }

 //method to calulate GCD and superset
 static void compute(int[] arr){
 	int n = arr.length;
 	 long fGCD = 1;

 	//creating the superset, to contain all the possible outcomes
 	List<List<Integer>> superSet = new ArrayList<List<Integer>>();
 	//decclaring the subset variable
 	List<Integer> subSet;
 	
 	//now performing the calculation of all the subsets based on the fact 
 	//that every subset is analogous to the binary numbers from 0 to 15
 	//algorithm performs the validation of all 2^n subsets
	for(int i = 0; i < (1<<n); i++){
 		subSet = new ArrayList<Integer>();
 	
 	// (1<<j) is a number with jth bit 1
    // so when we 'and' them with the
    // subset number we get which numbers
    // are present in the subset and which
    // are not
 	for(int j = 0; j < n; j++){
 		if((i & (1 << j)) > 0)
 			subSet.add(arr[j]);}
 		superSet.add(subSet);
 }	
 	int totalSet = (int)Math.pow(2,n);

 	//now the algorithm performs the calculation of GCD of
 	//all the possible subsets, the first element of the 
 	//superset is not taken as it is empty
 	for(int i = 1; i < totalSet; i++){
 		subSet = superSet.get(i);
 		gcd = subSet.get(0);

 		//GCD of each individual elements of the set is calculated
 		for(int j = 1; j < subSet.size(); j++){
 			gcd = eGCD(subSet.get(j), gcd);
 		}
 		//final GCD obtained
 		fGCD = fGCD*gcd;
 	}

 	//optimizing the solution in case of very large values and printing
 	System.out.println((fGCD)%m);
 }

 	//main method
	public static void main(String args[]){

	//FastReader class invoked
	FastReader fs = new FastReader();
	//test cases accepted
	int tc = fs.nextInt();
	for(int q = 0; q<tc; q++){
	//arrayy size accepted
	int n = fs.nextInt();
	int[] arr = new int[n];
	//array elements accepted
	for(int w = 0; w < n; w++){
	arr[w] = fs.nextInt();
	}
	//static method called
		compute(arr);
	}
	}
}
