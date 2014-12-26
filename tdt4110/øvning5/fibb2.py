def function(n):	
	if(n > 1):
		return function(n - 1) + function(n - 2)
	elif(n == 1):
		return 1
	elif(n == 0):
		return 0

	
print(function(7))
