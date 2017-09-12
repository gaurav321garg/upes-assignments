/**
 * This program finds out which additional rider needs to be picked in order to travel the least distance when an additional rider request,
 * for pooling at particular point of co-ordinate 
 * 
 * 
 * @author Ashish Verma
 */
 //External Libraries
#include<stdio.h>
#include<math.h>   

/**
* The main method computes the decision a uber driver needs to make in order to choose the rider .
*
*
*/                                       

int main ()
{
    int ac=0,cy=0,cx=0,yb=0,xb=0;
    int A[2],B[2],C[3],Y[2],X[2];
       
    printf("Enter Start Trip point A [x,y]:");
    scanf("%d",&A[0]);                                              //Accepts the X-coordinate of start point
    scanf("%d",&A[1]);                                              //Aceepts the Y-coordinate of start point
       
    printf("Enter Destination Trip point B [x,y]:");
    scanf("%d",&B[0]);                                              //Accepts the X-coordinate of destination point
    scanf("%d",&B[1]);                                              //Aceepts the Y-coordinate of destination point
      
    printf("Enter Co-ordinates of C [x,y]:");
    scanf("%d",&C[0]);                                              //Accepts the X-coordinate of point at which driver gets another request
    scanf("%d",&C[1]);                                              //Accepts the Y-coordinate of point at which driver gets another request
       
    printf("Enter Co-ordinates of X [x,y]:");
    scanf("%d",&X[0]);                                              //Accepts the X-coordinate of 1st  rider request
    scanf("%d",&X[1]);                                              //Accepts the Y-coordinate of 1st  rider request
       
    printf("Enter Co-ordinates of Y [x,y]:");
    scanf("%d",&Y[0]);                                               //Accepts the X-coordinate of 2nd rider request
    scanf("%d",&Y[1]);                                               //Accepts the X-coordinate of 2nd rider request
       
	int d_a_b =abs(A[0]-B[0])+abs(A[1]-B[1]);                        //Distance between A and B point

	int d_A_c =abs(A[0]-C[0])+abs(A[1]-C[1]);                        //Distance between A and C point
       
    int d_c_x=abs(C[0]-X[0])+abs(C[1]-X[1]);                         //Distance between C and X point
	
	int d_c_y=abs(C[0]-Y[0])+abs(C[1]-Y[1]);                         //Distance between C and Y point
	   
	int d_x_b=abs(X[0]-B[0])+abs(X[1]-B[1]);                         //Distance between X and B point
	   
	int d_y_b=abs(Y[0]-B[0])+abs(Y[1]-B[1]);                         //Distance between Y and B point
		
	int d_A_c_y_b= d_A_c+ d_c_y + d_y_b;                             //Distance between A,C,Y,B point
	
	int d_A_c_x_b= d_A_c+ d_c_x + d_x_b;                             //Distance between A,C,X,B point
	
	int max_dis=2*d_a_b;
		
	if(d_A_c_y_b < d_A_c_x_b){
		if(d_A_c_y_b< max_dis)
			printf("2");
		else
			printf("-1");
	}
	else{
		if(d_A_c_x_b< max_dis)
			printf("1");
		else
			printf("-1");
	}		
	return 0;		
}
