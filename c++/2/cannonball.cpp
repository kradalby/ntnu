#include <iostream>
#include "cannonball.h"
#include "math.h"

using namespace std;

double theta;
double absVelocity;
double velocityX;
double velocityY;

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
    double a = ((0.5) * acclY() * pow(time, 2));
    double b = (startSpeed * time);
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




void getUserInput(double *theta, double *absVelocity) {
    cout << "Skriv inn en vinkel: ";
    cin >> *theta;
    cout << "Skriv inn en fart: ";
    cin >> *absVelocity;
} 


double getVelocityX(double theta, double absVelocity) {
    return absVelocity * cos(theta);
} 
double getVelocityY(double theta, double absVelocity) {
    return absVelocity * sin(theta);
} 

void getVelocityVector(double theta, double absVelocity, double *velocityX, double *velocityY) {
    *velocityX = getVelocityX(theta, absVelocity);
    *velocityY = getVelocityY(theta, absVelocity);
}


double getDistanceTraveled(double velocityX, double velocityY);


double optimalAngleForMaxDistance(double absVelocity);

double targetPractice(double distanceToTarget, double velocityX, double velocityY);

void playTargetPractice();
