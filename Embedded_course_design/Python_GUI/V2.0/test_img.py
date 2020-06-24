from tkinter import *
import tkinter as tk
window = tk.Tk()
window.title('cowboy')
photo = PhotoImage(file="C:/Users/32458/Desktop/嵌入式课设/Python_GUI/V2.0/裴秀智.gif")
theLabel = Label(window, image=photo)
label = Label(window, text="hello", font=('heiti', 20), fg='red', bg='pink')
label.place(x=225, y=95)
theLabel.pack()
window.mainloop()

