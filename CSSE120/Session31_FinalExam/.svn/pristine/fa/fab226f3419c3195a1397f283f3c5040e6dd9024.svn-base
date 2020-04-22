"""
Final exam, problem 5.

Authors: David Mutchler, his colleagues,
         and Qishun Yu.  May 2017.
"""  # DONE: 1. PUT YOUR NAME IN THE ABOVE LINE.

import simple_testing as st

#-----------------------------------------------------------------------
# These problems use the  SIMPLE_TESTING  module for expressing and
# executing tests.  Here is an example:
#
#-----------------------------------------------------------------------


def main():
    """ Calls the   TEST   functions in this module. """
    test_problem5a()


def test_problem5a():
    """ Tests the    problem3a    function. """
    tests = [st.SimpleTestCase(problem5a,
                               [5],
                               False),
             st.SimpleTestCase(problem5a,
                               [52],
                               True),
             st.SimpleTestCase(problem5a,
                               [151],
                               True),
             st.SimpleTestCase(problem5a,
                               [30050],
                               True),
             st.SimpleTestCase(problem5a,
                               [5000],
                               False),
             st.SimpleTestCase(problem5a,
                               [50],
                               True),
             st.SimpleTestCase(problem5a,
                               [55],
                               True),
             st.SimpleTestCase(problem5a,
                               [450],
                               True),
             st.SimpleTestCase(problem5a,
                               [430],
                               False),
             st.SimpleTestCase(problem5a,
                               [11251],
                               True),
             st.SimpleTestCase(problem5a,
                               [555555],
                               True),
             st.SimpleTestCase(problem5a,
                               [555505],
                               False),
             st.SimpleTestCase(problem5a,
                               [555515],
                               False),
             st.SimpleTestCase(problem5a,
                               [555525],
                               False),
             st.SimpleTestCase(problem5a,
                               [555585],
                               False),
             ]

    st.SimpleTestCase.run_tests('problem5a', tests)


def problem5a(n):
    ####################################################################
    # IMPORTANT: You must NOT use the  str  function in solving this
    # problem.  Instead, use the   %   and   //   operators.
    #
    # Recall that for integers A and B:
    #     A // B   is the result of dividing B into A and rounding
    #                down to the nearest integer
    #     A % B    is the remainder when dividing B into A.
    # For example:
    #     17 // 4  evaluates to   4
    #     17 % 4   evaluates to   1
    ####################################################################
    """
    What comes in:
      -- A positive integer n.
    What goes out:
      -- Returns True if the given positive integer has a 5
           in its second-rightmost digit.
    Side effects: None.
    Examples:
      problem3a(5)     returns False
      problem3a(52)    returns True
      problem3a(151)   returns True
      problem3a(30050) returns True
      problem3a(5000)  returns False
    """
    # ------------------------------------------------------------------
    # DONE: 2. Implement and test this function.
    #          Tests have been written for you (above).
    # IMPORTANT: See the  RESTRICTION  just below the DEF line.
    # ------------------------------------------------------------------
    if n < 10:
        return False

    else:
        new = n % 100
        digitnum = new // 10
        if digitnum == 5:
            return True

        else:
            return False

# ----------------------------------------------------------------------
# Calls  main  to start the ball rolling.
# ----------------------------------------------------------------------
main()
