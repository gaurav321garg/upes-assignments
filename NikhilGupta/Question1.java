
import java.io.*;
import java.util.*;
class Question1
{
	int xCordi;
	int yCordi;
	public static void main(String args[])
	{
		//Initialization of location points.
		/*
		a=start point
		b=end point
		c=mid point (at which other drivers arrives)
		x=start point of 1st new driver
		y=start point of 2nd new driver
		*/
			
		Question1 a=new Question1();
		Question1 b=new Question1();
		Question1 c=new Question1();
		Question1 x=new Question1();
		Question1 y=new Question1();
		Scanner sc=new Scanner(System.in);
		int totalTimeWithoutExtra,totalTimeWithExtra1,totalTimeWithExtra2;
		int timeTillC;
		
		
		//Taking values from user
		a.xCordi=sc.nextInt();
		a.yCordi=sc.nextInt();
		b.xCordi=sc.nextInt();
		b.yCordi=sc.nextInt();
		c.xCordi=sc.nextInt();
		c.yCordi=sc.nextInt();
		x.xCordi=sc.nextInt();
		x.yCordi=sc.nextInt();
		y.xCordi=sc.nextInt();
		y.yCordi=sc.nextInt();
		
		//total time taken without new drivers
		totalTimeWithoutExtra=(Math.abs(b.xCordi-a.xCordi))+(Math.abs(b.yCordi-a.yCordi));

		//time completed when new drivers arrives
		timeTillC=(Math.abs(c.xCordi-a.xCordi))+(Math.abs(c.yCordi-a.yCordi));

		//total time with 1st as new driver
		totalTimeWithExtra1=timeTillC+(Math.abs(x.xCordi-c.xCordi))+(Math.abs(x.yCordi-c.yCordi))+(Math.abs(b.xCordi-x.xCordi))+(Math.abs(b.yCordi-x.yCordi));

		//total time with 2nd as new driver
		totalTimeWithExtra2=timeTillC+(Math.abs(x.xCordi-c.xCordi))+(Math.abs(x.yCordi-c.yCordi))+(Math.abs(b.xCordi-x.xCordi))+(Math.abs(b.yCordi-x.yCordi));

		if(totalTimeWithExtra2<totalTimeWithExtra1){
			if(totalTimeWithExtra1<=(totalTimeWithoutExtra*2))
				System.out.println("1");
			else
				System.out.println("-1");
		}
		else
		{
			if(totalTimeWithExtra2<=(totalTimeWithoutExtra*2))
				System.out.println("2");
			else
				System.out.println("-1");

		}
	}
	}

