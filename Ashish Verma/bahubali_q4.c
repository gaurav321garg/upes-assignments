/**
 * This program implemenst concept of HCF/GCD to find the product  of all subsets of, 
 * given integer array
 * 
 * 
 * @author Ashish Verma
 */
 
 //External library
#include<stdio.h>


/**
* This functions finds all posible subsets of given integer array.
* 
* This substring function uses findgcd method to find GCD's of all subsets
* @param A[] given array Super set
* @param n Length of array
* @return k ,product of GCD's of all substring 
*/
void substring(int A[],int n)
{ 	
	int i=0;
	int k=1;
	for(i=0;i<n;i++)
	{		int j;
			for( j=i;j<n;j++)
			{
	  			k*=findgcd(A,i,j);	             //Calling findgcd method to find gcd 
			}

	}
	
	k=k%1000000007;                               //Modulo operator to make the output value smaller
	printf("\t%d\n",k);                           //To print the final product of the GCD's of all subsets
}



/**
*This function finds the GCD  of subset of Super array by calling the method compute gcd
*
* @param array of integers
* @param start index no of subset
* @param end index of the subset whodse gcd is to be found
* @return g,GCD of the particular subset
*/
int findgcd(int A[], int i,int j)
{
	int k;
	for( k=i;k<=j;k++)
	{
		if(i==j)
		return A[i];
		else if(j-i==1)                                   //Number of integers whose GCD is to be found
		return computegcd(A[i],A[j]);                           
		else if(j-i>1)
		{
			int g;
				g=computegcd(A[i],A[i+1]); 
			int k;
			for( k=i+2;k<=j;k++)                         //Recursive functoin to compute GCD of more then two numbers
			{
				
				 g=computegcd(g,A[k]);
			}
			return g;
		}


	}
}

/*
* This function finds the GCD of two Numbers 
* @param a ,fisrt number
* @param b,second number
* @return a ,if two numbers are same the GCD is number itself.
* @return g,GCD of two numbers.
*/
int computegcd(int a,int b)
{
	int g;
	
	if(a==b)                                       //If two numbers are same return the number itself.
	{
 	return a;     
 	}

	else if(a<b)                             
	{ 
		int i;
		for(i=a;i>0;i--)
		{                                      //Finding Common Divisors
			if(a%i==0 && b%i==0)
			{
				g=i;                          //Storing common divisor in variable
				break;
			}
		}
		return g;
	}
	else if(a>b)
	{
		int i;
		for(i=b;i>0;i--)
		{
			if(a%i==0 && b%i==0)
			{
				g=i;
				break;
			}
		}
		return g;
	}
}

/*
* The main method accepts the total number of test cases from client and call the method substring by passing parameters.
*
*/
void main()
{ 
	int n,t=0,g=0;

	printf("Enter the No of test cases:");                              //Accepts number of test cases 
		scanf("%d",&t);
		
	for(g=0;g<t;g++)
	{

		printf("Enter the count of integers of array:");                 
			scanf("%d",&n);                                             //Accepts length of array
		int A[n];                                                       //Memory allocation For integer array of n size 
		int i;
		
		for( i=0;i<n;i++)
		{
			scanf("%d",&A[i]);                                         //Accepts the elements of array
		}
			substring(A,n);                                            //Call substring method and pass Array and It's length
	}
}
