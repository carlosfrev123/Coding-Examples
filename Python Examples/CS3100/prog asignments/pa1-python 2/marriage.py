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
# Your Computing ID: 
# Collaborators: 
# Sources: Introduction to Algorithms, Cormen
#################################
import collections
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
        totalRooms = int(file_data[0].strip())
        lukeSTART= int(file_data[1].split()[0])
        lukeEND = int(file_data[1].split()[1])
        loreSTART= int(file_data[2].split()[0])
        loreEND = int(file_data[2].split()[1])
        adjLIST = {room_num: [] for room_num in range(totalRooms)}
        for i, roomConnections in enumerate(file_data[3:]):
            connectedRooms = list(map(int, roomConnections.strip().split()))
            for room in connectedRooms:
                adjLIST[i].append(room)
        visitedNODES = set()
        roomorder = collections.deque([((lukeSTART, loreSTART), [(lukeSTART, loreSTART)])])
        while roomorder:
            #destructor
            (lukeCURR, loreCURR), path = roomorder.popleft()
            # CONDITIONAL: has luke and lore both reached the end
            if (lukeCURR, loreCURR) == (lukeEND, loreEND):
                self.lukePath = [step[0] for step in path]
                self.lorelaiPath = [step[1] for step in path]
                return len(self.lukePath)
#use forin to grab next node
            for lukeN in adjLIST[lukeCURR]+[lukeCURR]: 
                for loreN in adjLIST[loreCURR]+[loreCURR]:
                    if lukeN != loreN and loreN not in adjLIST[lukeN] and (lukeN, loreN) not in visitedNODES:
                        visitedNODES.add((lukeN, loreN))
                        roomorder.append(((lukeN, loreN), path + [(lukeN, loreN)]))
        return -1 # if no path is found


