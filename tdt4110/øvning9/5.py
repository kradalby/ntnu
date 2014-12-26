

def open_file(f):
    f = [r.strip() for r in open(f,'r')]
    d = {}
    for i in range(len(f)):
        t = f[i]
        t = t.split(',')
        d[t[0]] = t[1]
    return d

def filter_alle(d):
    c = 0
    alle = {}
    
    for i in d:       
        if d[i] == '"Alle"':
            alle[i] = "Alle"
    return alle


def ntnu_snitt(d):
    s = "NTNU"
    c = 0
    t = 0
    for i in d:
        if i.find(s) != -1 and d[i] != '"Alle"':
            c += 1
            t += float(d[i])
    snitt = t/c
    return snitt

print(len(filter_alle(open_file("poenggrenser_2011.csv"))))

print(ntnu_snitt(open_file("poenggrenser_2011.csv")))
