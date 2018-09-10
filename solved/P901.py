class StockSpanner:

    def __init__(self):
        self.lst = []
        self.size = 0
        self.index = -1

    def next(self, price):
        """
        :type price: int
        :rtype: int
        """
        self.index += 1
        if self.size == 0:
            self.lst.append((price, self.index))
            self.size = self.size + 1
            return 1
        else:
            if self.lst[-1][0] > price:
                self.lst.append((price, self.index))
                self.size = self.size + 1
                return self.index - self.lst[-2][1]
            elif self.lst[0][0] <= price:
                self.lst = [(price, self.index)]
                self.size = 1
                return self.index + 1
            else:
                left = 0
                right = self.size - 1
                while left + 1 < right:
                    mid = left + right >> 1
                    if self.lst[mid][0] == price:
                        left = right = mid
                    elif self.lst[mid][0] > price:
                        left = mid
                    else:
                        right = mid
                left = left + 1
                while left >= 0 and self.lst[left][0] <= price:
                    left -= 1
                left += 1
                self.lst = self.lst[:left] + [(price, self.index)]
                self.size = left + 1
                # print(self.lst, self.size, price, left)
                return self.index - self.lst[left-1][1]
            
# Your StockSpanner object will be instantiated and called as such:
# obj = StockSpanner()
# param_1 = obj.next(price)