//This program computes the minimum time required for a driver to complete the given route. If the requested route can be completed,It returns the time in seconds to complete it,else it returns -1. 

#include<stdio.h>


//This function returns the minimum time the given route will take
//'curtime' is a variable updating the current time 
//'tt','rt','ct' have the values of arrays travelTimes,readyTimesand cancelTimes
int timetaken(int tt[],int rt[],int ct[],int n)
{
	int t=0;
	int curtime=0;
	for(int i=0;i<=n+1;i++)
	{
		if(curtime+tt[i]<=rt[i])
		{
			t+=rt[i]-curtime;
			curtime+=rt[i]-curtime;	
		}
	
		else
		{	t+=curtime+tt[i];
			curtime+=tt[i];
	
		}

	}	
	t=t-ct[0];
           
	if(t<=86400)
		return t;
	else 
		return-1;
}
//This is the main function
//'travelTimes','readyTimes','cancelTimes' are three integer arrays
//'n' is total no of requests
int main()
{ 
	int n;
	scanf("%d",&n);
	int travelTimes[1000];
	int readyTimes[1000];
	int cancelTimes[100];
	for(int i=0;i<n;i++)                                    
	{
		scanf("%d",&travelTimes[i]);                  //Entering the arrays 
	}
	for(int i=0;i<n+1;i++)
	{
		scanf("%d",&readyTimes[i]);
	}
	for(int i=0;i<n+1;i++)
	{
		scanf("%d",&cancelTimes[i]);
	}
	int t=timetaken(travelTimes,readyTimes,cancelTimes,n);   //Call to function timetaken with all three arrays and their size as parameters.
	printf("\n%d",t);
}

