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
            print x, op, y
            # print root.val
            if op == "+":
                return x + y
            elif op == "-":
                return x - y
            elif op == "*":
                return x * y
            elif op == "/":
                return x / y
            else:
                return 0

        def heap_pop(heap):
            right = heap.pop()
            root  = heap.pop()
            left  = heap.pop()
            root  = get_value(left, right, root)
            heap.append(root)

        def option_pop(heap, op):
            while len(heap) >= 3 and is_prori(heap[-2], op):
                heap_pop(heap)

        heap = []
        val  = ""
        bracket = []
        for i in range(len(s)):
            if s[i] in digits:
                val += s[i]
            elif s[i] in ops:
                if len(val) > 0:
                    heap.append(int(val))
                    option_pop(heap, s[i])
                val = ""
                heap.append(s[i])

        if len(val) > 0:
            heap.append(int(val))
            while len(heap) >= 3:
                heap_pop(heap)
        
        return int(heap[0])