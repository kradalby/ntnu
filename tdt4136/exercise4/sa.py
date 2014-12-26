import math
import random
from copy import deepcopy

from board import *

random.seed()

'''
Simulated annealing function, written from pseudocode
in exercise description.
'''

def sa(board, ft, t):
    p = board
    #t = 5000
    t_max = t
    best_p = p
    while (t > 0):
        fp = p.objective()
        # Check if we have found the best board
        if (fp >= ft): return p
        # Generate neighbors
        neighbors = p.generate_neighbors()
        f_neighbors = set()
        for n in neighbors:
            f_neighbors.add(n)
        # Find the neighbor with the highest objective value
        p_max = max(f_neighbors, key=lambda n: n.o)
        # Keep the best board in memory (testing purposes)
        if (p_max.o > best_p.o):
            best_p = p_max
        
        q = 0 if fp == 0 else (p_max.objective() - (fp)) / fp
        pee = min(1, math.exp(-q/t))
        # Return the next random floating point number in the range [0.0, 1.0)
        x = random.random()
        if x > pee: p = p_max
        else: p = random.sample(f_neighbors, 1)[0]

        # end sa iteration
        # check if we have a premium solution
        if (p_max.o == 1.0):
            print("t_max", t_max)
            print("t at solution", t)
            print("iterations", t_max - t)
            for r in p_max.matrix:
                print(r)
            break

        # Decrease the temperature
        t -= 1

        # Print the current board (testing purposes)
        print(p.objective())
        for r in p.matrix:
            print(r)

