class Solution(object):
    def isPalindrome(self, s):
        """
        :type s: str
        :rtype: bool
        """
        l = 0
        r = len(s) - 1
        
        is_digit = lambda x: x >= '0' and x <= '9'
        is_alpha = lambda x: x >= 'a' and x <= 'z'
        is_valid = lambda x: is_digit(x) or is_alpha(x)
        
        while l < r:
            while not is_valid(s[l].lower()) and l < len(s) - 1:
                l += 1
            while not is_valid(s[r].lower()) and r > 0:
                r -= 1
            if l >= r:
                break
            if s[l].lower() != s[r].lower():
                return False
            else:
                l += 1
                r -= 1
        return True
                
            