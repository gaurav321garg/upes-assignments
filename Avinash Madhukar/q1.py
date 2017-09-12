def dis(x1, y1, x2, y2):
	
	""" manhattan distance |x1 - x2| + |y1 - y2|, between (x1,y1) and (x2,y2) 
	"""
	return abs(x1 - x2) + abs(y1 - y2)



def main():

	# taking inputs as x,y coordinates at each point (A, B, C, X, Y), seperated by space
	Ax, Ay = map(int, input().split())
	Bx, By = map(int, input().split())
	Cx, Cy = map(int, input().split())
	Xx, Xy = map(int, input().split())
	Yx, Yy = map(int, input().split())

	# distance A --> B
	dis_AB = dis(Ax, Ay, Bx, By)
	# print(dis_AB)
	
	# distance A --> C --> X --> B
	dis_thruX = dis(Ax, Ay, Cx, Cy) + dis(Cx, Cy, Xx, Xy) + dis(Xx, Xy, Bx, By)
	# print(dis_thruX)

	# distance A --> C --> Y --> B
	dis_thruY = dis(Ax, Ay, Cx, Cy) + dis(Cx, Cy, Yx, Yy) + dis(Yx, Yy, Bx, By)
	# print(dis_thruY)

	# minimum out of distance with rider X and rider Y
	minXY = min(dis_thruX, dis_thruY)


	# the final length of the trip can't be more than two times longer than the length of the trip with no extra riders
	max_dis_with_riders = 2*dis_AB

	if minXY > max_dis_with_riders:
		print(-1)
	elif dis_thruX <= dis_thruY:
		print(1)
	else:
		print(2)
		
if __name__ == "__main__":
	main()