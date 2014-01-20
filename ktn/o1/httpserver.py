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

    #Fill in start
    #Fill in end

    try:
        message = connectionSocket.recv(4096)
        print(message)
        filename = message.split()[1]
        print(filename)
        try:
            f = open(filename[1:])
            outputdata = f.read() 
        except FileNotFoundError as e:
            connectionSocket.send(u'HTTP/1.x 404 Not Found')
            connectionSocket.send(u'Content-Type: text/html; charset=UTF-8')
            connectionSocket.send(u'Connection: close')

            

        connectionSocket.send(u'HTTP/1.x 200 OK')
        connectionSocket.send(u'Content-Type: text/html; charset=UTF-8')
        connectionSocket.send(u'Connection: close')

        for i in range(0, len(outputdata)): 
            connectionSocket.send(outputdata[i])
        
        connectionSocket.close() 
    except IOError as e:
        print(e)
        #Send response message for file not found
        #Fill in start #Fill in end
        #Close client socket #Fill in start #Fill in end
    
serverSocket.close()
