class Solution(object):
    def reverseWords(self, s):
        """
        :type s: str
        :rtype: str
        """
        tmp = filter(lambda p: p != "", s.split(" "))
        tmp.reverse()
        return " ".join(tmp)