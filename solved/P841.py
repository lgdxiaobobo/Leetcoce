class Solution:
    def canVisitAllRooms(self, rooms):
        """
        :type rooms: List[List[int]]
        :rtype: bool
        """
        N = len(rooms)
        visit = set([0])
        
        while len(visit) < N:
            update = []
            for x in visit:
                update.append(x)
                update += rooms[x]
            if len(set(update)) == len(visit):
                break
            visit = set(update)
        
        return len(visit) == N