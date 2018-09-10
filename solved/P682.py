class Solution:
    def calPoints(self, ops):
        """
        :type ops: List[str]
        :rtype: int
        """
        
        last_valid = [0]
        now_score = [0]
        for ch in ops:
            if ch == 'C':
                last = last_valid.pop()
                score = now_score[-1]
                now_score += [score - last]
            elif ch == 'D':
                gain = last_valid[-1] * 2
                score = now_score[-1]
                now_score += [score + gain]
                last_valid += [gain]
            elif ch == '+':
                gain = last_valid[-1] + last_valid[-2]
                score = now_score[-1]
                now_score += [score + gain]
                last_valid += [gain]
            else:
                gain = int(ch)
                score = now_score[-1]
                now_score += [score + gain]
                last_valid += [gain]
        return now_score[-1]
            