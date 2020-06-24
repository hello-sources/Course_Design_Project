import tkinter as tk
import tkinter.ttk as ttk
import tkinter.font as tkfont

def on_combo_configure(event):
    global fruit
    font = tkfont.nametofont(str(event.widget.cget('font')))
    width = font.measure(fruit[0] + "0") - event.width
    style = ttk.Style()
    style.configure('TCombobox', postoffset=(0,0,width,0))

root = tk.Tk()
root.title("testing the combobox")
root.geometry('300x300+50+50')
fruit = ['apples are the best', 'bananas are better']

c = ttk.Combobox(root, values=fruit, width=10)
c.bind('<Configure>', on_combo_configure)
c.pack()

root.mainloop()