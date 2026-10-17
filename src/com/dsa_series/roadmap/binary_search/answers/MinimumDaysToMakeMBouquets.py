class MinimumDaysToMakeMBouquets:

     def roseGarden(self, n, nums, k, m):
        if k * m > n:
            return -1
        low = min(nums)
        high = max(nums)
        
        ans = -1
        while(low <= high):
            mid = low + ((high - low) >> 1)
            if self.possible(n, nums, mid, k, m):
                ans = mid
                high = mid -1
            else:
                low = mid + 1
        
        return ans

    
     def possible(self, n, nums, day, k, m):
        cnt = noOfBouquets = 0
        for i in range(n):
            if nums[i] <= day:
                cnt += 1
            else:
                noOfBouquets += (cnt//k)
                cnt = 0
        
        noOfBouquets += (cnt//k)
        return noOfBouquets >= m

    
    



