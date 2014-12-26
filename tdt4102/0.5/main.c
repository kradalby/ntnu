#include <iostream>

using namespace std;

int fibonacci(int n) {
    int a = 0;
    int b = 1;
    int temp = 0;
    cout << "Fibonacci numbers:" << endl;
    for (int x = 1; x < n + 1; x++) {
        temp = b;
        b = a + b;
        a = temp;
        cout << x << " " << b << endl;
    }
    cout << endl;
    return b;
    
}

void triangleNumbersBelow(int n) {
    int acc = 1;
    int num = 2;

    cout << "Triangle numbers below " << n << ":" << endl;
    while (acc + num < n) {
        acc = acc + num;
        num++;
        cout << acc << endl;
    }
}

bool isTriangleNumber(int number) {
    int acc = 1;

    while (number > 0) {
        number -= acc;
        acc++;
    }

    if (number == 0) {
        return true;
    } else {
        return false;
    }
}

int squareNumberSum(int n) {
    int totalSum = 0;

    for (int i = 0; i < n; i++) {
        totalSum += i*i;
        i++;
        cout << i*i << endl;
    }
    cout << totalSum << endl;
    return totalSum;
}

int max(int a, int b) {
    if ( a > b ) {
        cout << "A is greater than B" << endl;
        return a;
    } else {
        cout << "B is greater than A" << endl;
        return b;
    }
}

bool isPrime(int n) {
    bool primeness = true;
    for (int j = 2; j < n; j++) {
        if (n % j == 0) {
            primeness = false;
            break;
        }
    }
    return primeness;
}



void naivePrimeNumberSearch(int n) {
    for (int number = 2; number < n; number++) {
        if (isPrime(number)) {
            cout << number << " is a prime" << endl;
        }
    }
}

int findGreatestDivisor(int n) {
    for (int divisor = n-1; n > 0; divisor--) {
        if (n % divisor == 0) {
            return divisor;
        }
    }
    return 0;
}


void compareListOfNumbers(int l[3]) {
    int r[3] = {0,0,0};
    for (int i = 0; i < 3; i++) {
        if (l[i] < 0) {
            r[0] += 1;
        } else if (l[i] == 0) {
            r[1] += 1;
        } else {
            r[2] += 1;
        }

    }

    cout << r[0] << " numbers were below zero" << endl;
    cout << r[1] << " number were zero" << endl;
    cout << r[2] << " numbers greater than zero" << endl;
}





int main() {
    int list[3] = {1,2,3};
    fibonacci(10);
    squareNumberSum(10);
    compareListOfNumbers(list);
    return 0;
}
