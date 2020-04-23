"""
The Python Capstone Project.

CSSE 120 - Introduction to Software Development.
Team members: PUT-YOUR-NAMES_HERE (all of them).

The primary author of this module is: PUT-YOUR-NAME-HERE.
"""
# TODO: Put the names of ALL team members in the above where indicated.
#       Put YOUR NAME in the above where indicated.

import m0
import m1
import m2
import m3

import tkinter
from tkinter import ttk

# ----------------------------------------------------------------------
# TODO: Make your frame display your name.
#
# TODO: Make your frame have:
#   -- a  Spin Left   Button
#   -- an Entry box with a label that indicates it is for the
#        NUMBER OF SECONDS that the robot should spin left.
#
# TODO: Make your button, when pressed, print
#           Robot is spinning left X seconds
#   in the Console, where X is the FLOATING POINT NUMBER in the Entry box.
#
# TODO: THINK about this:  How will you make the REAL robot spin
#   the specified number of seconds?  Hint: Neither adding an argument
#   nor returning a value will solve the problem!
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
if __name__ == '__main__':
    m0.main()