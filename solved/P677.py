class MapSum:
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.kids = [{}]
        self.root = 0
        self.vocabular = set([])

    def insert(self, key, val):
        """
        :type key: str
        :type val: int
        :rtype: void
        """
        flag = key in self.vocabular
        curr = self.root
        self.vocabular.add(key)
        if flag:
            for ch in key:
                index = self.kids[curr][ch][1]
                self.kids[curr][ch] = [val, index]
                curr = index
        else:
            curr = self.root
            for ch in key:
                kids_dict = self.kids[curr]
                if ch in kids_dict:
                    self.kids[curr][ch][0] += val
                    curr = self.kids[curr][ch][1]
                else:
                    index = len(self.kids)
                    self.kids.append({})
                    self.kids[curr][ch] = [val, index]
                    curr = index            

    def sum(self, prefix):
        """
        :type prefix: str
        :rtype: int
        """
        curr = 0
        for ch in prefix[:-1]:
            if ch not in self.kids[curr]:
                return 0
            else:
                curr = self.kids[curr][ch][1]
        last = prefix[-1]
        if last in self.kids[curr]:
            return self.kids[curr][last][0]
        else:
            return 0