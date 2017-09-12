lists = []
strinf = []
numbers = []
test_case=int(input("Enter the number of test cases"))
for test in range(test_case):
    N = int(input("N:\t"))
    lists=input("List:\t")
    lists=lists.split( )
    numbers=input("A B C:\t")
    numbers=numbers.split( )
    string=input("String:\t")
    for i in range(N):
        if string[i]=='R':
            lists[i:] = reversed(lists[i:])
        elif string[i]=='A':
            lists[i:] = [int(x)+int(numbers[0]) for x in lists[i:]]
        elif string[i]=='M':
            lists[i:] = [int(x)*int(numbers[1]) for x in lists[i:]]

    lists[i:] = [x%int(numbers[2]) for x in lists[i:]]
    print(lists)
