# Mark Sherriff (mss2x)

# This program should convert any integer between 1 and 3999 (inclusive) into
# Roman numerals.  The program should exit on any other integer and is 
# allowed to crash on non-integer inputs.

num = int(input("Enter an integer: "))
if (num < 0 or num > 4000) :
    print("Input must be between 1 and 3999")
else:
    thousands = ["", "M", "MM", "MMM"]
    hundreds = ["", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"]
    tens = ["", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"]
    ones = ["", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"]
    print("In roman numerals, " + str(num) + " is " + thousands[int(num/1000)] + hundreds[int(num%1000/100)] + tens[int(num%100/10)] + ones[int(num%10)])