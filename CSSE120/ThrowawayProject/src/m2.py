"""
The Python Capstone Project.

CSSE 120 - Introduction to Software Development.
Team members: Jonathan Holst, Ben Lewer, Bill YU.

The primary author of this module is: Ben Lewer.
"""
# DONE: Put the names of ALL team members in the above where indicated.
#       Put YOUR NAME in the above where indicated.

import m0
import m1
import m3
import m4

import tkinter
from tkinter import ttk

# ----------------------------------------------------------------------
# TODO: Make your frame display your name.
#
# TODO: Make your frame have:
#   -- a  Connect Wireless   Button
#   -- an Entry box with a label that indicates it is for the URL.
#
# TODO: Make your button, when pressed, print
#            Connecting the robot to URL X
#   in the Console, where X is the STRING in the Entry box.
#
# TODO: THINK about this:  How will you make the REAL robot connect
#   to its URL?  Hint: Neither adding an argument nor returning a value
#   will solve the problem!
# ----------------------------------------------------------------------


def my_frame(root, dc):
    """
    Constructs and returns a   ttk.Frame   on the given root window.
    The frame contains all of this module's widgets.
    Does NOT   grid   the Frame, since the caller will do that.
    Also sets up callbacks for this module's widgets.

    The first argument is the  root  window (a tkinter.Tk object)
    onto which the   ttk.Frame  returned from this function
    will be placed.  The second argument is the shared DataContainer
    object that is CONSTRUCTED in m0 but USED in m1, m2, m3 and m4.

    Preconditions:
      :type root: tkinter.Tk
      :type dc:   m0.DataContainer
    """

# ----------------------------------------------------------------------
# If this module is running at the top level (as opposed to being
# imported by another module), then call the 'main' function.
# ----------------------------------------------------------------------
    frame = ttk.Frame(root, padding=5)

    name_label = ttk.Label(root, text='Ben Lewer')
    name_label.grid()

    return frame
if __name__ == '__main__':
    m0.main()