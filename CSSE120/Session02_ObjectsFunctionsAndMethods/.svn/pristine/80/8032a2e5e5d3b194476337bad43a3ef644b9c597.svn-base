"""
This module lets you practice  ** using objects **, including:
  -- CONSTRUCTING objects,
  -- applying METHODS to them, and
  -- accessing their DATA via INSTANCE VARIABLES

Authors: David Mutchler, Dave Fisher, Valerie Galluzzi, Amanda Stouder,
         their colleagues and Qishun Yu.  September 2016.
"""  # DONE: 1. PUT YOUR NAME IN THE ABOVE LINE.

import rosegraphics as rg


def main():
    """ Calls the other functions to demonstrate and/or test them. """
    # Test your functions by putting calls to them here:
    two_circles()
    circle_and_rectangle()
    lines()


def two_circles():
    """
    -- Constructs an rg.RoseWindow.
    -- Constructs and draws two rg.Circle objects on the window
         such that:
           -- They fit in the window and are easily visible.
           -- They have different radii.
           -- One is filled with some color and one is not filled.
    -- Waits for the user to press the mouse, then closes the window.
    """
    window = rg.RoseWindow(700, 400)
    enter_point1 = rg.Point(300, 200)
    circle1 = rg.Circle(enter_point1, 100)
    circle1.fill_color = 'green'
    circle1.attach_to(window)
    enter_point2 = rg.Point(500, 250)
    circle2 = rg.Circle(enter_point2, 100)
    circle2.attach_to(window)

    window.render()
    window.close_on_mouse_click()
    # ------------------------------------------------------------------
    # DONE: 2. Implement this function, per its green doc-string above.
    #    -- ANY two rg.Circle objects that meet the criteria are fine.
    #    -- File  COLORS.pdf  lists all legal color-names.
    # Put a statement in   main   to test this function
    #    (by calling this function).
    # ------------------------------------------------------------------


def circle_and_rectangle():
    """
    -- Constructs an rg.RoseWindow.
    -- Constructs and draws a rg.Circle and rg.Rectangle
       on the window such that:
          -- They fit in the window and are easily visible.
          -- The rg.Circle is filled with 'blue'
    -- Prints (on the console, on SEPARATE lines) the following data
         associated with your rg.Circle:
          -- Its outline thickness.
          -- Its fill color.
          -- Its center.
          -- Its center's x coordinate.
          -- Its center's y coordinate.
    -- Prints (on the console, on SEPARATE lines) the same data
         but for your rg.Rectangle.
    -- Waits for the user to press the mouse, then closes the window.

    Here is an example of the output on the console,
    for one particular circle and rectangle:
           1
           blue
           Point(180.0, 115.0)
           180
           115
           1
           None
           Point(75.0, 150.0)
           75.0
           150.0
    """
    window = rg.RoseWindow(700, 400)

    enter_point1 = rg.Point(300, 200)
    circle1 = rg.Circle(enter_point1, 100)
    circle1.fill_color = 'green'
    circle1.attach_to(window)
    print(circle1.outline_thickness)
    print(circle1.fill_color)
    print(circle1.center)
    print(enter_point1.x)
    print(enter_point1.y)

    point1 = rg.Point(400, 100)
    point2 = rg.Point(200, 50)
    rectangle = rg.Rectangle(point1, point2)
    rectangle.fill_color = 'blue'
    rectangle.attach_to(window)
    print(rectangle.outline_thickness)
    print(rectangle.fill_color)
    print(rectangle.get_center())
    print(rectangle.get_center().x)
    print(rectangle.get_center().y)

    window.render()
    window.close_on_mouse_click()
    # ------------------------------------------------------------------
    # DONE: 3. Implement this function, per its green doc-string above.
    #   -- ANY objects that meet the criteria are fine.
    # Put a statement in   main   to test this function
    #    (by calling this function).
    #
    # IMPORTANT: Use the DOT TRICK to guess the names of the relevant
    #       instance variables for outline thickness, etc.
    # ------------------------------------------------------------------


def lines():
    """
    -- Constructs a rg.RoseWindow.
    -- Constructs and draws on the window two rg.Lines such that:
          -- They both fit in the window and are easily visible.
          -- One rg.Line has the default thickness.
          -- The other rg.Line is thicker (i.e., has a bigger width).
    -- Uses a rg.Line method to get the midpoint (center) of the
         thicker rg.Line.
    -- Then prints (on the console, on SEPARATE lines):
         -- the midpoint itself
         -- the x-coordinate of the midpoint
         -- the y-coordinate of the midpoint

       Here is an example of the output on the console, if the two
       endpoints of the thicker line are at (100, 100) and (121, 200):
            Point(110.5, 150.0)
            110.5
            150.0

    -- Waits for the user to press the mouse, then closes the window.
    """
    window = rg.RoseWindow(700, 400)

    point1 = rg.Point(600, 100)
    point2 = rg.Point(100, 50)
    line1 = rg.Line(point1, point2)
    line1.thickness = 1

    point3 = rg.Point(200, 200)
    point4 = rg.Point(100, 50)
    line2 = rg.Line(point3, point4)
    line2.thickness = 5

    line1.attach_to(window)
    line2.attach_to(window)

    print(line1.get_midpoint())
    print(line1.get_midpoint().x)
    print(line1.get_midpoint().y)

    print(line2.get_midpoint())
    print(line2.get_midpoint().x)
    print(line2.get_midpoint().y)
    window.render()
    window.close_on_mouse_click()

# : DONE 4. Implement and test this function.

# ----------------------------------------------------------------------
# Calls  main  to start the ball rolling.
# ----------------------------------------------------------------------
main()
