"""
Final exam, problem 2.

Authors: David Mutchler, his colleagues,
         and Qishun Yu.  May 2017.
"""  # DONE: 1. PUT YOUR NAME IN THE ABOVE LINE.

import simple_testing as st
import rosegraphics as rg

#-----------------------------------------------------------------------
# These problems use the  SIMPLE_TESTING  module for expressing and
# executing tests.  Here is an example:
#
#-----------------------------------------------------------------------


def main():
    """ Calls the   TEST   functions in this module. """
    test_problem2a()
    test_problem2b()
    test_problem2c()


def test_problem2a():
    """ Tests the    problem2a    function. """
    tests = [st.SimpleTestCase(problem2a,
                               [[rg.Point(100, 40),
                                 rg.Point(50, 10),
                                 rg.Point(200, 50),
                                 rg.Point(120, 30),
                                 rg.Point(40, 88),
                                 rg.Point(90, 60)]],
                               88),
             st.SimpleTestCase(problem2a,
                               [[rg.Point(10, 40),
                                 rg.Point(50, 10),
                                 rg.Point(200, 50),
                                 rg.Point(120, 30),
                                 rg.Point(40, 88),
                                 rg.Point(90, 60)]],
                               40),
             st.SimpleTestCase(problem2a,
                               [[rg.Point(100, 40),
                                 rg.Point(13, 10),
                                 rg.Point(200, 50),
                                 rg.Point(120, 30),
                                 rg.Point(40, 88),
                                 rg.Point(90, 60)]],
                               10),
             st.SimpleTestCase(problem2a,
                               [[rg.Point(100, 40),
                                 rg.Point(50, 10),
                                 rg.Point(20, 50),
                                 rg.Point(120, 30),
                                 rg.Point(40, 88),
                                 rg.Point(90, 60)]],
                               50),
             st.SimpleTestCase(problem2a,
                               [[rg.Point(100, 40),
                                 rg.Point(50, 10),
                                 rg.Point(200, 50),
                                 rg.Point(12, 30),
                                 rg.Point(40, 88),
                                 rg.Point(90, 60)]],
                               30),
             st.SimpleTestCase(problem2a,
                               [[rg.Point(100, 40),
                                 rg.Point(50, 10),
                                 rg.Point(200, 50),
                                 rg.Point(120, 30),
                                 rg.Point(40, 88),
                                 rg.Point(20, 60)]],
                               60),
             st.SimpleTestCase(problem2a,
                               [[rg.Point(1, 40),
                                 rg.Point(2, 10),
                                 rg.Point(3, 50),
                                 rg.Point(4, 30),
                                 rg.Point(5, 88),
                                 rg.Point(6, 66),
                                 rg.Point(7, 55),
                                 rg.Point(8, 44),
                                 rg.Point(9, 99),
                                 rg.Point(10, 6)]],
                               40),
             st.SimpleTestCase(problem2a,
                               [[rg.Point(10, 40),
                                 rg.Point(9, 10),
                                 rg.Point(8, 50),
                                 rg.Point(7, 30),
                                 rg.Point(6, 88),
                                 rg.Point(5, 66),
                                 rg.Point(4, 55),
                                 rg.Point(3, 44),
                                 rg.Point(2, 99),
                                 rg.Point(1, 6)]],
                               6),
             ]

    st.SimpleTestCase.run_tests('problem2a', tests)


def problem2a(points):
    """
    What comes in:
      -- A non-empty list of rg.Point objects.
    What goes out:
      -- Returns the y-coordinate of the rg.Point in the list
           whose x-coordinate is smallest.
           Assume that the x-coordinates are all different
           (so that you can break ties however you wish).
    Side effects: None.
    Example:
      problem2a(rg.Point(100, 40),
                rg.Point(50,  10),
                rg.Point(200, 50),
                rg.Point(120, 30),
                rg.Point(40,  88),
                rg.Point(90,  60))     returns 88
    """
    # ------------------------------------------------------------------
    # DONE: 2. Implement and test this function.
    #          Tests have been written for you (above).
    # ------------------------------------------------------------------

    indexsmall = 0

    for k in range(1, len(points)):
        if points[indexsmall].x > points[k].x:
            indexsmall = k

    return points[indexsmall].y


def test_problem2b():
    """ Tests the    problem2b    function. """
    # ------------------------------------------------------------------
    # DONE: 3. Implement at least ONE test here.
    #
    # ** Do NOT use the   simpleTestCase  form in this problem. **
    #
    # Instead, use any form you like that demonstrates whether or not
    # the test passed or failed.
    # ------------------------------------------------------------------
    print()
    print('--------------------------------------------------')
    print('Testing the   problem2b   function:')
    print('--------------------------------------------------')
    # Test 1:
    expected = [-2, -3, -4, -5, -6, -7]
    actual = problem2b([2, 3, 4, 5, 6, 7])
    print()
    print('Test 1 expected:', expected)
    print('       actual:  ', actual)

    # Test 2:
    expected = [-3, -55, 2, -30, 5, -4, -4, 20]
    actual = problem2b([3, 55, -2, 30, -5, 4, 4, -20])
    print()
    print('Test 2 expected:', expected)
    print('       actual:  ', actual)


def problem2b(integers):
    """
    What comes in:
      -- A list of integers.
    What goes out:
      -- Nothing, i.e. None.
    Side effects:
      -- MUTATES the given list of integers so that each item in the
           list has its sign reversed.
    Example:
         integers = [ 3,  55, -2,  30, -5,  4,  4, -20]
         problem2a(integers)
         print(integers)
      should print  [-3, -55,  2, -30,  5, -4, -4,  20]
    """
    # ------------------------------------------------------------------
    # DONE: 4. Implement and test this function.
    #          Tests have been written for you (above).
    # IMPORTANT: See the  RESTRICTION  just below the DEF line.
    # ------------------------------------------------------------------

    for k in range(len(integers)):
        integers[k] = -integers[k]

    return integers


def test_problem2c():
    """ Tests the    problem2c    function. """
    tests = [st.SimpleTestCase(problem2c,
                               [1, 1],
                               [1]),
             st.SimpleTestCase(problem2c,
                               [3, 1],
                               [1, 9, 11]),
             st.SimpleTestCase(problem2c,
                               [2, 4],
                               [2, 8]),
             st.SimpleTestCase(problem2c,
                               [8, 0],
                               [10, 20, 30, 40, 50, 60, 70, 80]),
             st.SimpleTestCase(problem2c,
                               [3, 5],
                               [5, 15, 25]),
             st.SimpleTestCase(problem2c,
                               [12, 6],
                               [4, 6, 14, 16, 24, 26, 34, 36, 44, 46, 54, 56]),
             st.SimpleTestCase(problem2c,
                               [13, 6],
                               [4, 6, 14, 16, 24, 26, 34, 36, 44, 46, 54, 56, 64]),
             ]

    st.SimpleTestCase.run_tests('problem2c', tests)


def problem2c(n, m):
    # ------------------------------------------------------------------
    # NOTE: Do NOT try to solve this problem by trying to find
    # a "pattern".  Instead, just check whether 1 meets the condition,
    # and then whether 2 meets the condition, then 3, then 4, ...
    # ------------------------------------------------------------------
    """
    What comes in:
      -- A positive integer n and a digit m.
    What goes out:
      -- Returns the first n positive integers such that
           their squares end in m.
    Side effects: None.
    Example:
      problem2c(1, 1) = [1]
         since 1**2 is 1 (which ends in 1)
         and 1 is the smallest integer whose square ends in 1.

      problem2c(3, 1) = [1, 9, 11]
         since  1**2  is  1    and   9**2  is  81   and   11*2  is 121
         (all of which end in 1)
         and these are the 3 smallest integers whose squares end in 1.

      problem2c(2, 4) = [2, 8]
         since  2**2  is  4    and   8**2  is  64
         and these are the 2 smallest integers whose squares end in 4.

      problem2c(8, 0) = [10, 20, 30, 40, 50, 60, 70, 80]
         since  10**2  is  100    and   20**2  is  400  and ...
         and these are the 8 smallest integers whose squares end in 0.
    """
    # ------------------------------------------------------------------
    # DONE: 5. Implement and test this function.
    #          Tests have been written for you (above).
    # IMPORTANT: See the NOTE just under the DEF line.
    # ------------------------------------------------------------------
    count = 0
    num = 1
    numlist = []

    while True:
        numsquare = num ** 2
        if numsquare % 10 == m:
            numlist = numlist + [num]
            count = count + 1
        if count == n:
            break
        num = num + 1

    return numlist


# ----------------------------------------------------------------------
# Calls  main  to start the ball rolling.
# ----------------------------------------------------------------------
main()
