#Program is made in python 3.5.0

A=[]
B=[]
C=[]
X=[]
Y=[]
A=input("Enter the cordinates for inital pickup:\t")
A=A.split(',')

B=input("Enter Destination:\t")
B=B.split(',')

DistAB=abs(int(B[0])-int(A[0]))+abs(int(B[1])-int(A[1]))

C=input("Current position of driver:\t")
C=C.split(',')
X=input("Enter the coordinates of first request:\t")
X=X.split(',')
Y=input("Enter the coordinates of second request:\t")
Y=Y.split(',')
DistCX=abs(int(X[0])-int(C[0]))+abs(int(X[1])-int(C[1]))
DistCY=abs(int(Y[0])-int(C[0]))+abs(int(Y[1])-int(C[1]))
if DistCX<2*DistAB and DistCY<2*DistAB:
    if DistCX<=DistCY:
        print("Pick up 1\n")
    elif DistCY<DistCX:
        print("pick up 2\n")
    else:
        print("pick up 1\n")
elif DistCX<2*DistAB:
    print("pick up 1\n")
elif DistCY<2*DistAB:
    print("pick up 2\n")
else:
    print("Reject both\n")
                                                                    
