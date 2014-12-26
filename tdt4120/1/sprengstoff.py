from sys import stdin

class Kubbe:
    vekt = None
    neste = None
    def __init__(self, vekt):
        self.vekt = vekt 
        self.neste = None 

def spor(kubbe):
    high = 0
    while True:
        high = kubbe.vekt if kubbe.vekt > high else high
#        if kubbe.neste != None:
#            kubbe = kubbe.neste
#        else:
#            break
        kubbe = kubbe.neste if kubbe.vekt != None else break
    return high
        

# Oppretter lenket liste
forste = None
siste = None
for linje in stdin:
    forrige_siste = siste
    siste = Kubbe(int(linje))
    if forste == None:
        forste = siste
    else:
        forrige_siste.neste = siste

# Kaller loesningsfunksjonen og skriver ut resultatet
print spor(forste)
