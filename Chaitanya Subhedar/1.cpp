//programming language c++
#include<iostream>
#include<cmath>
using namespace std;

int distance(int src[],int dest[])              // function for calculating shortest distance between two points
{
    int dist=abs(dest[0]-src[0])+abs(dest[1]-src[1]);
    return dist;
}

int main()
{
    //Assuming each array is input as space separated integers
    int A[2],B[2],C[2],X[2],Y[2];
    cin>>A[0]>>A[1];            //input.A
    cin>>B[0]>>B[1];            //input.B
    cin>>C[0]>>C[1];            //input.C
    cin>>X[0]>>X[1];            //input.X
    cin>>Y[0]>>Y[1];            //input.Y

    int initDistance=distance(A,B); //Total Distance to travel
    int coveredDistance=distance(A,C); //Covered distance when message arrives

    int pctopx=distance(C,X);          //Distance from C to X
    int pxtopb=distance(X,B);          //Distance from X to B
    int dist1=coveredDistance+pctopx+pxtopb; //Calculating to total distance for picking up X
    int pctopy=distance(C,Y);          //Distance from C to X
    int pytopb=distance(Y,B);          //Distance form Y to B
    int dist2=coveredDistance+pctopy+pytopb; //Calculating to total distance for picking up Y

    if(dist1<=dist2 && dist1<=2*initDistance) //if distance for X is less than distance for Y and it is less than two times the initial distance
    {
        cout<<1<<endl;
    }
    else if(dist2<2*initDistance)  //if distance for Y is shorter
    {
        cout<<2<<endl;
    }
    else    //if having no passenger in possible
    {
      cout<<-1<<endl;
    }
    return 0;
}

