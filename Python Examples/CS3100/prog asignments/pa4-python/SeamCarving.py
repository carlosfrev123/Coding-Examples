# CS3100 - Fall 2023 - Programming Assignment 4
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
# Collaborators: n/a
# Sources: Introduction to Algorithms, Cormen
#################################
import numpy as np
class SeamCarving:
    def __init__(self):
        self.seam = []

    # This method is the one you should implement.  It will be called to perform
    # the seam carving.  You may create any additional data structures as fields
    # in this class or write any additional methods you need.
    # 
    # @return the seam's weight
    def compute(self, image):
        # Helper func to calculate the energy of a pixel xy
        def calcEofPixel(x, y, image):
            sum_energy = 0.0
            count = 0
            # Check all 8 nieghbors
            for i in range(-1, 2):
                for j in range(-1, 2):
                    if i == 0 and j == 0:
                        continue  # no calc needed for self
                    ni, nj = x + i, y + j
                    # ignore invalid neigbors
                    if 0 <= ni < len(image) and 0 <= nj < len(image[0]):
                        count += 1
                        # Calculate the Euclidean distance between the pixel colors
                        sum_energy += np.linalg.norm(np.subtract(image[x][y], image[ni][nj]))
            #do we divide by number of available pixels or always 8 regardless?
            # i guess we return the average energy of valid neigbors
            return sum_energy / count if count else float('inf')

        # energy table with energy of each pixel
        energy = np.array([[calcEofPixel(i, j, image) for j in range(len(image[0]))] for i in range(len(image))])
        # copy the table to store its energies for later to calc the seam weight
        storedEnergies = np.copy(energy)
        # Calculate the cumulative energy of each pixel
        for i in range(1, len(image)):
            for j in range(len(image[0])):
                # navigate all possible paths and get energies
                left = energy[i-1, j-1] if j-1 >= 0 else float('inf')
                up = energy[i-1, j]
                right = energy[i-1, j+1] if j+1 < len(image[0]) else float('inf')
                
                # add min(left right mid seams) to the current pixelE
                energy[i, j] += min(left, up, right)
        
        # bottom up seam build
        j = np.argmin(energy[-1])
        seam = [j]
        for i in range(len(image) - 1, 0, -1):
            j = seam[-1]
            # check mid left right and add min energy
            left = j-1 if j-1 >= 0 else None
            mid = j
            right = j+1 if j+1 < len(image[0]) else None
            
            paths = [left, mid, right]
            path_energies = [energy[i-1, p] if p is not None else float('inf') for p in paths]
            min_energy_index = np.argmin(path_energies)
            seam.append(paths[min_energy_index] if paths[min_energy_index] is not None else mid)
        
        # Reverse for top down order
        seam.reverse()
        self.seam = seam
        
        # total energy of seam calculatioon
        seam_energy = sum(storedEnergies[i, self.seam[i]] for i in range(len(self.seam)))
        return seam_energy

    # Get the seam, in order from top to bottom, where the top-left corner of the
    # image is denoted (0,0).
    # 
    # Since the y-coordinate (row) is determined by the order, only return the x-coordinate
    # 
    # @return the ordered list of x-coordinates (column number) of each pixel in the seam
    #         as an array
    def getSeam(self):
        return self.seam