class Solution(object):
    def lengthOfLastWord(self, s):
        """
        :type s: str
        :rtype: int
        """
        if len(s) == 0:
            return 0
        else:
            ps = s.split(" ")
            while len(ps) > 0:
                x = ps.pop()
                if len(x) > 0:
                    return len(x)
            return 0
                