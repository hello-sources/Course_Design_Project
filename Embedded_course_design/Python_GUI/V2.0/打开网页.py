from tkinter import *
import webbrowser

root = Tk()

text = Text(root,width=30,height = 5)
text.pack()

text.insert(INSERT, "百度一下，你就知道")

text.tag_add("link","1.0","1.4")
text.tag_config("link", foreground="blue", underline = True)

def click(event):
    webbrowser.open("http://www.baidu.com")

text.tag_bind("link","<Button-1>",click)

mainloop()