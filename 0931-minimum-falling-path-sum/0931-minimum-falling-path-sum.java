class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        for(int i =0;i<n;i++){
            dp[0][i] = matrix[0][i];
        }

        for(int i =1;i<n;i++){
            for(int j =0;j<n;j++){
                int s = dp[i-1][j] + matrix[i][j];
                int ld = (int) 1e9;
                if (j > 0) {
                    ld = matrix[i][j] + dp[i-1][j-1];
                }

                int rd = (int) 1e9;
                if (j < n-1) {
                    rd = matrix[i][j] + dp[i-1][j+1];
                }

                dp[i][j] = Math.min(s, Math.min(ld, rd));
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 0;i<n;i++){
            ans = Math.min(ans , dp[n-1][i]);
        }
        return ans;
    }
}