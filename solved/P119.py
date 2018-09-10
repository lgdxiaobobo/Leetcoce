class Solution(object):
    def getRow(self, rowIndex):
        """
        :type rowIndex: int
        :rtype: List[int]
        """
        
        if rowIndex == 0:
            return [1]
        
        res = []
        last = 1
        for i in range(rowIndex):
            if i == 0:
                res.append(1)
                last = 1
            else:
                last = last * (rowIndex - i + 1) / i
                res.append(last)
        res.append(1)
        return res