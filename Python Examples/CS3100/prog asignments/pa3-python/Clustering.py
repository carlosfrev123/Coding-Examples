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
# Your Computing ID: cfr5spw
# Collaborators: none
# Sources: Introduction to Algorithms, Cormen
#################################

# Push edges into a prioty queue based on weights.
# init n singleton clusters.
# Pop edges from queue -> For each edge check if its endpoints belong to different clusters
    # If they do, merge the clusters.
    # If merging this edge results in k clusters then break
# The next edge's weight in the priority queue (after breaking) should be max spacing

import heapq as pq

class Clustering:
    def __init__(self):
        return

     # This is the method that should compute the maximum possible
     # spacing. It takes as input an integer k and an nxn array of
     # distances. 
     #
     # @return the maximum possible spacing 

    
    def compute(self, k, distances):
        edgeHeap = []
        for i in range(len(distances)):
            for j in range(i+1, len(distances)):
                pq.heappush(edgeHeap, (distances[i][j], i, j))
        
        biggestBoys = [i for i in range(len(distances))]
        #init var to store length of distances that we will go through
        clusterCount = len(distances)
        rank = [0] * len(distances)

        # keep mergn' till we got more than k clusters
        while clusterCount > k and edgeHeap:
            weight, point1, point2 = pq.heappop(edgeHeap)
            if self.getMaxEdges(biggestBoys, point1) != self.getMaxEdges(biggestBoys, point2):
                self.mergeSets(biggestBoys,rank, point1, point2)
                clusterCount -= 1
        
       # Keep popping from the queue until you find an edge that connects two separate clusters
        while edgeHeap:
            weight, point1, point2 = pq.heappop(edgeHeap)
            if self.getMaxEdges(biggestBoys, point1) != self.getMaxEdges(biggestBoys, point2):
                return weight
    
        return -1 # return a dummyvalue if no edge found (this shouldn't happen)
        
        #helper func to get max's and merge the sets
                #......the bigboys are the max edge distances of each set
    def getMaxEdges(self, bigboys,i):
            if bigboys[i] != i:
                bigboys[i] = self.getMaxEdges(bigboys,bigboys[i])
            return bigboys[i]
    # need to check sorted ranks of edges
    #error: rank doesnt change in rankm1<rankm2 case 
    def mergeSets(self, bigboys,rank, set1, set2):
        max1 = self.getMaxEdges(bigboys, set1)
        max2 = self.getMaxEdges(bigboys, set2)
        
        if max1 != max2:
            if rank[max1]<rank[max2]: bigboys[max1]=max2
            elif rank[max1]>rank[max2]: bigboys[max2]=max1
            else:
                bigboys[max2] =max1
                rank[max1]+=1