import java.util.*;
public class question3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int T, N, item, temp, A , B , C, pos;
		String S = "";
		Scanner sc = new Scanner(System.in); //Scanner object for taking inputs
		ArrayList<Integer> L = new ArrayList<Integer>();
		T = sc.nextInt();
		
		while(T!=0) //Test cases start
		{
			N = sc.nextInt(); //Number of elements
			temp = N;
			while(temp!=0)
			{
				item = sc.nextInt(); //Get the elements of the list
				L.add(item);	
				temp--;
			}
			
			A = sc.nextInt();//Input A	
			B = sc.nextInt();//Input B
			C = sc.nextInt();//Input C
			
			sc.nextLine();
			
			S = sc.nextLine(); //String S
			char ch[] = S.toCharArray(); //Convert S to a character array so we can check for each character
			for(int i = 0;i < N; i++)
			{
			     if(ch[i] == 'R') //Incase R encountered, reverse the ArrayList
			    	 {
			    	 	int start, end;
			    	 	int x = i, y = N-1;
			    	 	while(x < y)
			    	 	{
			    	 		start = L.get(x);
			    	 		end = L.get(y);
			    	 		L.set(x, start);
			    	 		L.set(y, end);
			    	 		x++;
			    	 		y--;
			    	 	} 		    		 
			    	 }
			     
			   	 else if(ch[i] == 'A') //Incase A encountered, add A to each element
			    	 {			    	 
			    	 	for(int x=i;x<L.size();x++)
			    	 	{
			    	 		L.set(x, L.get(x)+A);
			    	 	} 	
			    	 }
			     
		    	 else if(ch[i] == 'M') //Incase M encountered, multiply each element by B
		    	 	{			    	 
			    	 for(int x=i;x<L.size();x++)
			    	 	{
			    	 		L.set(x, L.get(x)*B);
			    	 	}			    	 
		    	 	}
			          
			 }				
				
				for(int x=0;x<L.size();x++) //Module all elements by C
	    	 	{
	    	 		L.set(x, L.get(x) % C);
	    	 	}
				
				Iterator itr=L.iterator();  //Iterate through updated list
				  while(itr.hasNext()){  
				   System.out.print(itr.next() + " ");  
				  }  
				  
			L.clear(); //Reset ArrayList for next test case
			T--; //Decerement T
			  }		
	}
}
		

