"""
This module lets you practice the ACCUMULATOR pattern
in several classic forms:
   SUMMING:    total = total + number
   COUNTING:   count = count + 1
   AVERAGING:  summing and counting combined
and
   FACTORIAL:  x = x * k

Subsequent modules let you practice the ACCUMULATOR pattern
in its "in graphics" form:
   IN GRAPHICS:   x = x + pixels

Authors: David Mutchler, Dave Fisher, Valerie Galluzzi, Amanda Stouder,
         their colleagues and PUT_YOUR_NAME_HERE.  March 2016.
"""  # TODO: 1. PUT YOUR NAME IN THE ABOVE LINE.

import math
import builtins  # Never necessary, but here for pedagogical reasons


# ----------------------------------------------------------------------
# Students: As you work each of these problems, ask yourself:
#   1. Do I need a loop?
#      If so, HOW MANY LOOPS?
#
#   2. Where I need a loop, what needs to happen:
#        -- BEFORE the loop?
#        -- IN the loop?
#        -- AFTER the loop?
# ----------------------------------------------------------------------
def main():
    """ Calls the   TEST   functions in this module. """
    test_sum_from()
    test_factorial()
    test_count_cosines_from()
    test_sum_unit_fractions_from()


# ----------------------------------------------------------------------
# Students: READ the  test_sum_from  function that follows this comment.
# ----------------------------------------------------------------------
def test_sum_from():
    """ Tests the   sum_from   function. """
    print()
    print('--------------------------------------------------')
    print('Testing the   sum_from   function:')
    print('--------------------------------------------------')

    # ------------------------------------------------------------------
    # These first two tests use an ORACLE for testing,
    # that is, a way to get the answer by using some other approach
    # that is known to work correctly.
    #   The oracle here is the   builtins.sum    function.
    # ------------------------------------------------------------------

    # Test 1:
    answer_from_oracle = builtins.sum(range(6, 10))
    answer_from_my_code = sum_from(6, 9)
    print('Test 1 expected (from oracle):', answer_from_oracle)
    print('       actual (from my code): ', answer_from_my_code)

    # Test 2:
    answer_from_oracle = builtins.sum(range(100, 10001))
    answer_from_my_code = sum_from(100, 10000)
    print('Test 2 expected (from oracle):', answer_from_oracle)
    print('       actual (from my code): ', answer_from_my_code)

    # ------------------------------------------------------------------
    # The next test uses a KNOWN answer (usually computed by hand).
    #   (Everyone "knows" that the sum from 0 to 3 is 0+1+2+3, i.e. 6.)
    # ------------------------------------------------------------------

    # Test 3:
    answer_from_by_hand = 6
    answer_from_my_code = sum_from(0, 3)
    print('Test 3 expected (from by-hand):', answer_from_by_hand)
    print('       actual (from my code):  ', answer_from_my_code)

    # ------------------------------------------------------------------
    # The next test uses a FORMULA answer (which is one kind of ORACLE answer)
    # that uses the formula:
    #     m + (m+1) + (m+2) +  ...  + n  =  (m + n) * (n - m + 1) / 2
    # ------------------------------------------------------------------

    # Test 4:
    answer_from_formula = (53 + 4999) * (4999 - 53 + 1) // 2
    answer_from_my_code = sum_from(53, 4999)
    print('Test 4 expected (from formula):', answer_from_formula)
    print('       actual (from my code):  ', answer_from_my_code)

# ----------------------------------------------------------------------
# TODO: 2.
#   When you have READ the above  test_sum_from  function,
#   asking questions as needed, and you feel that you (mostly, at least)
#   understand it, and you feel that you understand from the example:
#     -- what an ORACLE answer is
#     -- what a KNOWN (typically, BY-HAND) answer is
#     -- what a FORMULA answer is
#     -- how the above are used in testing
#   THEN:
# CHANGE THE TODO at the beginning of this comment to DONE.
# There is no code to be written for this TODO (just reading).
# ----------------------------------------------------------------------


def sum_from(m, n):
    """
    What comes in:  The arguments are two integers m and n, with m <= n.
    What goes out:  Returns the sum of the integers from m to n,
      inclusive.
    Side effects:   None.
    Example:
        sum_from(6, 9) returns 6 + 7 + 8 + 9, that is, 30.
    """
    # ------------------------------------------------------------------
    # TODO: 3. Implement and test this function.
    #          Tests have been written for you (above).
    #
    # IMPORTANT:  Your solution MUST
    #   use an explicit    for ... in range(...):     statement
    #
    # IMPORTANT: As in previous problems in this session,
    #   you must NOT use the 2 or 3-parameter versions
    #   of the RANGE expression, if you happen to know them.
    # ------------------------------------------------------------------


def test_factorial():
    """ Tests the   factorial   function. """
    # ------------------------------------------------------------------
    # TODO: 4. Implement this TEST function.
    #   It TESTS the  factorial  function defined below.
    #   Include at least **   5   ** tests (we wrote two for you).
    #
    ####################################################################
    # IMPORTANT: At least 2 of your tests MUST use the
    #    math.factorial
    # function as an ORACLE for testing.  See examples above.
    ####################################################################
    # ------------------------------------------------------------------
    print()
    print('--------------------------------------------------')
    print('Testing the   factorial   function:')
    print('--------------------------------------------------')

    # Test 1:
    answer_from_oracle = math.factorial(0)
    answer_from_my_code = factorial(0)
    print('Test 1 expected (from oracle):', answer_from_oracle)
    print('       actual (from my code): ', answer_from_my_code)

    # Test 2:
    answer_from_oracle = math.factorial(21)
    answer_from_my_code = factorial(21)
    print('Test 2 expected (from oracle):', answer_from_oracle)
    print('       actual (from my code): ', answer_from_my_code)

    # ------------------------------------------------------------------
    # TODO: 4 (continued).
    # Below this comment, add 3 more test cases, at least two of which
    #   ** uses  math.factorial  as an ORACLE for testing. **
    # ------------------------------------------------------------------


def factorial(n):
    """
    What comes in:  The sole argument is a non-negative integer n.
    What goes out:  Returns n!, that is, n x (n-1) x (n-2) x ... x 1.
    Side effects:   None.
    Examples:
        factorial(5) returns 5 x 4 x 3 x 2 x 1, that is, 120.
        factorial(0) returns 1 (by definition).
    """
    # ------------------------------------------------------------------
    # TODO: 5. Implement and test this function.
    #   Note that you should write its TEST function first (above).
    #
    # IMPORTANT:  Your solution MUST
    #   use an explicit    for ... in range(...):     statement.
    # ------------------------------------------------------------------


def test_count_cosines_from():
    """ Tests the   count_cosines_from   function. """
    # ------------------------------------------------------------------
    # TODO: 6. Implement this TEST function.
    #   It TESTS the  count_cosines_from  function defined below.
    #   Include at least **   6   ** tests (we wrote one for you).
    #              ** Yes, 6 (six) tests. **
    #     ** Counting problems are harder to test than summing. **
    #
    # To implement this TEST function, use the same 4 steps as before:
    #
    #   Step 1: Read the green doc-string of  count_cosines_from  below.
    #     Understand what that function SHOULD return.
    #
    #   Step 2:  Pick a test case:  numbers that you could send as
    #     actual arguments to the  count_cosines_from  function.
    #
    #   Step 3: Figure out (by hand, or by using an oracle: a test case
    #     that your instructor provided in the green doc-string, or a
    #     known formula or an alternative implementation that you trust)
    #     the CORRECT (EXPECTED) answer for your test case.
    #
    #   Step 4: Write code that prints both the EXPECTED answer
    #     and the ACTUAL answer returned when you call the function.
    #     Follow the same form as in the test case we provided below.
    # ------------------------------------------------------------------
    print()
    print('--------------------------------------------------')
    print('Testing the   count_cosines_from   function:')
    print('--------------------------------------------------')

    # Test 1:
    expected = 2
    answer = count_cosines_from(3, 9, 0.29)
    print('Test 1 expected:', expected)
    print('       actual:  ', answer)

    # ------------------------------------------------------------------
    # TODO: 6 (continued).
    # Below this comment, add 5 more test cases of your own choosing.
    # ------------------------------------------------------------------


def count_cosines_from(m, n, x):
    """
    What comes in:  The three arguments are non-negative integers
      m and n, with m <= n, and a number x.
    What goes out:  Returns the number of integers from m to n,
      inclusive, whose cosine is greater than x.
    Side effects:   None.
    Examples:
    Since:  cosine(3) is about -0.99
            cosine(4) is about -0.65
            cosine(5) is about 0.28
            cosine(6) is about 0.96
            cosine(7) is about 0.75
            cosine(8) is about -0.15
            cosine(9) is about -0.91
      -- count_cosines_from(3, 9, 0.29)  returns  2
      -- count_cosines_from(3, 9, 0.27)  returns  3
      -- count_cosines_from(4, 8, -0.5)  returns  4
    """
    # ------------------------------------------------------------------
    # TODO: 7. Implement and test this function.
    #   Note that you should write its TEST function first (above).
    #
    # IMPORTANT: As in previous problems in this session,
    #   you must NOT use the 2 or 3-parameter versions
    #   of the RANGE expression, if you happen to know them.
    # ------------------------------------------------------------------


def test_sum_unit_fractions_from():
    """ Tests the   sum_unit_fractions_from   function. """
    # ------------------------------------------------------------------
    # TODO: 8. Implement this TEST function.
    #   It TESTS the  sum_unit_fractions_from  function defined below.
    #   Include at least **   3   ** tests (we wrote one for you).
    # Use the same 4-step process as for previous TEST functions.
    # ------------------------------------------------------------------
    print()
    print('--------------------------------------------------')
    print('Testing the   sum_unit_fractions_from   function:')
    print('--------------------------------------------------')

    # Test 1:
    expected = 0.545635  # This is APPROXIMATELY the correct answer.
    answer = sum_unit_fractions_from(6, 9)
    print('Test 1 expected:', expected, '(approximately)')
    print('       actual:  ', answer)

    # ------------------------------------------------------------------
    # TODO: 8 (continued).
    # Below this comment, add 2 more test cases of your own choosing.
    # ------------------------------------------------------------------


def sum_unit_fractions_from(m, n):
    """
    What comes in:  Two positive integers m and n with m <= n.
    What goes out:  Returns the sum:
      1/m + 1/(m+1) + 1/(m+2) + ... + 1/n.
    Side effects:   None.
    Examples:
      -- sum_unit_fractions_from(6, 9) returns
            1/6 + 1/7 + 1/8 + 1/9
         which is about 0.545635
      -- sum_unit_fractions_from(10, 9000)  returns about  6.853
    """
    # ------------------------------------------------------------------
    # TODO: 9. Implement and test this function.
    #   Note that you should write its TEST function first (above).
    #
    # IMPORTANT: As in previous problems in this session,
    #   you must NOT use the 2 or 3-parameter versions
    #   of the RANGE expression, if you happen to know them.
    # ------------------------------------------------------------------


# ----------------------------------------------------------------------
# Calls  main  to start the ball rolling.
# ----------------------------------------------------------------------
main()
