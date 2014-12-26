import math


#Oppgave 1

pi = 3.1415

r = [3, 2.3, 5]
null = [(pi/2), (pi/3), 0]
opp = [0, 1, 2]

for o in opp:
	print("kordinatene er:")
	x = r[o]*math.cos(null[o])
	y = r[o]*math.sin(null[o])
	print("x er lik: ", x )
	print("y er lik: ", y )

print("ferdig med oppgave 1")

#Oppgave 2

bi1 = (13*12)/2
bi2	= ((4*3)/2)**2
bi3 = 11
bi4	= 4

antmuligheter = bi1 * bi2 * bi3 * bi4

sannsynlighet = antmuligheter / 2598960 * 100

print("Sannsynligheten for å få to par i Texas hold'em er", sannsynlighet, "%")
print("ferdig med oppgave 2")


#Oppgave 3

a = 4 * math.atan(1)
print("a er lik: ",a)

b = math.sqrt(2)
print("b er lik: ",b)

print("ferdig med oppgave 3")
