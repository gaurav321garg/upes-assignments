
import java.util.Scanner;

class Question2 {
	
	static int minTime=-1;  // the minimum time to process the all the request if possible
	
	/**
	 * function to calculate the minimum time for the given start time of the driver.
	 * @param ready_time -> array with readyTimes of all the request 
	 * @param cancel_time -> array with cancelTimes of all the request
	 * @param distances	-> array with travelsTimes
	 * @param startTime -> time when driver picks up the first person(always between readyTimes and cancelTimes of the first person)
	 * @return -> time taken to process all the request if possible for the given start time. 
	 */
	static int varStartTime(int[] ready_time, int[] cancel_time, int[] distances,int startTime){
		
		int time=startTime;  // time is initalized with the startTime i.e when the driver picks up first person
		time=time+ distances[0]; // time is incremented with the travelTime from 1st to 2nd position
		for(int i=1;i<ready_time.length;i++) // loop to process the remaining request
		{
			if(time>cancel_time[i]) // if passed time till now exceeds the cancel time of (i+1)th request then  for the given startTime request can't be fulfilled  
				return -1; // return -1
			else{
				if(i==ready_time.length-1){ // condition to check whether it is the last request or not
					if(time>=ready_time[i] &&time<=cancel_time[i]){ // time passed between readyTime and cancelTime 
						time=time; // time will remain same and the last request if fulfilled
					}
					else{ // if the driver arrives early to pick last person then the driver will wait and 
						time=ready_time[i]; //time will become  the ready time of the last person
					}
				}
				else{ 												// if is is not the last request
					if(time>ready_time[i] &&time<cancel_time[i]){ // if the time when the driver arrives is b/w ready and cancel time  
						time=time+distances[i]; // add the time needed to reach the next location 
					}
					else{									// if the drivers arrives early
						time=ready_time[i]+distances[i];	// then first driver will wait till the rider comes and then also the time to move to next location
					}
				}	
			}
		}
		return time-startTime; // the time required by the driver to process all the request if the difference between picking time of last person and the driver start time
		
	}
	
	/**
	 * It's a recursive function to determine the maximum starting time for which the driver can fulfill all the 
	 * requests using Divide and conquer approach.
	 * @param start - start limit for checking
	 * @param end	- end limit for checking
	 * @param ready_time -> array with readyTimes of all the request 
	 * @param cancel_time -> array with cancelTimes of all the request
	 * @param distances	-> array with travelsTimes
	 */
	static void minPossibleTime(int start,int end,int[] ready_time, int[] cancel_time, int[] distances){
		int mid=(start+end)/2; // mid time is calculated for which it is to be checked whether it can be the start time
		int x= varStartTime(ready_time,cancel_time,distances,mid); // function is called to get the minTime for that startTime of the driver
		if(x>0) // if x is positive then the all the request can be fulfilled 
		{
			minTime=x; // minTime value is updated
			if((end-mid)!=1) // if the end and mid are not consecutive time then
			{
				// as x is positive then if driver startTime is less than or equal to mid then all the request will be fulfilled  
				// we have to check whether there is a time greater than mid for which all the request can be fulfilled 
				minPossibleTime(mid,end,ready_time,cancel_time,distances);
			}
			else 	// if the mid and end are consecutive then we just have to check the possibility of end as the startTime for the driver 
			{ 
				int temp=varStartTime(ready_time,cancel_time,distances,end);
				if(temp>0)
					minTime=temp;
			}
		}
		else // if x is negative then all request may be fulfilled by time less than mid but not greater than mid
		{
			if((mid-start)!=1)
				minPossibleTime(start,mid,ready_time,cancel_time,distances);
			else
			{
				int temp=varStartTime(ready_time,cancel_time,distances,start);
				if(temp>0)
					minTime=temp;
			}
		}
	}
	

	public static void main(String[] args)
	{
		Scanner scn= new Scanner(System.in);
		int cases=scn.nextInt();   // no of test cases
		scn.nextLine();
		int []no_of_request =new int[cases]; // no_of_request array for each test cases
		int [][] ready_time=new int[cases][];
		int [][] cancel_time=new int[cases][];
		int [][] distances=new int[cases][];
		for(int i=0;i<cases;i++) // loop to read all the values
		{
			no_of_request[i]=scn.nextInt();
			scn.nextLine();
			ready_time[i]=new int[no_of_request[i]];
			cancel_time[i]=new int[no_of_request[i]];
			distances[i]=new int[(no_of_request[i]-1)];
			for(int j=0;j<no_of_request[i]-1;j++)
			{
				distances[i][j]=scn.nextInt();
			}
			scn.nextLine();
			for(int j=0;j<no_of_request[i];j++)
			{
				ready_time[i][j]=scn.nextInt();
			}
			scn.nextLine();
			for(int j=0;j<no_of_request[i];j++)
			{
				cancel_time[i][j]=scn.nextInt();
			}
			
		}
		
		for(int i=0;i<cases;i++)
		{
		minPossibleTime(ready_time[i][0],cancel_time[i][0],ready_time[i], cancel_time[i], distances[i]); // function is called for every test case
		System.out.println(minTime);
		minTime=-1; // minTime is reset for every new case 
		}
		scn.close();
	}

	
}
