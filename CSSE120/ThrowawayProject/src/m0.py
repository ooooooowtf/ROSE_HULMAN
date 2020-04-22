"""
The Python Capstone Project.

This file contains data SHARED by the other modules in this project.

CSSE 120 - Introduction to Software Development.
Team members: Jonathan Holst, Ben Lewer, and Bill Yu.
"""
# DONE: Put the names of ALL team members in the above where indicated.

import m1
import m2
import m3
import m4

import tkinter
from tkinter import ttk

# ----------------------------------------------------------------------
# TODO: TEAM-PROGRAM this module so that it runs your entire program,
#       incorporating parts from m1 .. m3.
# ----------------------------------------------------------------------


def main():
    """ Runs the MAIN PROGRAM. """
    print('----------------------------------------------')
    print('Integration Testing of the INTEGRATED PROGRAM:')
    print('----------------------------------------------')

    root = tkinter.Tk()
    dc = None

    f1 = m1.my_frame(root, dc)
    f2 = m2.my_frame(root, dc)
    f3 = m3.my_frame(root, dc)

    frames = [f1, f2, f3]
    for k in range(len(frames)):
        if frames[k]:
            frames[k].grid(row=1, column=k + 1)

    root.mainloop()

# ----------------------------------------------------------------------
# If this module is running at the top level (as opposed to being
# imported by another module), then call the 'main' function.
# ----------------------------------------------------------------------
if __name__ == '__main__':
    main()
