
import java.util.Scanner;

class Question4 {
	
	static int ans=1; // variable to hold the product of gcd of the all the possible subsets
	
	/**
	 * Function to calculate gcd of two no's
	 * @param a -> first no
	 * @param b -> second no
	 * @return	-> gcd of the function parameters
	 */
	int gcdOfTwoNO(int a, int b)
    {
        if (a == 0)
            return b;
        return gcdOfTwoNO(b%a, a);
    }
     
    /**
     * It is the recursive function to find the find gcd of n numbers.It basically computes the gcd of two no's and its gcd with third and so on
     * @param noArr -> subset with n integers whose gcd is to be found
     * @param n	-> no of elements in subset
     */
    void findGCD(int noArr[], int n)
    {
        int result = noArr[0];
        for (int i=1; i<n; i++)
            result = gcdOfTwoNO(noArr[i], result);
         
        ans=ans*result;
    }
    
    /**
     * the 2^n possible subsets can be represented in form ofbinary numbers from 0 - 2^n-1 (with n bits). If the bit is set then the no is in subset else not
     * @param set-> The array whose product of gcd of all possible subsets has to be found
     */
	void printSubsets(int set[])
    {
        int length = set.length;
        for (int i = 0; i < (1<<length); i++) // loop for making the possible 2^n possible subset
        {
            int [] subset=new int[length]; // make a subset array to add the no's to it 
        	int pos=0;
            for (int j = 0; j < length; j++)
            {
            	 if ((i & (1 << j)) > 0) // if true then add the no to the subset and increment the pos value
            	 {
            		 subset[pos]=set[j];
            		 pos++;
            	 }
            } 
            if(pos!=0) // if it is not the empty set then call the function to calculate the gcd of the subset 
            	findGCD(subset,pos);
 
        }
        
    }
	
	public static void main(String[] args)
    {
		Question4 ob=new Question4(); // object of the class
		int cases=0;					// no of cases
		Scanner scn=new Scanner(System.in);
		cases=scn.nextInt();
		scn.nextLine();
		int []case_size=new int[cases];
		int [][]case_values=new int[cases][]; // jagged arrays to hold the variable case_size of different cases
		for(int i=0;i<cases;i++){	// loop to read the values 
			case_size[i]=scn.nextInt();
			scn.nextLine();
			case_values[i]=new int[case_size[i]];
			for(int j=0;j<case_size[i];j++){
				case_values[i][j]=scn.nextInt();
			}
			scn.nextLine();
		}
		for(int i=0;i<cases;i++){
			ob.printSubsets(case_values[i]); // calling the suitable function for each case
			ans=(int) (ans%(Math.pow(10, 9)+7)); // taking modulus of the product generated
			System.out.println(ans);
			ans=1;								// initializing the ans for next test case
		}

    }
}
