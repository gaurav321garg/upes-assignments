#include<iostream>
#include<conio.h>
#include<stdlib.h>
#include<cmath>
using namespace std;


//initial distance in ques given is 6units.
int distance(int *P,int *Q){
	int xco = abs(P[0]-Q[0]);
	int yco = abs(P[1]-Q[1]);
	return xco + yco;
}
int main(){
//for co-ordinate values of points
	int A[2],B[2],C[2],X[2],Y[2];
	for(int i=0;i<1;i++){
		cin>>A[i]>>A[i+1];
		cin>>B[i]>>B[i+1];
		cin>>C[i]>>C[i+1];
		cin>>X[i]>>X[i+1];
		cin>>Y[i]>>Y[i+1];
		
	}
	int AB = distance(A,B);
	int AX = distance(A,C)+distance(C,X)+distance(X,B); //distance from A->C->X->B
	int AY = distance(A,C)+distance(C,Y)+distance(Y,B); //distance from A->C->Y->B
//X AND Y to look for shortest distance
	int pickperson = -1;
	if(AX <= (2*AB)){
		pickperson = 1;

// selecting by measuring which co-ordinate is closer or we can say which point is at nearer distance
	}if(AY <= (2*AB) && AY < AX){
		pickperson = 2;
	}
	cout<<pickperson;
	return 0;
}