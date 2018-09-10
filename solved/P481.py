class Solution(object):
    def magicalString(self, n):
        """
        :type n: int
        :rtype: int
        """
        seq = [1, 2, 2]
        cnt = 2
        while len(seq) < n:
            seq += [seq[-1] % 2 + 1 for x in range(seq[cnt])]
            cnt += 1
        return len(filter(lambda x: x == 1, seq[:n]))