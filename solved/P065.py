class Solution(object):
    def isNumber(self, s):
        """
        :type s: str
        :rtype: bool
        """
        s = s.strip()
        if len(s) == 0:
            return False

        digits = set(map(str, range(10)))
        cnt = [0, 0]
        for ind in range(len(s)):
            print s[ind]
            if s[ind] == " ":
                return False
            elif s[ind] == "-" or s[ind] == "+":
                if ind == len(s) - 1 or (s[ind+1] not in digits and s[ind+1] != "."):
                    return False
                if ind > 0 and s[ind-1] != "e":
                    return False
            elif s[ind].lower() == "e":
                cnt[0] += 1
                if cnt[0] > 1 or ind == 0 or ind == len(s) - 1:
                    return False
                if s[ind-1] != "." and s[ind-1] not in digits:
                    return False    
                if s[ind+1] != "+" and s[ind+1] != "-" and s[ind+1] not in digits:
                    return False
            elif s[ind] == ".":
                cnt[1] += 1
                if cnt[0] > 0 or cnt[1] > 1 or (ind == 0 and ind == len(s) - 1):
                    return False
                if ind > 0:
                    if s[ind-1] == "+" or s[ind-1] == "-":
                        if ind == len(s) - 1 or s[ind+1] not in digits:
                            return False
                    elif s[ind-1] not in digits:
                        return False
                if ind < len(s) - 1:
                    if s[ind+1].lower() == "e":
                        if ind == 0 or s[ind-1] not in digits:
                            return False
                    elif s[ind+1] not in digits:
                        return False
            elif s[ind] not in digits:
                return False
        return True