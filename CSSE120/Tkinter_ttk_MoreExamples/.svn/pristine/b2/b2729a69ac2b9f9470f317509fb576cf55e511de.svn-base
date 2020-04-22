"""
This module demonstrates simple ways to READ and WRITE to TEXT FILES.

Authors: David Mutchler, Chandan Rupakheti and their colleagues,
         April 2013.
"""


def main():
    """ Calls the   TEST   functions in this module. """
    reading_in_one_chunk()
    reading_line_by_line()
    writing()


def reading_in_one_chunk():
    """
    Example showing how to read an entire text file into a list.
    """
    # Open the file for reading.  The returned value, f,
    # is the "stream" used for all subsequent actions.
    f = open('AliceInWonderland.txt', 'r')

    # BTW, to open a file in a parallel folder, use   ..   to go UP
    # a folder and then a folder name to go DOWN into another folder:
    #    f = open('../foo/blah.txt', 'r')

    # Read the entire file into a string.
    # Then close the file (because you are done with it).
    s = f.read()
    f.close()

    # From here, you would use   s   however you want.
    # This is just an example:
    print()
    print('After reading the ENTIRE file into all_lines:')
    print('  Its first character is:', s[0])
    print('  Its last character is: ', s[len(s) - 1])

    lines = s.split('\n')
    words_in_line7 = lines[7].split()
    print('  Its first line is:', lines[0])
    print('  Its last line is: ', lines[len(lines) - 1])
    print('  Word 3 of Line 7 (both zero-based) is:',
          words_in_line7[3])


def reading_line_by_line():
    """
    Example showing how to read a text file line by line.
    """
    print()
    print('Reading the file LINE BY LINE,')
    print('printing every line that contains "garden":')
    print()
    f = open('AliceInWonderland.txt', 'r')
    for line in f:
        if 'garden' in line:
            print(line, end='')


def writing():
    """
    Example showing how to write to a text file.
    """
    # Open the file for writing.  The returned value, f,
    # is the "stream" used for all subsequent actions.
    #   *** BE CAREFUL: *** Opening a file for writing OVERWRITES
    #                       any existing file with that name!!!
    f = open('my_new_file.txt', 'w')
    f.write('This is\n')
    f.write('how you')
    f.write('write to a file.\n')
    f.close()  # Don't forget this when you are done.

#-----------------------------------------------------------------------
# If this module is running at the top level (as opposed to being
# imported by another module), then call the 'main' function.
#-----------------------------------------------------------------------
if __name__ == '__main__':
    main()
