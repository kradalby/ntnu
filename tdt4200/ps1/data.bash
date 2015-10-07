#!/bin/bash

for p in 2 3 5 9
do
    for n in 100 1000000 1000000000
    do
        echo $p $n $(mpirun -np $p ./para 2 $n) >> time.txt
    done
done
