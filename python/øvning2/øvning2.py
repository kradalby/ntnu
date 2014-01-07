# -*- coding: utf-8 -*-

def beregn_avgift(b,v,h,c,l):
        vekt = b * v * 0.00034
        hk = b * h * 0.00015
        co = b * c * 0.004
        li = b * l * 0.00055
        netto = vekt + hk + co + li
        return netto


def main():
	print("Dette programmet regner ut nettopros på din bil")
	navn = input('Hva er navnet på bilen?: ')
	brutto = int(input("Hva er bruttopris på bilen?: "))
	vekt = int(input("Hva er vekten på bilen?: "))
	hk = int(input("Hvor mange hestekrefter har bilen?: "))
	co = int(input("Hvor mange gram Co2 utslipp har bilen?: "))
	li = int(input("Hvor mange liter motor har bilen?: "))	
	print("Netto prisen på", navn, "er beregnet til: ",beregn_avgift(brutto,vekt,hk,co,li))


main()	
