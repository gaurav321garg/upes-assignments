//Solution of Magic Trick
package q3;
import java.util.*;
public class Q3 {
    public static void main(String[] args) {
       int test;
       Scanner sc = new Scanner(System.in);
       test = sc.nextInt();    // number of test cases   
      
       int qq=0;
       while(qq<test)
       {           
           int n = sc.nextInt(); // size of array
           int list1[] = new int[n]; // numeric list array
           for(int j=0;j<n;j++)
           {
               list1[j] = sc.nextInt();
           }
           int a,b,c;
           // input value of a,b,c
           a=sc.nextInt(); 
           b=sc.nextInt(); 
           c=sc.nextInt(); 
           String ch = sc.next();
           char[] s=ch.toCharArray();
           // for loop for doing operations on M A R
           for(int k=0;k<n;k++)
           {
               if(s[k]=='M')
               {
                   for(int x=0;x<n;x++)     //     multiply all values of list1 to b
                    {
                        list1[x] = b*list1[x]; 
                        
                    } 
               } 
               else if(s[k]=='A')   // add value of a in list1
               {
                  for(int x=0;x<n;x++)
                    {
                        list1[x] = a+list1[x];
                         
                    } 
               } 
               else if(s[k]=='R') // reversing the array
               {
                   int m=n-1;
                   int nn=0;
                  while (nn <= m) 
                    {
                       int temp = list1[m];
                       list1[m] = list1[nn];
                       list1[nn] = temp;
                       m--;             
                       nn++;         
                    }   
                 
               } 
               else 
               {
                   System.exit(0);
               }
            }
           // doing modulus by c finally
           for(int z=0;z<n;z++)
           {
              list1[z]=list1[z]%c; 
           }        
           
          // printing
           for(int p=0;p<n;p++)
            {  
             System.out.print(list1[p]+"\t");  
            }  
           System.out.print("\n");
           qq++;
       }
       
    }    
}
