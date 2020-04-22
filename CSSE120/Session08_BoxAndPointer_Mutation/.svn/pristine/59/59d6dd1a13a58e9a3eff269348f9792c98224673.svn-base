"""
This module demonstrates the distinction betweeen:
  -- MUTATING an object to which the name BLAH refers.
  -- RE-ASSIGNING the name BLAH to refer to a different object.

Authors: David Mutchler, Valerie Galluzzi, Mark Hays, Amanda Stouder,
         their colleagues and Qishun Yu.  September 2016.
"""  # DONE: 1. PUT YOUR NAME IN THE ABOVE LINE.

import rosegraphics as rg

########################################################################
# Students:  You will not write any code in this module,
#            but there ARE things TODO below.
########################################################################


def main():
    """ Runs several examples. """
    example1()
#     example2()


# ----------------------------------------------------------------------
# DONE: 2.
#  Step a:  READ the code in  example1.
#
#  Step b:  PREDICT what  example1  will print when it runs.
#
#  Step c:  Un-comment the call in  main  to  example1.
#           RUN this module.
#
#  Step d:  See whether your prediction matched the actual output.
#           Ask questions as needed to resolve any differences.
#
#  Step e:  When you believe that you understand the code in example1,
#           change the above TODO to DONE.
# ----------------------------------------------------------------------

def example1():
    print()
    print('Demonstrating mutation vs re-assignment:')

    # The following code MUTATES the rg.Point to which  point1  refers.
    print()
    print('Mutation:')

    point1 = rg.Point(100, 200)
    print('Before:', point1)
    point1.x = 77
    print('After: ', point1)

    # The following code RE-ASSIGNS the name  point2  to a NEW rg.Point.
    print()
    print('Re-assignment:')

    point2 = rg.Point(100, 200)
    print('Before:', point2)
    point2 = rg.Point(77, 200)
    print('After: ', point2)


# ----------------------------------------------------------------------
#  DONE: 3.
#  Step a:  READ the code in  example2.
#           Pay close attention to the difference between the functions:
#              mutate_point
#              return_point
#           both of which are defined below.
#
#  Step b:  PREDICT what  example2  will print when it runs.
#
#  Step c:  Un-comment the call in  main  to  example2.
#           RUN this module.
#
#  Step d:  See whether your prediction matched the actual output.
#           Ask questions as needed to resolve any differences.
#
#  Step e:  When you believe that you understand the code in example2,
#           change the above TODO to DONE.
# ----------------------------------------------------------------------

def example2():
    print()
    print('Demonstrating mutation vs re-assignment via function calls:')

    # The following code MUTATES the rg.Point to which  point1  refers.
    print()
    print('Mutation:')

    point1 = rg.Point(100, 200)
    print('Before:', point1)
    mutate_point(point1)
    print('After: ', point1)

    # The following code RE-ASSIGNS the name  point2  to a NEW rg.Point.
    print()
    print('Re-assignment:')

    point2 = rg.Point(100, 200)
    print('Before:', point2)
    point2 = return_point(point2)
    print('After: ', point2)


def mutate_point(point):
    point.x = 77  # Mutates the  rg.Point  argument


def return_point(point):
    return rg.Point(77, point.y)  # Returns a NEW rg.Point

# ----------------------------------------------------------------------
# Calls  main  to start the ball rolling.
# ----------------------------------------------------------------------
main()
