import functools
from fractions import gcd
total_no = int(input("test cases"))
for total_test_case in range(total_no):
        data = []
        datanew = []
        gcd_value = []
        product = 1
        total_values = int(input("total numbers"))
        data=input("numbers:\t")
        data=data.split( )
        for i in range(total_values):
                data[i]=int(data[i])
        for i in range(1<<len(data)):
                for j in range(len(data)):
                        if (i&(1<<j)) > 0:
                                datanew.append(data[j])
                if not datanew:
                        continue
                gcd_value.append(functools.reduce(gcd,datanew))
                datanew = []
        for x in gcd_value:
                product=int(product)* int(x)
        print (product%10000000007)
