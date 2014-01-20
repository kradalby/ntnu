#include <iostream>
#include "cannonball.h"

using namespace std;


int main() {
    double speedX = 50.0;
    double speedY = 25.0;
    double t = 2.5;
    
    cout << t << endl;
    cout << speedY << endl;

    cout << "acclX: " << acclX() << endl;
    cout << "acclY: " << acclY() << endl;
    cout << "velX: " << velX(speedX, t) << endl;
    cout << "velY: " << velY(speedY, t) << endl;
    cout << "posX: " << posX(speedX, t) << endl;
    cout << "posY: " << posY(speedY, t) << endl;


    return 0;
}
