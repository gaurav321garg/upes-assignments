N=int(raw_input())
travelTime=map(int,raw_input().split())
readyTime=map(int,raw_input().split())
cancelTime=map(int,raw_input().split())

flag=0
total_time=0

for i in range(N-1):
    if readyTime[i]<=total_time<=cancelTime[i]:
        total_time+=travelTime[i]

    elif total_time<readyTime[i]:
        total_time+=((readyTime[i]-total_time)+travelTime[i])

    elif total_time>cancelTime[i]:
        flag=1
        break

#For last stop
if readyTime[-1]>total_time:
    total_time+=(readyTime[-1]-total_time)

elif cancelTime[-1]<total_time:
    flag=1

if flag:
    print "-1"

else:
    print total_time
