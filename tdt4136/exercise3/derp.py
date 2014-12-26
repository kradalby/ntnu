from astar import *
from bfs import * 
from node import *
import sys


def read_board():
    """
    Reads a file from commandline and generates Node
    objects in a two dimensional array. Every node is 
    instantiated with coordinates from the matrix and 
    weight.
    """
    start = ()
    end = ()
    board = []
    
    f = open(sys.argv[1], 'r')
    for y, line in enumerate(f):
        board.append([])
        for x, c in enumerate(line):
            board[y].append(Node(x, y))
            if c == 'A':
                board[y][x].start = True
                start = (x,y)
            if c == 'B':
                board[y][x].end = True
                end = (x,y)
            if c == '#':
                board[y][x].weight = 1000

            # Task 2
            if c == 'w':
                board[y][x].weight = 100
            if c == 'm':
                board[y][x].weight = 50
            if c == 'f':
                board[y][x].weight = 10
            if c == 'g':
                board[y][x].weight = 5
            if c == 'r':
                board[y][x].weight = 1


    f.close()
    print(start, end)
    return start, end, board

    
if __name__ == "__main__":
    start, end, board = read_board()
    
    # Precalculate all the g, h, f values and 
    # the neighbour nodes.
    for y in range(len(board)):
        for x in range(len(board[y])):
            board[y][x].calc_g()
            board[y][x].calc_h(board[end[1]][end[0]])
            board[y][x].calc_f()
            board[y][x].get_nb(board)


    # Get the start nodes
    start_node = board[start[1]][start[0]]
    end_node = board[end[1]][end[0]]

    # Run astar on the board
    alg = sys.argv[2]
    if alg in ['a-star', 'bfs', 'djikstra']:
        print(run(start_node, end_node, board, alg))
    else:
        print("algoritms are a-star, bfs and djikstra")

