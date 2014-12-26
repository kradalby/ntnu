from skumleskogen import *

mem = {}
run = True
n = nummer()

def banan(n):
    if n == nummer():
        return True
    else:
        return False

def herpyderp():
    global run
    global n
    global mem
    if er_vanlig():
        return None
    elif er_nokkel():
        plukk_opp()
        mem = {}
    elif er_laas() or er_superlaas():
        laas_opp()
    elif er_inngang():
        return None
    elif er_utgang():
        gaa_ut()
        run = False
    elif er_stank():
        gaa_tilbake()
        n = nummer()
        me(n)

def me(n):
    global mem
    if n not in mem:
        mem[n] = { "h" : False , "v" : False }
    

def spankbunnies():
    global mem
    global n
    me(n)
    if mem[n]["h"] == False:
        mem[n]["h"] = True
        gaa_hoyre()
        print("h")
        if banan(n):
            gaa_tilbake()
        else:
            n = nummer()
            me(n)
        herpyderp()
    elif mem[n]["v"] == False and mem[n]["h"] == True:
        mem[n]["v"] = True
        gaa_venstre()
        print("v")
        if banan(n):
            gaa_tilbake()
        else:    
            n = nummer()
            me(n)
        herpyderp()
    else:
        gaa_tilbake()
def main():
    while run:
        spankbunnies()
main()
