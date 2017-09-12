
//This program calculates the best route for an Uber driver to follow. It returns 1 if the driver should follow the route through X and 2 if the driver should follow the route through Y. It will return -1 if none of X or Y should be followed.


#include<stdio.h>
#include<stdlib.h>

//This is a function to calculate distance
//variable xdist calculates the distance in the x axis
//variable xdist calculates the distance in the y axis  
int distance(int a[],int b[])
{
	int xdist=abs(a[0]-b[0]);
	int ydist=abs(a[1]-b[1]);
	return xdist+ydist;
}


//This function checks the conditions and returns the required value 
 
int pickup(int ab, int axb, int ayb)
{
	if (axb<=2*ab && ayb<=2*ab) 
	{
		if(axb<ayb)
			return 1;
    		else 
			return 2;
	}
  	else if (axb<=2*ab)
	{
  		return 1;
	}
 	else if(ayb<=2*ab)
	{
 		return 2;
	}
	else 
		return -1;	 
}	


//This is the main function
//vaiable 'ac' is the distance between points A and C
//variable 'axb' is the total distance of the trip through X
//variable 'ayb' is the total distance of the trip through Y  
int main()
{
	int ac=0,axb=0,ayb=0;
	int a[2],b[2],c[2],x[2],y[2];
	scanf("%d",&a[0]);               //Taking inoput for all the coordinates.
	scanf("%d",&a[1]);
	scanf("%d",&b[0]);
	scanf("%d",&b[1]);
	scanf("%d",&c[0]);	
	scanf("%d",&c[1]);
	scanf("%d",&x[0]);
	scanf("%d",&x[1]);
	scanf("%d",&y[0]);
	scanf("%d",&y[1]);
	int ab=distance(a,b);
	ac=distance(a,c);
	axb=ac+distance(c,x)+distance(x,b);
	ayb=ac+distance(c,y)+distance(y,b);

	int p=pickup(ab,axb,ayb);         //Call to function pickup().
	printf("%d\n",p);
}











