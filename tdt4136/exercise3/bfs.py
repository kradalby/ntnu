from node import *
from astar import reconstruct_path
from queue import Queue

def bfs(start, end, board):
    queue = Queue()

    queue.put(start)
    

    while queue:
        current = queue.get()
        if current.end:
             return reconstruct_path(current, board)

        for nb in current.nb:
            queue.put(nb)
