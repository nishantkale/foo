#Client program
import socket
s=socket.socket ()
host= socket.gethostname()
port=12345
s.connect((host,port))
print ("Enter file name:")
name=raw_input()
s.send(name)
print(s.recv(65536))
s.close()
