class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int maxOR = 0;
        for(int i:nums) maxOR|= i;
        return solve(0,nums,0, maxOR);
    }

    private int solve(int i, int[] nums, int OR, int maxOR)
    {
        if(i==nums.length) 
        {
            if(OR == maxOR) return 1;
            return 0;
        }
        int ans = 0;

        //take
        ans+= solve(i+1, nums, OR|nums[i], maxOR);
        //don't take
         ans+= solve(i+1, nums, OR, maxOR);
         return ans;
    }
}