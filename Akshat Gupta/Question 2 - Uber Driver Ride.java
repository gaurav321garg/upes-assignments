// Uber driver request
package q2;

import java.util.Scanner;

public class Q2 {public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int travelTime[]= new int[n];
    int readyTime[]= new int[n];
    int cancelTime[]= new int[n];
    int calcuate=0;
    for(int i=0;i<n;i++)
    {
        travelTime[i] = sc.nextInt();
    }
    for(int i=0;i<n;i++)
    {
        readyTime[i] = sc.nextInt();
    }
    for(int i=0;i<n;i++)
    {
        cancelTime[i] = sc.nextInt();
    }
    for(int i=0;i<n-1;i++)
    {
        int cancel = cancelTime[i+1]-cancelTime[i];
        if(cancel<0)
        {
            cancel=-(cancel);
        }
        int ready = readyTime[i+1]-readyTime[i];
        if(ready<0)
        {
            ready=-(ready);
        }
        int travel = travelTime[i+1]-travelTime[i];
        if(travel<0)
        {
            travel=-(travel);
        }
        if(cancelTime[i]>readyTime[i])
        {
            //ride will be canceled
        }
        calcuate=calcuate+travelTime[i];
    }
    if(calcuate<=(86400))
    {
        System.out.println(calcuate);
    } else {
        System.out.println("Unorganised Schedule");
    }
    }
    
}
