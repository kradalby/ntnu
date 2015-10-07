from datetime import datetime, timedelta
import os
import array


BLOCKSIZE = 8192
NBLOCKS = 131072
BLOCK = array.array('b', [1 for x in range(8192 - 64)])

def pretty(ms, size):
    megabyte = size * 1024
    throughput = megabyte / (ms / 1000)
    print('{} GB\t{} MB/s\t{} ms'.format(size, throughput, ms))

print('{}\t{}\t{}'.format('EXT4', 'Throughput', 'Time'))
for size in [1, 2, 4]:
#for size in [1, 2, 4, 8, 16, 32]:
    with open('test', 'wb') as f:
        start = datetime.now()

        for i in range(NBLOCKS):
            f.write(BLOCK)

        stop = datetime.now()

        interval = stop - start

        pretty(interval.microseconds/1000, size)

    os.remove('test')
