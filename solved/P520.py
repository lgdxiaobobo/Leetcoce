class Solution:
    def detectCapitalUse(self, word):
        """
        :type word: str
        :rtype: bool
        """
        def is_upper(ch):
            return ch == ch.upper()
        
        flag = True
        if not is_upper(word[0]):
            for ch in word[1:]:
                if is_upper(ch):
                    flag = False
                    break
        else:
            size = len(word) - 1
            remains = [is_upper(ch) for ch in word[1:]]
            all_upper = len([x for x in remains if x])
            all_lower = len([x for x in remains if not x])
            if size != all_upper and size != all_lower:
                flag = False
        return flag
            
                
        
        