#include<iostream>
#include<istream>
using namespace std;
int main()
{
	long long int t[1000000],r[1000000],c[1000000],n=0,i,x=0,y,flag=0;		//t-travel time r-ready time c-cancel time
	char l='a';
	while(l!='\n')							//find out number of passengers
	{
		cin>>t[n++];
		x+=t[n-1];							//minimum time will always contain sum of all travelling time
		cin.get(l);
	}
	n++;
	for(i=0;i<n;i++)
	cin>>r[i];
	for(i=0;i<n;i++)
	cin>>c[i];
	for(i=r[0];i<=c[0];i++)						//max value between passenger 1 ready time and cancel time for which it will reach at ready time for passenger 2
	{
		if(i+t[0]<=r[1])
		y=i;
	}
	for(i=1;i<n;i++)						//calculate waiting time for all passengers
	{
	y+=t[i-1];
	if(y<r[i])
	{
		x+=r[i]-y;
		y=r[i];
	}
	else if(y>c[i])						//check if driver is late and request is not service return -1
	{
		cout<<-1<<endl;
		flag=1;
		break;
	}
	}
	if(flag==0)
	cout<<x<<endl;
	return 0;
}