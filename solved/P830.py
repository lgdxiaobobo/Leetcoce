class Solution(object):
    def largeGroupPositions(self, S):
        """
        :type S: str
        :rtype: List[List[int]]
        """
        res = []
        left = 0
        right = -1
        last = S[0]
        for ch in S:
            if ch == last:
                right += 1
            else:
                if right - left >= 2:
                    res.append((left, right))
                left = right + 1
                right= right + 1
                last = ch
        if right - left >= 2:
            res.append((left, right))
        return res
                