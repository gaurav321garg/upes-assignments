#include<iostream>
#include<conio.h>
#include<stdlib.h>
#include<cmath>
using namespace std;

// taking travel,ready and cancel times for the question given
int calTime(int n,int *travelTimes,int *readyTimes,int *cancelTimes){
	int minTime = 0;
	for(int i=0;i<n;i++)
{

		if(i != n-1)
{

			if(minTime<=readyTimes[i]){
				int wait = readyTimes[i]-minTime;
				minTime=minTime+wait; // to calculate for the minimum time of the route.
				minTime += travelTimes[i];
			}else if(minTime > readyTimes[i] && minTime <= cancelTimes[i]){
				minTime += travelTimes[i];
			}else{
				return -1;  // if not possible to serve all the request
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
int main(){
	int n;
	cin>>n;
	int travelTimes[n-1],readyTimes[n],cancelTimes[n];
	for(int i=0 ; i<n-1;i++){
		cin>> travelTimes[i];
	}
	for(int i=0;i<n;i++){
		cin>> readyTimes[i];
	}
	for(int i=0;i<n;i++){
		cin>> cancelTimes[i];
	}
	cout<<calTime(n,travelTimes,readyTimes,cancelTimes);
}