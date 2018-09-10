class Solution(object):
    def maskPII(self, S):
        """
        :type S: str
        :rtype: str
        """
        if S.find('@') > -1:
            tmp1 = S.lower()
            idx = tmp1.find('@')
            name1 = tmp1[:idx]
            personal = name1[0:1] + '*****' + name1[-1:]
            return personal + tmp1[idx:]
        else:
            digits = [x for x in S if x.isdigit()]
            if len(digits) == 10:
                return '***-***-' + "".join(digits[-4:])
            else:
                if len(digits) == 11:
                    prefix = '*'
                elif len(digits) == 12:
                    prefix = '**'
                else:
                    prefix = '***'
                return '+' + prefix + '-***-***-' + "".join(digits[-4:])