import java.util.*;
import java.lang.*;
import java.io.*;


class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		
		int[] travelTimes=new int[n-1];
		int[] readyTimes=new int[n];
		int[] cancelTimes=new int[n];
		for(int i=0;i<n-1;i++)
		{
			travelTimes[i]=in.nextInt();
		}
		for(int i=0;i<n;i++)
		{
			readyTimes[i]=in.nextInt();
		}
		for(int i=0;i<n;i++)
		{
			cancelTimes[i]=in.nextInt();
		}
		int result=Wait(n,travelTimes,readyTimes,cancelTimes);
		System.out.print(result);
	}
	 static int Wait(int n,int[] travelTimes,int[] readyTimes,int[] cancelTimes)
	{
	int minTime = 0;
 	for(int i=0;i<n;i++){
 		if(i != n-1){
 			if(minTime<=readyTimes[i]){
 				int wait = readyTimes[i]-minTime;
 				minTime+=wait;
 				minTime += travelTimes[i];
 			}else if(minTime > readyTimes[i] && minTime <= cancelTimes[i]){
 				minTime += travelTimes[i];
 			}else{
 				return -1;
 			}
 		}else if(i == n-1){
 			if(minTime <= cancelTimes[n-1]){
 				minTime = cancelTimes[n-1];
 			}else 
 				return -1;
 		}
 	}
 	return minTime;
 }
	}
