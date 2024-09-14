import java.util.*;

class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();
        int[][] maxHealth = new int[m][n];
        for (int[] row : maxHealth) {
            Arrays.fill(row, -1);
        }
        int startHealth = health - grid.get(0).get(0);
        if (startHealth < 1) {
            return false;
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, startHealth});
        maxHealth[0][0] = startHealth;
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int i = curr[0], j = curr[1], currHealth = curr[2];
            if (i == m - 1 && j == n - 1 && currHealth >= 1) {
                return true;
            }
            for (int[] dir : dirs) {
                int ni = i + dir[0];
                int nj = j + dir[1];
                if (ni >= 0 && ni < m && nj >= 0 && nj < n) {
                    int nextHealth = currHealth - grid.get(ni).get(nj);
                    if (nextHealth < 1) {
                        continue;
                    }
                    if (nextHealth <= maxHealth[ni][nj]) {
                        continue;
                    }
                    maxHealth[ni][nj] = nextHealth;
                    queue.offer(new int[]{ni, nj, nextHealth});
                }
            }
        }
        return false;
    }
}