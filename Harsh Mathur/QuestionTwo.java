
/**
 * The QuestionTwo implements getRouteDuration to find
 * the total time taken be a taxi driver across city
 * 
 * @author Harsh Mathur
 */
import java.util.*;

public class QuestionTwo {
	
	/**
	 * This function calculates the total time taken by the driver to
	 *  complete his tour for all riders possible
	 * 
	 * @param travelTime Array containing travel time from ith to i+1th location
	 * @param readyTime  Array containing time by which each passenger will be ready
	 * @param cancelTime Array containing time by which if cab not arrived, will be cancelled
	 * @param N Length of given array
	 * @return totalDuration taken for successful ride, else -1 if ride not possible
	 */
	static int getRouteDuration(int[] travelTime, int[] readyTime, int[] cancelTime, int N) {
		int totalDuration = 0;
		
		for(int i = 0; i < N ; i++){
			
			if(totalDuration <= readyTime[i])			   // he reaches before time then will wait till the customer is ready
			{
				totalDuration = readyTime[i];			   // he will only leave after passenger has arrived
				totalDuration += travelTime[i];			   // he will start his travel for iTH passenger				
			}
			else if(totalDuration > readyTime[i] && totalDuration <= cancelTime[i])	// he reaches after ready time but before cancel time then he will start with his travel
			{
				totalDuration += travelTime[i];            // he will continue with his next travel
			}
			else if(totalDuration > cancelTime[i])		   // if he reaches after ride is cancelled then no more further  
			{
				return -1;                          			
			}	
		}
		
		return (totalDuration <= 86400)? totalDuration : -1;
	}
	
	/*
	 * This main method uses getRouteDuration method to find the total time duration taken by cab driver
	 * to complete the journey.
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter length of array");
		int N = sc.nextInt();
		int[] travelTime = new int[N];
		int[] readyTime = new int[N];
		int[] cancelTime = new int[N];
		
		System.out.println("Enter travel time");
		for(int i = 0; i < N; i++){
			if(i == 0)
				travelTime[0] = 0;                          // Travel time for 1st ride will always be 0
			else
				travelTime[i] = sc.nextInt();			    
		}
		System.out.println("Enter ready time");
		for(int i = 0; i < N; i++){
			readyTime[i] = sc.nextInt();
		}
		System.out.println("Enter Cancel time");
		for(int i = 0; i < N; i++){
			cancelTime[i] = sc.nextInt();
		}
		int ans = getRouteDuration(travelTime, readyTime, cancelTime, N);
		if(ans != -1)
			System.out.println("Total travel duration "+ans);
		else
			System.out.println("Ride not possible "+ans);
		sc.close();
		
	}

	

}
