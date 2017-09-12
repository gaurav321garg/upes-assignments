   
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
    #define ull unsigned long long
    using namespace std;
    
/*Code for the solution*/

//method to calculate the Manhattan Distance, between two cartesian coordinates
int dist(int x,int y,int a,int b)
{
int x1=x-a;
int x2=y-b;
if(x1<0)
x1=-1*x1;
if(x2<0)
x2=-1*x2;
return x1+x2;
}
    int main()
    {
//taking the specified arrays with size as 2
int A[2], B[2], C[2], X[2], Y[2];
int n=2,i;
//repo method runs a for loop from i = 0 to i = n
//taking array inputs subsequently
repo(i,n)
cin>>A[i];
repo(i,n)
cin>>B[i];
repo(i,n)
cin>>C[i];
repo(i,n)
cin>>X[i];
repo(i,n)
cin>>Y[i];

//distance of trip from A to C then C to B
int dis=dist(A[0],A[1],C[0],C[1])+dist(C[0],C[1],B[0],B[1]);
//distance of trip from A to C then C to X and then X to B
int dis1=dist(A[0],A[1],C[0],C[1])+dist(C[0],C[1],X[0],X[1])+dist(X[0],X[1],B[0],B[1]);
//distance of trip from A to C then C to Y then Y to B
int dis2=dist(A[0],A[1],C[0],C[1])+dist(C[0],C[1],Y[0],Y[1])+dist(Y[0],Y[1],B[0],B[1]);

//computing the comparison parameter
dis=2*dis;

//setting logical markers
int flag1=0,flag2=0,ans=-1;

//starting actual comparisons of distances
if(dis1<=dis)
flag1=1;

if(dis2<=dis)
flag2=1;

//if both distances of X and Y are lesser than the comparison parameter
if(flag1==1 && flag2==1)
{
//if A-C-X-B is smaller
if(dis1<dis2)
ans=1;
//if A-C-Y-B
else if(dis2<dis1)
ans=2;
//else pick the first customer in case both distances are same
else
ans=1;
}
//checking the boundary conditions
else if(flag1==1)
ans=1;
else if(flag2==1)
ans=2;
else
ans=-1;
//output the result
cout<<ans<<endl;
return 0;
  }



