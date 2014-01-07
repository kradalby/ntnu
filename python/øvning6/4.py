teeth = [95, 103, 71, 99, 114, 64, 95, 53, 97, 114, 109, 11, 2 , 21, 45, 2, 26, 81, 54, 14, 118, 108, 117, 27, 115, 43, 70, 58, 107]

def mynt(g):
    antall20 = g // 20
    rest = g % 20
    antall10 = rest // 10
    rest = rest % 10
    antall5 = rest // 5
    rest = rest % 5
    antall1 = rest // 1
    rest = rest % 1
    antalldot5 = rest // 0.5
    

    print("Antall 20: ", antall20)
    print("Antall 10: ", antall10)
    print("Antall 5: ", antall5)
    print("Antall 1: ", antall1)
    print("Antall 50øre: ", antalldot5)
    print("-------------------------------")
for i in teeth:
    k = i / 2
    mynt(k)
