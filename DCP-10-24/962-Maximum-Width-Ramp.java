class Solution {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        int[] rightMax = new int[n];
        rightMax[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], nums[i]);
        }

        int l = 0, r = 0, rslt = 0;

        while (r < n) {
            while (l < r && nums[l] > rightMax[r]) {
                l++;
            }
            rslt = Math.max(rslt, r - l);
            r++;
        }

        return rslt;
    }
}