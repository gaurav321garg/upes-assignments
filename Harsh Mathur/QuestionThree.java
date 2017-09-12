/**
 * The QuestionThree program implements AncientAgorithm to impress my GirlFriend
 * 
 * @author Harsh Mathur
 */

import java.util.*;

public class QuestionThree {

	/**
	 * This function reverses the value of list from range i to n
	 * @param listL Accept complete integer array
	 * @param i starting range on which operation is to be performed
	 * @param n length of array
	 * @return updated listL with elements from i to n in reversed order
	 */
	static int[] reverse(int[] listL, int i, int n) {
		int[] temp = new int[n];                  //temporary array of same length to store altered array
		int pointer = n-1;
		
		/* 
		 * copy values which need not to be reversed
		 */
		for(int j=0; j < i; j++){
			temp[j] = listL[j];
		}

		/* 
		 * reverse values order from i to n-1
		 */
		for(int j=i; j < n; j++){
			temp[j] = listL[pointer--];
		}
		return temp;
		
	}
	
	
	/**
	 *  This function add A to each and every element of listL
	 * @param listL accepts array on which operation will be performed
	 * @param i starting range 
	 * @param n length of array
	 * @param A value to be added to each element
	 * @return updated listL array
	 */

	static int[] addA(int[] listL, int i, int n, int A) {
		for(int j = i; j < n; j++){
			listL[j] = (listL[j] + A);              // Add A to each element from i to n-1
		}
		return listL;
	}
	
	/**
	 *  This function multiply B to each and every element of listL
	 * @param listL accepts array on which operation will be performed
	 * @param i starting range 
	 * @param n length of array
	 * @param B value to be multiplied to each element
	 * @return updated listL array
	 */
	static int[] multiplyWithB(int[] listL, int i, int n, int B) {
		for(int j = i; j < n; j++){
			listL[j] = listL[j] * B;			    // Multiply each element from i to n-1 with B
		}
		return listL;
	}

	/**
	 *  This function module each and every element of listL by value in C
	 * @param listL accepts array on which operation will be performed
	 * @param i starting range 
	 * @param n length of array
	 * @param C value with which each element will module
	 * @return updated listL array
	 */
	static int[] moduleByC(int[] listL, int i, int n, int C) {
		for(int j = i; j < n; j++){
			listL[j] = listL[j] % C;               // Take modulus of each element in the range i to n-1
		}
		return listL;
	}
	
	/**
	 * This function performs given Ancient Algorithm to announce elements
	 * @param listL array of values
	 * @param str String with element 'A', 'R' and 'M'
	 * @param a value which will be added to elements of array
	 * @param b value which will be multiplied to elements of array
	 * @param c value with which list will module
	 * @param n length of array listL
	 */
	static void AncientAlgorith(int[] listL, String str, int a, int b, int c, int n) {
		for(int i = 0; i < n; i++){
			switch(str.charAt(i)){                 // Check for each character in given string and perform operation character wise
				case 'R' : listL = reverse(listL, i, n);
						   break;
				case 'A' : listL = addA(listL, i , n, a);
						   break;
				case 'M' : listL = multiplyWithB(listL, i, n, b);
						   break;
				default  : break;
			}
			
			listL = moduleByC(listL, i, n, c);
			
			System.out.print(listL[i]+" ");
		}
		System.out.println("");
	}


	/**
	 * This is the main method which makes use of method AncientAlgorithm to impress my girlFriend
	 * 
	 * @param args Unused
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter (T) number of test cases :");
		int t = sc.nextInt();                         // accepts number of test cases need to be performed
		
		for(int j = 0; j < t; j++){
			
			System.out.println("Enter value of N (length of array)");
			int N = sc.nextInt();                     // accepts length of array
			int[] listL = new int[N];
			
			System.out.println("Enter array of "+N+" elements");
			for(int i = 0; i<N; i++){
				listL[i] = sc.nextInt();
			}
			
			System.out.println("Enter value of A");
			int a = sc.nextInt();	
			System.out.println("Enter value of B");
			int b = sc.nextInt();
			System.out.println("Enter value of C");
			int c = sc.nextInt();
			
			System.out.println("Enter string");
			String str = sc.next().toUpperCase();
			
			AncientAlgorith(listL, str, a, b, c, N);   // call function for each test case
		}
		
		sc.close();
	}
}
