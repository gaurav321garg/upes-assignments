import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.BigInteger;

public class Main
{
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		int t=in.nextInt();
		while(t>0)
		{
			int n=in.nextInt(); 
			BigInteger a[] = new BigInteger[n];
			for(int i=0;i<n;i++)
			{
				a[i]=in.nextBigInteger();
			}
			BigInteger A=in.nextBigInteger();
			BigInteger B=in.nextBigInteger();
			BigInteger C=in.nextBigInteger();
			in.nextLine();
			String str=in.nextLine();
			char[] ch=str.toCharArray();
			int len=ch.length;
			int dir = 0, head = 0, tail = n - 1;
            		BigInteger add = BigInteger.ZERO, mul = BigInteger.ONE;
			for(int i=0;i<len;i++)
			{
				if(ch[i]=='R')
				{dir^=1;}
				else if(ch[i]=='A')
				{ add = add.add(A).mod(C);}
				else
				{
				 add = add.multiply(B).mod(C);
            			 mul = mul.multiply(B).mod(C);
					
				}
				BigInteger current;
				if(dir==0)
				{
					current=a[head++];
				}
				else
				{
					current=a[tail--];
				}
				System.out.print(current.multiply(mul).mod(C).add(add).mod(C));
				if (i == n - 1) System.out.println();
            			else System.out.print(" ");
			}
			t--;
		}
	}
}