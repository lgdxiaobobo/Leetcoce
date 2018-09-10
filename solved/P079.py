class Solution(object):
    def exist(self, board, word):
        """
        :type board: List[List[str]]
        :type word: str
        :rtype: bool
        """

        if len(word) == 0:
            return True

        nrow = len(board)
        ncol = len(board[0])
        vis  = [[True for y in range(ncol)] for x in range(nrow)]

        def dfs(word, i, j):
            if len(word) == 0:
                return True
            else:
                direction = [[-1, 0], [0, -1], [1, 0], [0, 1]]
                for k in range(4):
                    x = i + direction[k][0]
                    y = j + direction[k][1]
                    if x >= 0 and x < nrow and y >= 0 and y < ncol and vis[x][y] and board[x][y] == word[0]:
                        vis[x][y] = False
                        # print board[x][y]
                        flag = dfs(word[1:], x, y)
                        vis[x][y] = True
                        if flag:
                            return True
                return False

        for x in range(nrow):
            for y in range(ncol):
                if board[x][y] == word[0]:
                    vis[x][y] = False
                    # print board[x][y]
                    flag = dfs(word[1:], x, y)
                    vis[x][y] = True
                    if flag:
                        return True

        return False