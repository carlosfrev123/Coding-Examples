# CS3100 - Fall 2023 - Programming Assignment 3
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
import sys
import time
from Clustering import Clustering

# Read the input
fp = open("input.txt", 'r')
lines = fp.readlines()

# Parse the input
k = int(lines[0])
n = int(lines[1])
distances = [[0 for i in range(n)] for j in range(n)]

for i in range(0, n):
    row = lines[i+2].split(" ")
    for j in range(0, n):
        distances[i][j] = float(row[j])

# Call the compute function passing in the
# contents of the file
start = time.time()
c = Clustering()
print(c.compute(k, distances))
end = time.time()
print("time: "+ str(end-start))
