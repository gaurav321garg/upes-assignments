def GCD(a,b):
    '''
    Function to find GCD of two numbers
    '''
    if a==0:
        return b

    return GCD(b%a,a)

def findGCD(item):
    '''
    Function to find GCD of an array
    '''
    if len(item)==0:
        return 1
    ans=item[0]

    for i in range(1,len(item)):
        ans=GCD(item[i],ans)

    return ans

def getSubsets(A,N):
    '''
    Function to find all subsets of an array
    '''
    subsets=[]

    for i in range(2**N):
        curr_set=[]
        for j in range(N):
            if(i & (1<<j)):
                curr_set.append(A[j])
        subsets.append(curr_set)
    return subsets

def getSubsetProducts(Subsets):
    '''
    Function to find product of GCD of all subsets of an array
    '''
    ans=1

    for item in Subsets:
        gcd=findGCD(item)
        ans*=gcd

    return ans

def main():
    T=int(raw_input())

    for _ in range(T):
        N=int(raw_input())
        A=map(int,raw_input().split())

        subsets=getSubsets(A,N)
        subsets=list(subsets)
        ans=getSubsetProducts(subsets)
        print ans

if __name__=="__main__":
    main()
