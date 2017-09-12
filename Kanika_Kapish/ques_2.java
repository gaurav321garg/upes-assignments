import java.util.*;

public class UberRequest
{
	 public static void main(String args[])
    {
		int travelTimes[] = new int[100];
		int n,i,sum = 0;	
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the Travel Times array");
		String travel[] = s.nextLine().split("\\s+"); 
		n = travel.length;
		for(i=0;i<n;i++)
		{
			travelTimes[i] = Integer.parseInt(travel[i]);
		}
		int readyTimes[] = new int[n];
		int cancelTimes[] = new int[n];
		System.out.println("Enter the Ready Times array");
		for(i=0;i<n;i++)
		{
			readyTimes[i] = s.nextInt();
			if(readyTimes[i]>=86400)
			{
				System.out.println("Invalid input");
			}
		}
		System.out.println("Enter the Cancel Times array");
		for(i=0;i<n;i++)
		{
			cancelTimes[i] = s.nextInt();
			if(cancelTimes[i]>=86400)
			{
				System.out.println("Invalid input");
			}
		}
	   
			int result=totalTime(travelTime,readyTime,cancelTime);
	   
			System.out.println("minimum time-");
			System.out.println(result);
		
    }
	
	
	
	
    public static int totalTime(int[] travelTime,int[] readyTime,int[] cancelTime)
    {
        int cabTime = 0; 
		int n = readyTime.length;
        for(int i=0;i<n-1;i++)
        {
			
            if(cTime<=readyTime[i])
            {
                int waitTime=readyTime[i]-cTime;
                cTime+=waitTime+travelTime[i];
            }
			
            else if(cabTime>readyTime[i]&& cabTime<cancelTime[i])
            {
			   cabTime+=travelTime[i];
			}
		
            else
			{
                return -1;
			}
        }
		
		
        if(cabTime <= cancelTime[n-1])
        {
            cabTime = cancelTime[n-1];
        }
        else
		{
            return -1;
		}
        return cabTime;
    }
    
}