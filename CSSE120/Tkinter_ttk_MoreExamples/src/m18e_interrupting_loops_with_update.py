"""
Example showing for tkinter and ttk how to:
  1. Inside a long-running loop, use the root (Tk) object's
       update   method to give control back to Tkinter briefly, thus
       allowing Tkinter to react to button-presses and other events.

  2. Use a "flag" to control when a loop ends, with a button that
       can set the flag, thus "interrupting" a long-running loop.

Authors: David Mutchler and his colleagues
         at Rose-Hulman Institute of Technology. November 2013.
"""

import tkinter
from tkinter import ttk
import time


class StopFlag(object):
    def __init__(self):
        self.stop_os = False
        self.stop_xs = False


#-----------------------------------------------------------------------
#  *** WARNING: *** THE USE OF   UPDATE   PER THIS FILE MAY NOT WORK
#                   AS YOU WANT.  TALK WITH YOUR INSTRUCTOR AS NEEDED.
#-----------------------------------------------------------------------
def main():
    root = tkinter.Tk()
    stopper = StopFlag()

    frame = ttk.Frame(root, padding=10)
    frame.grid()

    button1 = ttk.Button(frame, text='oooo')
    button1.grid()
    button1['command'] = lambda: print_oooo(root, stopper)

    button2 = ttk.Button(frame, text='xxxx')
    button2.grid()
    button2['command'] = lambda: print_xxxx(root, stopper)

    button3 = ttk.Button(frame, text='Stop the O\'s')
    button3.grid()
    button3['command'] = lambda: stop_o(stopper)

    button4 = ttk.Button(frame, text='Stop the X\'s')
    button4.grid()
    button4['command'] = lambda: stop_x(stopper)

    root.mainloop()


def print_oooo(root, stopper):
    """ Prints   oooo   once a second, (almost) forever. """
    stopper.stop_os = False
    while True:
        if stopper.stop_os:
            break
        print('oooo')
        time.sleep(1)
        root.update()


def print_xxxx(root, stopper):
    """ Prints   xxxx   once a second, (almost) forever. """
    stopper.stop_xs = False
    while True:
        if stopper.stop_xs:
            break
        print('xxxx')
        time.sleep(1)
        root.update()


def stop_o(stopper):
    """ Set the variable that will stop all the O processes. """
    stopper.stop_os = True


def stop_x(stopper):
    """ Set the variable that will stop all the X processes. """
    stopper.stop_xs = True

#-----------------------------------------------------------------------
# If this module is running at the top level (as opposed to being
# imported by another module), then call the 'main' function.
#-----------------------------------------------------------------------
if __name__ == '__main__':
    main()
