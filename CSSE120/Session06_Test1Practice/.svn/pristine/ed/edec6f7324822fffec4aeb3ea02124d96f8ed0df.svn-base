"""
PRACTICE Test 1, problem 0.

These problems illustrate concepts that previous problems have not
emphasized:
  -- determining whether a number is odd or even (Problem 0a)
  -- returning True or False (Problem 0a)
  -- is_prime (Problem 0b)
  -- animation (Problem 0c)

Authors: David Mutchler, Valerie Galluzzi, Mark Hays, Amanda Stouder,
         their colleagues and PUT_YOUR_NAME_HERE.  September 2016.
"""  # TODO: 1. PUT YOUR NAME IN THE ABOVE LINE.

import rosegraphics as rg


def main():
    """ Calls the   TEST   functions in this module. """
    test_problem0a()
    test_problem0b()
    test_problem0c()


def is_prime(n):
    """
    What comes in:  An integer n >= 2.
    What goes out:
      -- Returns True if the given integer is prime,
         else returns False.
    Side effects:   None.
    Examples:
      -- is_prime(11) returns  True
      -- is_prime(12) returns  False
      -- is_prime(2)  returns  True
    Note: The algorithm used here is simple and clear but slow.
    """
    for k in range(2, (n // 2) + 1):
        if n % k == 0:
            return False

    return True
    # ------------------------------------------------------------------
    # Students:
    #   Do NOT touch the above  is_prime  function - it has no TODO.
    #   Do NOT copy code from this function.
    #
    # Instead, ** CALL ** this function as needed in the problems below.
    # ------------------------------------------------------------------


def sum_of_digits(number):
    """
    What comes in:  An integer.
    What goes out:  Returns the sum of the digits in the given integer.
    Side effects:   None.
    Example:
      If the integer is 83135,
      this function returns (8 + 3 + 1 + 3 + 5), which is 20.
    """
    # ------------------------------------------------------------------
    # Students:
    #   Do NOT touch the above  sum_of_digits function - it has no TODO.
    #   Do NOT copy code from this function.
    #
    # Instead, ** CALL ** this function as needed in the problems below.
    # ------------------------------------------------------------------
    if number < 0:
        number = -number

    digit_sum = 0
    while True:
        if number == 0:
            break
        digit_sum = digit_sum + (number % 10)
        number = number // 10

    return digit_sum


def test_problem0a():
    """ Tests the   problem0a   function. """
    print()
    print('--------------------------------------------------')
    print('Testing the   problem0a   function:')
    print('--------------------------------------------------')

    # Test 1:
    expected = False
    answer = problem0a(83135)
    print()
    print('Test 1 expected:', expected)
    print('       actual:  ', answer)
    if answer == 'False':
        print('Your function returned the STRING "False",')
        print('which is WRONG.  It should have returned')
        print('the built-in constant False.')
        print('Ask for help as needed.')

    # Test 2:
    expected = True
    answer = problem0a(306)
    print()
    print('Test 2 expected:', expected)
    print('       actual:  ', answer)
    if answer == 'True':
        print('Your function returned the STRING "True",')
        print('which is WRONG.  It should have returned')
        print('the built-in constant True.')
        print('Ask for help as needed.')

    # Test 3:
    expected = False
    answer = problem0a(246)
    print()
    print('Test 3 expected:', expected)
    print('       actual:  ', answer)

    # Test 4:
    expected = False
    answer = problem0a(830931)
    print()
    print('Test 4 expected:', expected)
    print('       actual:  ', answer)

    # Test 5:
    expected = True
    answer = problem0a(730931)
    print()
    print('Test 5 expected:', expected)
    print('       actual:  ', answer)


def problem0a(n):
    """
    What comes in:  An integer.
    What goes out:
      -- Returns True if the sum of the digits in the given integer
         is odd, else returns False.
    Side effects:   None.
    Examples:
      -- If the given integer is 83135, this function returns False,
           since (8 + 3 + 1 + 3 + 5) is 20, which is NOT odd.
      -- If the given integer is 306, this function returns True,
           since (3 + 0 + 6) is 9, which IS odd.
      -- If the given integer is 246, this function returns False,
           since (2 + 4 + 6) is 12, which is NOT odd.
    """
    # ------------------------------------------------------------------
    # TODO: 2. Implement and test this function.
    #          Tests have been written for you (above).
    #
    ####################################################################
    # IMPORTANT:
    #    **  For full credit you must appropriately
    #    **  use (call) the   sum_of_digits   function
    #    **  that is DEFINED ABOVE.
    ####################################################################
    #
    # HINT:  To test whether a number  m   is even or odd,
    #        compute m % 2, i.e., the REMAINDER from m // 2.
    #        If that remainder is 0, the number is even.
    #        If that remainder is 1, the number is odd.
    #        Simply try a few examples to convince yourself of this.
    #        ASK FOR HELP if you do not understand this hint.
    # ------------------------------------------------------------------


def test_problem0b():
    """ Tests the   problem0b   function. """
    print()
    print('--------------------------------------------------')
    print('Testing the   problem0b   function:')
    print('--------------------------------------------------')

    # Test 1:
    expected = 6
    answer = problem0b(13)
    print()
    print('Test 1 expected:', expected)
    print('       actual:  ', answer)

    # Test 2:
    expected = 1
    answer = problem0b(2)
    print()
    print('Test 2 expected:', expected)
    print('       actual:  ', answer)

    # Test 3:
    expected = 46
    answer = problem0b(200)
    print()
    print('Test 3 expected:', expected)
    print('       actual:  ', answer)

    # Test 4:
    expected = 168
    answer = problem0b(997)
    print()
    print('Test 4 expected:', expected)
    print('       actual:  ', answer)


def problem0b(n):
    """
    What comes in:  An integer n >= 2.
    What goes out:
      -- Returns the number of integers from 2 to n, inclusive,
         that are prime.
    Side effects:   None.
    Examples:
      -- If n is 13, this function returns 6,
           since there are 6 primes -- namely, 2, 3, 5, 7, 11, and 13 --
           between 2 and 13.
      -- If n is 2, this function returns 1,
           since there is one prime (namely, 2) between 2 and 2.
      -- If n is 200, the correct answer is 46,
           since there are 46 primes between 2 and 200.
     """
    # ------------------------------------------------------------------
    # TODO: 3. Implement and test this function.
    #          Tests have been written for you (above).
    #
    ####################################################################
    # IMPORTANT:
    #    **  For full credit you must appropriately
    #    **  use (call) the   is_prime   function that is DEFINED ABOVE.
    ####################################################################
    # ------------------------------------------------------------------


def test_problem0c():
    """ Tests the   problem0c  function. """
    print()
    print('--------------------------------------------------')
    print('Testing the  problem0c  function:')
    print('  See the graphics windows that pop up.')
    print('--------------------------------------------------')

    # TWO tests on ONE window.
    title = 'Tests 1 & 2 of problem0c: blue circle + 6 circles;'
    title += ' then green circle + 3 circles'
    window1 = rg.RoseWindow(650, 300, title)

    circle1 = rg.Circle(rg.Point(100, 50), 30)
    circle1.fill_color = 'blue'
    problem0c(circle1, 6, window1)
    window1.continue_on_mouse_click()

    circle2 = rg.Circle(rg.Point(75, 200), 75)
    circle2.fill_color = 'green'
    problem0c(circle2, 3, window1)
    window1.close_on_mouse_click()

    # A third test on ANOTHER window.
    title = 'Test 3 of problem0c:  red circle + 10 circles'
    window2 = rg.RoseWindow(600, 200, title)

    circle3 = rg.Circle(rg.Point(50, 50), 20)
    circle3.fill_color = 'red'
    problem0c(circle3, 10, window2)
    window2.close_on_mouse_click()


def problem0c(circle, n, window):
    """
    See   problem0c_picture.pdf   in this project for pictures
    that may help you better understand the following specification:
    
    What comes in:
      -- An rg.Circle.
      -- A positive integer n.
      -- An rg.RoseWindow.
    What goes out:  Nothing (i.e., None).
    Side effects:
      Draws the given rg.Circle and n additional rg.Circles
      on the given rg.RoseWindow such that:
        -- The circles form a row of touching rg.Circles with the
             leftmost circle being the given rg.Circle.
        -- There is a 0.5 second pause after each rg.Circle is drawn.
      Must  ** NOT close **   the window.

    Type hints:
      :type circle: rg.Circle
      :type n: int
      :type window: rg.RoseWindow
    """
    # ------------------------------------------------------------------
    # TODO: 4. Implement and test this function.
    #          Tests have been written for you (above).
    #
    ####################################################################
    # HINT:   render(0.5)
    #   renders with a half-second pause after rendering.
    ####################################################################
    # ------------------------------------------------------------------


# ----------------------------------------------------------------------
# Calls  main  to start the ball rolling.
# ----------------------------------------------------------------------
main()
