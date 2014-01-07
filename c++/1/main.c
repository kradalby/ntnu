#include <iostream>

using namespace std;

/* Start of assignment 1 */

// Void function because no return is needed.
void getAndPrinterInteger() {
    int input;
    cout << "Skriv inn et tall: ";
    cin >> input;
    cout << "Du skrev: " << input << endl;
}

// Returns a int, because that was what i was told to do.
int getAndReturnInteger() {
    int input;
    cout << "Skriv inn et tall: ";
    cin >> input;
    return input;
}

/* I choose the getAndReturnInteger function.
I choose this because it returns a value and that is the only 
sensible to do. */
void getAndPrintSum() {
    int one;
    int two;
    one = getAndReturnInteger();
    two = getAndReturnInteger();
    cout << "Sum: " << (one + two) << endl;
}

/* End of assignment 1 */


/* Start of assignment 2 */

void getAndPrintMoreSum() {
    int sum = 0;
    int n;
    cout << "Hvor mange tall vil du summere?" << endl;
    n = getAndReturnInteger();
    
    /* If the user is suppose to choose how many times the loop should run
    for loop is the right choice. If you choose the other where it should run 
    until the user furfill a condition, you use a while loop */
    for (int i = 0; i < n; i++) {
        sum += getAndReturnInteger();
    }

    cout << "Sum: " << sum << endl;
}

double getAndReturnDouble() {
    double input;
    cout << "Skriv inn et desimaltall: ";
    cin >> input;
    return input;
}

void convertNokToEur() {
    double euro = 7.84;
    double amount;
    double result;

    cout << "Skriv tallet du vil konvertere" << endl;
    amount = getAndReturnDouble();

    while (amount < 0) {
        cout << "Tallet var negativt, skriv et positivt" << endl;
        amount = getAndReturnDouble();
    }
    
    result = amount / euro;
    
    cout.precision(2);
    cout << fixed << result << " euro" << endl;
}

void printMultiTable() {
    int x;
    int y;

    x = getAndReturnInteger();
    y = getAndReturnInteger();

    for (int i = 1; i < x+1; i++) {
        for (int j = 1; j < y+1; j++) {
            cout << i*j << " ";

        }
        cout << endl;
    }
}

/* End of assignment 2 */


/* Start of assignment 3 */

void secondsToTime() {
    int input;
    int hour;
    int min;
    int sec;

    input = getAndReturnInteger();

    hour = input / 3600;
    input = input % 3600;
    min = input / 60;
    sec = input % 60;

    cout << hour << " timer, " << min << " minutter og " << sec << " sekunder" << endl;

}

void mvaCalculator() {
    double price; 
    double mva;
    double tips;
    double total;

    price = getAndReturnDouble();

    mva = price * 0.0875;
    tips = (price+mva) * 0.18;
    total = mva + tips + price;

    cout.precision(2);
    cout << "Pris: " << price << fixed << " MVA: " << mva << fixed << " Tips: " << tips << fixed << " Total : " << total << fixed << endl;
}

/* End of assignment 3 */


/* Start of assignment 4 */

void isEven() {
    int n = getAndReturnInteger();

    if (n % 2 == 0) {
        cout << "Tallet er et partall" << endl;
    } else {
        cout << "Tallet er et oddetal" << endl;
    }
}

void biggestDouble() {
    double x = getAndReturnDouble();
    double y = getAndReturnDouble();

    if (x < y) {
        cout << y << "er storst" << endl;
    } else if (x > y) {
        cout << x << "er storst" << endl;
    } else {
        cout << "they are the same" << endl;
    }
}

int main() {
    int choice;
    while (choice != 0) {
        cout << "0) Avslutt" << endl;
        cout << "1) Summer to tall" << endl;
        cout << "2) Summer flere tall" << endl;
        cout << "3) Konverter NOK til EURO." << endl;
        cout << "4) Skriv ut en x*y gangetabell." << endl;
        cout << "5) Konverter sekunder til tid" << endl;
        cout << "6) Resturangpriskalkulator" << endl;
        cout << "7) Tallsjekk" << endl;
        cout << "8) Finn største desimal" << endl;
        cout << "Angi valg (0-8):" << endl;
        
        cin >> choice;

        if (choice == 1) {
            getAndPrintSum();            
        } else if (choice == 2) {
            getAndPrintMoreSum();
        } else if (choice == 3) {
            convertNokToEur();
        } else if (choice == 4) {
            printMultiTable();
        } else if (choice == 5) {
            secondsToTime();
        } else if (choice == 6) {
            mvaCalculator();
        } else if (choice == 7) {
            isEven();
        } else if (choice == 8) {
            biggestDouble();
        }

    }

    return 0;
}
