	class Solution {
		public int maxMoves(int kx, int ky, int[][] positions) {
			int m = positions.length + 1;
			int[][][] ds = new int[m][][];
			int n = 50;
			for(int i = 0;i < m-1;i++){
				ds[i] = distMap(n, positions[i][0], positions[i][1]);
			}
			ds[m-1] = distMap(n, kx, ky);

//			for(int i = 0;i < m;i++){
//				List<Integer> dss = new ArrayList<>();
//				for(int j = 0;j < m-1;j++){
//					dss.add(ds[i][positions[j][0]][positions[j][1]]);
//				}
//				dss.add(ds[i][kx][ky]);
//				tr(dss);
//			}

			int[][] dp = new int[1<<m-1][m-1];
			for(int i = 0;i < (1<<m-1)-1;i++){
				Arrays.fill(dp[i], -1);
			}

			for(int i = (1<<m-1)-1;i >= 1;i--){
				boolean alice = Integer.bitCount(i) % 2 == 1;
				for(int j = 0;j < m-1;j++){
					if(i<<~j<0){
						for(int k = 0;k < m-1;k++){
							if(i<<~k<0 && j != k){
								if(alice){
									if(dp[i^1<<j][k] == -1)dp[i^1<<j][k] = 0;
									dp[i^1<<j][k] = Math.max(dp[i^1<<j][k], dp[i][j] + ds[k][positions[j][0]][positions[j][1]]);
								}else{
									if(dp[i^1<<j][k] == -1)dp[i^1<<j][k] = Integer.MAX_VALUE;
									dp[i^1<<j][k] = Math.min(dp[i^1<<j][k], dp[i][j] + ds[k][positions[j][0]][positions[j][1]]);
								}
							}
						}
					}
				}
			}
			int ans = 0;
			for(int i = 0;i < m-1;i++){
				ans = Math.max(ans, Math.max(0, dp[1<<i][i]) + ds[m-1][positions[i][0]][positions[i][1]]);
			}
//			for(int i = 0;i < 1<<m-1;i++){
//				for(int j = 0;j < m-1;j++){
//					tr(i, j, dp[i][j]);
//				}
//			}
			return ans;
		}

		public static int[][] distMap(int n, int sr, int sc)
		{
			int[] dr = {-2,-2,-1,-1,1,1,2,2};
			int[] dc = {-1,1,-2,2,-2,2,-1,1};
			if(n == 0)return new int[0][0];
			int m = n;

			int[][] d = new int[n][m];
			int I = 999999999;
			for(int i = 0;i < n;i++) {
				Arrays.fill(d[i], I);
			}

			Queue<int[]> q = new ArrayDeque<int[]>();
			q.add(new int[]{sr, sc});
			d[sr][sc] = 0;

			while(!q.isEmpty()){
				int[] cur = q.poll();
				int r = cur[0], c = cur[1];
				for(int k = 0;k < dr.length;k++) {
					int nr = r + dr[k], nc = c + dc[k];
					if(nr >= 0 && nr < n && nc >= 0 && nc < m){
						if(d[nr][nc] > d[r][c] + 1) {
							d[nr][nc] = d[r][c] + 1;
							q.add(new int[]{nr, nc});
						}
					}
				}
			}
			return d;
		}

	}
