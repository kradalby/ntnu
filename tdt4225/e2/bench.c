#include <sys/types.h>
#include <sys/stat.h>
#include <sys/time.h>
#include <fcntl.h>
#include <unistd.h>
#include <stdio.h>
#include <errno.h>
#include <string.h>

#define BLOCKSIZE 8192
#define NBLOCKS 32*131072

int fd = open ("mydata", O_CREAT | O_RDWR);
char datablock[BLOCKSIZE];

int main(int argc, const char* argv[]) {

    timeval start;
    timeval finish;
    timeval time_elapsed;
    timezone tz;

    gettimeofday(&start, &tz);
    sleep(5);
    for (int i=0; i<NBLOCKS; i++) {
        write(fd,datablock,BLOCKSIZE);
    }
    close(fd);
    gettimeofday(&finish, &tz);


    printf("%f secons elapsed", interval);
    return 0;
}

int timeval_subtract(struct timeval *result, struct timeval *x, struct timeval *y)
{  
    // preserve *y
    struct timeval yy = *y;
    y = &yy;

    /* Perform the carry for the later subtraction by updating y. */  
    if (x->tv_usec < y->tv_usec) {  
        int nsec = (y->tv_usec - x->tv_usec) / 1000000 + 1;  
        y->tv_usec -= 1000000 * nsec;  
        y->tv_sec += nsec;  
    }  
    if (x->tv_usec - y->tv_usec > 1000000) {  
        int nsec = (y->tv_usec - x->tv_usec) / 1000000;  
        y->tv_usec += 1000000 * nsec;  
        y->tv_sec -= nsec;  
    }  

    /* Compute the time remaining to wait.
       tv_usec is certainly positive. */  
    result->tv_sec = x->tv_sec - y->tv_sec;  
    result->tv_usec = x->tv_usec - y->tv_usec;  

    /* Return 1 if result is negative. */  
    return x->tv_sec < y->tv_sec;  
}
