
package q1;

import java.util.Scanner;

public class Q1 {

    int accept_request(int A[],int B[],int C[],int x[],int y[])
    {
        int total_dis,distancex,distancey;
        total_dis=calculate_distance(A,B);
        distancex=calculate_intermediate_dis(C,x,B);
        distancey=calculate_intermediate_dis(C,y,B);
        if((distancex<distancey)&&(distancex<(2*total_dis)))
                {
                    return 1;
                }
       else if((distancey<distancex)&&(distancey<(2*total_dis)))
                {
                    return 2;
                }
        else if((distancey==distancex)&&(distancex<(2*total_dis)))
                {
                    if(x[2]<y[2])
                        return 1;
                    else
                        return 2;
                }
        else
            return -1;
    }
    
    int calculate_distance(int A[],int B[])
    {
        int dis=0;
        dis=B[0]-A[0];
        if(dis<0)
        {
            dis=-(dis);
        }
        dis+=B[1]-A[1];
        return dis;
    }
    int calculate_intermediate_dis(int C[],int pos[],int B[])
    {
        int dis=0;
        dis=calculate_distance(C,pos);
        dis=calculate_distance(pos,B);
        return dis;
    }
    public static void main(String[] args) {
        int A[] = new int[2];
        int B[] = new int[2];
        int C[] = new int[2];
        int X[] = new int[2];
        int Y[] = new int[2];
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<2;i++)
        {
            A[i]=sc.nextInt();
        }
        for(int i=0;i<2;i++)
        {
            B[i]=sc.nextInt();
        }
        for(int i=0;i<2;i++)
        {
            C[i]=sc.nextInt();
        }
        for(int i=0;i<2;i++)
        {
            X[i]=sc.nextInt();
        }
        for(int i=0;i<2;i++)
        {
            Y[i]=sc.nextInt();
        }
        Q1 q = new Q1();
        System.out.println(q.accept_request(A,B,C,X,Y));
    }
    
}
