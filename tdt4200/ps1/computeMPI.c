#include <stdio.h>
#include <stdlib.h>
#include <mpi.h>
#include <math.h>

/*
    A simple MPI example.
    TODO:
    1. Fill in the needed MPI code to make this run on any number of nodes.
    2. The answer must match the original serial version.
    3. Think of corner cases (valid but tricky values).

    Example input:
    ./simple 2 10000

*/

double calculate_interval(int start, int stop);

int main(int argc, char **argv) {
    int rank, size;

    if (argc < 3) {
        printf("This program requires two parameters:\n \
the start and end specifying a range of positive integers in which \
start is 2 or greater, and end is greater than start.\n");
        exit(1);
    }

    int start = atoi(argv[1]);
    int stop = atoi(argv[2]);


    if(start < 2 || stop <= start){
        printf("Start must be greater than 2 and the end must be larger than start.\n");
        exit(1);
    }

    MPI_Init(NULL, NULL);
    //MPI_Init(&argc, &argv);
    MPI_Comm_rank(MPI_COMM_WORLD, &rank);/* get current process id */
    MPI_Comm_size(MPI_COMM_WORLD, &size);/* get number of processsses */

    //printf("Number of process: %d\n", size);

    // TODO: Compute the local range, so that all the elements are accounted for.
    double local_range = (stop - start) / size;

    double total_sum = 0.0;
    double local_sum = 0.0;
    double rest = 0.0;

    if (rank == size - 1) {
        rest = (stop - start) % size;
    } else {
        rest = 0;
    }

    int local_start = start+rank*local_range;
    int local_stop = start+(rank+1)*local_range+rest;

    //printf("%d %d\n", local_start, local_stop);

    //printf("Running calculate on %d to %d\n", start, stop);
    if (rank != 0) {
        for (int i = start+rank-1; i < stop; i += size - 1) {
            double test = 1.0/log(i);
            //printf("index: %d\n", i);
            //printf("result: %f\n", test);
            local_sum += test;
            //printf("calculated: %f\n", local_sum);
        }
    }

    // Perform the computation
    if (rank == 0) {
        double recv_sum = 0.0;
        for (int worker = 1; worker < size; worker++) {
            MPI_Recv(&recv_sum, 1, MPI_DOUBLE, worker, MPI_ANY_TAG, MPI_COMM_WORLD, MPI_STATUS_IGNORE);
            total_sum += recv_sum;
        }
        printf("The sum is: %f\n", total_sum);
    } else {
        MPI_Send(&local_sum, 1, MPI_DOUBLE, 0, 0, MPI_COMM_WORLD);
    }

    MPI_Finalize();


    return 0;
}

double calculate_interval(int start, int stop) {
    double sum = 0.0;
    printf("Running calculate on %d to %d\n", start, stop);
    for (int i = start; i < stop ; i++) {
        sum += 1.0/log(i);
    }
    return sum;
}
