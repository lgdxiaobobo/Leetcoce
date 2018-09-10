class Solution:
    def uniqueLetterString(self, S):
        """
        :type S: str
        :rtype: int
        """
        if len(S) == 0:
            return 0

        word_pos = {}
        pos = 0
        for ch in S:
            if not ch in word_pos:
                word_pos[ch] = []
            word_pos[ch] += [pos]
            pos += 1
        N = len(S)
        res = 0
        for (ch, pos_lst) in word_pos.items():
            M = len(pos_lst)
            for idx in range(M):
                if idx == 0:
                    left = pos_lst[0] + 1
                else:
                    left = pos_lst[idx] - pos_lst[idx-1]
                if idx + 1 < M:
                    right = pos_lst[idx+1] - pos_lst[idx]
                else:
                    right = N - pos_lst[idx]
                res += left * right
        return res
                    
                
            