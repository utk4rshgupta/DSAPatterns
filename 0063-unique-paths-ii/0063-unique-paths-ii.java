class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] dp = new int[n][m];
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
              dp[i][j] = -1;
            }
        }
        fun(n -1, m -1, dp,obstacleGrid);
        return dp[n-1][m-1];
        
    }
    int fun(int n , int m , int[][] dp,int[][] obstacleGrid){
        if(n>=0 && m>=0 && obstacleGrid[n][m] == 1) return 0;
            if(n==0 && m==0) return 1;
            if(n<0 || m<0) return 0;
            if (dp[n][m] != -1) {
            return dp[n][m];
        }

            int left = fun(n-1 , m ,dp,obstacleGrid);
            int up = fun(n , m-1 , dp,obstacleGrid);

            return dp[n][m] = up+left;
        }
}