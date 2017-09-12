import java.util.*;

class Swanvayar{

	public static void main(String args[]) {
	
			Scanner s = new Scanner(System.in);
			int testCases = Integer.parseInt(s.readLine());
			int[] output=new int[testCases];
			
			for(int y=0;y<testCases;y++){

				int number=Integer.parseInt(s.readLine());
				
				int[] intArray=new int[number];
				String[] arr=(s.readLine()).split(" ");
				for(int i=0;i<umber;i++){
				intArray[i]=Integer.parseInt(arr[i]);
			}
			output[y]=gcdProduct(intArray,number);
			}
			
			
			for(int x=0;x<testCases;x++){
				
				System.out.println(output[x]);
			
			}
	}

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
					gcd= calGcd(c_row.get(j),gcd);
		
			result*=gcd;
		}
		
		
		return result%mod;
	}
	
	static int calGcd(int a,int b) {
		if(a==0)
            {return b;}
		else if(b==0)
			{return a;}
		else 
			{return calGcd(b%a, a);}
	}


}