/* cannonball.h */

double acclY();
double acclX();

double velY(double startSpeed, double time);
double velIntY(double startSpeed, double time);
double velX(double startSpeed, double time);
double velIntX(double startSpeed, double time);

double posY(double startSpeed, double time);
double posIntY(double startSpeed, double time);
double posX(double startSpeed, double time);
double posIntX(double startSpeed, double time);

void printTime(double time);

double flightTime(double startSpeedY);


