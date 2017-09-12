#include<iostream>
#include<cmath>
#include <vector>
using namespace std;

int gcd(int a, int b)
{
    if (a == 0)
        return b;
    return gcd(b%a, a);
} 

int calculateGCD(int *arr, int n)
{
    int result = arr[0];
    for (int i=1; i<n; i++)
        result = gcd(arr[i], result);
 
    return result;
}

unsigned long long int getGCDMultiple(int *A , int N){

    unsigned int subSet = pow(2, N);
    unsigned long long int ans=1;
 
    for(int i = 0; i < subSet; i++)
    {
      std::vector<int> myvector;
      for(int j = 0; j < N; j++)
       {
		  if(i & (1<<j)){
		  		myvector.push_back (A[j]);
		  }
       }
       int subarray[myvector.size()];
       for(int k =0;k<myvector.size();k++){
       	subarray[k]=myvector[k];
	   }
	  if(myvector.size() != 0){
	  	ans *= calculateGCD(subarray, myvector.size());
       myvector.clear();
       delete [] subarray;	
	  }
      
	
	
    }
    return ans;
}
int main(){
	int T;
	cin>>T;
	while(T--){
		int N;
		cin>>N;
		int A[N];
		for(int i=0;i<N;i++){
			cin>>A[i];
		}
		unsigned long long int ans = getGCDMultiple(A,N);
		cout<<ans%1000000007;	
	}
	return 0;
}
