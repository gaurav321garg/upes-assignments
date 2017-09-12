#Function to find distance between 2 points.
def findDist(A,B):
    return abs(A[0]-B[0])+abs(A[1]-B[1])

def main():
    #Input all the arrays
    A=map(int,raw_input().split())
    B=map(int,raw_input().split())
    C=map(int,raw_input().split())
    X=map(int,raw_input().split())
    Y=map(int,raw_input().split())

    #Find the distance between A and B.
    uninterrupted_dist=abs(A[0]-B[0]) + abs(A[1]-B[1])

    #Twice of distance between A and B.
    double_dist=2*uninterrupted_dist

    #Find the distance between A and C.
    mid_dist=abs(A[0]-C[0]) + abs(A[1]-C[1])

    #Find distance between A to C to X to B.
    dist_A_C_X_B=mid_dist+findDist(C,X)+findDist(X,B)

    #Find the distance between A to C to X to B.
    dist_A_C_Y_B=mid_dist+findDist(C,Y)+findDist(Y,B)

    #Find the shorter distance to be travelled for the two extra riders.
    if dist_A_C_X_B < dist_A_C_Y_B:
        shorter_dist=dist_A_C_X_B

    #If X is shorter than Y and also double return 1
        if shorter_dist<=double_dist:
            return 1

    #if X is longer than double of dist between A and B, return -1.
        else:
            return -1

    else:
        shorter_dist=dist_A_C_Y_B

    #Same logic as above.
        if shorter_dist<=double_dist:
            return 2

        else:
            return -1


if __name__=="__main__":
    print main()
