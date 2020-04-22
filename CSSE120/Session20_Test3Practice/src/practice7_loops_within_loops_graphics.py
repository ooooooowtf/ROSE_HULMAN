"""
PRACTICE Test 3.

This problem provides practice at:
  ***  LOOPS WITHIN LOOPS in 2D GRAPHICS problems.  ***

Authors: David Mutchler, Valerie Galluzzi, Mark Hays, Amanda Stouder,
         their colleagues and Qishun Yu.  October 2016.
"""  # DONW: 1. PUT YOUR NAME IN THE ABOVE LINE.

########################################################################
# Students:
#
# These problems have DIFFICULTY and TIME ratings:
#  DIFFICULTY rating:  1 to 10, where:
#     1 is very easy
#     3 is an "easy" Test 2 question.
#     5 is a "typical" Test 2 question.
#     7 is a "hard" Test 2 question.
#    10 is an EXTREMELY hard problem (too hard for a Test 2 question)
#
#  TIME ratings: A ROUGH estimate of the number of minutes that we
#     would expect a well-prepared student to take on the problem.
#
#  IMPORTANT: For ALL the problems in this module,
#    if you reach the time estimate and are NOT close to a solution,
#    STOP working on that problem and ASK YOUR INSTRUCTOR FOR HELP
#    on it, in class or via Piazza.
########################################################################

import math
import rosegraphics as rg


def main():
    """ Calls the   TEST   functions in this module. """
    test_hourglass()
    test_many_hourglasses()


def test_hourglass():
    """ Tests the    hourglass    function. """
    print()
    print('--------------------------------------------------')
    print('Testing the   hourglass   function:')
    print('--------------------------------------------------')

    test1 = '(n = 3, radius = 40, blue)'
    test2 = '(n = 8, radius = 15, green)'
    title1 = 'Hourglass, two tests: {} and {}'.format(test1, test2)
    window1 = rg.RoseWindow(600, 500, title1)

    hourglass(window1, 3, rg.Point(150, 200), 40, 'blue')
    hourglass(window1, 8, rg.Point(450, 250), 15, 'green')

    window1.close_on_mouse_click()

    test3 = '(n = 6, radius = 30, red)'
    title2 = 'Hourglass, one more test: {}'.format(test3)
    window2 = rg.RoseWindow(400, 700, title2)

    hourglass(window2, 6, rg.Point(200, 350), 30, 'red')

    window2.close_on_mouse_click()


def hourglass(window, n, point, radius, color):
    """
    See   problem3a_picture.pdf   in this project for pictures that may
    help you better understand the following specification:

    Displays an "hourglass" shape of circles in the given window.
      -- Each circle has the given radius and given color.
      -- Each circle has a horizontal line drawn through it.
      -- The middlemost of the circles is centered at the given point.
      -- There is a single circle in that middlemost row.
      -- There are n rows (including the middlemost row)
            of circles going UP from the middlemost circle.
      -- There are n rows (including the middlemost row)
           of circles going DOWN from the middlemost circle.
      -- Each circle barely touches its neighbor circles.

    Preconditions:
      :type window: rg.RoseWindow
      :type n: int
      :type point: rg.Point
      :type radius: int
      :type color: str
    where n and radius are positive and color is a string that denotes
    a color that rosegraphics understands.
    """
    # ------------------------------------------------------------------
    # DONE: Implement and test this function.
    #       We provided some tests for you (above).
    # ------------------------------------------------------------------
    ####################################################################
    # BONUS: Avoid replicated code if you can.  Hint: You are allowed
    #        to define an additional function(s) if you wish.
    ####################################################################
    # ------------------------------------------------------------------
    # DIFFICULTY AND TIME RATINGS (see top of this file for explanation)
    #    DIFFICULTY:      8
    #    TIME ESTIMATE:  25 minutes.
    # ------------------------------------------------------------------
    orix = point.x
    oriy = point.y
    newpoint = rg.Point(orix, oriy)
    newpoint1 = rg.Point(orix, oriy)
    for k in range(n):
        for j in range(k + 1):
            circle = rg.Circle(newpoint, radius)
            circle.fill_color = color
            circle.attach_to(window)
            newpoint.x = newpoint.x + 2 * radius
            window.render()
            circle1 = rg.Circle(newpoint1, radius)
            circle1.fill_color = color
            circle1.attach_to(window)
            newpoint1.x = newpoint1.x + 2 * radius
            window.render()
        newpoint.x = newpoint.x - radius * (2 * k + 3)
        newpoint.y = newpoint.y - math.sqrt(3) * radius
        newpoint1.x = newpoint1.x - radius * (2 * k + 3)
        newpoint1.y = newpoint1.y + math.sqrt(3) * radius

    pointy1 = oriy
    pointy2 = oriy
    point1x = orix - radius
    point2x = orix + radius
    for k in range(n):
        point1 = rg.Point(point1x, pointy1)
        point2 = rg.Point(point2x, pointy1)
        line = rg.Line(point1, point2)
        line.attach_to(window)
        window.render()
        pointy1 = pointy1 + math.sqrt(3) * radius
        point3 = rg.Point(point1x, pointy2)
        point4 = rg.Point(point2x, pointy2)
        line = rg.Line(point3, point4)
        line.attach_to(window)
        window.render()
        pointy2 = pointy2 - math.sqrt(3) * radius
        point1x = point1x - radius
        point2x = point2x + radius


def test_many_hourglasses():
    """ Tests the    many_hourglasses    function. """
    print()
    print('--------------------------------------------------')
    print('Testing the   many_hourglasses   function:')
    print('--------------------------------------------------')

    test1 = '(n = 4, radius = 30, red-blue-black-green)'
    test2 = '(n = 3, radius = 70, brown-cyan-yellow-green)'
    title1 = 'Many hourglasses, two tests: {} and {}'.format(test1,
                                                             test2)
    window1 = rg.RoseWindow(800, 400, title1)

    square1 = rg.Square(rg.Point(50, 150), 30)
    square2 = rg.Square(rg.Point(400, 200), 70)

    many_hourglasses(window1, square1, 4,
                     ('red', 'blue', 'black', 'green'))
    many_hourglasses(window1, square2, 3,
                     ('brown', 'cyan', 'yellow', 'green'))
    window1.close_on_mouse_click()

    test3 = '(n = 7, radius = 40, red-black-blue)'
    title2 = 'Many hourglasses, one more test: {}'.format(test3)
    window2 = rg.RoseWindow(1200, 500, title2)

    square3 = rg.Square(rg.Point(50, 250), 40)

    many_hourglasses(window2, square3, 7, ('red', 'black', 'blue'))

    window2.close_on_mouse_click()


def many_hourglasses(window, square, m, colors):
    """
    See   problem3b_picture.pdf   in this project for pictures that may
    help you better understand the following specification:

    Displays  m  rectangles, where:
      -- Each rectangle has an hourglass of circles inside it,
           per the  hourglass  function above.
      -- The circles in the hourglasses are all the same size.
      -- The leftmost rectangle is the given square, and it contains
           an hourglass with a single circle that fills the square.
      -- Each successive rectangle is immediately to the right of the
           previous rectangle, and each contains an hourglass with
           the hourglass'  n   being one greater than the  n  used
           for the previous rectangle.
      -- The colors for the hourglass figures use the given sequence of
           colors, "wrapping" if m exceeds the length of the sequence.

    Preconditions:
      :type window: rg.RoseWindow
      :type square: rg.Square
      :type m: int
      :type colors: (list, tuple)
    where m is positive and colors is a sequence of strings,
    each of which denotes a color that rosegraphics understands.
    """
    # ------------------------------------------------------------------
    # TODO: Implement and test this function.
    #       We provided some tests for you (above).
    # ------------------------------------------------------------------
    ####################################################################
    # IMPORTANT:
    #   1. Partial credit if you draw JUST the rectangles.
    #   2. No additional credit unless you CALL the  hourglass  function
    #        in the PREVIOUS problem appropriately
    #        to draw the hourglass figures.
    ####################################################################
    # ------------------------------------------------------------------
    # DIFFICULTY AND TIME RATINGS (see top of this file for explanation)
    #    DIFFICULTY:      6  (assuming that you already have
    #                         a correct "hourglass" function above)
    #    TIME ESTIMATE:  15 minutes.
    # ------------------------------------------------------------------
    centerx = square.center.x
    centery = square.center.y
    radius = square.length_of_each_side / 2
    for k in range(m):
        for j in range(k + 1):
            circle = rg.Circle((centerx, centery), radius)
        point1x = centerx - (k + 1) * radius
        point1y = centery - (k + 1) * radius
        point2x = centerx + (k + 1) * radius
        point2y = centery + (k + 1) * radius
        point1 = rg.Point(point1x, point1y)
        point2 = rg.Point(point2x, point2y)
        rectangle = rg.Rectangle(point1, point2)

# ----------------------------------------------------------------------
# Calls  main  to start the ball rolling.
# ----------------------------------------------------------------------
main()
