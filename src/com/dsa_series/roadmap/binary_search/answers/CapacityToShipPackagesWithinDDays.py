class CapacityToShipPackagesWithinDDays:
    def shipWithinDays(self, weights, days):
        low = max(weights)
        high = sum(weights)

        ans = -1
        while low <= high:
            mid = low + ((high - low) >> 1)
            if self.possible(weights, days, mid):
                ans = mid
                high = mid - 1
            else:
                low = mid + 1
        
        return ans

    def possible(self, weights,days,capacity):
        currCap, daysReq = capacity , 1
        for i in range(len(weights)):
            if currCap >= weights[i]:
                currCap -= weights[i]
            else:
                currCap = capacity - weights[i];
                daysReq += 1

        return daysReq <= days
    
                