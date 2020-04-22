"""
This module lets you experience the POWER of FUNCTIONS and PARAMETERS.

Authors: David Mutchler, Valerie Galluzzi, Mark Hays, Amanda Stouder,
         their colleagues and Qishun Yu.  September 2015.
"""
# DONE: 1. PUT YOUR NAME IN THE ABOVE LINE.

import rosegraphics as rg


def main():
    """ Calls the   TEST   functions in this module. """
    test_draw_circles()
    # Un-comment the next lines when you are ready to use them.
    test_better_draw_circles()
    test_even_better_draw_circles()


# ----------------------------------------------------------------------
# READ THIS:
#  The next two functions:
#       draw_circles    test_draw_circles
#  are both complete.  Do NOT change them.
#  In a previous exercise, YOU implemented very similar functions.
#
#  In the REST of this exercise (see below), you will implement
#  MORE POWERFUL versions of the   draw_circles   function.
# ----------------------------------------------------------------------

def test_draw_circles():
    """ Tests the   draw_circles   function. """
    # ------------------------------------------------------------------
    # Students:
    #   Do NOT touch this function - it has no TODO in it.
    # ------------------------------------------------------------------
    print()
    print('--------------------------------------------------')
    print('Testing  draw_circles:  See graphics window')
    print('--------------------------------------------------')
    draw_circles()


def draw_circles():
    """
    -- Constructs a window whose width and height are both 400.
    -- Constructs and draws 21 rg.Circle objects such that:
         -- Each is centered at (200, 200)
         -- They have radii:  0  10  20  30  40 ... 200, respectively.
         -- Pauses 0.05 seconds after rendering each.
    -- Waits for the user to press the mouse, then closes the window.
    """
    # ------------------------------------------------------------------
    # Students:
    #   Do NOT touch this function - it has no TODO in it.
    # ------------------------------------------------------------------
    window = rg.RoseWindow(400, 400)

    center = rg.Point(200, 200)
    for k in range(21):
        circle = rg.Circle(center, 10 * k)
        circle.attach_to(window)
        window.render(0.05)  # Pauses for 0.05 seconds after rendering.

    window.close_on_mouse_click()

# ----------------------------------------------------------------------
# DONE: 2.
#   First, RUN this program.  You will see that draw_circles draws
#   concentric circles whose radii vary by 10.
#
#   A function that did the same thing as draw_circles, but allowed
#   for the radii to vary by ANY desired amount would be MORE POWERFUL.
#
#   So, implement TWO functions immediately below this comment.
#   They should be called:
#      better_draw_circles
#      test_better_draw_circles
#
#   Your   better_draw_circles  function should have a single PARAMETER
#   that is the amount by which the radii of the circles increase.
#   For example, if that parameter is given the value 10,
#   then the circles have radii:  0  10  20  30  40 ... 200, respectively,
#   just as in   draw_circles1.  But if that parameter is given the
#   value 3, the circles have radii:  0  3  6  9  12  ... 60.
#
#   Your  test_better_draw_circles function should TEST your new
#   better_draw_circles function, by calling it with different values
#   for its argument.  Don't forget to put a call to
#   test_better_draw_circles  in  main.
#
#   You may find that COPY-AND-PASTE of the  draw_circles  and its
#   test_draw_circles  may get you started more quickly on your new
#   better_draw_circles  and  test_better_draw_circles.
# ----------------------------------------------------------------------


def test_better_draw_circles():
    print()
    print('--------------------------------------------------')
    print('Testing  better_draw_circles:  See graphics window')
    print('--------------------------------------------------')

    # test 1
    better_draw_circles(5)

    # test 2
    better_draw_circles(6)

    # test 3
    better_draw_circles(17)


def better_draw_circles(n):
    window = rg.RoseWindow(400, 400)

    center = rg.Point(200, 200)
    for k in range(n):
        circle = rg.Circle(center, 10 * k)
        circle.attach_to(window)
        window.render(0.05)  # Pauses for 0.05 seconds after rendering.

    window.close_on_mouse_click()


# ----------------------------------------------------------------------
# DONE: 3.
#   In the previous exercise, you made a MORE POWERFUL version
#   of draw_circles by introducing a PARAMETER for the amount by
#   which the radii of the concentric circles increase.
#
#   In this exercise, implement TWO MORE functions immediately below
#   this comment. They should be called:
#      even_better_draw_circles
#      test_even_better_draw_circles
#
#   Your new   even_better_draw_circles  function should have
#   SEVERAL parameters, for allowing the caller to vary what YOU
#   choose to have the caller vary.  For example, you could have
#   parameters for any or all of the following:
#     -- The amount by which the radii vary (as you did above)
#     -- The number of concentric circles drawn
#     -- The center of the concentric circles
#     -- The outline_color of the concentric circles
#     -- The speed at which the animation runs
#    and more.
#
#   A total of any THREE parameters (of your choosing) is enough,
#   although you may have more.
#
#   In testing your even_better_draw_circles function,
#   can you make some fun pictures?
# ----------------------------------------------------------------------

# ----------------------------------------------------------------------
# Calls  main  to start the ball rolling.
# ----------------------------------------------------------------------
def test_even_better_draw_circles():
    print()
    print('--------------------------------------------------')
    print('Testing  even_better_draw_circles:  See graphics window')
    print('--------------------------------------------------')

    # test 1
    even_better_draw_circles(5, 10, 250, 100)

    # test 2
    even_better_draw_circles(10, 5, 200, 200)

    # test 3
    even_better_draw_circles(3, 30, 200, 200)


def even_better_draw_circles(i, n, x, y):
    #     -- The amount by which the radii vary (as you did above)
    #     -- The number of concentric circles drawn
    #     -- The center of the concentric circles
    window = rg.RoseWindow(400, 400)

    center = rg.Point(x, y)
    for k in range(n):
        circle = rg.Circle(center, i * k)
        circle.attach_to(window)
        window.render(0.05)  # Pauses for 0.05 seconds after rendering.

    window.close_on_mouse_click()


main()
