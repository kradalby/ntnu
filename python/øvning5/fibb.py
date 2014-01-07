#!/bin/usr/python3

def fibb(n):
    if n > 1:
        return fibb(n - 1) + fibb(n - 2)
    elif n == 0:
        return 0
    elif n == 1:
        return 1


print(fibb(13))
