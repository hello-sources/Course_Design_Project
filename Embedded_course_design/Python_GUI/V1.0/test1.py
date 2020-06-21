from tkinter import *
import time
import serial #导入模块
import json
import time
import requests
from tkinter import *
from tkinter import *
import time
import serial #导入模块

from PIL import Image, ImageTk


#函数区
def gettime():  #获取当前时间
    timestr = time.strftime("%H:%M:%S") # 获取当前的时间并转化为字符串
    labeld.configure(text=timestr) # 重新设置标签文本
    root.after(1000,gettime) # 每隔1s调用函数 gettime 自身获取时间

def getall():#得到湿度 温度 距离 气压等数据
    str=""
    try:
        portx="COM2"    #串口
        bps=9600    #波特率
        timex=1000  #延时

        ser=serial.Serial(portx,bps,timeout=timex)  #打开串口
        while True:
            if ser.in_waiting:  #判断缓冲区是否为空
                str=ser.readline().decode("gbk")    #读入一行
                print("收到数据：",str)
                break
        ser.close() #关闭串口
    except Exception as e:
        print("---异常---：",e)
    sd=str[21:26]   #湿度
    tem=str[28:33]  #温度
    hic=str[35:41]  #热指数
    lux=str[0:4]    #光照强度
    pa=str[14:19]        #气压
    distance=str[5:12]  #距离

    labels2.configure(text=sd)  #写道lable里面 湿度
    labelt.configure(text=tem)  #温度
    labelq1.configure(text=pa)  #气压
    labelj1.configure(text=distance) #距离
    labelre1.configure(text=hic)    #热指数
    labelgu1.configure(text=lux)
    root.after(100,getall) #隔一秒重新调用函数getall

#控制LED灯的 灭 亮
def LED():
    try:
        portx="COM2"    #串口
        bps=9600    #波特率
        timex=1000  #延时

        ser=serial.Serial(portx,bps,timeout=timex)  #打开串口
        
        ser.close() #关闭串口
    except Exception as e:
        print("---异常---：",e)

#控制锋鸣器
def Fmqi():
    try:
        portx="COM2"    #串口
        bps=9600    #波特率
        timex=1000  #延时

        ser=serial.Serial(portx,bps,timeout=timex)  #打开串口
        
        ser.close() #关闭串口
    except Exception as e:
        print("---异常---：",e)


#主界面
root=Tk()   #初始化界面
root.title("无人机传感器模块")  #界面标题
root.geometry('600x600')    #界面大小


#显示温度
labelw=Label(root,text="温度",font=("宋体"))
labelw.place(relx=0.1,rely=0.1,relheight=0.1,relwidth=0.1)  #确定标签相对位置和相对大小

labelt=Label(root,text="",font=("宋体"))
labelt.place(relx=0.2,rely=0.1,relheight=0.1,relwidth=0.1)

#显示湿度
labels=Label(root,text="湿度",font=("宋体"))
labels.place(relx=0.3,rely=0.1,relheight=0.1,relwidth=0.1)

labels2=Label(root,text="",font=("宋体"))
labels2.place(relx=0.4,rely=0.1,relheight=0.1,relwidth=0.1)

#显示热指数
labelre=Label(root,text="热指数",font=("宋体"))
labelre.place(relx=0.6,rely=0.1,relheight=0.1,relwidth=0.1)

labelre1=Label(root,text="",font=("宋体"))
labelre1.place(relx=0.75,rely=0.1,relheight=0.1,relwidth=0.1)

#显示光照强度
labelgu=Label(root,text="光照强度",font=("宋体"))
labelgu.place(relx=0.1,rely=0.2,relheight=0.1,relwidth=0.15)

labelgu1=Label(root,text="",font=("宋体"))
labelgu1.place(relx=0.25,rely=0.2,relheight=0.1,relwidth=0.15)

#显示气压传感器的数据
labelq=Label(root,text="气压",font=("宋体"))
labelq.place(relx=0.1,rely=0.3,relheight=0.1,relwidth=0.1)

labelq1=Label(root,text="",font=("宋体"))
labelq1.place(relx=0.2,rely=0.3,relheight=0.1,relwidth=0.1)

#显示红外传感器的数据
labelj=Label(root,text="距离",font=("宋体"))
labelj.place(relx=0.1,rely=0.4,relheight=0.1,relwidth=0.1)

labelj1=Label(root,text="",font=("宋体"))
labelj1.place(relx=0.2,rely=0.4,relheight=0.1,relwidth=0.2)

getall()#显示温度 湿度 气压 距离等，实时显示

#读取当前时间
labels=Label(root,text="当前时间",font=("宋体"))
labels.place(relx=0.7,rely=0.2,relheight=0.1,relwidth=0.2)

labeld=Label(root,text="",font=("宋体"))
labeld.place(relx=0.7,rely=0.3,relheight=0.1,relwidth=0.2)
gettime()

#按钮
btn1 = Button(root, text="警示灯")# 函数需要后续定义，来对LED进行操作
btn1.place(relx=0.4, rely=0.8, relwidth=0.1, relheight=0.1)

btn1 = Button(root, text="蜂鸣器")# 函数需要后续定义，来对蜂鸣器进行操作
btn1.place(relx=0.5, rely=0.8, relwidth=0.1, relheight=0.1)



root.mainloop()