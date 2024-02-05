# CS3100 - Fall 2023 - Programming Assignment 5
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
# Sources: Introduction to Algorithms, Cormen,
# https://www.youtube.com/watch?v=rZyR-RwxKS8 ,
# https://www.youtube.com/watch?v=yn2jnmlepY8 ,
# https://www.reddit.com/r/mathriddles/comments/hl2a5k/domino_tiling_problem/ ,
# lecture slide, notes

#################################
from collections import defaultdict
class TilingDino:
    def __init__(self):
        return
    # This is the method that should set off the computation
    # of tiling dino.  It takes as input a list lines of input
    # as strings.  You should parse that input, find a tiling,
    # and return a list of strings representing the tiling
    #
    # @return the list of strings representing the tiling
    def compute(self, lines):
        # input parsing 
        grid = list(map(list, lines))
        rows, cols = len(grid), len(grid[0])
        # get sum of char: # -- if odd return imposiible
        hashtags = sum(row.count('#') for row in grid)
        if hashtags % 2 != 0:
            return ["impossible"]

        # need a helper function to build out a graph-- might help reduce time comp
        def buildGraph():
            graph = defaultdict(lambda: {'neighboring': [], 'linked': False})
            directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]

            for x in range(rows):
                for y in range(cols):
                    if grid[x][y] == '#':
                        for dx, dy in directions:
                            adj_x, adj_y = x + dx, y + dy
                            if 0 <= adj_x < rows and 0 <= adj_y < cols and grid[adj_x][adj_y] == '#':
                                graph[(x, y)]['neighboring'].append((adj_x, adj_y))

            return graph
        #this should work but might risk efficiency by having all of it in one func

        # buildGraph() -- assign to var graph
        graph = buildGraph()
        graph = buildGraph()
        print("Graph constructed")  # Debugging print

        def pathFinder(pixel, visited):
            if pixel in visited:
                return False
            visited.add(pixel)

            print(f"Pathfinding at {pixel}")  # Debugging print

            for adj in graph[pixel]['neighboring']:
                if graph[adj]['linked'] is None:
                    print(f"Trying to link {pixel} with {adj}")  # Debugging print
                if graph[adj]['linked'] is None or pathFinder(graph[adj]['linked'], visited):
                    graph[adj]['linked'] = pixel
                    graph[pixel]['linked'] = adj
                    print(f"Linked {pixel} with {adj}")  # Debugging print
                    return True
            return False

        for pixel in graph:
            if graph[pixel]['linked'] is None:
                print(f"Attempting to link {pixel}")  # Debugging print
                if not pathFinder(pixel, set()):
                    print(f"Failed to link {pixel}")  # Debugging print
                    return ["impossible"]
        # final check to see if we can perfectly match the tiling if so return the tiling else return impossible
        #once we link all pixels we need to return a tiling
        #to check for this we can use if all : [pixel][linked] is true then for pixel in graph add those linkages to the final output in correct format.
        result_tiling = []
        visited_tiles = set()
        for pixel, properties in graph.items():
            if pixel not in visited_tiles:
                linked_pixel = properties['linked']
                if linked_pixel is not None and linked_pixel != False:
                    visited_tiles.add(linked_pixel)
                    px1, py1 = pixel
                    px2, py2 = linked_pixel
                    tiling = f"{py1} {px1} {py2} {px2}"
                    print(f"Adding tiling: {tiling}")  # Debugging print
                    result_tiling.append(f"{py1} {px1} {py2} {px2}")
        if not result_tiling:
            print("No tiling added")  # Debugging print
        return result_tiling
        #if not output impossinle
        # else:
        #     return ["impossible"]
