.PHONY: clean all

START:=2
STOP:=10000000
PROCESSES:= 4

serial: computeSerial.c
	gcc -o $@ computeSerial.c -std=c99 -lm -O2

run_serial: serial
	./serial $(START) $(STOP)

parallel: computeMPI.c
	mpicc -g -Wall -lm -std=c99 -o $@ computeMPI.c

run_parallel: parallel
	mpirun -np $(PROCESSES) ./parallel $(START) $(STOP)

clean:
	rm -f serial

all: run_parallel
