from node import *
import sys



def readBoard():
    start = None
    end = None
    file = open(sys.argv[1], 'r')
    board = []
    for y, line in enumerate(file):
        board.append([])
        for x, character in enumerate(line):
            if character == ".":
                board[y].append(Node(character, x, y, None, None, False))
            elif character == "#":
                board[y].append(Node(character, x, y, None, None, False))
                board[y][x].status = False
            elif character == "A":
                start = Node(character, x, y, None, None, False)
                board[y].append(start)
            elif character == "B":
                end = Node(character, x, y, None, None, True )
                board[y].append(end)
    return board, start, end

board, start, end = readBoard()
print(astar(start, end, board))

