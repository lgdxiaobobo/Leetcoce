class Solution:
    def maxDistToClosest(self, seats):
        """
        :type seats: List[int]
        :rtype: int
        """
        
        def min_dist(idx, candidates):
            l = 0
            r = len(candidates) - 1
            if idx < candidates[l]:
                return candidates[l] - idx
            elif idx > candidates[r]:
                return idx - candidates[r]
            else:
                while (l < r):
                    m = l + r >> 1
                    if (candidates[m] > idx):
                        r = m - 1
                    else:
                        l = m + 1
                if (idx < candidates[l]):
                    return min(idx - candidates[l-1], candidates[l] - idx)
                else:
                    return min(idx - candidates[l], candidates[l+1] - idx)                  
                
        res = 0
        size = len(seats)
        sitted = []
        empty = []
        for idx in range(size):
            if seats[idx] == 0:
                empty.append(idx)
            else:
                sitted.append(idx)
        for idx in empty:
            res = max(res, min_dist(idx, sitted))
        
        return res