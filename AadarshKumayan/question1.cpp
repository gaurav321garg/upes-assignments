#include <iostream>
#include<math.h>
using namespace std;
long long int dis(long long int x1,long long int y1,long long int x2,long long int y2)				//Calculate minimum distance between two co-ordinates
{
	return abs(x2-x1)+abs(y2-y1);
}
int main() {
	
	long long int ax,ay,bx,by,cx,cy,xx,xy,yx,yy,d1,d2,d3;
	cin>>ax>>ay>>bx>>by>>cx>>cy>>xx>>xy>>yx>>yy;
	d1=dis(ax,ay,cx,cy)+dis(cx,cy,bx,by);							//length of trip with no extra riders
	d1*=2;
	d2=dis(ax,ay,cx,cy)+dis(cx,cy,xx,xy)+dis(xx,xy,bx,by);					//length of trip with x rider
	d3=dis(ax,ay,cx,cy)+dis(cx,cy,yx,yy)+dis(yx,yy,bx,by);					//length of trip with y driver
	if(d1<d2 && d1<d3)									//no extra riders
	cout<<"-1"<<endl;
	else if(d3<d2)
	cout<<"2"<<endl;									//take y
	else
	cout<<"1"<<endl;									//take x
	return 0;
}