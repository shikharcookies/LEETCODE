class Solution {
    public int countSquares(int[][] matrix) {
        int[][] dp=new int[matrix.length][matrix[0].length];
        
        int count=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
              if(matrix[i][j]==0){
                  dp[i][j]=0;
              }else if(i==0){
                  dp[i][j]=1;
              }else if(j==0){
                  dp[i][j]=1;
              }else{
                  dp[i][j]=1+Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]));
              }
                count+=dp[i][j];
            }
        }
        return count;
    }
}