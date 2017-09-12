#include<iostream>
#include<conio.h>
#include<stdlib.h>
#include<cmath>
using namespace std;

//reversing the list 
void reverse(int N,int *L,int start){
	int end = N-1;
	while(start < end){
		int temp = L[start];
		L[start] = L[end];
		L[end] = temp;
		start++;
		end--;
	}
}
//adding A to all numbers of the list
void add(int N,int *L,int A,int start){
	for(int i=start;i<N;i++){
		L[i]=L[i]+A;
	}
}

//multiplying B to all numbers of the list
void multiply(int N,int *L,int B, int start){
	for(int i=start;i<N;i++){
		L[i]=L[i]*B;
	}
}

//for all the numbers in list module function by C
void module(int N,int *L,int C){
	for(int i=0 ;i<N;i++){
		L[i]=L[i]%C;
	}
}

int main(){
	int T;
	cin>>T;
	while(T--){
		int N;
		cin>>N;
		int L[N],A,B,C;
		char S[N+1];
		for(int i=0;i<N;i++){
			cin>>L[i];
		}
		cin>>A>>B>>C;
		cin>>S;
		for(int i=0;i<N;i++){
			if(S[i] == 'R'){
				reverse(N,L,i);	
			}else if(S[i]== 'A'){
				add(N,L,A,i);
			}else if(S[i] == 'M'){
				multiply(N,L,B,i);
			}module(N,L,C);
			
		}
		for(int i=0;i<N;i++)
		
//finally announcing L[i] loud
	cout<<L[i]<<" ";
	}
}