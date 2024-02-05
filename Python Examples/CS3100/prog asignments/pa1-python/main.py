# CS3100 - Fall 2023 - Programming Assignment 1
#################################
# Collaboration Policy: You may discuss the problem and the overall
# strategy with up to 4 other students, but you MUST list those people
# in your submission under collaborators.  You may NOT share code,
# look at others' code, or help others debug their code.  Please read
# the syllabus carefully around coding.  Do not seek published or online
# solutions for any assignments. If you use any published or online resources
# (which may not include solutions) when completing this assignment, be sure to
# cite them. Do not submit a solution that you are unable to explain orally to a
# member of the course staff.
#################################
import collections
import sys
import time
from marriage import Marriage 

fp = open("chapel.txt", 'r')
lines = fp.readlines()

# Call the closest_pair function passing in the
# contents of the file
start = time.time()
m = Marriage()
print(m.compute(lines))
print(m.getLukePath())
print(m.getLorelaiPath())
end = time.time()
print("time: "+ str(end-start))
