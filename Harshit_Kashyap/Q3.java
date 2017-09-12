

/* 
This code is created for Digicred round-1 programming
	
	by-Harshit Kashyap
	email- kashyap.harshit14@stu.upes.ac.in
	
*/


import java.io.InputStreamReader;
import java.io.BufferedReader;


class Q3{

	public static void main(String dt[]){
		
		InputStreamReader isr;
		BufferedReader br;
		
		isr=new InputStreamReader(System.in);
		br=new BufferedReader(isr);
		
		try{
		
		
		
		//input number of test cases
		
		int test=Integer.parseInt(br.readLine());
		String[] output=new String[test];
		
		for(int y=0;y<test;y++){
		
		//input <space> seperated numbers in integer array
		
		int number=Integer.parseInt(br.readLine());
		int[] intArray=new int[number];
		String[] sArray=(br.readLine()).split(" ");
		
		for(int i=0;i<number;i++){
		
			intArray[i]=Integer.parseInt(sArray[i]);
		
		}
		
		//input value of <space> seperated A B C
		
		String[] abc=(br.readLine()).split(" ");
		int[] abcArray=new int[3];
		
		for(int i=0;i<3;i++){
		
			abcArray[i]=Integer.parseInt(abc[i]);
		
		}
		
		//input String consisting ("R","A","M")
		
		String[] s=(br.readLine()).split("");
		
		
			for(int i=0;i<number;i++){
				
				if(s[i].equals("R")){
					
					// reverse the remaining sub Array
					
					for(int j = i; j < ((number+i-1)/ 2); j++)
						{
							int temp = intArray[j];
							intArray[j] = intArray[number - j - 1];
							intArray[number- j - 1] = temp;
						}
					
				}
				else if(s[i].equals("A")){
					
					//add value of A to all to all elements of sub integer array
					
					for(int j = i; j < number; j++)
					{
				
						intArray[j] = intArray[j]+abcArray[0];
				
					}
					
				}
				else if(s[i].equals("M")){
					
					//multiply value of B to all to all elements of sub integer array
					
					for(int j=i; j < number; j++)
					{
				
						intArray[j] = intArray[j]*abcArray[1];
				
					}
				}
				
		
			}
		
		
		for(int k=0;k<number;k++)
			{
			
			// set value of all elements of array as remainder of value divided by C
			
			intArray[k]=intArray[k]%abcArray[2];
			}
		
			output[y]=Integer.toString(intArray[0])+" ";
			for(int f=1;f<number;f++)
				{
				output[y]=output[y]+Integer.toString(intArray[f])+" ";
				}
			}	
		
			for(int r=0;r<test;r++)
				{
			System.out.println(output[r]);
				}
		
		}
		catch(Exception e){
			System.out.println(e);
		}
		finally{
			
			try{
			br.close();
			isr.close();
			}
			catch(Exception e){
				
				System.out.println(e);
			}
		}
	
	
	}


}