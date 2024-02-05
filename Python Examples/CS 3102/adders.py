"""The first three functions are just used for testing purposes for this assignment. You also saw them in the last programming problem set. list_strings gives a list of all strings of length n, string_to_nat and nat_to_string convert back and forth between binary strings and natural numbers."""

def list_strings(n):
    """lists all binary strings of length n, do not modify this function"""
    if n == 0:
        return [""]
    else:
        strings = []
        for b in list_strings(n-1):
            strings.append(b+"0")
            strings.append(b+"1")
        return strings
        
def string_to_nat(b):
    """Given a binary string, converts it into a natural number.  Do not modify this function."""
    if b == "":
        return 0
    else:
        return 2 * string_to_nat(b[:-1]) + int(b[-1])
        

def nat_to_string(x):
    """Given a natural number, converts it into a binary string  Do not modify this function."""
    assert(x >= 0)
    if x == 0:
        return ""
    else:
        return nat_to_string(x//2) + str(x % 2)
        
"""This next block of functions is setting us up to program in AON-Straightline. The is_binary function checks that we are only computing on binary inputs/outputs (the only data type that AON-Straightlin can handle). The AND, OR, and NOT functions implement the corresponding boolean operators in python. """

def is_binary(b):
    return b == '1' or b == '0'

def AND(a,b):
    assert(is_binary(a) and is_binary(b))
    return str(int(a)*int(b))

def OR(a,b):
    assert(is_binary(a) and is_binary(b))
    return str(int(a)+int(b) - int(a)*int(b))

def NOT(a):
    assert(is_binary(a))
    return str(1-int(a))
    
"""For this assignment we're programming in NAND-Straightline in for some functions, and NAND-Straightline with sugar for others. We start out by providing implementations of some functions disccussed in-class in AON-Straightline: XOR, NAND, and MAJ (you saw these last week). Recall that each line in the program should consist of a new variable declaration on the left-hand side and a NAND operation (or the permitted sugary operation for some problems) on the right-hand side, or else a return statement. Please note that you cannot have multiple operations nested (e.g. NOT(AND(a,b)) is not permitted), and you cannot re-assign and already assigned variable (e.g. a = NOT(a) is not permitted)."""
    
def XOR(a,b):
    not_a = NOT(a)
    not_b = NOT(b)
    a_not_b = AND(a, not_b)
    b_not_a = AND(b, not_a)
    return OR(a_not_b, b_not_a)

def NAND(a,b):
    a_and_b = AND(a,b)
    return NOT(a_and_b)
    
def MAJ(a,b,c):
    assert(is_binary(a) and is_binary(b) and is_binary(c))
    first_two = AND(a,b)
    last_two = AND(b,c)
    first_last = AND(a,c)
    temp = OR(first_two, last_two)
    return OR(temp, first_last)

"""For this assignment you'll be building arithmetic (specifically, addition) using straightline programs. Keep in mind that straightline programs can be easily converted into boolean gates, meaning that you're actually starting to build components of real integrated circuits here. How neat is that?!

These are going to be using a similar recursive definition of functions as what you saw with LOOKUP from lecture. You'll be able to build "larger" versions of functions out of smaller versions of the same functions.

To begin, we will implement a carry-free adder. Sometimes when adding n-bit numbers together, the result will be n+1 bits long. Consider the sum (in binary) 10+11=101. An n-bit carry-free adder is an adder which takes as input two n-bit natural numbers and returns the least significant n bits of their sum. For the previous example, a 2-bit carry-free adder would return 01.

Implement a 2-bit carry-free adder below. You may use NAND or any of the sugary functions provided above.
"""

score = 0

def CFADD2(a1, a0, b1, b0):
    irstIndex = XOR(string_to_nat(a0),string_to_nat(b0))
    secondIndex = AND(string_to_nat(a1),(NAND(string_to_nat(b1),firstIndex)))
    return nat_to_string(secondIndex), nat_to_string(firstIndex)

"""This code tests CFADD2 by checking that the correct response is given for all possible 4-bit input strings. You're welcome to read it, but the test cases are purposefully checked in a way that cannot be emulated with straightline."""
CFADD2_correct = True
for a in list_strings(2):
    a_val = string_to_nat(a)
    for b in list_strings(2):
        b_val = string_to_nat(b)
        returned = "".join(CFADD2(a[0], a[1], b[0], b[1]))
        answer = "0"*(2-len(nat_to_string(a_val+b_val)))+nat_to_string(a_val+b_val)[-2:]
        CFADD2_correct = CFADD2_correct and returned == answer
        if not CFADD2_correct:
            print("CFADD2 gave incorrect result for sum " + str(a_val) + "+" + str(b_val))
            break
    if not CFADD2_correct:
        break
if CFADD2_correct:
    print("You did it! CFADD2 is correct! Time to celebrate!")
    score += 1


"""A one-bit Full Adder is a function that takes in three bits as input and gives their sum as output. For example, FADD(0,1,1) = 1,0. The idea of a full adder is that two of the bits will represent input bits in the addition, and the third bit will represent the carry value of the addition of a less-significant bit.

Implement a one-bit Full Adder below. You may use only NAND gates for this function (keep it sugar-free!). Maintaining this restriction will help you with problem 2 on this week's problem set."""

def FADD1(a,b,c):
    """TODO: Implement this function"""
    return '0','0'

"""This code tests FADD1 by checking that the correct response is given for all possible 3-bit input strings. You're welcome to read it, but the test cases are purposefully checked in a way that cannot be emulated with straightline."""
FADD1_correct = True    
for i in list_strings(3):
    a, b, c = i
    a_val = string_to_nat(a)
    b_val = string_to_nat(b)
    c_val = string_to_nat(c)
    response = "".join(FADD1(a,b,c))
    answer = "0"*(2-len(nat_to_string(a_val+b_val+c_val)))+nat_to_string(a_val+b_val+c_val)[-2:]
    FADD1_correct = FADD1_correct and response == answer
    if not FADD1_correct:
        print("FADD1 gave incorrect result for sum " + a + "+" + b + "+" + c)
        break
if FADD1_correct:
    print("Hip-Hip-Hooray! Hip-Hip-Hooray! Hip-Hip-Hooray! FADD1 Works!")
    score += 1

    

"""Next I'll show you how you can use FADD1 to implement a function that adds together two 2-bit numbers. """

def ADD2(a1, a0, b1, b0):
    carry0, r0 = FADD1(a0, b0, "0")
    r2, r1 = FADD1(a1, b1, carry0)
    return r2, r1, r0
    
"""This code tests ADD2 by checking that the correct response is given for all possible 4-bit input strings. You're welcome to read it, but the test cases are purposefully checked in a way that cannot be emulated with straightline."""
ADD2_correct = True
for a in list_strings(2):
    a_val = string_to_nat(a)
    for b in list_strings(2):
        b_val = string_to_nat(b)
        returned = "".join(ADD2(a[0], a[1], b[0], b[1]))
        answer = "0"*(3-len(nat_to_string(a_val+b_val)))+nat_to_string(a_val+b_val)[-3:]
        ADD2_correct = ADD2_correct and returned == answer
        if not ADD2_correct:
            print("ADD2 gave incorrect result for sum " + str(a_val) + "+" + str(b_val))
            break
    if not ADD2_correct:
        break
if ADD2_correct:
    print("With our powers combined, we implemented ADD2!")
    
"""And now a function that adds together two 3-bit numbers. """

def ADD3(a2, a1, a0, b2, b1, b0):
    carry, r1, r0 = ADD2(a1, a0, b1, b0)
    r3, r2 = FADD1(a2, b2, carry)
    return r3, r2, r1, r0
    

"""This code tests ADD3 by checking that the correct response is given for all possible 6-bit input strings. You're welcome to read it, but the test cases are purposefully checked in a way that cannot be emulated with straightline."""
ADD3_correct = True
for a in list_strings(3):
    a_val = string_to_nat(a)
    for b in list_strings(3):
        b_val = string_to_nat(b)
        returned = "".join(ADD3(a[0], a[1], a[2], b[0], b[1], b[2]))
        answer = "0"*(4-len(nat_to_string(a_val+b_val)))+nat_to_string(a_val+b_val)[-4:]
        ADD3_correct = ADD3_correct and returned == answer
        if not ADD3_correct:
            print("ADD3 gave incorrect result for sum " + str(a_val) + "+" + str(b_val))
            break
    if not ADD3_correct:
        break
if ADD3_correct:
    print("With our powers combined, we implemented ADD3!")

    
"""Finally, you implement a function that adds together two 5-bit numbers. You may use NAND, XOR, MAJ, ADD2, any of the other sugary procedures either you or I build above, or any new procedures you choose to implement as syntactic sugar if you wish (you must follow these same rules when implementing your own procedures)."""


def ADD5(a4, a3, a2, a1, a0, b4, b3, b2, b1, b0):
    """TODO: Implement this function"""
    return '0' # you must figure out how many bits you actually need to return

"""This code tests ADD5 by checking that the correct response is given for all possible 10-bit input strings. You're welcome to read it, but the test cases are purposefully checked in a way that you cannot emulate with straightline."""
ADD5_correct = True
for a in list_strings(5):
    a_val = string_to_nat(a)
    for b in list_strings(5):
        b_val = string_to_nat(b)
        returned = "".join(ADD5(a[0], a[1], a[2], a[3], a[4], b[0], b[1], b[2], b[3], b[4]))
        answer = "0"*(6-len(nat_to_string(a_val+b_val)))+nat_to_string(a_val+b_val)[-6:]
        ADD5_correct = ADD5_correct and returned == answer
        if not ADD5_correct:
            print("ADD5 gave incorrect result for sum " + str(a_val) + "+" + str(b_val))
            break
    if not ADD5_correct:
        break
if ADD5_correct:
    print("That's amazing, you did ADD5 correctly!")
    score += 1


    
"""The next problem is a challenge problem. These are problems whose difficulty is so high that we do not necessarily expect most students will be able to do them within the time constraints of this assignment. We do, though, believe that they will be good practice. You are not required to complete or even attempt any challenge problems, but if you do, please let you Cohort Coach know. Successful completion of challenge problems will very much impress the course staff, and can also improve your community score.

CHALLENGE: Implement a function which computes the product of two 4-bit numbers"""

def MULT4(a0, a1, a2, a3, b0, b1, b2, b3):
    return '0' # you must figure out how many bits you actually need to return

grade = score/3
print("Problem Grade:", grade)
