import calendar
import datetime


tabell = {0:'mandag',1:'tirsdag',2:'onsdag',3:'torsdag',4:'fredag',5:'lørdag',6:'søndag'}

def skudd(n):
    return n % 4 == 0 and n % 100 != 0 or n % 400 == 0

def ukedag(y):
    s = 0
    if y >= 1900:
        for x in range(1900,y):
            if skudd(x):
                s += 1
        return tabell[((365*((y-1900)-s)+366*s)%7)]

troll = 1900
while troll <= 1919:
    print(troll, ukedag(troll))
    troll += 1


def is_workday(weekday):
    swaptabell = dict(zip(tabell.values(),tabell.keys()))
    if swaptabell[weekday] < 5:
        return True
    else:
        return False

if is_workday('mandag'):
    print('Mandag er en ukedag\n')


def print_workdays_in_year(year):
    print('Følgende dager er ukedager i ',year,':\n',sep="")
    for x in range(1,13):
        a, b = calendar.monthrange(year,x)
        for y in range(1,b+1):
            if datetime.date(year,x,y).weekday() < 5:
                print(y,'.',x,'.',year,' er en ukedag!',sep="")

print_workdays_in_year(2012)

