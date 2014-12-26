# -*- coding: utf-8 -*-


def ftoc(x):
        c = (5/9)*(x-32)
        return c

def main():
        fahr = int(input("Skriv inn fahrenheit gradene du vil ha gjort om: "))
        print(fahr," fahrenheit er det samme som", ftoc(fahr), "celcius")

main()
