class Solution(object):

    def calculate(self, s):
        """
        :type s: str
        :rtype: int
        """
        prori = {"*":1, "/":1, "+":0, "-":0, "(":-1, ")":-1}
        is_prori = lambda a, b: prori[a] >= prori[b]
        digits  = set(map(str, range(10)))
        ops = set(["+", "-", "*", "/", "(", ")"])

        def get_value(x, y, op):
            # print root.val
            if op == "+":
                return int(x) + int(y)
            elif op == "-":
                return int(x) - int(y)
            elif op == "*":
                return int(x) * int(y)
            elif op == "/":
                return int(x) / int(y)
            else:
                return 0

        def heap_pop(heap):
            right = heap.pop()
            root  = heap.pop()
            left  = heap.pop()
            root  = get_value(left, right, root)
            heap.append(root)

        def option_pop(heap, bracket, op):
            lst_ind = 0 if len(bracket) == 0 else bracket[-1]
            if len(heap) - lst_ind >= 3 and is_prori(heap[-2], op):
                # print heap[-3].val, heap[-2].val, heap[-1].val
                heap_pop(heap)

        heap = []
        val  = ""
        bracket = []
        for i in range(len(s)):
            if s[i] in digits:
                val += s[i]
            elif s[i] in ops:
                if len(val) > 0:
                    heap.append(val)
                    option_pop(heap, bracket, s[i])
                val = ""
                if s[i] == "(":
                    bracket.append(len(heap))
                elif s[i] == ")":
                    bracket.pop()
                    index = 0 if len(bracket) == 0 else bracket[-1]
                    while len(heap) >= index + 3:
                        option_pop(heap, bracket, s[i])
                else:
                    heap.append(s[i])

        if len(val) > 0:
            heap.append(val)
            while len(heap) >= 3:
                # print heap[-3].val, heap[-2].val, heap[-1].val
                heap_pop(heap)
        
        return int(heap[0])