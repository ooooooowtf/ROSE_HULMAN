"""
This module demonstrates and practices:
  -- using ARGUMENTs in function CALLs,
  -- having PARAMETERs in function DEFINITIONs, and
  -- RETURNING a value from a function,
        possibly CAPTURING the RETURNED VALUE in a VARIABLE.
  -- UNIT TESTING.

Authors: David Mutchler, Valerie Galluzzi, Mark Hays, Amanda Stouder,
         their colleagues and Qishun Yu.  December 2015.
"""
# DONE: 1. PUT YOUR NAME IN THE ABOVE LINE.


def main():
    """ Calls the   TEST   functions in this module. """
    test_sum_of_digits()
    test_digits_in_cube()
    test_digits_in_power()
    test_fancy_sums_of_digits()

    # ------------------------------------------------------------------
    # DONE: 9. DO THIS LAST!
    #    -- Run file   m3t_tester.py   (do not make changes to it).
    #         It runs OUR tests on your code.
    #    -- Check to see whether all test cases indicate they
    #          "COMPLETED SUCCESSFULLY!"
    #    -- If your code fails any of OUR tests but passes YOUR tests,
    #         then you are likely not TESTING the methods correctly.
    #       ** Ask a TA or your professor for help in that case. **
    # ------------------------------------------------------------------


def test_sum_of_digits():
    """ Tests the  sum_of_digits   function. """
    # ------------------------------------------------------------------
    # DONE: 2. Implement this TEST function, as follows:
    #
    #  Step 1:  This TEST function tests the  sum_of_digits  function.
    #    So read the green doc-string of the  sum_of_digits  function
    #    defined below.  Be sure that you understand from the green
    #    doc-string what the  sum_of_digits  function SHOULD return.
    #
    #  Step 2:  Pick a test case:  a number that you could send as
    #    an actual argument to the  sum_of_digits  function.
    #      - For example, you could pick the test case  826.
    #
    #  Step 3: Figure out the CORRECT (EXPECTED) answer for your
    #    test case.  In the example of  826  the correct answer
    #    for the sum of its digits is  8 + 2 + 6, which is 16.
    #
    #  Step 4: Write code that prints both the EXPECTED answer
    #    and the ACTUAL answer returned when you call the function.
    #    See the example below.
    # ------------------------------------------------------------------
    print()
    print('--------------------------------------------------')
    print('Testing the   sum_of_digits   function:')
    print('--------------------------------------------------')

    # Test 1:
    expected = 16
    answer = sum_of_digits(826)
    print('Test 1 expected:', expected)
    print('       actual:  ', answer)

    # Test 2:
    expected = 3
    answer = sum_of_digits(111)
    print('Test 2 expected:', expected)
    print('       actual:  ', answer)

    # Test 3:
    expected = 16
    answer = sum_of_digits(30751)
    print('Test 3 expected:', expected)
    print('       actual:  ', answer)

    # Test 4:
    expected = 23
    answer = sum_of_digits(82607)
    print('Test 4 expected:', expected)
    print('       actual:  ', answer)

    # ------------------------------------------------------------------
    # DONE: 2 (continued).
    # Below this comment, add 3 more test cases of your own choosing.
    # ------------------------------------------------------------------


def sum_of_digits(number):
    """
    What comes in:  An integer.
    What goes out:  The sum of the digits in the given integer.
    Side effects:   None.
    Example:
      If the integer is 83135,
      this function returns (8 + 3 + 1 + 3 + 5), which is 20.
    """
    # ------------------------------------------------------------------
    # Students:
    #   Do NOT touch this function - it has no TODO in it.
    #   Do NOT copy code from this function.
    #
    # Instead, ** CALL ** this function as needed in the other problems.
    #
    # Ask for help if you are unsure what it means to CALL a function.
    # The ONLY part of this function that you need to understand is
    # the green doc-string above.  Treat this function as a black box.
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


def test_digits_in_cube():
    """ Tests the   digits_in_cube   function. """
    # ------------------------------------------------------------------
    # DONE: 3. Implement this function.
    #   It TESTS the  digits_in_cube  function defined below.
    #   Include at least **   3   ** tests.
    #
    # To implement this TEST function, use the same 4 steps as above:
    #
    #   Step 1: Read the green doc-string of  digits_in_cube  below.
    #     Understand what that function SHOULD return.
    #
    #   Step 2:  Pick a test case:  a number(s) that you could send as
    #     actual argument(s) to the  digits_in_cube  function.
    #
    #  Step 3: Figure out the CORRECT (EXPECTED) answer for your
    #    test case.
    #
    #  Step 4: Write code that prints both the EXPECTED answer
    #    and the ACTUAL answer returned when you call the function.
    #    Follow the same form as in previous examples.
    # ------------------------------------------------------------------
    print()
    print('-----------------------------------------------------')
    print('Testing the   digits_in_cube   function:')
    print('-----------------------------------------------------')
    # Test 1:
    expected = 10
    answer = digits_in_cube(7)
    print('Test 1 expected:', expected)
    print('       actual:  ', answer)

    # Test 2:
    expected = 8
    answer = digits_in_cube(2)
    print('Test 2 expected:', expected)
    print('       actual:  ', answer)

    # Test 3:
    expected = 8
    answer = digits_in_cube(8)
    print('Test 3 expected:', expected)
    print('       actual:  ', answer)


def digits_in_cube(n):
    """
    What comes in:  A positive integer.
    What goes out:  The sum of the digits in the CUBE of the integer.
    Side effects:   None.
    Example:
      If the integer (n) is 5    (so n cubed is 125),
      this function returns (1 + 2 + 5), which is 8.
    """
    # ------------------------------------------------------------------
    # DONE: 4. Implement and test this function.
    #   Note that you should write its TEST function first (above).
    #   That is called TEST-DRIVEN DEVELOPMENT (TDD).
    #
    ####################################################################
    # IMPORTANT: CALL, as many times as needed,
    #    the    sum_of_digits    function that is DEFINED ABOVE.
    ####################################################################
    # ------------------------------------------------------------------
    if n < 0:
        n = -n

    digit_sum = 0
    n = n ** 3
    while True:
        if n == 0:
            break
        digit_sum = digit_sum + (n % 10)
        n = n // 10
    return digit_sum


def test_digits_in_power():
    """ Tests the   digits_in_power   function. """
    # ------------------------------------------------------------------
    # DONE: 5. Implement this function.
    #   It TESTS the  digits_in_power  function defined below.
    #   Include at least **   3   ** tests.
    #
    # Use the same 4-step process as in implementing the previous
    # TEST functions.
    # ------------------------------------------------------------------
    print()
    print('--------------------------------------------------')
    print('Testing the   digits_in_power   function:')
    print('--------------------------------------------------')

    # Test 1:
    expected = 1
    answer = digits_in_power(1, 2)
    print('Test 1 expected:', expected)
    print('       actual:  ', answer)

    # Test 2:
    expected = 7
    answer = digits_in_power(2, 4)
    print('Test 2 expected:', expected)
    print('       actual:  ', answer)

    # Test 1:
    expected = 9
    answer = digits_in_power(3, 2)
    print('Test 1 expected:', expected)
    print('       actual:  ', answer)


def digits_in_power(n, k):
    """
    What comes in:  Two positive integers, n and k.
    What goes out:
      The sum of the digits in x, where x is n raised to the kth power.
    Side effects:   None.
    Example:
      If the arguments are 12 and 3, respectively,
      this function returns 18
      since 12 to the 3rd power is 1728 (whose digits sum to 18).
    """
    # ------------------------------------------------------------------
    # DINE: 6. Implement and test this function.
    #
    ####################################################################
    # IMPORTANT: CALL, as many times as needed,
    #    the    sum_of_digits    function that is DEFINED ABOVE.
    ####################################################################
    # ------------------------------------------------------------------

    if n < 0:
        n = -n
    if k < 0:
        k = -k

    digit_sum = 0
    n = n ** k
    while True:
        if n == 0:
            break
        digit_sum = digit_sum + (n % 10)
        n = n // 10
    return digit_sum


def test_fancy_sums_of_digits():
    """ Tests the   fancy_sums_of_digits   function. """
    # ------------------------------------------------------------------
    # DONE: 7. Implement this function.
    #   It TESTS the  fancy_sums_of_digits  function defined below.
    #   Include at least **   3   ** tests.
    #
    # Use the same 4-step process as in implementing the previous
    # TEST functions.
    # ------------------------------------------------------------------
    print()
    print('--------------------------------------------------')
    print('Testing the   fancy_sums_of_digits   function:')
    print('--------------------------------------------------')

    # Test 1:
    expected = 1
    answer = fancy_sums_of_digits(10)
    print('Test 1 expected:', expected)
    print('       actual:  ', answer)

    # Test 2:
    expected = 19084
    answer = fancy_sums_of_digits(2)
    print('Test 2 expected:', expected)
    print('       actual:  ', answer)

    # Test 3:
    expected = 124309
    answer = fancy_sums_of_digits(35)
    print('Test 3 expected:', expected)
    print('       actual:  ', answer)
    # ------------------------------------------------------------------
    # HINT:  For your 1st test, consider  n=10.  Figure out BY HAND
    # the correct (expected) answer for that test case.  (It's easy.)
    # The green doc-string below gives test cases you can use for
    # your 2nd and 3rd tests but READ THOSE TEST CASES CAREFULLY
    # in the doc-string to be sure that you understand the specification.
    # ------------------------------------------------------------------


def fancy_sums_of_digits(n):
    """
    What comes in:  A positive integer n.
    What goes out:
      -- Let X denote the sum of the digits in (n ** 1000).
      -- Let Y denote the sum of the digits in (n ** 999).
      This function RETURNs the sum of the digits in (X ** Y).
    Side effects:   None.
    Examples:
      -- If n is 2, then:
            -- the sum of the digits in n ** 1000 is 1366 (trust me!).
            -- the sum of the digits in n ** 999 is 1367 (trust me!).
            -- so X ** Y is VERY LARGE in this case
                     (don't try to print it!)
            -- the sum of the digits in (X ** Y) is 19084 (trust me!)
            -- so this function returns 19084.
      -- If n is 35, then:
            -- the sum of the digits in n ** 1000 is 7021 (trust me!).
            -- the sum of the digits in n ** 999 is 7145 (trust me!).
            -- so X ** Y is VERY LARGE in this case
                     (don't try to print it!)
            -- the sum of the digits in (X ** Y) is 124309 (trust me!)
            -- so this function returns 124309.
    """
    # ------------------------------------------------------------------
    # DONE: 8. Implement and test this function.
    #
    ####################################################################
    # IMPORTANT: CALL, as many times as needed,
    #    the    sum_of_digits    function that is DEFINED ABOVE.
    ####################################################################
    # ------------------------------------------------------------------

    X = 0
    Y = 0
    digit_sum = 0
    n1 = n ** 1000
    n2 = n ** 999

    while True:
        if n1 == 0:
            break
        X = X + (n1 % 10)
        n1 = n1 // 10

    while True:
        if n2 == 0:
            break
        Y = Y + (n2 % 10)
        n2 = n2 // 10

    Z = X ** Y

    while True:
        if Z == 0:
            break
        digit_sum = digit_sum + (Z % 10)
        Z = Z // 10

    return digit_sum
# ----------------------------------------------------------------------
# Calls  main  to start the ball rolling.
# This unusual form is necessary for the special testing we provided.
# ----------------------------------------------------------------------
if __name__ == '__main__':
    main()
