from colors import *

class Node:
    
    # Instantiate a node with default values
    def __init__(self, x, y):
        self.x = x
        self.y = y
        self.g = 0
        self.h = 0
        self.f = 0
        self.parent = None
        self.nb = set()
        self.start = False
        self.end = False
        self.weight = 1

    # Manhatten distance    
    def calc_h(self, goal):
        self.h = abs(goal.x - self.x) + abs(goal.y - self.y)
    
    # Calculate g value, take weight into account.
    def calc_g(self):
        self.g = 1 + self.weight

    def calc_f(self):
        self.f = self.h + self.g

    # Find all neighbour nodes for this node
    def get_nb(self, b):
        for y in range(len(b)):
            for x in range(len(b[y])):
                if abs(b[y][x].x - self.x) == 1 and (b[y][x].y == self.y): self.nb.add(b[y][x])
                if abs(b[y][x].y - self.y) == 1 and (b[y][x].x == self.x): self.nb.add(b[y][x])


    # Return a terminal block with color for visualization.
    def get_symbol(self, visited, path=None):
        if self.weight > 200:
            return BL + u"\u2588" + W
        if self.start:
            return R + u"\u2588" + W  
        if self.end:
            return P + u"\u2588" + W  
        if path and self in path:
            return O + u"\u2588" + W 
        if visited and self in visited:
            return B + u"\u2588" + W
        if self.weight == 100:
            return LB + u"\u2588" + W 
        if self.weight == 50:
            return T + u"\u2588" + W  
        if self.weight == 10:
            return G + u"\u2588" + W
        if self.weight == 5:
            return C + u"\u2588" + W
        if self.weight == 1:
            return GR + u"\u2588" + W 
        else: 
            return "."

    def __repr__(self):
        return str((self.x, self.y))

    def __str__(self):
        return str((self.x, self.y))




