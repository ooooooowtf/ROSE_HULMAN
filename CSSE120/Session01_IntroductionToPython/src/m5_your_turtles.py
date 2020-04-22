"""
Your chance to explore Loops and Turtles!

Authors: David Mutchler, Dave Fisher, Valerie Galluzzi, Amanda Stouder,
         their colleagues and Qishun YU.  November 2016.
"""
########################################################################
# DONE: 1.
# On Line 5 above, replace  PUT_YOUR_NAME_HERE  with your OWN name.
########################################################################

########################################################################
# DONE: 2.
#
#  You should have RUN the PREVIOUS module and READ its code.
#  (Do so now if you have not already done so.)
#
#  Below this comment, add ANY CODE THAT YOUR WANT, as long as:
#    1. You construct at least 2 rg.SimpleTurtle objects.
#    2. Each rg.SimpleTurtle object draws something
#         (by moving, using its rg.Pen).  ANYTHING is fine!
#    3. Each rg.SimpleTurtle moves inside a LOOP.
#
#  Be creative!  Strive for way-cool pictures!  Abstract pictures rule!
#
#  If you make syntax (notational) errors, no worries -- get help
#  fixing them at either this session OR at the NEXT session.
#
#  Don't forget to COMMIT your work by using  SVN ~ Commit.
########################################################################
import rosegraphics as rg

window = rg.TurtleWindow()

bill = rg.SimpleTurtle()
bill.pen = rg.Pen('yellow', 1)
bill.speed = 10
mark = rg.SimpleTurtle()
mark.pen = rg.Pen('blue', 1)
mark.speed = 10

size = 160

for k in range(20):
    bill.draw_circle(size)
    mark.forward(size)
    mark.left(90)
    mark.forward(size * 2)
    mark.left(90)
    mark.forward(size * 2)
    mark.left(90)
    mark.forward(size * 2)
    mark.left(90)
    mark.forward(size)
    size = size - 5
window.close_on_mouse_click()
