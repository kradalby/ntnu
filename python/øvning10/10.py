from skumleskogen import *
from random import choice

mem = {}
n = nummer()
go = True

def blindvei(n):
    if n == nummer():
        return True
    else:
        return False

def check():
    global mem
    global n
    global go
    if er_stank():
        gaa_tilbake()
    elif er_laas():
        laas_opp()
    elif er_superlaas():
        laas_opp()
    elif er_nokkel():
        plukk_opp()
        mem = {}
    elif er_utgang():
        gaa_ut()
        go = False

def rundownrabbits(): 
    global mem
    global n
    if go:
        n = nummer()
        if n not in mem:
            mem[n] = { "left":False , "right":False}
        if mem[nummer()]["right"] == False:
            mem[nummer()]["right"] = True
            gaa_hoyre()
            print("h")
            check()
            if blindvei(n):
                gaa_tilbake()
            rundownrabbits()
        elif mem[nummer()]["left"] == False:
            mem[nummer()]["left"] = True
            gaa_venstre()
            print("v")
            check()
            if blindvei(n):
                gaa_tilbake()
            rundownrabbits()

rundownrabbits()
