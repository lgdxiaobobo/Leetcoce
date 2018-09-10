class Solution(object):
    def bestRotation(self, A):
        """
        :type A: List[int]
        :rtype: int
        """
        N = len(A)
        if N == 0:
            return 0
        else:
            loss_dct = {}
            score0 = 0
            for i in xrange(N):
                ai = A[i]
                ki = (i - ai + N) % N
                if not loss_dct.has_key(ki):
                    loss_dct[ki] = 0
                loss_dct[ki] += 1
                if ai <= i:
                    score0 += 1

            max_score = score0
            best_k    = 0
            prev_score= score0
            for k in xrange(1, N):
                score = prev_score
                if A[k-1] >= 0:
                    score += 1
                if loss_dct.has_key(k - 1):
                    score -= loss_dct[k - 1]
                if score > max_score:
                    max_score = score
                    best_k = k

                prev_score = score
            return best_k

            
