
/**
 * This program Finds the minimum amount of time required by driver to serve all the request made to him. 
 * 
 * 
 * @author Ashish Verma
 */
 
 //External Library
#include<stdio.h>

/**
*The main function finds the minimum amount of time it will take a lonely uber driver to complete all requests made to him .
*/

int main(){
	 int n;
	
	
	printf("Enter the No of services scheduled for the day");           
		scanf("%d",&n);                                                      //Accepts the total number of services
	
	int tt[n];                                                               //Travel time array
	int rt[n];                                                               //Ride time array
	int ct[n];                                                               //Cancelletion time array
	int i=0;                           
	
	for(i=0;i<n;i++)                                                        //Accepts the travel time between two locations
	{
		if(i+1==n)
			{
				tt[i]=0;                                                  
				continue;
			}
			else {
				printf("Enter The travel Time Between %d and %d location :",i,i+1);
			scanf("%d",&tt[i]);                                                       //Accept the travel time between two locations.
			}
			
		}
	for(i=0;i<n;i++){
	
		printf("enter the ready time of passenger at %d location",i);
			scanf("%d",&rt[i]);                                                       //Accepts the ready time for each passenger
	}
	for(i=0;i<n;i++){
	
		printf("enter The cancellation time of passenger at %d location:",i);
			scanf("%d",&ct[i]);                                                       //Accepts the cancellation time for each passenger
		
	}
	
	int minimumtime=0;
	
	for (i=0;i<n;i++){
		
	
	
		if(minimumtime<rt[i])                                                
		{
			minimumtime=rt[i]+tt[i];                                                       //First case to compute the minimum ride time between to location .
			
		}
		
		else if(minimumtime>rt[i] && minimumtime<ct[i])
		{
			minimumtime=minimumtime+tt[i];                                         //second case to computation of minimum time
		}
		
		else if(minimumtime>ct[i]){
			
			printf("Status :-1");                                                //Third case when the rider can't be served
			
			
		}
		
	}
	
	
	/*
	* Below mentioned for loop is for Special cases when a driver can reduce the total travel time.
	* Loop checks if driver can just start at or in between of ready time of 1st request and cancellation time of ,
	* 1st request and serve the second request by reducing the wait time for 2nd Location
	*/
	
	for (i=0;i<1;i++)
	{
		int sp,sp1;
		
		sp=ct[i]+rt[i]+tt[i];                                       //special case
		sp1=rt[i]+tt[i];
		                         
		
		if (sp1<rt[i+1] && sp<ct[i+1] )                          //case when driver can start at just befor  cancellation time of 1st and serve the 2nd request too
		{
			minimumtime=minimumtime-ct[i];
				continue;
					
		}
		int st=0;
		if (sp1>rt[i+i] && sp1<ct[i+1])                        //case if driver can start in between of ready time and cancel time of 1st request and serve 2nd
		{
			int diff=ct[i+1]-rt[i+1];
			
			minimumtime=minimumtime-diff;
			continue;
		}
		
	}
	if(minimumtime>86400)                                      //To verify if total time to serve all request must be less than 24 hrs 
	{
		printf("status:-1");                                                                     
		
	}
	else
	{
		printf("min route and time required will take %d",minimumtime);                      //Minimumtime taken by Driver to serve all the requests
	}
	
	
}

