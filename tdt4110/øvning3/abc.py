#!/usr/bin/python
# -*- coding: utf-8 -*-
#abc formelen python

from math import sqrt

def abcformelen(a,b,c):
	d = ((b**2) - (4 * a * c))
	#print(d)	
	if d < 0:
		print("Svaret har to imaginære løsninger")
	elif d == 0:
		r1 = ((-b) + sqrt(d))/(2 * a)
		#print(format(r1, '.3f'))
		print("Svaret har en reel dobbeltrot")
	else:
		r1 = ((-b) - sqrt(d))/(2 * a)
		r2 = ((-b) + sqrt(d))/(2 * a)
		#print(format(r1, '.3f'))
		#print(format(r2, '.3f'))
		print("Svaret har to reelle løsninger")



def main():
    a = int(input("Tast inn a: "))
    b = int(input("Tast inn b: "))
    c = int(input("Tast inn c: "))
    abcformelen(a,b,c)

main()
