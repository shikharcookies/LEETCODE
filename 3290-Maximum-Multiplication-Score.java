class Solution {
    public long maxScore(int[] a, int[] b) {
        int n = b.length;
        long[] dp = new long[5];
        Arrays.fill(dp, Long.MIN_VALUE / 10);
        dp[0] = 0;
        for(int v : b){
            for(int j = 3;j >= 0;j--){
                dp[j+1] = Math.max(dp[j+1], dp[j] + (long)a[j] * v);
            }
        }       
        return dp[4];
    }
}