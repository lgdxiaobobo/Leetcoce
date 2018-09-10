class Solution(object):
    def solveNQueens(self, n):
        """
        :type n: int
        :rtype: List[List[str]]
        """
        if n == 0 or n == 3 or n == 2:
            return []

        res = []
        col = [True for x in range(n)]
        diag= [True for x in range(2*n-1)]
        back= [True for x in range(2*n-1)]

        def search(ind, tmp):
            if ind == n:
                res.append(tmp)
            else:
                for x in range(n):
                    if col[x] and diag[ind-x+n-1] and back[ind+x]:
                        col[x] = False
                        diag[ind-x+n-1] = False
                        back[ind+x] = False
                        search(ind+1, tmp + ["."*x+ "Q" + "."*(n-x-1)])
                        col[x] = True
                        diag[ind-x+n-1] = True
                        back[ind+x] = True

        search(0, [])
        return res