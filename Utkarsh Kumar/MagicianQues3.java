import java.util.Scanner;

class MagicianQues3{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		//accepting the number of test cases
		int tc = sc.nextInt();

		//looping through the cases
		for(int t = 0; t< tc; t++){

		//size of the number array l
		int n = sc.nextInt();
		int[] l = new int[n];

		//accepting the elements of array l
		for(int i = 0; i<n; i++){
			l[i] = sc.nextInt();
		}

		//taking A,B,C
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();

		//String input
		String str = sc.next();

		//String to char array conversion
		char[] ch = str.toCharArray();

		//traversing the char array and matching subsequent
		//integer values to any of A,R or M
		for(int i = 0; i<ch.length; i++){
			char x = ch[i];
			if(x == 'A'){

				//loop for given condition A
				for(int j = i; j<n; j++){
					l[j] = l[j] + a;
				}
			}

			//loop for given condition M
			else if(x == 'M'){
				for(int j = i; j<n; j++){
					l[j] = l[j]*b;
				}
			}
			//loop for condition R
			else if(x == 'R'){
				int ii = i;
				//making a new array to store elements of l from i to n
				int[] arr2 = new int[n-i];
				//loop to store l[i] to l[n] into new array
				for(int z = i; z<n; z++){
				arr2[z-i] = l[z];
				}
				//to reverse the new array's elements
				for(int q=0; q<arr2.length/2; q++){
  					int temp = arr2[q];
 					 arr2[q] = arr2[arr2.length -q -1];
 					 arr2[arr2.length -q -1] = temp;
				}
				//to override the old array with modified values
				for(int q = i; q<n; q++){
				l[q] = arr2[q-i];
				}
			}
		}
		
		//computing the modulus with C
		for(int tt = 0; tt<l.length; tt++){
			l[tt] = l[tt] % c;
		}
		//printing the result
		for(int tt = 0; tt < l.length; tt++){
			System.out.print(l[tt]+" ");
		}
	}	
  }
}
