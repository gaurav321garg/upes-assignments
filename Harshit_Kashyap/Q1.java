
/* 
This code is created for Digicred round-1 programming
	
	by-Harshit Kashyap
	email- kashyap.harshit14@stu.upes.ac.in
	
*/


import java.io.InputStreamReader;
import java.io.BufferedReader;

class Q1{

	public static void main(String dt[]){
	
		InputStreamReader dis;
		BufferedReader br;
		
		try{
		dis=new InputStreamReader(System.in);
		br=new BufferedReader(dis);
		
		// input 2-D array
		int[][] input=new int[5][2];
		
		// input space seperated co-ordinates of A
		
		System.out.println("Starting point as x co-ordinate <space> y co-ordinate-");
		String[] a=(br.readLine()).split(" ");
		input[0][0]=Integer.parseInt(a[0]);
		input[0][1]=Integer.parseInt(a[1]);
		
		// input space seperated co-ordinates of B
		
		System.out.println("Ending point as x co-ordinate <space> y co-ordinate-");
		a=(br.readLine()).split(" ");
		input[1][0]=Integer.parseInt(a[0]);
		input[1][1]=Integer.parseInt(a[1]);
		
		// input space seperated co-ordinates of C
		
		System.out.println("Deviation Point point as x co-ordinate <space> y co-ordinate-");
		a=(br.readLine()).split(" ");
		input[2][0]=Integer.parseInt(a[0]);
		input[2][1]=Integer.parseInt(a[1]);
		
		// input space seperated co-ordinates of X
		
		System.out.println("Customer X position as x co-ordinate <space> y co-ordinate-");
		a=(br.readLine()).split(" ");
		input[3][0]=Integer.parseInt(a[0]);
		input[3][1]=Integer.parseInt(a[1]);
		
		// input space seperated co-ordinates of Y
		
		System.out.println("Customer Y position as x co-ordinate <space> y co-ordinate-");
		a=(br.readLine()).split(" ");
		input[4][0]=Integer.parseInt(a[0]);
		input[4][1]=Integer.parseInt(a[1]);
		
		int output=selectCustomer(input);
		System.out.println(output);
	
		}
		catch(Exception e){
			System.out.println(e);
		}
		finally{
			try{
				
			}
			catch(Exception e){
				System.out.println(e);
			}
			
		}
	
	
	}
	
	//this method selects the customer that will take shortest path
	
	static int selectCustomer(int[][] in)
	{
		int x=Math.abs(in[3][0]-in[2][0])+Math.abs(in[3][1]-in[2][1]);
		int y=Math.abs(in[4][0]-in[2][0])+Math.abs(in[4][1]-in[2][1]);
		if(x<=y)
		{
			return 1;
		}
		else if(x>y)
		{
			return 2;
		}
		else{
			return -1;
		}
		
		
		
	}


}