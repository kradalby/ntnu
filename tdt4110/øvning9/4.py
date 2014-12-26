


def number_of_lines(f):
    li = [r.strip() for r in open(f,'r')]
    return len(li)

print(number_of_lines("nummer.txt"))


def number_frequency(f):
    li = [r.strip() for r in open(f,'r')]
    li2 = set(li)
    d = {}
    for i in li2:
        c = 0
        for j in li:
            if j == i:
                c += 1
            d[i] = c
    for g in d:
        print(g, ": ", d[g])

number_frequency("nummer.txt")
