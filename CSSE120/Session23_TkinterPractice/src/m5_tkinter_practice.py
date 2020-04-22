"""
This project lets you try out Tkinter/Ttk and practice it!

Authors: David Mutchler, Valerie Galluzzi, Mark Hays, Amanda Stouder,
         their Qishun Yu.  Summer 2016.
"""  # DONE: 1. PUT YOUR NAME IN THE ABOVE LINE.

import tkinter
from tkinter import ttk


def main():
    """ Constructs a GUI with stuff on it. """
    # ------------------------------------------------------------------
    # DONE: 2. After reading and understanding the m1e module,
    #   ** make a window that shows up. **
    # ------------------------------------------------------------------
    root = tkinter.Tk()

    # ------------------------------------------------------------------
    # DONE: 3. After reading and understanding the m2e module,
    #   ** put a Frame on the window. **
    # ------------------------------------------------------------------
    frame1 = ttk.Frame(root, padding=5)
    frame1.grid()

    # ------------------------------------------------------------------
    # DONE: 4. After reading and understanding the m2e module,
    #   ** put a Button on the Frame. **
    # ------------------------------------------------------------------
    connect_button = ttk.Button(frame1, text='Button')
    connect_button.grid()
    # ------------------------------------------------------------------
    # DONE: 5. After reading and understanding the m3e module,
    #   ** make your Button respond to a button-press **
    #   ** by printing   "Hello"  on the Console.     **
    # ------------------------------------------------------------------
    connect_button['command'] = (lambda:
                                 do_stuff())
    # ------------------------------------------------------------------
    # DONE: 6. After reading and understanding the m4e module,
    #   -- Put an Entry box on the Frame.
    #   -- Put a second Button on the Frame.
    #   -- Make this new Button, when pressed, print "Hello"
    #        on the Console if the current string in the Entry box
    #        is the string 'ok', but print "Goodbye" otherwise.
    # ------------------------------------------------------------------
    my_entry_box = ttk.Entry(frame1)
    my_entry_box.grid()
    secbutton = ttk.Button(frame1, text='Second Button')
    secbutton.grid()
    secbutton['command'] = (lambda:
                            do_stuff(my_entry_box))

    # ------------------------------------------------------------------
    # DONE: 7.
    #    -- Put a second Entry on the Frame.
    #    -- Put a third Button on the frame.
    #    -- Make this new Button respond to a button-press as follows:
    #
    #    Pressing this new Button causes the STRING that the user typed
    #    in the FIRST Entry box to be printed N times on the Console,
    #      where N is the INTEGER that the user typed
    #      in the SECOND Entry box.
    #
    #    If the user fails to enter an integer,
    #    that is a "user error" -- do NOT deal with that.
    #
    # ------------------------------------------------------------------
    ####################################################################
    # HINT:
    #   You will need to obtain the INTEGER from the STRING
    #   that the GET method returns.
    #   Use the   int   function to do so, as in this example:
    #      s = entry_box.get()
    #      n = int(s)
    ####################################################################
    my_entry_box2 = ttk.Entry(frame1)
    my_entry_box2.grid()

    trdbutton = ttk.Button(frame1, text='Third Button')
    trdbutton.grid()
    trdbutton['command'] = (lambda:
                            do_otherstuff(my_entry_box, my_entry_box2))

    # ------------------------------------------------------------------
    # DONE: 8. As time permits, do other interesting GUI things!
    # ------------------------------------------------------------------
    root.mainloop()


def do_stuff(my_entry_box):
    contents_of_entry_box = my_entry_box.get()
    if contents_of_entry_box == 'ok':
        print('hello')
    else:
        print('Godbye')


def do_otherstuff(my_entry_box, my_entry_box2):
    contents_of_entry_box = my_entry_box.get()
    n = my_entry_box2.get()
    s = int(n)
    for _ in range(s):
        print(contents_of_entry_box)

# ----------------------------------------------------------------------
# Calls  main  to start the ball rolling.
# ----------------------------------------------------------------------
main()
