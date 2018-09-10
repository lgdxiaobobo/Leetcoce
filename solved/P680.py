class Solution:
    def validPalindrome(self, s):
        """
        :type s: str
        :rtype: bool
        """
        def is_palindrome(lst):
            flag = True
            size = len(lst)
            half = size >> 1
            for idx in range(half):
                if lst[idx] != lst[size - idx - 1]:
                    flag = False
                    break
            return flag
        
        def diff_one(lst1, lst2):
            size1 = len(lst1)
            size2 = len(lst2)
            i = size1 - 1
            j = 0
            cnt = 0
            flag = True
            while i >=0 and j < size2:
                if lst1[i] == lst2[j]:
                    i -= 1
                    j += 1
                elif cnt == 1:
                    flag = False
                    break
                else:
                    cnt += 1
                    if size1 > size2:
                        i -= 1
                    else:
                        j += 1
            return flag
        
        def can_be_valid(lst):
            size = len(lst)
            half = size >> 1
            if size % 2 == 0:               
                p1 = half - 1
                p2 = half
                return diff_one(lst[:p1], lst[p1+1:]) or diff_one(lst[:p2], lst[p2+1:])
            else:
                l = lst[half-1]
                m = lst[half]
                r = lst[half+1]
                if l == r and l != m and r != m:
                    return False
                else:
                    a = half - 1
                    b = half
                    c = half + 1
                    return (l == m and diff_one(lst[:a], lst[c:])) or (m == r and diff_one(lst[:b], lst[c+1:]))
                    
        return len(s) <= 2 or is_palindrome(s) or can_be_valid(s)