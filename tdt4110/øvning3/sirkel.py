import math


def sirkel(r):
	a = math.pi*(r**2)
	o = 2*math.pi*r
	print('Areal: ', format(a, '.2f'))
	print('Omkrets: ', format(o, '.2f'))

sirkel(10)

def radius(a,o):
	if o > 0:
		r = o/(2*math.pi)
	else:
		r = math.sqrt(a/math.pi)
	print("Radius av sirkelen er:", format(r, '.2f'))
radius(0,3)
