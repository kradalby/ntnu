.PHONY: clean all

START:=2
STOP:=10000000
PROCESSES:=

serial: computeSerial.c
	gcc -o $@ computeSerial.c -std=c99 -lm -O2

run_serial: serial
	./serial $(START) $(STOP)

para: computeMPI.c
	mpicc -g -Wall -std=c99 -o $@ computeMPI.c

run_para: para
	mpirun -np 4 ./para $(START) $(STOP)

clean:
	rm -f serial
