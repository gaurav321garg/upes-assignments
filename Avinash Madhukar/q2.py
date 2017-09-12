def main():

	# input N
	N = int(input())

	# input arrays
	travelT = list(map(int, input().split()))
	readyT = list(map(int, input().split()))
	cancelT = list(map(int, input().split()))

	# initial corner case addition
	total = travelT[0] + readyT[0]
	answer = 0
	
	# boolean flag
	flag = 0

	for i_th in range(1, N):
		# print(total)
        # is rider ready or uber has to wait

		if readyT[i] > answer:
			total = readyT[i]

        # if rider can wait for uber

		if answer <= cancelT[i]:
			if i < N - 1:
				total += travelT[i-1] # add travel time

		else:
			# if rider can't wait then all can't be served
			flag = 1 
			break

	# output
	if flag:
		print(-1)
	else:
		print(total)

if __name__ == "__main__":
	main()