class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
         Collections.sort(robot);
        Arrays.sort(factory, (a, b) -> Integer.compare(a[0], b[0]));

        int n = robot.size();
        int m = factory.length;

        // Step 2: Initialize the DP array with a large value (using Long.MAX_VALUE)
        long[][] dp = new long[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Long.MAX_VALUE);
        }
        dp[0][0] = 0;  // No cost if no robots and no factories are used

        // Step 3: Fill DP array
        for (int j = 1; j <= m; j++) {  // For each factory
            int pos = factory[j - 1][0];
            int limit = factory[j - 1][1];
            dp[0][j] = 0;  // No robots to assign, cost is 0

            if (limit == 0) {
                // Skip factories with a repair limit of 0
                for (int i = 1; i <= n; i++) {
                    dp[i][j] = dp[i][j - 1];
                }
                continue;
            }

            for (int i = 1; i <= n; i++) {  // For each number of robots to repair up to i
                dp[i][j] = dp[i][j - 1];  // Start with the cost of skipping this factory
                long distSum = 0;  // Cumulative distance for robots assigned to this factory

                // Try assigning up to 'limit' robots to this factory
                for (int k = 1; k <= Math.min(limit, i); k++) {
                    distSum += Math.abs((long) robot.get(i - k) - pos);  // Calculate distance for k-th robot
                    if (dp[i - k][j - 1] != Long.MAX_VALUE) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - k][j - 1] + distSum);
                    }
                }
            }
        }

        // Minimum distance for all robots using all factories
        return dp[n][m];
    
    }
}