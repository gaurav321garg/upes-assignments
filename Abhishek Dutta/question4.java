//Question 4
//Abhishek Dutta
//B.Tech CSE CCVT 4th Year, UPES Dehradun

import java.util.*;
public class question4 {

	static int gcd(int a, int b)
    {
        if (a == 0)
            return b;
        return gcd(b%a, a);
    }
     
    // Function to find gcd of array of
    // numbers
    static int findGCD(ArrayList<Integer> list, int n)
    {
    	int[] ret = new int[list.size()];
        for (int i=0; i < ret.length; i++)
        {
            ret[i] = list.get(i).intValue();
        }
        
        int result = ret[0];
        for (int i=1; i<n; i++)
            result = gcd(ret[i], result);
         
        return result;
    }
    
	// Print all subsets of given set[]
    static void printSubsets(int arr[])
    {
    	int prod = 1;
        int n = arr.length; 
        ArrayList<Integer> temp = new ArrayList<Integer>(n); //Temporary array for each subset
        
        for (int i = 1; i < (1<<n); i++)
        {
            // Calculate elements of each subset using AND operation and binary left shift
            for (int j = 0; j < n; j++)
            {
                
                if ((i & (1 << j)) > 0)
                {
                	temp.add(arr[j]); //Add subset element to a temporary ArrayList
                }
            }
            prod = prod * findGCD(temp, temp.size()); //calculate products of GCDs of each subset
            temp.clear(); //Reset temporary ArrayList
            
        }
        System.out.println(prod % 1000000007);
    }
    
    public static void main(String[] args)
    {
    	int T, N; //T denotes number of test cases and N denotes number of elements in the set
    	Scanner sc = new Scanner(System.in);
    	T = sc.nextInt();    	
    	while(T!=0)
    	{
    		N = sc.nextInt();
    		int nums[] = new int[N];
    		for(int i=0;i<N;i++)
    		{
    			nums[i] = sc.nextInt();
    		}    		
    		printSubsets(nums);
    		T--; //Decrement test cases
    		
    	}
    }
}
