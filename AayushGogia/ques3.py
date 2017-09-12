T=int(raw_input())

for _ in range(T):
    N=int(raw_input())
    L=map(int,raw_input().split())
    A,B,C=map(int,raw_input().split())
    S=raw_input()

    #Iterate for every value in L
    for i in range(N):
        #Case 1: reverse L[i..N]
        if S[i]=='R':
            temp=L[i:N]
            temp.reverse()
            L=L[0:i]+temp

        #Case 2: Add A to L[i..N]
        elif S[i]=='A':
            for j in range(i,N):
                L[j]+=A

        #Case 3: Multiply B to L[i..N]
        elif S[i]=='M':
            for j in range(i,N):
                L[j]*=B

        #Mod L[i..N] by C
        for j in range(i,N):
            L[j]%=C

        #Announce L[i]    
        print L[i],
