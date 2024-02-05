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
# Your Computing ID: cfr5spw
# Collaborators: 
# Sources: Introduction to Algorithms, Cormen
#################################
import collections 
import sys
import heapq
class Marriage:
    lukePath = []
    lorelaiPath = []

    def __init__(self):
        return

    def getLukePath(self):
        return self.lukePath

    def getLorelaiPath(self):
        return self.lorelaiPath

    # This is the method that should set off the computation
    # of marriage.  It takes as input a list lines of input
    # as strings.  You should parse that input and then compute 
    # the shortest paths that both Luke and Lorelai should take.
    # The class fields of lukePath and lorelaiPath should be filled
    # with their respective paths.  The getters above will be called
    # by the grader script.
    #
    # @return the length of the shortest paths (in rooms)
    def compute(self, file_data):
        #@ rewrite the break down of the chapel txt file 
        totalRooms = int(file_data[0].strip())
        lukeSTART, lukeEND = map(int, file_data[1].split())
        loreSTART, loreEND = map(int, file_data[2].split())
    #adj list might not be mapping correctly
        #adjLIST = [list(map(int, line.split())) for line in file_data[3:]]
         # Build adjacency list
        adjLIST = {i: [] for i in range(totalRooms)}
        for i, line in enumerate(file_data[3:]):
            rooms = list(map(int, line.strip().split()))
            for room in rooms:
                adjLIST[i].append(room)


        visitedNODES = set()
        orderOfRoomsVisited = deque([((lukeSTART, loreSTART), [(lukeSTART, loreSTART)])])
        print('deque looks like this: ', orderOfRoomsVisited)
        while orderOfRoomsVisited:
            #grab value of path
            pathVALs=orderOfRoomsVisited.popleft() 
            #destructor
            (lukeCURR, loreCURR), pathtaken = pathVALs
            if lukeCURR == lukeEND and loreCURR == loreEND:
                self.lukePath = [step[0] for step in pathtaken]
                self.lorePath = [step[1] for step in pathtaken]
                return len(self.lukePath)
# fo r
            for nextLukeNODE in adjLIST [lukeCURR] + [lukeCURR]: 
                for nextLoreNODE in adjLIST [loreCURR] + [loreCURR]: 
                    if nextLukeNODE != nextLoreNODE and nextLoreNODE not in adjLIST[nextLukeNODE] and (nextLukeNODE, nextLoreNODE) not in visitedNODES:
                        visitedNODES.add((nextLukeNODE, nextLoreNODE))
                        orderOfRoomsVisited.append(((nextLukeNODE, nextLoreNODE), pathtaken + [(nextLukeNODE, nextLoreNODE)]))

        return -1


    ]