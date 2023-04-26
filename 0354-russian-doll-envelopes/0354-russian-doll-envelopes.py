class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        # nums = [10,9,2,5,3,7,101,18]

        # let dp[i] is the length of LIS which has nums[i] as the end of the subsequence
        # dp[0] = 1, [10]
        # dp[1] = 1, [9]
        # dp[2] = 1, [2]
        # dp[3] = 2, [2, 5]
        # dp[4] = 2, [2, 3]
        # dp[5] = 3, [2, 3, 7]
        # dp[6] = 4, [2, 3, 7, 101]
        # dp[7] = 4, [2, 3, 7, 18]
        

        n = len(nums)
        sub = []
        for i in range(n):
            if not sub or nums[i] > sub[-1]:
                sub.append(nums[i])
            else:
                x = bisect_left(sub, nums[i]) 
                sub[x] = nums[i]           

        return len(sub)

        # Time: O(N^2)
        # Space: O(1)


    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        envelopes.sort(key = lambda x:[x[0], -x[1]])
        arr = [h for _, h in envelopes]
        return self.lengthOfLIS(arr)