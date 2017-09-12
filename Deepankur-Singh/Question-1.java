
import java.util.*;
import java.lang.*;
import java.io.*;


class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		int[] A=new int[2];
		int[] B=new int[2];
		int[] C=new int[2];
		int[] X=new int[2];
		int[] Y=new int[2];
		Scanner in=new Scanner(System.in);
		// Take input for every value;
		A[0]=in.nextInt();
		A[1]=in.nextInt();
		B[0]=in.nextInt();
		B[1]=in.nextInt();
		C[0]=in.nextInt();
		C[1]=in.nextInt();
		X[0]=in.nextInt();
		X[1]=in.nextInt();
		Y[0]=in.nextInt();
		Y[1]=in.nextInt();
		// call the function to compare the distances
		int ans=Dis(A,B,C,X,Y);
		System.out.print(ans);// print the answers
	}
	static int Dis(int[] a,int[] b,int[] c,int[] x,int[] y)
	{
		int od=Math.abs(a[0]-b[0])+Math.abs(a[1]-b[1]);//Original distance od
		int dt=Math.abs(a[0]-c[0])+Math.abs(a[1]-c[1]);//Distance travelled dt
		int dx=Math.abs(x[0]-c[0])+Math.abs(x[1]-c[1])+Math.abs(x[0]-b[0])+Math.abs(x[1]-b[1])+dt;// distance from xMath.abs(x[0]-c[0])+Math.abs(x[1]-c[1])+Math.abs(x[0]-b[0])+Math.abs(x[1]-b[1]);// distance from x

		int dy=Math.abs(y[0]-c[0])+Math.abs(y[1]-c[1])+Math.abs(y[0]-b[0])+Math.abs(y[1]-b[1])+dt;// distance from x
		if(2*od>=dx||dy<=2*od)
		{
			if (dx <= dy && dx > od && dy > od)
			{return 1;}
		else if (dx > dy && dx > od && dy > od)
			{return 2;}
		else
			{return -1;}
		}
		else
		{return -1;}
	}
}