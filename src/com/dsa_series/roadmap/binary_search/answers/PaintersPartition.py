class PaintersPartition:
    def paint(self, A: int, B: int, C: list[int]) -> int:
        low = max(C)
        high = sum(C)
        
        MOD , time = 10000003 , 0
        while low <= high:
            mid = low + ((high - low) >> 1)
            if self.possible(A , C , mid):
                time = mid
                high = mid - 1
            else:
                low = mid + 1
        
        return ((time % MOD)  * (B % MOD)) % MOD
    

    def possible(self, A, C , units):
        painters,currUnits  = 1 , 0
        for unit in C:
            if currUnits + unit <= units:
                currUnits += unit
            else:
                painters += 1
                currUnits = unit
        
        return painters <= A