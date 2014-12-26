birthdays={
"22 nov" : ["Lars","Mathias"],
"10 des" : "Elle",
"30 okt" : ["Veronica","Rune"],
"12 jan" : "Silje",
"31 okt" : "Willy",
"8 jul" : ["Brage","Øystein"],
"1 mar" : "Nina"
}

def birth_add(date,name):
    try:
        birthdays[date].append(name)
    except KeyError:
        birthdays[date] = name
    except AttributeError:
        temp = birthdays[date]
        birthdays[date] = []
        birthdays[date].append(temp)
        birthdays[date].append(name)

birth_add("31 okt","Lars")

print(birthdays["31 okt"])

birth_add("30 jan","Lars")

print(birthdays["30 jan"])
