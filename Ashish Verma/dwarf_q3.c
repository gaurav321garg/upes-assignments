/**
 * This program implements the Ancient Algorithm to learn a magic trick
 * 
 * 
 * @author Ashish Verma
 */
 
 //External Libraries
#include<stdio.h>

#include<string.h>


/*
*This method reverses the integers from i'th to n'th location
*
*@param array containing list of integers
*@param i index of the integer from where the string array is to be reversed
*@param n ,last index of integer in array
*/
void reverse(int L[],int i,int n)
{
	int temp;
	while(i<n-1)
	{
		temp=L[i];
		L[i]=L[n-1];
		L[n-1]=temp;
		i++;
		n--;
		
	}

}

 
 /*
 *
 * The main method computes the ancient algorithm and calls reverse method to reverse the string of integers .
 *
 */
int main(){
	
	int n=0,L[1000],t;
	int a,b,c,j,i;
	
	
	
	printf("Enter The No. of test cases:");                                  //Accepts the number of test cases
	
	scanf ("%d",&t);
	
	
	for(j=0;j<t;t--){
	
		printf("enter the number of integers: ");
		scanf("%d",&n);                                                       //accepts the count of integers 
	
		for(i=0;i<n;i++){
			
			scanf("%d",&L[i]);                                              //accepts the set of atomic integer values
		
		}
		printf("Speak out three Numbers\n");
			printf("Enter a:");
				scanf("%d",&a);
			printf("Enter b:");
				scanf("%d",&b);
			printf("Enter c:");
				scanf("%d",&c);
				
		char str[n];
		printf("enter the string of size n [in range of (A-Z)]: ");
			scanf("%s",str);                                                     //Accepts the string
			if(strlen(str)==n)                                                   //Conditional statement to check the length of string constraint
			{
				;
			}
			else
			{
				
			printf("size of string is not equal to that of max size of integer");
				continue;
			}	
			
			for(i=0;i<n;i++)
			{
				if(str[i]=='R')	
			{
				reverse(L,i,n);
			}	
			
			else if(str[i]=='A')
			
			{
				int k;
				for(k=i;k<n;k++)
				{
					L[k]=a+L[k];
				}
			}
			else if(str[i]=='M')
			{	
				int k;
				for(k=i;k<n;k++)
				{
					L[k]=b*L[k];
				}
			
			}
			
			
	}
	for(i=0;i<n;i++){
		int final=L[i]%c;                                       //Applying the modulo operator condition
		printf("%d\n ",final);                                 //Output the final generated number
	}
}}
