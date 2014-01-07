from math import sqrt

def tre(x,y,z):
    return [x,y,z]

def vakker(x,y,z):
    list = tre(x,y,z)
    print("Pretty: ",list[0],',',list[1],',',list[2])

def vektorskalar(x,y,z,s):
    vec1 = tre(x,y,z)
    vec1[0] = vec1[0] * s
    vec1[1] = vec1[1] * s
    vec1[2] = vec1[2] * s
    print(vec1)
    return vec1

def lengde(x,y,z,s):
    vec1 = [x,y,z]
    vec1_length = sqrt((vec1[0]**2)+(vec1[1]**2)+(vec1[2]**2))
    vecsk = vektorskalar(x,y,z,s)
    vecsk_length = sqrt((vecsk[0]**2)+(vecsk[1]**2)+(vecsk[2]**2))
    forhold = vecsk_length / vec1_length
    print("Lengde på vektor1: ",vec1_length)
    print("Lengden på vektor1 etter skalar: ",vecsk_length)
    print("Forholdet mellom lengdene: ",forhold)

def indre(a,b,c,x,y,z):
    print(a*x,b*y,c*z)

print(tre(3,5,6))

vakker(3,5,6)

vektorskalar(3,5,6,3)

lengde(3,5,6,3)

indre(3,5,6,4,6,7)
