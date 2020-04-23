"""
Final exam, problem 3.

Authors: David Mutchler, his colleagues,
         and Qishun Yu.  May 2017.
"""  # DONE: 1. PUT YOUR NAME IN THE ABOVE LINE.

import simple_testing as st


def main():
    """ Calls the   TEST   functions in this module. """
    test_problem3a()
    test_problem3b()
    test_problem3c()


def test_problem3a():
    """ Tests the    problem3a    function. """
    tests = [st.SimpleTestCase(problem3a,
                               [["foo", "double"]],
                               ["foo", "double", "double"]),
             st.SimpleTestCase(problem3a,
                               [["a", "double", "b", "double", "c"]],
                               ["a", "double", "double", "b", "double",
                                "double", "c"]),
             st.SimpleTestCase(problem3a,
                               [["foo", "double", "double", "ok"]],
                               ["foo", "double", "double", "double",
                                "double", "ok"]),
             st.SimpleTestCase(problem3a,
                               [["foo", "the end"]],
                               ["foo", "the end"]),
             st.SimpleTestCase(problem3a,
                               [["double", "foo", "double", "bar"]],
                               ["double", "double", "foo",
                                "double", "double", "bar"]),
             st.SimpleTestCase(problem3a,
                               [["double", "double", "double"]],
                               ["double", "double", "double",
                                "double", "double", "double"]),
             st.SimpleTestCase(problem3a,
                               [[]],
                               []),
             ]

    st.SimpleTestCase.run_tests('problem3a', tests)


def problem3a(strings):
    """
    What comes in:
      -- A list of strings.
    What goes out:
      -- Returns a new list where any time the word "double"
           appears in the original (given) list, it is doubled
           (that is, repeated twice) in the new list.
    Side effects: None.
    Examples:
      problem3a(["foo", "double"])
         returns
                ["foo", "double", "double"]

      problem3a(["a", "double", "b", "double", "c"])
         returns
                ["a", "double", "double", "b", "double", "double", "c"]    

      problem3a(["foo", "double", "double", "ok"])
         returns
                ["foo", "double", "double", "double", "double", "ok"]

      problem3a(["foo", "the end"])
         returns
                ["foo", "the end"]

    """
    # ------------------------------------------------------------------
    # DONE: 2. Implement and test this function.
    #          Tests have been written for you (above).
    # ------------------------------------------------------------------
    newlist = []
    for k in range(len(strings)):
        if strings[k] == 'double':
            newlist = newlist + [strings[k]] + [strings[k]]
        else:
            newlist = newlist + [strings[k]]

    return newlist


def test_problem3b():
    """ Tests the    problem3b    function. """
    tests = [st.SimpleTestCase(problem3b,
                               [[1, 2],
                                [7, 1, 2, 7, 7, 7, 1, 2, 7]],
                               2),
             st.SimpleTestCase(problem3b,
                               [[1, 1],
                                [1, 1, 1, 3]],
                               2),
             st.SimpleTestCase(problem3b,
                               [[1, 2],
                                [1, 3, 2, 1]],
                               0),
             st.SimpleTestCase(problem3b,
                               [[88, 33, 22],
                                [1, 2, 4, 10, 88, 33, 14, 15, 88, 33, 22, 55]],
                               1),
             st.SimpleTestCase(problem3b,
                               [[88, 33, 88],
                                [1, 88, 33, 88, 33, 88, 33, 88, 33, 0, 88, 33, 88, 10]],
                               4),
             ]

    st.SimpleTestCase.run_tests('problem3b', tests)


def problem3b(list1, list2):
    """
    What comes in:
      -- Two lists of integers.
         Assume that the length of the first list is less than
         the length of the second list.
    What goes out:
      -- Returns the number of times the first list occurs
           as a subsequence within the second list.
    Side effects: None.
    Examples:
      problem3b([1, 2],
                [7, 1, 2, 7, 7, 7, 1, 2, 7])
                    ----           ----
         returns 2
           (the dashes indicate the two places where [1, 2]
           occurs within [7, 1, 2, 7, 7, 7, 1, 2, 7])

      problem3b([1, 1],
                [1, 1, 1, 3])
         returns 2
           (once starting in the 0th position and a second time
           starting in the 1st position)

      problem3b([1, 2],
                [1, 3, 2, 1])
         returns 0

      problem3b([88, 33, 22],
                [1, 2, 4, 10, 88, 33, 14, 15, 88, 33, 22, 55])
                                              ----------
         returns 1

      problem3b([88, 33, 88],
                [1, 88, 33, 88, 33, 88, 33, 88, 33, 0, 88, 33, 88, 10])
                    ----------
                            ----------
                                    ----------
                                                       ----------
         returns 4
    """
    # ------------------------------------------------------------------
    # DONE: 3. Implement and test this function.
    #          Tests have been written for you (above).
    # ------------------------------------------------------------------
    count = 0
    for k in range(len(list2) - len(list1)):
        if list1[0] == list2[k]:
            icount = 0
            for j in range(len(list1)):
                if list1[j] == list2[k + j]:
                    icount = icount + 1
                if icount == len(list1):
                    count = count + 1
    return count


def test_problem3c():
    """ Tests the    problem3c    function. """
    tests = [st.SimpleTestCase(problem3c,
                               ["aaab"],
                               "a"),
             st.SimpleTestCase(problem3c,
                               ["abcbcdc"],
                               "c"),
             st.SimpleTestCase(problem3c,
                               ["bbaaa"],
                               "a"),
             st.SimpleTestCase(problem3c,
                               ["aaabb"],
                               "a"),
             st.SimpleTestCase(problem3c,
                               ["a"],
                               "a"),
             st.SimpleTestCase(problem3c,
                               ["Hello"],
                               "l"),
             ]

    st.SimpleTestCase.run_tests('problem3c', tests)


def problem3c(s):
    # ------------------------------------------------------------------
    # HINT: Use a NESTED LOOP (i.e., a loop within a loop)
    #   to solve this problem.
    # ------------------------------------------------------------------
    """
    What comes in:
      -- A non-empty string s.
    What goes out:
      -- Returns the most common character in the given string.
    Note: You can assume that one character will be more common
          than all the others
          (i.e. there won't be a tie for the most common character).
    Side effects: None.
    Examples:
      problem3c("aaab") returns "a"
      problem3c("abcbcdc") returns "c"

    """
    # ------------------------------------------------------------------
    # DONE: 4. Implement and test this function.
    #          Tests have been written for you (above).
    # IMPORTANT:  See the HINT just below the DEF line.
    # ------------------------------------------------------------------
    newlist = []
    for k in range(len(s)):
        newlist = newlist + [s[k]]
    for k in range(len(newlist)):
        for j in range(1, len(newlist) - k):
            if newlist[k][0] == newlist[k + j][0]:
                newlist[k] = newlist[k] + newlist[k][0]
    indexlarge = 0

    for k in range(len(newlist)):
        if len(newlist[indexlarge]) < len(newlist[k]):
            indexlarge = k

    return newlist[indexlarge][0]


# ----------------------------------------------------------------------
# Calls  main  to start the ball rolling.
# ----------------------------------------------------------------------
main()