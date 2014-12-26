#Kollektiv aldersprisutregnerfastastifiserer

def main():
    a = int(input("Hvor gammel er personen?: "))
    pris(a)

def pris(g):
    if g < 5:
        print("Personen får gå gratis")
    elif g >= 5 and g <= 15:
    	print("Personen er Barn pris er 10 kroner")
    elif g >= 16 and g <= 20:
        print("Personen er Ungdom pris er 20 kroner")
    elif g >= 21 and g <= 25:
        print("Personen er Student pris er 30 kroner")
    elif g > 25 and g < 60:
        print("Personen er Voksen pris er 40 kroner")
    elif g >= 60:
        print("Personen er Honnør, gratis")


main()

