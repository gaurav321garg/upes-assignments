import java.util.*;
import java.lang.*;
import java.io.*;

class Ideone
{
	public static int mod=(int)(1e9+7);
	public static int mod1=(int)(1e9+6);
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner in=new Scanner(System.in);
		int t=in.nextInt();
		while(t>0)
		{
			int n=in.nextInt();
			long[] a1=new long[100005];
			long[] b=new long[100005];
			ArrayList<Integer>[] L=new ArrayList[100005];
			 for(int i=0;i<L.length;i++)
			 {
            			L[i]=new ArrayList<>();
            		 }
            
			 for(int i=2;i<L.length;i++)
            		{
            			int j=i;
            			while(j<L.length)
            			{
            			  L[j].add(i);
            			  j+=i;
            			}
            		}
            
            		for(int i=0;i<n;i++)
            		{
            			int a=in.nextInt();
            		for(int j=0;j<L[a].size();j++)
            		{
            			a1[L[a].get(j)]++;
            		}
            	}
            	long answer=1;
            	for(int i=100000;i>1;i--)
            	{
            		int j=i;
            		long r=0;
            		while(j<L.length)
            		{
            			r+=b[j];
            			r%=mod1;
            			j+=i;
            		}
            	long tmp=pow(2, a1[i], mod1)-1;
            	tmp=(tmp-r+mod1)%mod1;
            	b[i]=tmp;
            	}
            
            	for(int i=2;i<L.length;i++)
            	{
            	answer=(answer*pow(i, b[i], mod))%mod;
            	}
            		System.out.println(answer);
			t--;
		}
	}
	    public static long pow(long n,long p,long m){
	 long  result = 1;
	  if(p==0)
	    return 1;
	if (p==1)
	    return n;
	while(p!=0)
	{
	    if(p%2==1)
	        result *= n;
	    if(result>=m)
	    result%=m;
	    p >>=1;
	    n*=n;
	    if(n>=m)
	    n%=m;
	}
	return result;
    }
}