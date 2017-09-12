import sys
from collections import deque



def main():
    
    """ linear complexity using maths and deque library
    """        
  
    # number of test cases
    T = int(input())

    for i_th in range(T):
        
        # size of list L
        N = int(input())
        
        # list L
        L = deque(input().split())
        
        # three space seperated integer
        A,B,C = map(int, input().split())
        
        # string S as input
        S = input()

        # taking flag for multiplication
        mul = 1
        
        # taking flag for addtition
        add = 0

        # taking flag for 'R'
        Rflag = True
        
        for op in S:
            if op == 'R':
                # flag for 'R'
                Rflag = not Rflag

            elif op == 'A':
                # summing up addition
                add = (add + A) % C

            elif op == 'M':
                # multiplication flag
                mul = mul * B % C
                
                # multiplication flag for addition flag
                add = add * B % C

            # using deque for constant complexity of popping on both side
            # deleting the first/last element depending on Rflag, we dont need to manipulate it further
            if Rflag:
                v = int(L.popleft())
            else:
                v = int(L.pop())

            # for faster input/output
            sys.stdout.write("%d " % ((v * mul + add) % C))
        print('')

if __name__ == "__main__":
    main()