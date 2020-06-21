from PIL import Image, ImageTk
import serial
import time
import tkinter as tk
import tkinter.messagebox
import requests

window = tk.Tk()
window.title('煲罗天下')
window.geometry('600x500')
 
l = tk.Label(window, text = '欢迎使用葫芦牌电饭煲', bg = 'red', font=('Arial', 16))
l.pack()

counter = 0
def do_job():
    global counter
    l.config(text='do '+ str(counter))
    counter += 1

def ContactUs():
    window1 = tk.Tk()
    window1.title('联系我们')
    window1.geometry('400x350')
    r = tk.Label(window1, text = '2017061614李天伟与2017061625王玉峰', bg = 'white', font = ('Arial', 10))
    r.pack()
    r = tk.Label(window1, text = '历经千辛万苦', bg = 'yellow', font = ('Arial', 10))
    r.pack()
    r = tk.Label(window1, text = '瞎搞出来什么鬼东西', bg = 'green', font = ('Arial', 10))
    r.pack()
    #tkinter.messagebox.showinfo(title='Hi', message='这是我们的联系方式')

on_temp = False
def Temp():
    global on_temp
    if on_temp == False :
        on_temp = True
        var.set('temp1')
    else :
        on_temp = False
        var.set(' ')

on_wet = False
def Wet():
    global on_wet
    if on_wet == False :
        on_wet = True
        var.set('wet1')
    else :
        on_wet = False
        var.set(' ')

on_pre = False
def Pre():
    global on_pre
    if on_pre == False :
        on_pre = True
        var.set('pre1')
    else :
        on_pre = False
        var.set(' ')

def print_selection(v):
    #tk.Label(frame_l, text='temp' + v, bg= 'yellow').pack()
    a.config(text='温度调节 ' + v)


def GetTime():
    timestr = time.strftime("%H:%M:%S")
    r3.config(text=timestr)
    window.after(1000, GetTime)

def GetDate():
    datestr = time.strftime("%Y-%m-%d")
    r4.config(text=datestr)
    window.after(1, GetDate)

def GetMessage():
    str = ""
    try:
        portx="COM2"
        bps=9600
        timex=1000
        ser = serial.Serial(portx, bps, timeout=timex)
        while True:
            if ser.in_waiting:
                str=ser.readline().decode("gbk")
                print("收到数据：", str)
                break
        ser.close()
    except Exception as ex:
        print("----异常----", )
    TEMP = str[30:36]
    WET = str[48:53]
    PRE = str[64:67]
    r0.config(text=TEMP)
    r1.config(text=WET)
    r2.config(text=PRE)
    window.after(100, GetMessage)


menubar = tk.Menu(window)

filemenu = tk.Menu(menubar, tearoff=0)

menubar.add_cascade(label='File', menu=filemenu)
filemenu.add_command(label='Contact Us', command=ContactUs)
filemenu.add_command(label='Exit', command=window.quit)

window.config(menu=menubar)

frame = tk.Frame(window)
frame.pack()
frame_l = tk.Frame(frame)
frame_r = tk.Frame(frame)
frame_l.pack(side = 'left')
frame_r.pack(side = 'right')

Funcs = ['温度', '湿度', '压强', '时间', '日期', '其他']

l0 = tk.Label(frame_l, text = Funcs[0], font=('Arial', 12))
l0.pack()

l1 = tk.Label(frame_l, text = Funcs[1], font=('Arial', 12))
l1.pack()

l2 = tk.Label(frame_l, text = Funcs[2], font=('Arial', 12))
l2.pack()

l3 = tk.Label(frame_l, text = Funcs[3], font=('Arial', 12))
l3.pack()

l4 = tk.Label(frame_l, text = Funcs[4], font=('Arial', 12))
l4.pack()

l5 = tk.Label(frame_l, text = Funcs[5], font=('Arial', 12))
l5.pack()

r0 = tk.Label(frame_r, text = "", font=('Arial', 12))
r0.pack()

r1 = tk.Label(frame_r, text = "", font=('Arial', 12))
r1.pack()

r2 = tk.Label(frame_r, text = "", font=('Arial', 12))
r2.pack()
GetMessage()

r3 = tk.Label(frame_r, text = "", font=('Arial', 12))
r3.pack()
GetTime()

r4 = tk.Label(frame_r, text = "", font=('Arial', 12))
r4.pack()
GetDate()

r5 = tk.Label(frame_r, text = "版本V1.0", font=('Arial', 12))
r5.pack()

a = tk.Button(window, text = '温度', font=('Arial', 12), width=10, height=1, command=Temp)
a.pack()

s = tk.Scale(window, label='time setting', from_=0, to=100, orient=tk.HORIZONTAL, length=200, showvalue=0,tickinterval=2, resolution=10, command=print_selection)
s.pack()

b = tk.Button(frame_l, text = '湿度', font=('Arial', 12), width=10, height=1, command=Wet)
b.pack()

c = tk.Button(frame_r, text = '压强', font=('Arial', 12), width=10, height=1, command=Pre)
c.pack()

window.mainloop()