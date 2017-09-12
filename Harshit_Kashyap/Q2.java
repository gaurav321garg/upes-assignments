

/* 
This code is created for Digicred round-1 programming
	
	by-Harshit Kashyap
	email- kashyap.harshit14@stu.upes.ac.in
	
*/

import java.util.*;

public class Q2
{
	 public static void main(String dt[])
    {
		
			Scanner sc=new Scanner(System.in);
			
		try{
	   
			//input number of customers-
			
			System.out.println("Enter number of customers-");
			int number=sc.nextInt();
			
			//input travel time array
			int[] travelTime=new int[number-1];
			for(int i=0;i<number-1;i++)
			{
			System.out.println("Enter travel time-");
			travelTime[i]=sc.nextInt();
			}
	   
			//input ready time array
	   
			int[] readyTime=new int[number];
			for(int i=0;i<number;i++)
			{
			System.out.println("Enter ready time time-");
			readyTime[i]=sc.nextInt();
			}
	   
			//input cancel time array
	   
			int[] cancelTime=new int[number];
			for(int i=0;i<number;i++)
			{
			System.out.println("Enter cancel time time-");
			cancelTime[i]=sc.nextInt();
			}
	   
			int result=minTime(travelTime,readyTime,cancelTime);
	   
			System.out.println("minimum time-");
			System.out.println(result);
		}
		catch(Exception e){
		
			System.out.println(e);
		}
		finally{
			
			try{
				sc.close();
			}
			catch(Exception e){
				System.out.println(e);
			}
		}
	
	   
    }
	
	
	
	
    public static int minTime(int[] travelTime,int[] readyTime,int[] cancelTime)
    {
        int cTime = 0; 
		
        for(int i=0;i<readyTime.length-1;i++)
        {
			// if cab arrives before ready time
            if(cTime<=readyTime[i])
            {
                int wTime=readyTime[i]-cTime;
                cTime+=wTime+travelTime[i];
            }
			//if cab arrives after ready time and before cancel time;
            else if(cTime>readyTime[i]&& cTime<cancelTime[i])
            {
			   cTime+=travelTime[i];
			}
			//if cab is cancelled
            else
			{
                return -1;
			}
        }
		
		
        if(cTime <= cancelTime[readyTime.length-1])
        {
            cTime = cancelTime[readyTime.length-1];
        }
        else
		{
            return -1;
		}
        return cTime;
    }
    
}