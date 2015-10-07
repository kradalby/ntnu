import os
import array
import time


BLOCKSIZE = 8192
NBLOCKS = 131072

# Define a array of 8192 bits
BLOCK = array.array('b', [1 for x in range(BLOCKSIZE - 64)])

def pretty(ms, size):
    '''
    This method pretty prints the output
    '''
    megabyte = size * 1024
    throughput = megabyte / (ms / 1000)
    throughput = '{0:.2f}'.format(throughput)
    ms = '{0:.2f}'.format(ms)
    print('{} GB\t{} MB/s\t{} ms'.format(size, throughput, ms))

print('{}\t{}\t{}'.format('EXT4', 'Throughput', 'Time'))

for size in [1, 2, 4, 8, 16, 32]:
    # Open the file in binary form
    with open('test{}'.format(size), 'wb') as f:

        start = time.clock()

        for i in range(NBLOCKS * size):
            f.write(BLOCK)

        f.flush()
        os.system('sync')
        #os.fsync(f)
        stop = time.clock()

        interval = stop - start

        pretty(interval*1000, size)
