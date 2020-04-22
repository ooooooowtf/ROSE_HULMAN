"""
<describe what this module has/does>

Created on May 19, 2017.
Written by: david.
"""

import simple_testing as st
from multiprocessing import Process


def main():
    """ Calls the   TEST   functions in this module. """
    test_practice_problem1()


def test_practice_problem1():
    """ Tests the    practice_problem1    function. """
    # ------------------------------------------------------------------
    # 4 tests.  They use the imported   simple_testing (st)   module.
    # Each test is a SimpleTestCase with 3 arguments:
    #   -- the function to test,
    #   -- a list containing the argument(s) to send to the function,
    #   -- the correct returned value.
    # For example, the first test below will call
    #   practice_problem3v((9, 33, 8, 8, 0, 4, 4, 8))
    # and compare the returned value against [2, 5] (the correct answer).
    # ------------------------------------------------------------------
    tests = [st.SimpleTestCase(practice_problem1,
                               [3],
                               [1, 2, 4, 8]),
             st.SimpleTestCase(practice_problem1,
                               [0],
                               [1]),
             st.SimpleTestCase(practice_problem1,
                               [-66],
                               []),
             st.SimpleTestCase(practice_problem1,
                               [-1],
                               []),
             ]

    # Run the 4 tests in the   tests   list constructed above:
    st.SimpleTestCase.run_tests('practice_problem1', tests)

    # Test whether the code is EFFICIENT:
    print()
    print('If you passed the above tests,')
    print('that suggests that your code is correct.')
    print()
    print('The following is a test to see if your code is EFFICIENT:')
    print()

    p = Process(target=practice_problem1, args=[10000])
    p.start()
    p.join(1)
    p.terminate()
    if p.exitcode is None:
        print('*** Your code FAILED the test for efficiency.')
        print('    Comment out your current solution')
        print('    and try to find a correct solution that runs faster.')
    else:
        print('*** Your code PASSED the test for efficiency.')


def practice_problem1(n):
    ####################################################################
    # IMPORTANT: You must NOT use the  **  operator or the math.pow
    #   function in this problem. Only MULTIPLICATION is allowed
    #   for computing the powers of 2.
    ####################################################################
    """
    What comes in: An integer n.
    What goes out: Returns a list of all the powers of two,
      up to (and including) the given n, starting at 2 to the 0th power.

       If the given n is less than zero, returns an empty list.
    Examples:
      practice_problema(3) returns [1, 2, 4, 8]
      practice_problema(0) returns [1]
      practice_problema(-66) returns []
    """
    ####################################################################
    # DONE: 1. Implement and test this function.
    #     The testing code is already written for you (above).
    #     Also, see the  IMPORTANT restriction just below the DEF line.
    ####################################################################
    list1 = []

    if n < 0:
        return list1
    else:
        org = 1
        for _ in range(n + 1):
            list1 = list1 + [org]
            org = org * 2
        return list1

main()
