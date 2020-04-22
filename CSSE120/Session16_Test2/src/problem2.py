""""
Test 2, problem 2.

Authors: David Fisher, David Mutchler, and their
         colleagues and Qishun Yu.  April 2017.
"""  # DONE: 1. PUT YOUR NAME IN THE ABOVE LINE.

import time
import sys


def main():
    """ Calls the   TEST   functions in this module. """

    ####################################################################
    # STUDENTS:  UN-comment these tests as you work the problems.
    ####################################################################

    test_init()
    test_drink()
    test_many_drinks()
    test_get_drinks()
    test_refill()
    test_combine_with()


########################################################################
# The   SweetTea   class (and its methods) begins here.
########################################################################

class SweetTea(object):
    """
    A SweetTea has:
        -- glass_capacity, a non-negative number
             Number of ounces of liquid the glass can hold, this value will
             not change
        -- liquid_amount, a non-negative number
             Number of ounces of liquid that are in the SweetTea.
             This value can be 0 <= liquid_amount <= glass_capacity
        -- sugar_amount, a non-negative number
             Number of grams of sugar in the SweetTea.
        Note, sugar is always assumed to be evenly distributed in the
        liquid and there is no maximum amount of sugar that can be in
        an ounce of liquid.  For example, 1 ounce of liquid can have
        999+ grams of sugar (no limit).
    """

    def __init__(self, glass_capacity, liquid_amount, sugar_amount):
        """
        What comes in:
          -- glass_capacity, which is a non-negative number,
          -- liquid_amount, which is a non-negative number, and
          -- sugar_amount, which is a non-negative number.
        What goes out: Nothing (i.e., None).
        Side effects:
          -- Stores the SweetTeas's glass_capacity, liquid_amount,
             and sugar_amount in the instance variables:
                  self.glass_capacity
                  self.liquid_amount
                  self.sugar_amount
             If the liquid_amount is greater than the glass_capacity
             the extra liquid spills out and the liquid_amount is
             set to the glass_capacity (which is always the max
             that a SweetTea can hold).  Sugar is added after the
             liquid so no sugar is ever spilled.
          -- Also initializes other instance variables as needed
              by other methods.
        Examples:
          sweet_tea1 = SweetTea(12, 10, 3)
            #   sweet_tea1.glass_capacity   is now 12
            #   sweet_tea1.liquid_amount    is now 10
            #   sweet_tea1.sugar_amount     is now 3

          sweet_tea2 = SweetTea(32, 40, 3)
            #   sweet_tea2.glass_capacity   is now 32
            #   sweet_tea2.liquid_amount    is now 32 (NOT 40)
            #   sweet_tea2.sugar_amount     is now 3

        Type hints:
          :type glass_capacity: non-negative number
          :type liquid_amount:  non-negative number
          :type sugar_amount:  non-negative number
        """
        # --------------------------------------------------------------
        # DONE: 2. Implement and test this function.
        #     See the testing code (below) for more examples.
        # --------------------------------------------------------------
        self.orili = liquid_amount
        self.orisu = sugar_amount
        self.glass_capacity = glass_capacity
        self.sugar_amount = sugar_amount
        if liquid_amount > glass_capacity:
            self.liquid_amount = glass_capacity
        else:
            self.liquid_amount = liquid_amount

        self.count = 0

    def drink(self, drink_amount):
        """
        What comes in:
          -- self
          -- drink_amount, which is a non-negative number.
        What goes out:
          Returns the amount of sugar that was just consumed.

        Side effects:  Simulates "drinking" the given drink_amount
          from this SweetTea object, as follows:

          -- If this SweetTea's liquid_amount is zero,
                returns immediately returning a value of 0,
                since no liquid is available to drink in this case.

          Otherwise, this method:

          -- Reduces this SweetTea's liquid_amount by the given
               drink_amount, if the drink_amount was indeed less than
               or equal to this SweetTea's liquid_amount.  If the
               drink_amount is greater than this SweetTea's liquid_amount,
               then only the actual liquid_amount is consumed.  That is,
               you can only drink a max of what is present;
               there is no way to have a negative liquid_amount.

          -- Reduces this SweetTea's sugar_amount based on the amount of
               liquid that was consumed, under the assumption that
               sugar was evenly distributed in the liquid.
               (See the examples.)

        Examples:
          sweet_tea1 = SweetTea(12, 10, 3)
          sugar_consumed = sweet_tea1.drink(5)
            #   sweet_tea1.glass_capacity   is 12
            #   sweet_tea1.liquid_amount    is now 5
            #   sweet_tea1.sugar_amount     is now 1.5
            #   sugar_consumed             is 1.5
            Explain the sugar: Exactly half of the liquid was consumed
            and exactly half of the sugar was consumed with it.

          sweet_tea2 = SweetTea(40, 40, 8)
          sweet_tea2.drink(5)
            #   sweet_tea2.glass_capacity   is 40
            #   sweet_tea2.liquid_amount    is now 35
            #   sweet_tea2.sugar_amount     is now 7
            #   sugar_consumed             is 1
            Explain the sugar: There were 8 grams of sugar in 40 ounces of
            liquid before the drink, so that is a sugar concentration of
            8/40 = 0.2 grams / ounce. With 5 ounces consumed 5 * 0.2 = 1 gram.
            With 1 gram of sugar consumed, 7 grams remained in the SweetTea.

          sweet_tea3 = SweetTea(12, 7, 100)
          sweet_tea3.drink(5)
            #   sweet_tea3.glass_capacity   is 12
            #   sweet_tea3.liquid_amount    is now 2
            #   sweet_tea3.sugar_amount     is now 28.571428
            #   sugar_consumed             is 71.428571
            Explain the sugar: There were 100 grams in 7 ounces before the drink,
            so the concentration of sugar was 100/7 = 14.28571 grams / ounce.
            With 5 ounces consumed 5 * 14.28571 = 71.428571 grams consumed.
            That left 28.571428 grams of sugar remaining in the SweetTea.

          sweet_tea4 = SweetTea(12, 1, 2)
          sweet_tea4.drink(5)
            #   sweet_tea4.glass_capacity   is 12
            #   sweet_tea4.liquid_amount    is now 0
            #   sweet_tea4.sugar_amount     is now 0
            #   sugar_consumed             is 2
            Explanation: The attempt to drink 5 was instead limited by
            the actual amount of liquid remaining in the SweetTea.
        """
        # --------------------------------------------------------------
        # DONE: 3. Implement and test this function.
        #     See the testing code (below) for more examples.
        # --------------------------------------------------------------
        if self.liquid_amount == 0:
            return 0
        else:
            self.count = self.count + 1
            if drink_amount <= self.liquid_amount:
                oriliamo = self.liquid_amount
                orisuamo = self.sugar_amount
                self.liquid_amount = self.liquid_amount - drink_amount
                leftper = self.liquid_amount / oriliamo
                self.sugar_amount = self.sugar_amount * leftper
                cosume = orisuamo - self.sugar_amount

                return cosume
            else:
                ori = self.sugar_amount
                self.liquid_amount = 0
                self.sugar_amount = 0
                return ori

    def many_drinks(self, drink_amount, n):
        """
        What comes in:
          -- self
          -- drink_amount a non-negative number that represents the
              amount of liquid that is drunk with each drink.
          -- n a non-negative integer, number of drinks to take
        What goes out:
          -- Returns the total amount of sugar that was just consumed
              from all the drinks.
        Side effects:
          -- Simulates taking n drinks; that is,
               calls the  drink  method n times,
               each time drinking the given drink_amount.
        Examples:
          sweet_tea1 = SweetTea(12, 10, 3)
          sugar_consumed = sweet_tea1.many_drinks(2, 4)
            #   sweet_tea1.glass_capacity   is 12
            #   sweet_tea1.liquid_amount    is now 2
            #   sweet_tea1.sugar_amount     is now 0.6
            #   sugar_consumed              is 2.4

          sweet_tea2 = SweetTea(12, 10, 3)
          sugar_consumed = sweet_tea2.many_drinks(99, 99)
            #   sweet_tea1.glass_capacity   is 12
            #   sweet_tea1.liquid_amount    is now 0
            #   sweet_tea1.sugar_amount     is now 0
            #   sugar_consumed              is 3
            # A drink was only really taken the for the first drink calls
            # The remaining 98 did not have any effect.
        """
        # --------------------------------------------------------------
        # DONE: 4. Implement and test this function.
        #     See the testing code (below) for more examples.
        # --------------------------------------------------------------
        j = 0
        for _ in range(n):
            j = j + self.drink(drink_amount)

        return j

    def get_drinks(self):
        """
        What comes in:
          -- self
        What goes out:
          Returns the number of drinks that have been taken from this
          SweetTea object. Note that a drink is taken only when liquid
          leaves the glass!
        Side effects:
          -- None
        Examples:
          sweet_tea1 = SweetTea(12, 10, 3)
          sugar_consumed = sweet_tea1.drink(1)
          sugar_consumed = sweet_tea1.drink(1)
          sugar_consumed = sweet_tea1.drink(1)
          num_drinks = sweet_tea1.get_drinks()
            #   num_drinks             is 3

          sweet_tea1 = SweetTea(12, 10, 3)
          sugar_consumed = sweet_tea1.drink(5)
          sugar_consumed = sweet_tea1.drink(5)
          sugar_consumed = sweet_tea1.drink(5)
          sugar_consumed = sweet_tea1.drink(5)
          sugar_consumed = sweet_tea1.drink(5)
          sugar_consumed = sweet_tea1.drink(5)
          num_drinks = sweet_tea1.get_drinks()
            #   num_drinks             is 2
            # A drink was taken only the for the first two drink calls!
            # Future calls to the drink function did NOT cause any liquid
            # to leave the SweetTea object, therefore, they were not drinks.
        """
        # --------------------------------------------------------------
        # DONE: 5. Implement and test this function.
        #     See the testing code (below) for more examples.
        # --------------------------------------------------------------
        return self.count

    def refill(self):
        """
        What comes in:
          -- self
        What goes out: Nothing (i.e., None).
        Side effects:
          -- Resets this SweetTea's liquid_amount to the amount of
               liquid that this SweetTea object held when it was
               constructed.
          -- Resets this SweetTea's sugar_amount to the amount of
               sugar that this SweetTea object held when it was
               constructed.
        Examples:
          sweet_tea1 = SweetTea(12, 10, 3)
            #   sweet_tea1.glass_capacity   is 12
            #   sweet_tea1.liquid_amount    is 10
            #   sweet_tea1.sugar_amount     is 3

          sugar_consumed = sweet_tea1.drink(3)
          sugar_consumed = sweet_tea1.drink(2)
          sweet_tea1.refill()
            #   sweet_tea1.glass_capacity   is still 12
            #   sweet_tea1.liquid_amount    is again 10
            #   sweet_tea1.sugar_amount     is again 3

          sweet_tea1.liquid_amount = 5
          sweet_tea1.sugar_amount = 1.5
          sweet_tea1.refill()
            #   sweet_tea1.glass_capacity   is still 12
            #   sweet_tea1.liquid_amount    is again 10
            #   sweet_tea1.sugar_amount     is again 3

          another_tea = SweetTea(32, 40, 3)
            #   another_tea.glass_capacity   is 32
            #   another_tea.liquid_amount    is 32  (NOT 40)
            #   another_tea.sugar_amount     is 3

          sugar_consumed = another_tea.drink(1)
          another_tea.reset() 
            #   another_tea.glass_capacity   is still 32
            #   another_tea.liquid_amount    is again 32 (NOT 40)
            #   another_tea.sugar_amount     is again 3
        """
        # --------------------------------------------------------------
        # DONE: 6. Implement and test this function.
        #     See the testing code (below) for more examples.
        # --------------------------------------------------------------
        self.liquid_amount = self.orili
        self.sugar_amount = self.orisu

    def combine_with(self, other_sweet_tea):
        """
        What comes in:
          -- self
          -- other_sweet_tea which is another SweetTea.
        What goes out:
          Returns a new SweetTea whose:
              -- glass_capacity is the sum of the glass_capacity of the two SweetTea objects
                  (yes, this is a magical glass)
              -- liquid_amount is the sum of the liquid_amount of the two SweetTea objects
              -- sugar_amount is the sum of the sugar_amount of the two SweetTea objects
        Side effects:
          -- Reduces this SweetTea's liquid_amount and sugar_amount to zero.
          -- Reduces the given other_sweet_tea's liquid_amount and sugar_amount to zero.
        Examples:
            sweet_tea1 = SweetTea(12, 10, 3)
            sweet_tea2 = SweetTea(40, 40, 8)
            sweet_tea3 = sweet_tea1.combine_with(sweet_tea2)
            #   sweet_tea1.glass_capacity   is 12
            #   sweet_tea1.liquid_amount    is 0
            #   sweet_tea1.sugar_amount     is 0

            #   sweet_tea2.glass_capacity   is 40
            #   sweet_tea2.liquid_amount    is 0
            #   sweet_tea2.sugar_amount     is 0

            #   sweet_tea3.glass_capacity   is 52
            #   sweet_tea3.liquid_amount    is 50
            #   sweet_tea3.sugar_amount     is 11
        Type hints:
          :type other_sweet_tea: SweetTea
        """
        # --------------------------------------------------------------
        # DONE: 7. Implement and test this function.
        #     See the testing code (below) for more examples.
        # --------------------------------------------------------------
        newcap = self.glass_capacity + other_sweet_tea.glass_capacity
        newliq = self.liquid_amount + other_sweet_tea.liquid_amount
        newsug = self.sugar_amount + other_sweet_tea.sugar_amount
        newbottle = SweetTea(newcap, newliq, newsug)
        self.liquid_amount = 0
        self.sugar_amount = 0
        other_sweet_tea.liquid_amount = 0
        other_sweet_tea.sugar_amount = 0

        return newbottle

########################################################################
# The TEST functions for the  SweetTea  class begin here.
########################################################################

# ----------------------------------------------------------------------
# These first two methods are used in most of the tests:
# ----------------------------------------------------------------------


def test_instance_variables(sweet_tea, expected_glass_capacity,
                            expected_liquid_amount, expected_sugar_amount):
    """
    Tests whether the instance variables for the given sweet_tea
    are per the given expected values.
      type: sweet_tea:   SweetTea
    """
    print()
    format_string = '{:13}  {:13} {:11} {:12}'
    # print(format_string.format('', 'glass_capacity', 'liquid_amount', 'sugar_amount'))
    print('          glass_capacity liquid_amount sugar_amount')
    print(format_string.format('Expected:',
                               pretty_number_string(expected_glass_capacity),
                               pretty_number_string(expected_liquid_amount),
                               pretty_number_string(expected_sugar_amount)))
    print(format_string.format('Actual:',
                               pretty_number_string(sweet_tea.glass_capacity),
                               pretty_number_string(sweet_tea.liquid_amount),
                               pretty_number_string(sweet_tea.sugar_amount)))
    if ((expected_glass_capacity == sweet_tea.glass_capacity)
            and (round(expected_liquid_amount, 6) == round(sweet_tea.liquid_amount, 6))
            and (round(expected_sugar_amount, 6) == round(sweet_tea.sugar_amount, 6))):
        print("Test passed SUCCESSFULLY!")
    else:
        print_failure_message()


def print_failure_message(message='  *** FAILED the above test. ***',
                          flush_time=1.0):
    """ Prints a message onto stderr, hence in RED. """
    time.sleep(flush_time)
    print(message,
          file=sys.stderr, flush=True)
    time.sleep(flush_time)


def pretty_number_string(value, decimal_places=6):
    """Returns a string for the number value that is formatted as either
        and integer or a 6 decimal place value."""
    if abs(value - round(value)) < (10 ** -decimal_places):
        # Treat it as an integer:
        format_string = '{}'
        number = round(value)
    else:
        # Treat it as a float to D decimal places:
        format_string = '{:.' + str(decimal_places) + 'f}'
        number = round(value, decimal_places)

    return format_string.format(number)


# ----------------------------------------------------------------------
# test_init:
# ----------------------------------------------------------------------
def test_init():
    """ Tests the   __init__   method of the SweetTea class. """
    print()
    print('-----------------------------------------------------------')
    print('Testing the   __init__   method of the SweetTea class.')
    print('-----------------------------------------------------------')

    # Test 1: Constructing one sweet_tea:
    sweet_tea = SweetTea(40, 25, 4)

    expected_glass_capacity = 40
    expected_liquid_amount = 25
    expected_sugar_amount = 4

    test_instance_variables(sweet_tea, expected_glass_capacity,
                            expected_liquid_amount, expected_sugar_amount)

    # Test 2: Constructing another sweet_tea:
    sweet_tea = SweetTea(10, 99, 15)

    expected_glass_capacity = 10
    expected_liquid_amount = 10
    expected_sugar_amount = 15

    test_instance_variables(sweet_tea, expected_glass_capacity,
                            expected_liquid_amount, expected_sugar_amount)


# ----------------------------------------------------------------------
# test_drink:
# ----------------------------------------------------------------------
def test_drink():
    """ Tests the   drink   method of the SweetTea class. """
    print()
    print('-----------------------------------------------------------')
    print('Testing the   drink   method of the SweetTea class.')
    print('-----------------------------------------------------------')

    # Test 1:
    sweet_tea1 = SweetTea(12, 10, 3)
    print()
    expected = 1.5
    actual = sweet_tea1.drink(5)
    print('Expected from drink():', pretty_number_string(expected))
    print('Actual   from drink():', pretty_number_string(actual))
    if round(expected, 6) == round(actual, 6):
        print("Test passed SUCCESSFULLY!")
    else:
        print_failure_message()
    test_instance_variables(sweet_tea1, 12, 5, 1.5)

    # Test 2:
    sweet_tea2 = SweetTea(40, 40, 8)
    print()
    expected = 1
    actual = sweet_tea2.drink(5)
    print('Expected from drink():', pretty_number_string(expected))
    print('Actual   from drink():', pretty_number_string(actual))
    if round(expected, 6) == round(actual, 6):
        print("Test passed SUCCESSFULLY!")
    else:
        print_failure_message()
    test_instance_variables(sweet_tea2, 40, 35, 7.0)

    # Test 3:
    sweet_tea3 = SweetTea(12, 7, 100)
    print()
    expected = 71.42857142857143
    actual = sweet_tea3.drink(5)
    print('Expected from drink():', pretty_number_string(expected))
    print('Actual   from drink():', pretty_number_string(actual))
    if round(expected, 6) == round(actual, 6):
        print("Test passed SUCCESSFULLY!")
    else:
        print_failure_message()
    test_instance_variables(sweet_tea3, 12, 2, 28.57142857142857)

    # Test 4:
    sweet_tea4 = SweetTea(12, 1, 2)
    print()
    expected = 2
    actual = sweet_tea4.drink(5)
    print('Expected from drink():', pretty_number_string(expected))
    print('Actual   from drink():', pretty_number_string(actual))
    if round(expected, 6) == round(actual, 6):
        print("Test passed SUCCESSFULLY!")
    else:
        print_failure_message()
    test_instance_variables(sweet_tea4, 12, 0, 0)


def test_many_drinks():
    """ Tests the   many_drinks   method of the SweetTea class. """
    print()
    print('-----------------------------------------------------------')
    print('Testing the   many_drinks   method of the SweetTea class.')
    print('-----------------------------------------------------------')

    # Test 1:
    sweet_tea1 = SweetTea(12, 10, 3)
    print()
    expected = 2.4
    actual = sweet_tea1.many_drinks(2, 4)
    print('Expected from many_drinks():', pretty_number_string(expected))
    print('Actual   from many_drinks():', pretty_number_string(actual))
    if round(expected, 6) == round(actual, 6):
        print("Test passed SUCCESSFULLY!")
    else:
        print_failure_message()
    test_instance_variables(sweet_tea1, 12, 2, 0.6)

    # Test 2:
    sweet_tea2 = SweetTea(12, 10, 3)
    print()
    expected = 3
    actual = sweet_tea2.many_drinks(99, 99)
    print('Expected from many_drinks():', pretty_number_string(expected))
    print('Actual   from many_drinks():', pretty_number_string(actual))
    if round(expected, 6) == round(actual, 6):
        print("Test passed SUCCESSFULLY!")
    else:
        print_failure_message()
    test_instance_variables(sweet_tea2, 12, 0, 0)


def test_get_drinks():
    """ Tests the   get_drinks   method of the SweetTea class. """
    print()
    print('-----------------------------------------------------------')
    print('Testing the   get_drinks   method of the SweetTea class.')
    print('-----------------------------------------------------------')

    sweet_tea1 = SweetTea(120, 100, 3)
    sweet_tea2 = SweetTea(120, 100, 3)

    # Test 1:
    expected = 0
    actual = sweet_tea1.get_drinks()
    print('Expected from get_drinks():', pretty_number_string(expected))
    print('Actual   from get_drinks():', pretty_number_string(actual))
    if expected == actual:
        print("Test passed SUCCESSFULLY!")
    else:
        print_failure_message()

    # Test 2:
    sweet_tea1.drink(1)
    print()
    expected = 1
    actual = sweet_tea1.get_drinks()
    print('Expected from get_drinks():', pretty_number_string(expected))
    print('Actual   from get_drinks():', pretty_number_string(actual))
    if expected == actual:
        print("Test passed SUCCESSFULLY!")
    else:
        print_failure_message()

    # Test 3:
    sweet_tea1.drink(1)
    sweet_tea1.drink(1)
    sweet_tea1.drink(1)
    print()
    expected = 4
    actual = sweet_tea1.get_drinks()
    print('Expected from get_drinks():', pretty_number_string(expected))
    print('Actual   from get_drinks():', pretty_number_string(actual))
    if expected == actual:
        print("Test passed SUCCESSFULLY!")
    else:
        print_failure_message()

    # Test 4:
    sweet_tea2.many_drinks(1, 42)
    print()
    expected = 42
    actual = sweet_tea2.get_drinks()
    print('Expected from get_drinks():', pretty_number_string(expected))
    print('Actual   from get_drinks():', pretty_number_string(actual))
    if expected == actual:
        print("Test passed SUCCESSFULLY!")
    else:
        print_failure_message()

    # Stopping when empty
    # Test 5:
    sweet_tea1.drink(1000)  # 5th and final drink
    sweet_tea1.drink(1000)
    print()
    expected = 5
    actual = sweet_tea1.get_drinks()
    print('Expected from get_drinks():', pretty_number_string(expected))
    print('Actual   from get_drinks():', pretty_number_string(actual))
    if expected == actual:
        print("Test passed SUCCESSFULLY!")
    else:
        print_failure_message()

    # Test 6:
    sweet_tea2.many_drinks(1, 1000)
    print()
    expected = 100  # Started as 100 ounces so 100 one ounce drinks.
    actual = sweet_tea2.get_drinks()
    print('Expected from get_drinks():', pretty_number_string(expected))
    print('Actual   from get_drinks():', pretty_number_string(actual))
    if expected == actual:
        print("Test passed SUCCESSFULLY!")
    else:
        print_failure_message()


def test_refill():
    """ Tests the   refill   method of the SweetTea class. """
    print()
    print('-----------------------------------------------------------')
    print('Testing the   refill   method of the SweetTea class.')
    print('-----------------------------------------------------------')

    # Test 1:
    sweet_tea1 = SweetTea(12, 10, 3)
    sweet_tea1.refill()
    test_instance_variables(sweet_tea1, 12, 10, 3)

    # Test 2:
    sweet_tea1 = SweetTea(200, 100, 8)
    sweet_tea1.liquid_amount = 90
    sweet_tea1.sugar_amount = 7.2
    sweet_tea1.refill()
    test_instance_variables(sweet_tea1, 200, 100, 8)

    # Test 3:
    sweet_tea2 = SweetTea(40, 40, 8)
    sweet_tea2.drink(5)
    sweet_tea2.refill()
    sweet_tea2.drink(5)
    sweet_tea2.refill()
    test_instance_variables(sweet_tea2, 40, 40, 8)

    # Test 4:
    sweet_tea3 = SweetTea(12, 10, 3)
    sweet_tea1.many_drinks(2, 30)
    test_instance_variables(sweet_tea3, 12, 10, 3)


def test_combine_with():
    """ Tests the   combine_with   method of the SweetTea class. """
    print()
    print('-----------------------------------------------------------')
    print('Testing the   combine_with   method of the SweetTea class.')
    print('-----------------------------------------------------------')

    # Test 1:
    sweet_tea1 = SweetTea(12, 10, 3)
    sweet_tea2 = SweetTea(40, 40, 8)
    sweet_tea3 = sweet_tea1.combine_with(sweet_tea2)
    test_instance_variables(sweet_tea1, 12, 0, 0)
    test_instance_variables(sweet_tea2, 40, 0, 0)
    test_instance_variables(sweet_tea3, 52, 50, 11)

    # Test 2:
    sweet_tea4 = SweetTea(120, 0, 0)
    sweet_tea5 = SweetTea(100, 100, 100)
    sweet_tea6 = sweet_tea4.combine_with(sweet_tea5)
    test_instance_variables(sweet_tea4, 120, 0, 0)
    test_instance_variables(sweet_tea5, 100, 0, 0)
    test_instance_variables(sweet_tea6, 220, 100, 100)


# ----------------------------------------------------------------------
# Calls  main  to start the ball rolling.
# ----------------------------------------------------------------------
main()
