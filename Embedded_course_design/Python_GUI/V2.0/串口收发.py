import serial
import os
import threading
import serial.tools.list_ports
from time import sleep

def rcv_data():
    while True:
        rcv=serial.readline()
        rcv=rcv.decode() 
        print(rcv)

if __name__=='__main__':
    port_list = list(serial.tools.list_ports.comports())
    k=0
    for i in port_list:
        print(i,k)
        k=k+1

    if len(port_list) <= 0:
        print("not find serial")
    else:
        serial_k=input("please switch serial:")
        k = int(serial_k)
        serial_list = list(port_list[k])
        serialName = serial_list[0]
        #print(serialName)
        serial=serial.Serial("COM2",9600,timeout=3600)
        th=threading.Thread(target=rcv_data)
        th.setDaemon(True)
        th.start()
        if serial.isOpen():
            print("open succeed >",serial.name)
        else:
            print("open failed >",serial.name)
        while True:
            send_data=input("=>")
            send_data = send_data + '\r\n'
            serial.write(send_data.encode())
        #  data=serial.read(1)
        #  sleep(0.1)
        #  data = (data + serial.read(serial.inWaiting())).decode()
        #  print(data)