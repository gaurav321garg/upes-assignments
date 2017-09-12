#include<iostream>
#include<cmath>
using namespace std;

int distance(int *P,int *Q){
	int xAbs = abs(P[0]-Q[0]);
	int yAbs = abs(P[1]-Q[1]);
	return xAbs + yAbs;
}
int main(){
	int A[2],B[2],C[2],X[2],Y[2];
	for(int i=0;i<1;i++){
		cin>>A[i]>>A[i+1];
		cin>>B[i]>>B[i+1];
		cin>>C[i]>>C[i+1];
		cin>>X[i]>>X[i+1];
		cin>>Y[i]>>Y[i+1];
		
	}
	int AB = distance(A,B);
	int AX = distance(A,C)+distance(C,X)+distance(X,B);
	int AY = distance(A,C)+distance(C,Y)+distance(Y,B);
	int selectedPassenger = -1;
	if(AX <= (2*AB)){
		selectedPassenger = 1;
	}if(AY <= (2*AB) && AY < AX){
		selectedPassenger = 2;
	}
	cout<<selectedPassenger;
	return 0;
}
