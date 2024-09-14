class Solution {
    public int maxPathLength(int[][] coordinates, int k) {
        Integer[] sort = new Integer[coordinates.length];
        for (int i = 0; i < coordinates.length; ++i) {
            sort[i] = i;
        }
        Arrays.sort(sort, (a, b) -> (coordinates[a][0] == coordinates[b][0]
                ? Integer.compare(coordinates[b][1], coordinates[a][1]) : Integer.compare(coordinates[a][0], coordinates[b][0])));
        int[] dp = new int[coordinates.length];
        int initial = -1, p = 0;
        for (int i : sort) {
            if (i == k) {
                initial = binarySearchPos(dp, p, coordinates[i][1]);
                dp = new int[coordinates.length];
                dp[0] = coordinates[i][1];
                p = 1;
            } else {
                int tmp = binarySearchPos(dp, p, coordinates[i][1]);
                if (initial != -1) {
                    if (tmp != 0) {
                        dp[tmp] = coordinates[i][1];
                    }
                } else {
                    dp[tmp] = coordinates[i][1];
                }
                if (tmp == p) {
                    ++p;
                }
            }
        }
        return initial + p;
    }

    private int binarySearchPos(int[] dp, int pos, int num) {
        if (pos == 0 || dp[pos - 1] < num) {
            return pos;
        }
        int st = 0, ed = pos;
        while (st < ed) {
            int mid = (st + ed) / 2;
            if (dp[mid] < num) {
                st = mid + 1;
            } else {
                ed = mid;
            }
        }
        return st;
    }
}