    #include <iostream>
    #include <algorithm>
    #include <string.h>
    using namespace std;
     
    int main() {
    	string s;
    	long long int t,arr[1000000],arr1[3],i,n,j;
    	cin>>t;
    	while(t>0)
    	{
    	  cin>>n;
    	  memset(arr,0,sizeof(arr));
    	  for(i=0;i<n;i++)
    	  cin>>arr[i];
    	  cin>>arr1[0]>>arr1[1]>>arr1[2];
    	  cin>>s;
    	  for(i=0;i<n;i++)
    	  {
    	  	if(s[i]=='R')
    	  	reverse(begin(arr)+i,begin(arr)+n-1);
    	  	else if(s[i]=='A')
    		{
    			for(j=i;j<n;j++)
    			arr[j]=(arr[j]%arr1[2])+(arr1[0]%arr1[2])%arr1[2];
    		}	
    	  	else if(s[i]=='M')
    		{
    			for(j=i;j<n;j++)
    			arr[j]=(arr[j]%arr1[2])*(arr1[1]%arr1[2])%arr1[2];
    		}	
    	  }
     
    	for(i=0;i<n;i++)
    	cout<<arr[i]%arr1[2]<<" ";
    	cout<<endl;
     
    	  t--;
    	}
    	return 0;
    }