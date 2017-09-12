//Question 2
//Abhishek Dutta
//B.Tech CSE CCVT 4th Year, UPES Dehradun
import java.util.*;

class request{
	public int travel_time;
	public int ready_time;
	public int cancel_time;
}

public class question2 {

	static int calculate(request arr[], int N, int t_time)
	{
		int i;
		int flag = 0; //Just to check if it is possible to fulfill all requests
		for(i=1;i<N;i++)
		{
			
			//Taxi arrives early i.e before the ready time of i'th request
			if(t_time + arr[i-1].travel_time < arr[i].ready_time)
				t_time = arr[i].ready_time;
			
			//Taxi arrives on time i.e before getting cancelled 
			else if( t_time+arr[i-1].travel_time >= arr[i].ready_time && ( t_time+arr[i].travel_time )<=(arr[i].ready_time+arr[i].cancel_time))
				t_time+=arr[i].travel_time;
					
			else //Cannot fulfill any one request, then set flag to 1
			{
				flag = 1;
				break;
			}
		}
		
		if(flag==1 || t_time > 86400) //Incase total time crosses total number of seconds in a day(impossible to service)
			return -1;
		else	//Return minimum amount of time route will take
			return t_time;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N, i, t_time;
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); //
		request arr[] = new request[N];
		
		for(i=0; i< arr.length;i++) //Instantiate each element in the object array
		    arr[i] = new request();
		
		for(i=0; i<N-1; i++) //Take travel time input
		{
			arr[i].travel_time = sc.nextInt();
		}
		
		for(i=0;i<N;i++) //Take ready time and cancel time input
		{
			arr[i].ready_time = sc.nextInt();
			arr[i].cancel_time = sc.nextInt();	
		}
		t_time = arr[0].ready_time;
		System.out.println(calculate(arr,N,t_time));
	}

}
