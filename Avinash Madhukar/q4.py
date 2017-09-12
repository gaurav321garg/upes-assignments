import sys
from itertools import *
from functools import reduce


def powerset(iterable):
    
    """powerset([1,2,3]) --> () (1,) (2,) (3,) (1,2) (1,3) (2,3) (1,2,3)
    """
    
    s = list(iterable)
    return chain.from_iterable(combinations(s, r) for r in range(1,len(s)+1))


def igcd(a, b):
    
    """ greatest common divisor using euclid's, iteration 
    """
    
    while b:
        a, b = b, a % b
    return a


def listgcd(L):
    
    """ GCD is associative, GCD(a,b,c) is the same as (GCD(GCD(a,b),c) 
    """
    
    return reduce(igcd, L)


def llmul(a, b, M=10**9+7):

    """ fast modular multiplication
    """

    res = 0
    k = 14 # floor(64 - log2(MAX_VALUE))
    while a > 0:
        intA = a & ((1 << k) - 1)
        res = (res + b * intA) % M
        a >>= k
        b = (b << k) % M
    
    return res;


def bruteforce():

    """ N^2^n complexity, iterating over all the subsets to find the gcd
    """
    
    # number of test cases
    T = int(input())

    for i_th in range(T):
        
        # size of list A
        N = int(input())

        # list A of integers
        A = list(map(int, input().split()))

        # all the subsets, brute
        superset = powerset(A)

        # result
        answer = 1

        # interating over subsets
        for i in superset:
            answer = llmul(answer, listgcd(i))

        # faster i/o for long long ints
        sys.stdout.write("%d " % (answer%(10**9+7)))
        print(end='\n')


if __name__ == "__main__":
    bruteforce()