"""
This module demonstrates:

1. How a module is executed by the Python interpreter:

   a. The module is processed from line 1 to the end.
        In that processing, the interpreter encounters
        and stores function DEFINITIONS:
             def blah(...):
                 ...
                 ...
               
   b. At the end of the module, we will always have a statement:
             main()
        that CALLS the function named  main  that must have been
        DEFINED previously in the module.  This statement causes
        execution to jump to the beginning of the definition of main.

  b. Execution continues from  main  line by line (sequentially) except:
      -- When a function is CALLED,
            execution JUMPS to the beginning of that function.
      -- When a function REACHES ITS END (or reaches a RETURN statement)
            execution continues from the point
            at which the function WAS CALLED.
     Note: We will soon see two more exceptions to line-by-line
           execution: LOOPs and IF statements.

2. DEFINING a function versus CALLING a function.
     -- The former begins     def blah(): ...
     -- The latter uses the notation     blah()    in an expression.

Authors: Many, many people over many, many years.
         David Mutchler, Valerie Galluzzi, Mark Hays, Amanda Stouder,
         and their colleagues wrote this version.  September 2015.
"""
# ----------------------------------------------------------------------
# Students: PREDICT what this program will print when you run it,
# then run it to check your prediction.  Before you leave this example,
# be sure you understand the order in which statements are executed:
#      -- sequential
#      -- but interrupted by function calls.
#
#   There is nothing for you to turn in from this file.
# ----------------------------------------------------------------------


def main():
    """ Calls the other functions to demonstrate them. """
    hello()
    goodbye()
    hello()
    hello()

    print('---------------------------------------------')
    print('The remaining output comes from CALLING')
    print('the  hello_and_goodbye  FUNCTION.')
    print('---------------------------------------------')

    hello_and_goodbye()


def hello():
    """ Prints a welcoming message on the console. """
    print('Hello!  How are things?')


def goodbye():
    """ Prints a farewell message on the console, in 3 languages. """
    print('Goodbye!')
    print('   Ciao!')
    print('   Bai bai!')


def hello_and_goodbye():
    """ Prints welcoming and farewell messages on the console. """
    hello()
    goodbye()


# ----------------------------------------------------------------------
# Calls  main  to start the ball rolling.
# ----------------------------------------------------------------------
main()
