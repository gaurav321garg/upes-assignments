    #include<bits/stdc++.h>
    #include<string>
    #include<stack>
    #include<queue>
    #include<vector>
    #include<list>
    #include<algorithm>
    #include<utility>
    #include<set>
    #include<time.h>
    #define ll long long int
    #define pb push_back
    #define repo(i,n) for(i=0;i<n;i++)
    #define rep1(i,n) for(i=1;i<=n;i++)
    #define rep2(i,n) for(i=2;i<=n;i++)
    #define repa(i,a,n) for(i=a;i<=n;i++)
    #define sc(a) cin>>a;
    #define pr(a) cout<<a;
    #define pl() cout<<endl;
    #define min(a,b) (((a)<(b))?a:b)
    #define max(a,b) (((a)>(b))?a:b)
    #define lg(a) log2(a)
    #define nlg(a) log(a)
    #define MAX 86400
    #define ull unsigned long long
   using namespace std;

 /*code for the solution*/

//defining the required arrays   
int trav[10001],ready[10001],can[10001];
int main()
{
int n,i;
cin>>n;
//repo method starts loop from i = 0 to i = n
//sc method simply scans the elements
//taking travel time input
repo(i,n-1)
sc(trav[i]);

//taking the ready time input
repo(i,n)
sc(ready[i]);

//taking the cancel time input
repo(i,n)
sc(can[i]);
int curr=0;
int tt=0;
int flag =0;
trav[n-1]=can[n-1]-ready[n-1];
repo(i,n)
{
    //applying the given logic according to the test case
if(curr<=ready[i] && ready[i]+trav[i]<MAX)
{
    flag = 1;
curr=ready[i]+trav[i];
tt+=trav[i];
}
}
if(flag ==1)
cout<<tt<<endl;
//printing -1 if the cases fail
else 
cout<<-1<<endln ;
return 0;
}
