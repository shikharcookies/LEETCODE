class Solution {
    private static final int max = 128;

    public int maxValue(int[] nums, int k) {
        boolean[][] dp = new boolean[nums.length][max];
        {
            boolean[][] isMet = new boolean[max][k + 1];
            List<int[]> valid = new ArrayList<>();
            valid.add(new int[]{0, 0});
            isMet[0][0] = true;

            for (int i = nums.length - 1; i >= 0; --i) {
                List<int[]> nextValid = new ArrayList<>();
                for (int[] tmp : valid) {
                    nextValid.add(tmp);
                    if (tmp[1] + 1 <= k && !isMet[tmp[0] | nums[i]][tmp[1] + 1]) {
                        isMet[tmp[0] | nums[i]][tmp[1] + 1] = true;
                        nextValid.add(new int[]{tmp[0] | nums[i], tmp[1] + 1});
                    }
                    if (tmp[1] + 1 == k) {
                        dp[i][tmp[0] | nums[i]] = true;
                    }
                    if (tmp[1] == k) {
                        dp[i][tmp[0]] = true;
                    }
                }
                valid = nextValid;
            }
        }

        int res = 0;
        {
            boolean[] isLeftMet = new boolean[max];
            boolean[][] isMet = new boolean[max][k + 1];
            List<int[]> valid = new ArrayList<>();
            valid.add(new int[]{0, 0});
            isMet[0][0] = true;

            for (int i = 0; i < nums.length; ++i) {
                List<int[]> nextValid = new ArrayList<>();
                for (int[] tmp : valid) {
                    nextValid.add(tmp);
                    if (tmp[1] + 1 <= k && !isMet[tmp[0] | nums[i]][tmp[1] + 1]) {
                        isMet[tmp[0] | nums[i]][tmp[1] + 1] = true;
                        nextValid.add(new int[]{tmp[0] | nums[i], tmp[1] + 1});
                    }
                    if (tmp[1] + 1 == k && !isLeftMet[tmp[0] | nums[i]] && i + 1 < nums.length) {
                        int orResult = tmp[0] | nums[i];
                        isLeftMet[orResult] = true;
                        for (int j = 1; j < max; ++j) {
                            if (dp[i + 1][j]) {
                                res = Math.max(res, orResult ^ j);
                            }
                        }
                    }
                }
                valid = nextValid;
            }
        }
        return res;
    }
}