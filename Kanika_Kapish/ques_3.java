import java.util.*;


class Magic{

	public static void main(String args[]){
		
		Scanner s = new Scanner(System.in);
		
		int testCases=Integer.parseInt(s.readLine());
		String[] output=new String[testCases];
		
		for(int y=0;y<testCases;y++){

		int number=Integer.parseInt(s.readLine());
		int[] intArray=new int[number];
		String[] sArray=(s.readLine()).split(" ");
		
		for(int i=0;i<number;i++){
		
			intArray[i]=Integer.parseInt(sArray[i]);
		
		}
		
		String[] abc=(s.readLine()).split(" ");
		int[] abcArray=new int[3];
		
		for(int i=0;i<3;i++){
		
			abcArray[i]=Integer.parseInt(abc[i]);
		
		}

		
		String[] s=(s.readLine()).split("");
		
		
			for(int i=0;i<number;i++){
				
				if(s[i].equals("R")){
					
					for(int j = i; j < ((number+i-1)/ 2); j++)
						{
							int temp = intArray[j];
							intArray[j] = intArray[number - j - 1];
							intArray[number- j - 1] = temp;
						}
					
				}
				else if(s[i].equals("A")){

					
					for(int j = i; j < number; j++)
					{
				
						intArray[j] = intArray[j]+abcArray[0];
				
					}
					
				}
				else if(s[i].equals("M")){
		
					
					for(int j=i; j < number; j++)
					{
				
						intArray[j] = intArray[j]*abcArray[1];
				
					}
				}
				
		
			}
		
		
		for(int k=0;k<number;k++)
			{
			
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


}