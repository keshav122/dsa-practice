class TwoSum_1:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        n = len(nums)
        i , j =  0, n-1
        for i in range(0,n-1):
            val = target - nums[i]
            for j in range(i+1,n):
                if(nums[j] == val):
                    return [i,j]
        
        return [0,1]
    
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        n = len(nums)
        numbers = {}
        for i in range(n):
            key = target - nums[i]
            if key in numbers:
                return [i, numbers[key]]
            else:
                numbers[nums[i]] = i
        return [-1,-1]
        