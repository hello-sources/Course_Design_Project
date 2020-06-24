import tkinter

#创建主窗口
win = tkinter.Tk()
#设置标题
win.title("sunck")
#设置大小和位置
#win.geometry("400x400+200+20")

'''
文本控件，用于显示多行文本
'''
#创建滚动条
scroll = tkinter.Scrollbar()
text = tkinter.Text(win, width=50, height=8)
#side放到窗体的那一侧   fill填充
scroll.pack(side=tkinter.RIGHT, fill=tkinter.Y)
text.pack(side=tkinter.LEFT, fill=tkinter.Y)
#关联
scroll.config(command=text.yview)
text.config(yscrollcommand=scroll.set)

str = '''If there is anyone out there who still doubts that America is a place where all things are possible, who still wonders if the dream of our founders is alive in our time, who still questions the power of our democracy, tonight is your answerIt’s the answer told by lines that stretched around schools and churches in numbers this nation has never seen, by people who waited three hours and four hours, many for the first time in their lives, because they believed that this time must be different, that their voices could be that difference.'''
text.insert(tkinter.INSERT, str)

win.mainloop()