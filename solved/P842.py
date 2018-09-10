class Solution:
    def splitIntoFibonacci(self, S):
        """
        :type S: str
        :rtype: List[int]
        """
        max_value = 2147483648
        def get_fibs(a, b, r):
            answer = [a, b]
            while len(r) > 0:
                c = a + b
                if c >= max_value:
                    break
                c_str = str(c)
                if not r.startswith(c_str):
                    break
                r = r[len(c_str):]
                answer.append(c)
                a = b
                b = c
            if len(r) == 0:
                return answer
            else:
                return []
            
        def one_fib(a, r):
            if r[0] == "0":
                return get_fibs(a, 0, r[1:])
            else:
                for idx in range(1, len(r)):
                    b = int(r[:idx])
                    tmp = get_fibs(a, b, r[idx:])
                    if len(tmp) > 0:
                        return tmp
                return []
        
        if len(S) < 3:
            return []
        else:
            if S[0] == "0":
                return one_fib(0, S[1:])
            else:
                for idx in range(1, len(S)):
                    a = int(S[:idx])
                    tmp = one_fib(a, S[idx:])
                    if len(tmp) > 2:
                        for idx in range(2, len(tmp)):
                            print(tmp[idx-2], tmp[idx-1], tmp[idx-2]+tmp[idx-1]-tmp[idx])
                        print(int("".join([str(x) for x in tmp]))-int(S))
                        return tmp
                return []
                
            