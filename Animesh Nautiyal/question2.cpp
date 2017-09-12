#include<iostream>
using namespace std;

int calculateTime(int n,int *travelTimes,int *readyTimes,int *cancelTimes){
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
	cout<<calculateTime(n,travelTimes,readyTimes,cancelTimes);
}
