from socket import *
import sys
import ssl
import base64

msg = b"I love computer networks!\n"
endmsg = b"\r\n.\r\n"

# Choose a mail server (e.g. Google mail server) and call it mailserver 
mailserver = "smtp.gmail.com"
port = 587
username = b"dummy@dfekt.no"
password = b""

# Create socket called clientSocket and establish a TCP connection with mailserver 

#Fill in start
clientSocket = socket(AF_INET, SOCK_STREAM)
clientSocket.connect((mailserver, port))
#Fill in end

recv = clientSocket.recv(1024) 
print(recv)

if recv[:3] != b'220':
    sys.exit(b"Error here: " + recv)
else:
    print(recv)


heloCommand = b'HELO Alice\n' 
print(heloCommand)
clientSocket.send(heloCommand)

recv = clientSocket.recv(1024)

if recv[:3] != b'250':
    sys.exit(b"Error here: " + recv)
else:
    print(recv)


starttls = b"STARTTLS\r\n"

clientSocket.send(starttls)

recv = clientSocket.recv(1024)
if recv[:3] != b'220':
    sys.exit(b"Error here: " + recv)
else:
    print(recv)

clientSocketSecure = ssl.wrap_socket(clientSocket, ssl_version=ssl.PROTOCOL_TLSv1)


clientSocketSecure.send(b'AUTH LOGIN\n')
recv = clientSocketSecure.recv(1024)
if recv[:3] != b'334':
    sys.exit(b"Error here: " + recv)
else:
    print(recv)


uencode = base64.b64encode(username)+b'\r\n'
pencode = base64.b64encode(password)+b'\r\n'

print(uencode)
print(pencode)

clientSocketSecure.send(uencode)

recv = clientSocketSecure.recv(1024)
if recv[:3] != b'334':
    sys.exit(b"Error here: " + recv)
else:
    print(recv)


clientSocketSecure.send(pencode)

recv = clientSocketSecure.recv(1024)
if recv[:3] != b'235':
    sys.exit(b"Error here: " + recv)
else:
    print(recv)


mailfrom = b"<dummy@dfekt.no>\n"
rcptto = b"<kradalby@dfektlan.no>\n"
data = b"DATA\n"
subject = b"TESTY\n"
message = b"""HEI DIN TEST

heprasdg
sdag
adfg
ds
fh

mvh
kraddemail\n
"""
end = b".\n"
quit = b"QUIT\n"


# Send MAIL FROM command and print server response.
# Send RCPT TO command and print server response.
# Send DATA command and print server response.
# Send message data.
# Message ends with a single period.
# Send QUIT command and get server response.

clientSocketSecure.send(b"MAIL FROM: " + mailfrom)
recv = clientSocketSecure.recv(1024)
if recv[:3] != b'250':
    sys.exit(b"Error here: " + recv)
else:
    print(recv)

clientSocketSecure.send(b"RCPT TO: " + rcptto)
recv = clientSocketSecure.recv(1024)
if recv[:3] != b'250':
    sys.exit(b"Error here: " + recv)
else:
    print(recv)

clientSocketSecure.send(data)
recv = clientSocketSecure.recv(1024)
if recv[:3] != b'354':
    sys.exit(b"Error here: " + recv)
else:
    print(recv)

print(msg)
clientSocket.send(msg)
#recv = clientSocket.recv(1024)
#if recv[:3] != 250:
#    sys.exit(b"Error here: " + recv)
#else:
#    print(recv)

clientSocket.send(end)
recv = clientSocket.recv(1024)
if recv[:3] != b'250':
    sys.exit(b"Error here: " + recv)
else:
    print(recv)

clientSocket.send(quit)
recv = clientSocket.recv(1024)
if recv[:3] != b'221':
    sys.exit(b"Error here: " + recv)
else:
    print(recv)
