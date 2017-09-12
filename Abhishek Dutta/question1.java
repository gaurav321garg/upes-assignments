//Question 1
//Abhishek Dutta
//B.Tech CSE CCVT 4th Year, UPES Dehradun

import java.util.*;
public class question1 {

	static int calculate(int A[],int B[],int C[],int X[],int Y[])
	{
		int o_length = Math.abs(B[0]-A[0]) + Math.abs(B[1]-A[1]); //Find original length from A to B without pickup
		
		int to_c = Math.abs(C[0]-A[0]) + Math.abs(C[1]-A[1]); //Find distance from A to intermediate point C
		
		int cx = Math.abs(C[0]-X[0]) + Math.abs(C[1]-X[1]); //Distance between intermediate point C and passenger X
		
		int cy = Math.abs(C[0]-Y[0]) + Math.abs(C[1]-Y[1]); //Distance between intermediate point C and passenger Y
		
		int xb = Math.abs(X[0]-B[0]) + Math.abs(X[1]-B[1]); //Distance between pickup of X and destination 
		
		int yb = Math.abs(Y[0]-B[0]) + Math.abs(Y[1]-B[1]); //Distance between pickup of Y and destination
		
		if((to_c + cx + xb > 2*o_length) || (to_c + cy + yb > 2*o_length)) //Case where length of trip > than length of direct trip from A to B
			return -1;
		
		else if (to_c +cx + xb == to_c + cy + yb) //If both distance are equal, choose X(first passenger)
			return 1;
		
		else if (to_c + cx + xb  < to_c + cy + yb) //Distance after picking up X is smaller
		{
			return 1;
		}
			
		else	//Distance after picking up Y is smaller 
		{
			return 2;
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int departure[] = new int[2];
		int destination[] = new int[2];
		int inter[] = new int[2];
		int f_req[] = new int[2];
		int s_req[] = new int[2];
		Scanner sc = new Scanner(System.in);
		//Enter coordinates in the following order: point A, point B, point C, point X, point Y
		departure[0] = sc.nextInt();
		departure[1] = sc.nextInt();
		destination[0] = sc.nextInt();
		destination[1] = sc.nextInt();
		inter[0] = sc.nextInt();
		inter[1] = sc.nextInt();
		f_req[0] = sc.nextInt();
		f_req[1] = sc.nextInt();
		s_req[0] = sc.nextInt();
		s_req[1] = sc.nextInt();
		//Print result below
		System.out.println(calculate(departure,destination,inter,f_req,s_req));
		
	}

}
