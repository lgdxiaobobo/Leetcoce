class Solution(object):
    def ambiguousCoordinates(self, S):
        """
        :type S: str
        :rtype: List[str]
        """
        
        def is_valid(lst):
            ind = lst.find(".")
            if ind == -1:
                return len(lst) == 1 or lst[0] != "0"
            else:
                x_left = lst[:ind]
                x_right = lst[ind+1:]

                return (len(x_left) == 1 or x_left[0] != '0') and x_right[-1] != '0'


        def all_valid(lst):
            tmp = []
            l = len(lst)
            if len(lst) > 0 and is_valid(lst):
                tmp.append(lst)
            for d_pos in xrange(1, l):
                val = lst[:d_pos] + "." + lst[d_pos:]
                if is_valid(val):
                    tmp.append(val)
            return tmp

        digits = S[1:-1]
        nDigit = len(digits)
        res = []
        for i in xrange(1, nDigit):
            left = all_valid(digits[:i])
            right = all_valid(digits[i:])
            if len(left) > 0 and len(right) > 0:               
                for x in left:
                    for y in right:
                        res.append('(' + x + ", " + y + ")")

        return res