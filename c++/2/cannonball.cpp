#include <iostream>
#include "cannonball.h"
#include "math.h"

using namespace std;

double acclY() {
    return -9.81;
}

double acclX() {
    return 0;
}

double velX(double startSpeed, double time) {
    return startSpeed + (acclX() * time);
}

double velY(double startSpeed, double time) {
    return startSpeed + (acclY() * time);
}

double velIntY(double startSpeed, double time);

double posY(double startSpeed, double time) {
    double a = ((1/2) * acclY() * pow(time, 2));
    double b = (startSpeed * time);
    cout << startSpeed << endl;
    cout << time << endl;
    cout << a << endl;
    cout << b << endl;
    return 0 + b + a;
}

double posIntY(double startSpeed, double time);

double posX(double startSpeed, double time) {
    return 0 + (startSpeed * time) + (0.5 * acclX() * pow(time, 2.0));
}

double posIntX(double startSpeed, double time);

void printTime(double time) {
    int hour;
    int min;
    double sec;

    hour = time / 3600;
    time = fmod(time, 3600);
    min = time / 60;
    sec = fmod(time, 60);

    cout << "Flight time: " << hour << ":" << min << ":" << sec << endl;
}

double flightTime(double startSpeedY);


