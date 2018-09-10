class Solution(object):
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        
        if len(grid) == 0:
            return 0

        rows = len(grid)
        cols = len(grid[0])
        island = [[-1 for x in range(cols)] for y in range(rows)]
        direction = [[-1, 0], [0, -1], [0, 1], [1, 0]]

        def dfs(x, y, island_no):
            for i in range(4):
                new_x = x + direction[i][0]
                new_y = y + direction[i][1]
                if new_x >= 0 and new_x < rows and \
                   new_y >= 0 and new_y < cols and \
                   island[new_x][new_y] == -1 and \
                   grid[new_x][new_y] == "1":
                    island[new_x][new_y] = island_no
                    dfs(new_x, new_y, island_no)

        island_no = 0
        for x in range(rows):
            for y in range(cols):
                if island[x][y] == -1 and grid[x][y] == "1":
                    island_no += 1
                    dfs(x, y, island_no)

        return island_no