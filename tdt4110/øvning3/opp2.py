#!/usr/bin/python3

debug = True 

def add(a,b):
	
	if debug == True:
		print("Tallene som er tastet inn er: ", a, b)

	c = a + b
	return c

print(add(3,4))
