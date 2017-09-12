

/* 
This code is created for Digicred round-1 programming
	
	by-Harshit Kashyap
	email- kashyap.harshit14@stu.upes.ac.in
	
*/

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.*;

class Q4{

	public static void main(String dt[]) {
	
			
			InputStreamReader isr;
			BufferedReader br;
		
			isr = new InputStreamReader(System.in);
			br=new BufferedReader(isr);
			
		try{
			
			// input number of test case
			
			int test = Integer.parseInt(br.readLine());
			int[] output=new int[test];
			
			for(int y=0;y<test;y++){
				
				// input <space> seperated number in the integer array
				int number=Integer.parseInt(br.readLine());
				
				int[] intArray=new int[number];
				String[] arr=(br.readLine()).split(" ");
				for(int i=0;i<number;i++){
				intArray[i]=Integer.parseInt(arr[i]);
			}
			
				// get output in the output array
				
			output[y]=gcdProduct(intArray,number);
			}
			
			
			for(int x=0;x<test;x++){
				
				System.out.println(output[x]);
			
			}
		
		}
		catch(Exception e){
		
			System.out.println(e);
		}
		finally{
			
			try{
				br.close();
				isr.close();
			}
			catch(Exception e){
				System.out.println(e);
			}
		}
	}
	
	//this method calculates calculates GCD product of each subset of the passed array
	
	static int gcdProduct(int[] intArray, int n) {
	
		int mod=(int)(1e9+7);
		int result=1;
		int combinations=(int)Math.pow(2,n);


		List<List<Integer>> Sets = new ArrayList<List<Integer>>();
		List<Integer> c_row ;
		int gcd;
		
		
		for(int i=0;i<(1<<n);i++){
			c_row = new ArrayList<Integer>();
			for(int j=0;j<n;j++)
	               if((i&(1<<j))> 0)
	            	   c_row.add(intArray[j]);  
			 Sets.add(c_row);
		}
		
		
		for(int i=1;i<combinations;i++){          
			c_row=Sets.get(i);               
			gcd=c_row.get(0);            
			for (int j=1;j<c_row.size();j++)
					gcd= calGCD(c_row.get(j),gcd);
		
			result*=gcd;
		}
		
		
		return result%mod;
	}
	
	// this methods calculates GCD of sub arrays
	
	static int calGCD(int a,int b) {
		if(a==0)
            {return b;}
		else if(b==0)
			{return a;}
		else 
			{return calGCD(b%a, a);}
	}


}