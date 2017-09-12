#include<iostream>
#include<conio.h>
#include<stdlib.h>
#include<cmath>
#include <vector>
using namespace std;

//gcd greatest common divisor
int gcd(int a, int b)
{
    if (a == 0)
        return b;
    return gcd(b%a, a);
} 
//function to calculate gcd
int calGCD(int *ar, int n)
{
    int result = ar[0];
    for (int i=1; i<n; i++)
        result = gcd(ar[i], result);
 
    return result;
}

unsigned long long int getGCDMultiple(int *A , int N){
//to find all possible subsets
    unsigned int subSet = pow(2, N);// calculating for possible subsets 2 to power of
    unsigned long long int ans=1;
 
    for(int i = 0; i < subSet; i++)
    {
      std::vector<int> vector1;
      for(int j = 0; j < N; j++)
       {
		  if(i & (1<<j)){
		  		vector1.push_back (A[j]);
		  }
       }
       int subarray[vector1.size()];
       for(int k =0;k<vector1.size();k++){
       	subarray[k]=vector1[k];
	   }
	  if(vector1.size() != 0){
	  	ans =ans* calGCD(subarray, vector1.size());
       vector1.clear();
       delete [] subarray;	
	  }
      
	
	
    }
    return ans;
}
int main(){
	int T;//input for test cases according to ques
	cin>>T;
	while(T--){
		int N;
		cin>>N; // input N space separated integer values
		int A[N];
		for(int i=0;i<N;i++){
			cin>>A[i];
		}
		unsigned long long int ans = getGCDMultiple(A,N);
		cout<<ans%1000000007;	
	}
	return 0;
}