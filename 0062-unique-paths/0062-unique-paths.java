class Solution {
    public int uniquePaths(int m, int n) {
        if(m==1 && n==1) return 1;
        int[][] dp = new int[m][n];
        for(int[] edge : dp){
            Arrays.fill(edge ,-1);
        }
        f(m-1,n-1,dp);
        return dp[m-1][n-1];
    }
    int f(int m , int n , int[][] dp){
        if(m==0 && n==0) return 1;
        if(m<0 || n<0) return 0;
        if(dp[m][n] != -1) return dp[m][n];
        int left = f(m-1 ,n ,dp);
        int up = f(m , n-1,dp);

        return dp[m][n]= left + up;
    }
}