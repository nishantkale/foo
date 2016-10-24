# Server Program
import socket
s= socket.socket()
host=socket.gethostname()
port=12345
s.bind((host,port))
s.listen(10)
while True:
    c,addr=s.accept()
    print ("Got connection from",addr)
    name=c.recv(100)
    
    print("File requested by client:")
    print(name)
    file=open(name,"r")
    while True:
        chunk=file.read(65536)
        if not chunk:
            break #EOF
        c.sendall(chunk)
        c.close()
