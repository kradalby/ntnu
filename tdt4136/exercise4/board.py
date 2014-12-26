from random import shuffle,seed 
from copy import deepcopy

seed()

class AbstractBoard():

    '''
    Create board that contains values N, M, a matrix and the objective value
    '''

    def __init__(self):
        self.M = None
        self.N = None
        self.matrix = None
        self.o = None

    '''
    Create a board based on values N and M containing an empty matrix
    '''

    def create_board(self, cols, rows):
        
        self.N = cols
        self.M = rows
        self.matrix = [[0 for col in range(cols)] for row in range(rows)]

    def get_rows(self):
        """
        Returns a lists of the rows from of the matrix.
        """
        return self.matrix

    def get_cols(self):
        """
        Returns a lists of the columns from of the matrix.
        """
        return [[self.matrix[i][j] for i in range(self.M)] for j in range(self.N)]

    def get_reverse_matrix(self):
        """
        Returns a matrix with reverse rows
        """
        return [list(reversed(self.matrix[i])) for i in range(self.N)]

    def get_diagonals(self): 
        """
        Returns a lists of the columns from of the matrix.
        Inspiration: http://stackoverflow.com/questions/20447210/get-diagonal-without-using-numpy-in-python
        """

        right_diags = [[row[i+j-1] for i,row in enumerate(self.matrix, start=3-self.N) if 0 <= i+j-1 < len(row)] for j in range(2*self.N-3)]
        left_diags = [[row[i+j-1] for i,row in enumerate(self.get_reverse_matrix(), start=3-self.N) if 0 <= i+j-1 < len(row)] for j in range(2*self.N-3)]

        return right_diags + left_diags

    '''
    Set the objective value
    '''

    def set_objective(self):
        self.o = self.objective()


class EggBoard(AbstractBoard):
    
    '''
    Create an EggBoard containing value k
    '''

    def __init__(self, k):
        self.K = k
    
    '''
    Generate neighbors for the EggBoard
    This function loops through the matrix and generates
    new neighbors with an egg in a row moved either left
    or right.
    '''

    def generate_neighbors(self):
        neighbors = []
        for y in range(self.N):
            for x in range(self.M):
                new_matrix = deepcopy(self.matrix)
                eb = EggBoard(self.K)
                eb.create_board(self.N, self.M)
                if (new_matrix[y][x] == 1):
                    if (new_matrix[y][x-1] == 0):
                        new_matrix[y][x-1] = 1
                        new_matrix[y][x] = 0
                    # Check if we are at an edge to the right
                    elif (self.N-1 == x):
                        if (new_matrix[y][x] == 0 and not new_matrix[0][y] == 1):
                            new_matrix[y][0] = 1
                            new_matrix[y][x] = 0
                    elif (new_matrix[y][x+1] == 0):
                        new_matrix[y][x+1] = 1
                        new_matrix[y][x] = 0
                eb.matrix = new_matrix
                eb.set_objective()
                neighbors.append(eb)
        return neighbors

    '''
    Generate an initial board containing
    K eggs located to the left in each row
    '''

    def generate_initial_board(self):
        for row in self.matrix:
            for i in range(self.K):
                row[i] = 1

    '''
    Generate a random board containing
    K eggs randomly placed in each row
    '''

    def generate_random_board(self):
        for row in self.matrix:
            for i in range(self.K):
                row[i] = 1
            shuffle(row)

    '''
    Objective function
    Loops through all rows, columns, left and right diagonals
    and subtracts, from the total score, 0.01 times the quantity
    of eggs that is more than K eggs.
    The score starts at 1.0    
    '''

    def objective(self):
        def penalize(elements):
            pen = 0.
            pen += (sum(elements)-self.K)/100 if sum(elements) >self.K else 0
            return pen

        value = 1.

        for col in self.get_cols():
            value -= penalize(col)
        for row in self.get_rows():
            value -= penalize(row)
        for diag in self.get_diagonals():
            value -= penalize(diag)
        result = 0 if value < 0 else value
        self.o = result
        return 0 if value < 0 else value

