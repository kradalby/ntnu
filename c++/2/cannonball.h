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


void getUserInput(double *theta, double *absVelocity); 
double getVelocityX(double theta, double absVelocity); 
double getVelocityY(double theta, double absVelocity); 
void getVelocityVector(double theta, double absVelocity, double *velocityX, double *velocityY);


double getDistanceTraveled(double velocityX, double velocityY);

double optimalAngleForMaxDistance(double absVelocity);

double targetPractice(double distanceToTarget, double velocityX, double velocityY);

void playTargetPractice();
