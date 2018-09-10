class Solution(object):
    def pushDominoes(self, dominoes):
        """
        :type dominoes: str
        :rtype: str
        """
        N = len(dominoes)
        if N == 0:
            return ""
        else:
            result = []
            right = -1
            left = -1
            for idx in xrange(N):
                # print result
                if dominoes[idx] == ".":
                    if right >= 0 and left < right:
                        result.append('R')
                    else:
                        result.append('.')
                elif dominoes[idx] == 'R':
                    right = idx
                    result.append('R')
                else:
                    result.append('L')
                    if right == -1 or right < left:
                        for i in xrange(left, idx-1):
                            result[i+1] = 'L'
                    else:
                        temp = right + idx
                        p1 = temp >> 1
                        p2 = p1 + 1                        
                        # print right, p1, p2, idx
                        if temp % 2 == 0:
                            result[p1] = '.'
                        for i in xrange(p2, idx):
                            result[i] = 'L'
                    left = idx
            return "".join(result)
