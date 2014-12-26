from sa import *

'''
Main function.
Creates an EggBoard object with K eggs
as a rule, then creates the board with
N and M as size.
Starts the SA function with the board object,
the score of the perfect board and the
temperature
'''

def main():

    a = EggBoard(2)

    a.create_board(5,5)
    a.generate_initial_board()
    print(a.objective())
    sa(a, 1.0, 10000)

if __name__=='__main__':
    main()
