
import java.util.*;

public class Question3{
	public static void reverseArray(int arr[], int start, int end)
	{
	    int temp=0;
	    while (start < end)
	    {
	        temp = arr[start];   
	        arr[start] = arr[end];
	        arr[end] = temp;
	        start++;
	        end--;
	    }   
	}     
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ListArray[] = new int[500];
		Scanner sc = new Scanner(System.in);
		int noOfInputs = sc.nextInt();
		
			int listSize = sc.nextInt();
		
		for (int i=0;i<listSize;i++)
		{
			ListArray[i]=sc.nextInt();
		}
		int ABC[]= new int[3];
		for (int w=0;w<3;w++)
		{
			ABC[w]=sc.nextInt();
		}
		String ram = sc.next();
		char[] letters = ram.toCharArray();
		for (int k=0;k<letters.length;k++)
		{
			if(letters[k]=='R')
			{
				reverseArray(ListArray,0,listSize-1);
			}
			if(letters[k]=='A')
			{
				for (int i=0;i<listSize;i++)
				{
					ListArray[i]=ListArray[i] + ABC[0];
				}
			}
			if(letters[k]=='M')
			{
				for (int i=0;i<listSize;i++)
				{
					ListArray[i]=ListArray[i] * ABC[1];
				}
			}
		}
		for(int z=0;z<listSize;z++)
		{
			ListArray[z]=(ListArray[z])%(ABC[2]); 
			
		}
		
		for(int y=0;y<listSize;y++)
		{
			System.out.print(ListArray[y]+" "); 
		}
		
	}

}
