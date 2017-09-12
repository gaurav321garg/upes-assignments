import java.util.*;
class UberPool{

	public static void main(String args[]){
	
		Scanner s = new Scanner(System.in);
		
		
		int[][] input=new int[5][2];
		
		//array Integer A
		
		System.out.println("Enter the starting point of the uber driver as per the cartesian co-ordinates(x,y)");
		String[] a=(br.readLine()).split(" ");
		input[0][0]=Integer.parseInt(a[0]);
		input[0][1]=Integer.parseInt(a[1]);
		
		//array Integer B
		
		System.out.println("Enter the destination of the uber as per the cartesian co-ordinates(x,y)");
		a=(s.readLine()).split(" ");
		input[1][0]=Integer.parseInt(a[0]);
		input[1][1]=Integer.parseInt(a[1]);
		
		//array Integer C
		
		System.out.println("Enter the point where the new requests are made as per the cartesian co-ordinates(x,y)");
		a=(s.readLine()).split(" ");
		input[2][0]=Integer.parseInt(a[0]);
		input[2][1]=Integer.parseInt(a[1]);
		
		//array Integer X
		
		System.out.println("Enter the position of the new customer X as per the cartesian co-ordinates(x,y)");
		a=(s.readLine()).split(" ");
		input[3][0]=Integer.parseInt(a[0]);
		input[3][1]=Integer.parseInt(a[1]);
		
		//array Integer Y
		
		System.out.println("Enter the position of the new customer Y as per the cartesian co-ordinates(x,y)");
		a=(s.readLine()).split(" ");
		input[4][0]=Integer.parseInt(a[0]);
		input[4][1]=Integer.parseInt(a[1]);
		
		int result=customerRequestSanction(input);
		System.out.println(result);	
	}
	
	
	int customerRequestSanction(int[][] in)
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