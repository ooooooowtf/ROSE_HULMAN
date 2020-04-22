"""
This module lets you practice IMPLEMENTING
functions that MUTATE their arguments.

Authors: David Mutchler, Valerie Galluzzi, Mark Hays, Amanda Stouder,
         their colleagues and Qishun Yu.  September 2016.
"""  # DONE: 1. PUT YOUR NAME IN THE ABOVE LINE.

import rosegraphics as rg

########################################################################
#
# Your instructor will help you understand the TESTS of the
#   swap_colors
# function.  You will implement the   swap_colors  function itself.
########################################################################


def main():
    """ Calls the   TEST   functions in this module. """
    test_swap_colors()


def test_swap_colors():
    """ Tests the   swap_colors   function. """
    print()
    print('--------------------------------------------------')
    print('Testing the   swap_colors   function:')
    print('--------------------------------------------------')

    # ------------------------------------------------------------------
    # Test 1:  Note that it tests both:
    #            -- what was SUPPOSED to be mutated (fill_color) and
    #            -- what was NOT supposed to be mutated (all else).
    #   The code passes this test if the expected value printed
    #   is the same as the actual value printed.
    # ------------------------------------------------------------------
    circle = rg.Circle(rg.Point(100, 150), 50)
    circle.fill_color = 'blue'

    rectangle = rg.Rectangle(rg.Point(200, 30), rg.Point(350, 150))
    rectangle.fill_color = 'green'

    expected_c = 'Circle: center=(100, 150), radius=50,'
    expected_c += ' fill_color=green, outline_color=black,'
    expected_c += ' outline_thickness=1.'

    expected_r = 'Rectangle: corner_1=(200, 30), corner_2=(350, 150),'
    expected_r += ' fill_color=blue, outline_color=black,'
    expected_r += ' outline_thickness=1.'

    swap_colors(circle, rectangle)

    print()
    print('Expected circle after the function call:')
    print(expected_c)
    print('Actual circle after the function call:')
    print(circle)

    print()
    print('Expected rectangle after the function call:')
    print(expected_r)
    print('Actual rectangle after the function call:')
    print(rectangle)

    # ------------------------------------------------------------------
    # Test 2:  This is a VISUAL test.
    #   The code passes this test if the objects are drawn per the test.
    #
    #   Here, that means that when the window pauses and asks the user
    #   to press any key to continue:
    #     -- the circle is black_filled and
    #     -- the rectangle is red_filled
    #   and then when the user presses a key and the window pauses
    #   again, now the reverse is true:
    #     -- the circle is red_filled and
    #     -- the rectangle is black_filled.
    # ------------------------------------------------------------------
    title = 'The code passes the test if the fill colors of the circle'
    title += ' and rectangle get SWAPPED.'
    window = rg.RoseWindow(700, 400, title)

    circle = rg.Circle(rg.Point(100, 50), 40)
    circle.fill_color = 'black'
    circle.attach_to(window)

    rectangle = rg.Rectangle(rg.Point(200, 280), rg.Point(350, 350))
    rectangle.fill_color = 'red'
    rectangle.attach_to(window)

    msg1 = 'At this point, the circle should be filled with BLACK\n'
    msg1 += 'and the rectangle should be filled with RED'
    message = rg.Text(rg.Point(400, 100), msg1)
    message.attach_to(window)

    # At this point, the CIRCLE should be filled with BLACK
    #                   and the RECTANGLE filled with RED.
    window.render()
    window.continue_on_mouse_click()

    swap_colors(circle, rectangle)

    # At this point, the CIRCLE should be filled with RED
    #                   and the RECTANGLE filled with BLACK.
    msg2 = 'Now, the circle should be filled with RED\n'
    msg2 += 'and the rectangle should be filled with BLACK.\n'
    msg2 += 'If so, and if nothing else changed,\n'
    msg2 += 'the code passed this test.'
    message.text = msg2

    window.render()
    window.close_on_mouse_click()


def swap_colors(circle, rectangle):
    """
    What comes in:
      -- An rg.Circle.
      -- An rg.Rectangle.
    What goes out:  Nothing (i.e., None).
    Side effects:
      MUTATES the given rg.Circle and rg.Rectangle by swapping
      (exchanging) their fill colors.
    Example:
      If:
        -- the given rg.Circle has fill color 'blue' and
        -- the given rg.Rectangle has fill color 'green',
      then after this function returns to its caller,
        -- the rg.Circle argument should have fill color 'green' and
        -- the rg.Rectangle argument should have fill color 'blue'.

    Type hints:
      :type circle: rg.Point
      :type rectangle: rg.Rectangle
    """
    # ------------------------------------------------------------------
    # DONE: 2. Implement and test this function.
    #          Tests have been written for you (above).
    #
    ####################################################################
    # HINT: To SWAP two things (let's call them A and B),
    #   use the SWAP pattern, like this:
    #      temp = A
    #      A = B
    #      B = temp
    ####################################################################
    # ------------------------------------------------------------------
    x1 = circle.fill_color
    circle.fill_color = rectangle.fill_color
    rectangle.fill_color = x1

# ----------------------------------------------------------------------
# Calls  main  to start the ball rolling.
# ----------------------------------------------------------------------
main()
