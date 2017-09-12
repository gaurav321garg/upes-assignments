//programming language c++
#include<iostream>
using namespace std;

int main()
{
 int n; //Number of array elements
 cin>>n;    //Input number of passengers
 int travelTimes[n-1];  //Array for travel times
 int readyTimes[n];     //Array for ready times
 int cancelTimes[n];    //Array for cancel times
 int sum=0;             //Initializing the total time
 for(int i=0;i<n-1;i++)
 {
     cin>>travelTimes[i];       //Input travel times
 }
 for(int i=0;i<n;i++)
 {
     cin>>readyTimes[i];        //Input Ready Times
 }
 for(int i=0;i<n;i++)
 {
     cin>>cancelTimes[i];       //Input Cancel Times
 }
 sum+=readyTimes[0];            //time for first passenger will be the passengers ready time
 int flag=0;                    //flag for checking if servicing all is possible
 for(int i=1;i<n;i++)
 {
     if((sum+travelTimes[i-1])>=readyTimes[i] && (sum+travelTimes[i-1])<=(readyTimes[i]+cancelTimes[i]))    //If the arrival time of taxi is between the ready time and cancel time of the passenger
     {
       sum+=travelTimes[i-1];   //adding the travel time of the passenger to the sum
     }
     else if((sum+travelTimes[i-1])<readyTimes[i])  //If taxi arrives early
     {
         sum=readyTimes[i];         //the time taken will be the ready time of the passenger
     }
     else
     {
         flag=1;            //if the taxi cannot reach the passenger then set flag to 1
         break;
     }
 }
 if(flag==1 || sum>86400)   //Check if the total time is greater than 86400 or servicing all passengers is not possible
 {
    cout<<-1<<endl;      //print -1
 }
 else
 {
     cout<<sum<<endl;       //print the total time
 }
 return 0;
}
