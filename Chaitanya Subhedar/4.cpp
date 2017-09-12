#include<iostream>
#include<algorithm>
#include<vector>
#include<cmath>
#define mod 1000000007          //defining 1000000007 as mod
using namespace std;

int gcd(vector<int> vec)        //Function to calculate GCD of a subset
{
    while(vec.size()!=1)        //while size of set is greater than 1
    {
      int num1=vec.back();
      vec.pop_back();
      int num2=vec.back();
      vec.back()=__gcd(num1,num2);      //replace second last number of the set with the GCD of second last and last number of the set
    }
    return vec.front();             //return the GCD
}

int main()
{
    int t;      //number of test cases
    cin>>t;     //Input number of test cases
    while(t--)  //Loop for each test case
    {
    vector<int> subset;         //creating data structure for storing subset
    long long product=1;        //initializing the result
    int n;                      //size of list
    cin>>n;                     //Input size of list
    int arr[n];                 //array for storing input list
    for(int i=0;i<n;i++)
    {
        cin>>arr[i];            //Input list
    }
    long long num=pow(2,n);     //calculating total number of subsets
    for(long long i=1;i<num;i++)      //loop for every non-empty subset
    {
        subset.clear();         //emptying the data structure
        for(int j=0;j<n;j++)    //iteration to check every bit of i
        {
            if(i & (1<<j))      //Check which bits are ON in the number
                subset.push_back(arr[j]);   //adding the array element corresponding to the ON bits to the data structure
        }
        product=(product*gcd(subset))%mod;  //multiplying the GCD into existing result and finding modulo 1000000007
    }
    cout<<product<<endl;        //Output final result
    }
    return 0;
}
