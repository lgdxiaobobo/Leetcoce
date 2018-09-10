class Solution(object):
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: List[str]
        :rtype: bool
        """
        status = set([])
        def is_matched(s):
            if len(s) == 0:
                return True
            flag = False
            for word in wordDict:
                if s.startswith(word):
                    l = len(s) - len(word)
                    if l in status:
                        flag = False
                    else:
                        flag = is_matched(s[len(word):])
                        if flag:
                            break
                        else:
                            status.add(l)
            return flag
        return is_matched(s)
        