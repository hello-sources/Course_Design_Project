#from PIL import Image, ImageTk
import tkinter as tk
import tkinter.messagebox

window = tk.Tk()
window.title('嵌入式之电饭煲')
window.geometry('800x600')
 
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
    r.pack('left')
    #tkinter.messagebox.showinfo(title='Hi', message='这是我们的联系方式')

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

on_hit = False
def Temp():
    global on_hit
    if on_hit == False :
        on_hit = True
        var.set('temp1')
    else :
        on_hit = False
        var.set(' ')


l1 = tk.Label(frame_l, text='湿度：', font=('Arial', 12)).pack()
l2 = tk.Label(frame_l, text='压强：', font=('Arial', 12)).pack()
l3 = tk.Label(frame_l, text='温度：', font=('Arial', 12)).pack()
l4 = tk.Label(frame_l, text='时间', font=('Arial', 12)).pack()
l5 = tk.Label(frame_l, text='日期', font=('Arial', 12)).pack()
l6 = tk.Label(frame_l, text='设置时间', font=('Arial', 12)).pack()

r1 = tk.Text(frame_r, width = 10, height = 1, font=('Arial', 12)).pack()
r2 = tk.Text(frame_r, width = 10, height = 1, font=('Arial', 12)).pack()
r3 = tk.Text(frame_r, width = 10, height = 1, font=('Arial', 12)).pack()
r4 = tk.Text(frame_r, width = 10, height = 1, font=('Arial', 12)).pack()
r5 = tk.Text(frame_r, width = 10, height = 1, font=('Arial', 12)).pack()
r6 = tk.Text(frame_r, width = 10, height = 1, font=('Arial', 12)).pack()




tk.Label(frame_l, text='湿度：', bg='green').pack()
tk.Label(frame_l, text='压强：', bg='green').pack()
rr = tk.Label(frame_l, text='温度：', bg='green')
rr.pack()
b =tk.Button(window,text = '温度', font=('Arial', 12), width=10, height=1, command=Temp)
b.pack()
tk.Label(frame_r, text='时间', bg='yellow').pack()
tk.Label(frame_r, text='日期', bg='yellow').pack()
tk.Label(frame_r, text='设置时间', bg='yellow').pack()

def print_selection(v):
    #tk.Label(frame_l, text='temp' + v, bg= 'yellow').pack()
    rr.config(text='温度调节' + v)
s = tk.Scale(frame_r, label='time setting', from_=0, to=100, orient=tk.HORIZONTAL, length=200, showvalue=0,tickinterval=2, resolution=10, command=print_selection)
s.pack(side= 'bottom')

window.mainloop()