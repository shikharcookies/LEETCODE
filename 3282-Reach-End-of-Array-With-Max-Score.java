class Solution {
		public long findMaximumScore(List<Integer> a) {
			int n = a.size();
			int max = 0;
			long ans = 0;
			for(int i = 0;i < n-1;i++){
				int v = a.get(i);
				max = Math.max(max, v);
				ans += max;
			}
			return ans;
		}
	}
