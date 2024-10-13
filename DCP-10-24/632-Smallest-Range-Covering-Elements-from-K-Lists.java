import java.util.*;

class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int k = nums.size();
        int left = nums.get(0).get(0);
        int right = nums.get(0).get(0);
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < k; i++) {
            int val = nums.get(i).get(0);
            left = Math.min(left, val);
            right = Math.max(right, val);
            minHeap.offer(new int[]{val, i, 0});
        }
        int[] res = new int[]{left, right};
        while (true) {
            int[] top = minHeap.poll();
            int n = top[0];
            int i = top[1];
            int idx = top[2];
            idx++;
            if (idx == nums.get(i).size()) {
                return res;
            }
            int nextVal = nums.get(i).get(idx);
            minHeap.offer(new int[]{nextVal, i, idx});
            right = Math.max(right, nextVal);
            left = minHeap.peek()[0];
            if (right - left < res[1] - res[0]) {
                res = new int[]{left, right};
            }
        }
    }
}