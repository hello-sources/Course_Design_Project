from PIL import Image, ImageTk
import serial
import time
import tkinter as tk
import tkinter.messagebox
import requests
import webbrowser

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
    window1.geometry('300x250')
    r = tk.Label(window1, text = '煲饭双人组', font = ('黑体', 12)).pack()

    frame = tk.Frame(window1)
    frame.pack()
    frame_l = tk.Frame(frame)
    frame_r = tk.Frame(frame)
    frame_l.pack(side = 'left')
    frame_r.pack(side = 'right')

    #photo = tk.PhotoImage(file="C:/Users/32458/Desktop/嵌入式课设/Python_GUI/V2.0/裴秀智.gif")
    #theLabel = tk.Label(window1, image=photo)
    #label = tk.Label(window1, text="hello", font=('heiti', 20), fg='red', bg='pink')
    #label.place(x=225, y=95)
    #theLabel.pack()
    #tk.mainloop()

    r = tk.Label(frame_l, text = '历经千辛万苦', bg = 'yellow', font = ('Arial', 10))
    r.pack()
    r = tk.Label(frame_r, text = '搞出来煲罗万象', bg = 'green', font = ('Arial', 10))
    r.pack()
    r = tk.Label(frame_l, text = '金牌制作人：', font = ('Arial', 10))
    r.pack()
    r = tk.Label(frame_r, text = '', font = ('Arial', 10))
    r.pack()
    r = tk.Label(frame_l, text = '李天伟：', font = ('Arial', 10))
    r.pack()
    r = tk.Label(frame_r, text = '2017061614', font = ('Arial', 10))
    r.pack()
    r = tk.Label(frame_l, text = '王玉峰：', font = ('Arial', 10))
    r.pack()
    r = tk.Label(frame_r, text = '2017061625', font = ('Arial', 10))
    r.pack()
    
    URL = tk.Label(window1, text = '欢迎点击访问项目Github地址', fg='blue', font = ('Arial', 12))
    URL.pack()
    def click(event):
        webbrowser.open("https://github.com/hello-sources/Course_Design_Project", new = 0)

    URL.bind("<Button-1>", click)
    
    l = tk.Label(window1, text = '欢迎点赞分享转发', bg = 'green')
    l.pack()
    def print_selection():
        if (var1.get() == 0) & (var2.get() == 0) & (var3.get() == 0):
            l.config(text='谢谢观看演示')
        if (var1.get() == 1) & (var2.get() == 1) & (var3.get() == 1):
            l.config(text='感谢三连')
        else:
            l.config(text='感谢支持')
    
    var1 = tk.IntVar()
    var2 = tk.IntVar()
    var3 = tk.IntVar()

    c1 = tk.Checkbutton(window1, text='点赞',variable=var1, onvalue=1, offvalue=0, command=print_selection)    
    c1.pack()
    c2 = tk.Checkbutton(window1, text='分享',variable=var2, onvalue=1, offvalue=0, command=print_selection)
    c2.pack()
    c3 = tk.Checkbutton(window1, text='投币',variable=var3, onvalue=1, offvalue=0, command=print_selection)
    c3.pack()

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
pat = 0
def pattern_selection(v):
    #tk.Label(frame_l, text='temp' + v, bg= 'yellow').pack()
    a.config(text='您选择模式 ' + v)
    pat = v

def SendMsg():
    serialPort = "COM2"
    baudRate = 9600
    ser = serial.Serial(serialPort, baudRate, timeout=1000)
    ser.write(pat)

def GetTime():
    timestr = time.strftime("%H:%M:%S")
    r4.config(text=timestr)
    window.after(1000, GetTime)

def GetDate():
    datestr = time.strftime("%Y-%m-%d")
    r5.config(text=datestr)
    window.after(1, GetDate)

def GetMessage():
    RECV = ""
    try:
        serialPort="COM2"
        baudRate=9600
        timedelay=1000
        ser = serial.Serial(serialPort, baudRate, timeout=timedelay)
        while True:
            if ser.in_waiting:
                RECV=ser.readline().decode("gbk")
                print("收到数据：", RECV)
                break
        ser.close()
    except Exception as ex:
        print("Exception!发生")
    TEMP = RECV[30:36]
    WET = RECV[10:15]
    PRE = RECV[64:70]
    CNT = RECV[87:89]
    if CNT[1] == '':
        cnt = int(CNT[0])
    else :
        cnt = int(CNT)
    if cnt == 0:
        tk.messagebox.showwarning('温馨提示','饭已经做好，请慢用')

    CNT = str(cnt)
    r0.config(text=TEMP + '摄氏度')
    r1.config(text=WET + '%')
    r2.config(text=PRE + '帕')
    r3.config(text=CNT + '秒')
    window.after(100, GetMessage)


menubar = tk.Menu(window)

filemenu = tk.Menu(menubar, tearoff=0)

menubar.add_cascade(label='File', menu=filemenu)
filemenu.add_command(label='Contact Us', command=ContactUs)
filemenu.add_command(label='Exit', command=window.quit)

window.config(menu=menubar)

s = tk.Scale(window, label='Pattern setting', from_=0, to=6, orient=tk.HORIZONTAL, length=200, showvalue=0,tickinterval=1, resolution=1, command=pattern_selection).pack()
a = tk.Button(window, text = '请选择工作模式', font=('Arial', 12), width=20, height=1, command=SendMsg)
a.pack()

frame = tk.Frame(window)
frame.pack()
frame_l = tk.Frame(frame)
frame_r = tk.Frame(frame)
frame_l.pack(side = 'left')
frame_r.pack(side = 'right')

Funcs = ['温度', '湿度', '压强', '倒计时', '时间', '日期', '其他']

l0 = tk.Label(frame_l, text = Funcs[0], font=('Arial', 12)).pack()
l1 = tk.Label(frame_l, text = Funcs[1], font=('Arial', 12)).pack()
l2 = tk.Label(frame_l, text = Funcs[2], font=('Arial', 12)).pack()
l3 = tk.Label(frame_l, text = Funcs[3], font=('Arial', 12)).pack()
l4 = tk.Label(frame_l, text = Funcs[4], font=('Arial', 12)).pack()
l5 = tk.Label(frame_l, text = Funcs[5], font=('Arial', 12)).pack()
l6 = tk.Label(frame_l, text = Funcs[6], font=('Arial', 12)).pack()

r0 = tk.Label(frame_r, text = "", font=('Arial', 12))
r0.pack()
r1 = tk.Label(frame_r, text = "", font=('Arial', 12))
r1.pack()
r2 = tk.Label(frame_r, text = "", font=('Arial', 12))
r2.pack()
r3 = tk.Label(frame_r, text = "", font=('Arial', 12))
r3.pack()
GetMessage()
r4 = tk.Label(frame_r, text = "", font=('Arial', 12))
r4.pack()
GetTime()
r5 = tk.Label(frame_r, text = "", font=('Arial', 12))
r5.pack()
GetDate()
r6 = tk.Label(frame_r, text = "版本V2.0", font=('Arial', 12))
r6.pack()

b = tk.Button(frame_l, text = '湿度', font=('Arial', 12), width=10, height=1, command=Wet).pack()
c = tk.Button(frame_r, text = '压强', font=('Arial', 12), width=10, height=1, command=Pre).pack()

window.mainloop()