// Q4 - Devsana
package q4;
import java.util.*;
public class Q4 {
    // find highest common factor
    int gcd(int a, int b)
    {
        if (a == 0)
            return b;
        return gcd(b%a, a);
    }    
    int hcf(ArrayList<Integer> arr, int n)
    {    if(arr.isEmpty())
           {return 1;  }
        int result=arr.get(0);
        for (int i=1; i<n; i++)
            result = gcd(arr.get(i), result);
               
        return result;
    }
    // find combinations
     int printSubsets(int set[])
    {   int x=1;
        int n = set.length; 
       
        for (int i = 0; i < (1<<n); i++)
        {            
            ArrayList<Integer> aa = new ArrayList<Integer>();
           
            for (int j = 0; j < n; j++)
            {                              
                if ((i & (1 << j)) > 0)
                {
                    aa.add(set[j]);
                    //System.out.print(set[j]+" ");
                }                
            }
            int size = aa.size();
            x*=hcf(aa,size);            
        }
        //System.out.println(x);
        
        return x;
    }
    
    public static void main(String[] args) {
        Q4 q = new Q4();
        int test;
        Scanner sc = new Scanner(System.in);
        test = sc.nextInt();
        int hold[] = new int[test];
        for(int i=0;i<test;i++)
        {
            int size = sc.nextInt();
            int arr[] = new int[size];
            for(int j=0;j<size;j++)
            {
                arr[j] = sc.nextInt();
            }
            hold[i]=q.printSubsets(arr);
        }
        
        for(int i=0;i<test;i++)
        {
            System.out.println(hold[i]);
        }
    }
    
}
