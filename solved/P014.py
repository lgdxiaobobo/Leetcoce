class Solution(object):
    def longestCommonPrefix(self, strs):
        """
        :type strs: List[str]
        :rtype: str
        """
        if len(strs) == 0:
            return ""
        if len(strs) == 1:
            return strs[0]
            
        res = ""
        length = min(map(len, strs))
        for i in range(length):
            flag = True
            tmp = strs[0][i]
            for word in strs:
                if tmp != word[i]:
                    flag = False
                    break
            if flag:
                res += tmp
            else:
                break
        return res