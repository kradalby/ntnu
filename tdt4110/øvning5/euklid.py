#!/usr/bin/python3
# -*- coding: utf-8 -*-

def gcd(a,b):
    while b != 0:
        gammelB = b
        b = a % b
        a = gammelB
        
    return a

#print(gcd(1122,867))

def reduce_fraction(a,b):
    devisor = gcd(a,b)
    a = a // devisor
    b = b // devisor
    return a, b


def main():
    a, b = reduce_fraction(4,8)
    print(a, "/", b)

main()
