import sys
from socket import *

HOST = '127.0.0.1'
PORT = 8088


serverSocket = socket(AF_INET, SOCK_STREAM) 

#Prepare a sever socket
try:
    serverSocket.bind((HOST, PORT))

except OSError as e:
    sys.exit(e)

serverSocket.listen(1)

while True:
    #Establish the connection 
    print('Ready to serve...')
    connectionSocket, addr = serverSocket.accept() 
    
    print("Connection opened by: ", addr)

    try:
        message = connectionSocket.recv(1024)
        print(message)

        #Handling empty requests
        if len(message) == 0:
            filename = b'/'
        else: 
            filename = message.split()[1]
        
        print(filename)

        if filename == b'/' or filename == b'':
            filename = 'index.html'
        else:
            filename = filename[1:]

        f = open(filename)
        outputdata = f.read() 
        print(outputdata)
        print(bytes(outputdata, 'utf-8'))

        #connectionSocket.send(bytes('HTTP/1.1 200 OK\n\r', 'utf-8'))
        connectionSocket.send(bytes('Content-Type: text/html; charset=UTF-8\n\r', 'utf-8'))
        connectionSocket.send(bytes('Connection: close\n\r', 'utf-8'))
        connectionSocket.send(bytes(outputdata, 'utf-8'))

        #for i in range(0, len(outputdata)): 
        #    connectionSocket.send(bytes(outputdata[i], 'utf-8'))

        print("200 sent")

            
        
    except IOError as e:
        print(e)

        connectionSocket.send(bytes('HTTP/1.1 500 Internal Server Error', 'utf-8'))
        connectionSocket.send(bytes('Content-Type: text/html; charset=UTF-8', 'utf-8'))
        connectionSocket.send(bytes('Connection: close', 'utf-8'))
        connectionSocket.send(bytes('<h1>500 Internal Server Error</h1>', 'utf-8'))
        
        print("500 sent")


    except FileNotFoundError as e:
        print(e)

        connectionSocket.send(bytes('HTTP/1.1 404 Not Found', 'utf-8'))
        connectionSocket.send(bytes('Content-Type: text/html; charset=UTF-8', 'utf-8'))
        connectionSocket.send(bytes('Connection: close', 'utf-8'))
        connectionSocket.send(bytes('<h1>404 file not found</h1>', 'utf-8'))
        
        print("404 sent")
        
    connectionSocket.close() 
    
serverSocket.close()
