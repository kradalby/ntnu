#!/usr/bin/python3
# -*- coding: utf-8 -*-

antall_kvinner = 0
antall_menn = 0
antall_sosmedier = 0
antall_facebook = 0
antall_timer_sosmedier = 0


def unders():
    global antall_kvinner
    global antall_menn
    global antall_sosmedier
    global antall_facebook
    global antall_timer_sosmedier
    hade = True
    while hade:
        
        kjonn = input("Hvilket kjønn er du? mann/kvinne: ")
        if kjonn == "hade":
            hade = False
            return
        alder = input("Hvor gammel er du? ")
        if alder == "hade":
            hade = False
            return
        alder = int(alder)
        if alder >=16 and alder <= 25:
            aktiv_sosmedier = input("Er du aktiv i et eller flere sosiale medier? ja/nei ")
            if aktiv_sosmedier == "ja":
                antall_sosmedier += 1
                if kjonn == "kvinne":
                    antall_kvinner += 1
                    medlem_facebook = input("Mellom 55-60% av Facebook sine brukere er kvinner. Er du en av disse? ja/nei ")
                    if medlem_facebook == "hade":
                        hade = False
                        return
                    elif medlem_facebook == "ja":
                        antall_facebook += 1
                        print("Takk for din deltagelse i undersøkelsen.")
                        hade = False
                        unders()
                    elif medlem_facebook == "nei":
                        print("Takk for din deltagelse i undersøkelsen.")
                        hade = False
                        unders()
                elif kjonn == "mann":
                    antall_menn += 1
                    medlem_facebook = input("Mellom 40-45% av Facebook sine brukere er menn. Er du en av disse? ja/nei ")
                    if medlem_facebook == "hade":
                        hade = False
                        return
                    elif medlem_facebook == "ja":
                        antall_facebook += 1
                        print("Takk for din deltagelse i undersøkelsen.")
                        hade = False
                        unders()
                    elif medlem_facebook == "nei":
                        print("Takk for din deltagelse i undersøkelsen.")
                        hade = False
                        unders()
                else:
                    print("Du svarte ikke mann eller kvinne tidligere, starter på nytt.")
                    hade = False
                    unders()
                    
                timer_sosmedier = input("Hvor mange timer bruker du på sosiale medier i snitt hver dag? ")
                if timer_sosmedier == "hade":
                    hade = False
                    return
                timer_sosmedier = int(timer_sosmedier)
                antall_timer_sosmedier += timer_sosmedier
            elif aktiv_sosmedier == "nei":
                print("Du bruker ikke sosiale medier og er derfor ferdig med undersøkelsen.")
                hade = False
                unders()
            elif aktiv_sosmedier == "hade":
                hade = False
                return
            else:
                print("Du svarte ikke ja eller nei, starter på nytt.")
                hade = False
                unders()

        else:
            print("Du er ikke innenfor aldersgruppen for denne undersøkelsen.")
            hade = False
            unders()


def main():
    unders()
    print("Antall kvinner som svarte: ", antall_kvinner)
    print("Antall menn som svarte: ", antall_menn)
    print("Antall som bruker sosiale medier: ", antall_sosmedier)
    print("Antall som bruker facebook: ", antall_facebook)
    print("Antall ukentlige timer brukt på sosiale medier: ", antall_timer_sosmedier)

main()
