//programming language c++
#include<iostream>
#include<string>
using namespace std;

void Reverse(int arr[],int i, int n)        //Function for reversing the array from ith to nth position
{
    int temp;
    for(int j=i;j<(i+n)/2;j++)
    {
        temp=arr[i];                        // swapping the values in the array
        arr[i]=arr[n-j+i-1];
        arr[n-j+i-1]=temp;
    }
}

void Sum(int arr[],int i,int n,int num)     //Function for adding an element from ith to nth terms in array
{
    for(int j=i;j<n;j++)
    {
        arr[j]+=num;
    }
}

void Multiply(int arr[],int i,int n,int num)     //Function for multiplying an element from ith to nth terms in array
{
    for(int j=i;j<n;j++)
    {
        arr[j]*=num;
    }
}

int main()
{
    int t;      //Number of test cases
    cin>>t;     //Input number of test cases
    while(t--)    //loop for every test case
    {
        int n;      //number of elements
        int a,b,c;  //numbers A,B,C
        cin>>n;     //Input number of elements
        int arr[n]; //Array of elements
        for(int i=0;i<n;i++)
        {
            cin>>arr[i];        //Input array
        }
        cin>>a>>b>>c;           //Input A,B,C
        string str;             //String for defining functionality
        cin>>str;               //Input string
        for(int i=0;i<n;i++)       //Traversing the string
        {
           switch(str[i])
           {
           case 'A':                            //if  A is encountered
            Sum(arr,i,n,a);                     //Call function Sum
            for(int j=i;j<n;j++)
            {
                arr[j]=arr[j]%c;                //modulo each number from i to n-1 by C
            }
            break;
            case 'M':                           //if  M is encountered
            Multiply(arr,i,n,b);                //Call function Multiply
            for(int j=i;j<n;j++)
            {
                arr[j]=arr[j]%c;                //modulo each number from i to n-1 by C
            }
            break;
            case 'R':                            //if  M is encountered
            Reverse(arr,i,n);                    //Call function Reverse
            for(int j=i;j<n;j++)
            {
                arr[j]=arr[j]%c;                //modulo each number from i to n-1 by C
            }
            break;
           }
        }

        for(int k=0;k<n;k++)
        {
            cout<<arr[k]<<" ";                  //Output the final Array
        }
        cout<<endl;
    }
    return 0;
}
