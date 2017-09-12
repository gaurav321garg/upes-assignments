travel_time=[]
ready_time=[]
cancel_time=[]
num=int(input("Enter the number of rides"))
print("Enter the travle time")
def calculate(num, travel_time,ready_time,cancel_time):
    minTime=0
    extraTime=0
    for i in range(num):
        if i != num-1:
            if minTime<=int(ready_time[i]):
                wait=int(ready_time[i])-minTime
                minTime+=wait
                minTime=minTime+int(travel_time[i])
                #print(minTime)
            elif minTime > int(ready_time[i])and minTime <= cancel_time[i]:
                    minTime=minTime+int(travel_time[i])
            else:
                return -1
        elif i == num-1:
            if minTime <= int(ready_time[i]):
                minTime=ready_time[i]
            else:
                return -1
    extraTime=int(ready_time[1])-int(travel_time[0])
    if extraTime>int(cancel_time[0]):
        minTime=minTime-int(cancel_time[0])
    return minTime


for i in range(num-1):
    travel_time.append(int(input()))
for i in range(num):
    ready_time.append(int(input()))
for i in range(num):
    cancel_time.append(int(input()))

print(calculate(num,travel_time,ready_time,cancel_time))


