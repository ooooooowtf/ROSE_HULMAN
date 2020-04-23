"""
Final exam, problem 4.

Authors: David Mutchler, his colleagues,
         and Qishun Yu.  May 2017.
"""  # DONE: 1. PUT YOUR NAME IN THE ABOVE LINE.


def main():
    """ Calls the   TEST   functions in this module. """
    test_shape()


def test_shape():
    """ Tests the    shape    function. """
    print()
    print('--------------------------------------------------')
    print('Testing the   SHAPE   function:')
    print('--------------------------------------------------')

    print()
    print('Test 1 of shape: r=7')
    shape(7)

    print()
    print('Test 2 of shape: r=4')
    shape(4)

    print()
    print('Test 3 of shape: r=2')
    shape(2)


def shape(r):
    ####################################################################
    # IMPORTANT: In solving this problem,
    #   You must NOT use string multiplication.
    ####################################################################
    """
    Prints a slanted shape with r rows
    that looks like this example where r=7:
    1234567
           76
            765
             7654
              76543
               765432
                7654321

    Another example, where r=4:
    1234
        43
         432
          4321

    One more example, where r=2:
    12
      21

    Preconditions:  r is an integer that is at least 2.
    For purposes of "lining up", assume r is a single digit.
    """
    # ------------------------------------------------------------------
    # DONE: Implement and test this function.
    #          Some tests are already written for you (above).
    # IMPORTANT:  See the RESTRICTION just below the DEF line.
    #
    # HINT:
    #   If you're having trouble with the spacing, print Xs for
    #    the spaces until you figure out where the problem is
    #    (and then change the Xs back to spaces).
    # ------------------------------------------------------------------
    for k in range(r):
        print(k + 1, end='')
    print()

    for k in range(r - 1):
        for _ in range(r + k):
            print(' ', end='')
        for l in range(r, r - k - 2, -1):
            print(l, end='')
        print()


# ----------------------------------------------------------------------
# Calls  main  to start the ball rolling.
# ----------------------------------------------------------------------
main()