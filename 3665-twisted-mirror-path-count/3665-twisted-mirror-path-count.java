class Solution {

    // recursion 

    // int n ;
    // int m ;
    // public int uniquePaths(int[][] grid) {

    //     n = grid.length;
    //     m = grid[0].length;
    //     return solve(n-1 , m-1, grid , false , false);
    // }
    // int solve(int i , int j , int[][] grid , boolean up_Dir , boolean left_Dir){
    //     if(i==0 && j==0) return 1;
    //     if(i<0 || j<0) return 0;

    //     if(grid[i][j] == 1){
    //         if(up_Dir){
    //             return solve(i, j-1 , grid , false , true);
    //         }else if(left_Dir){
    //             return solve(i-1 , j , grid , true , false);
    //         }
    //     }
    //     int up = solve(i-1 , j , grid , true , false);
    //     int left = solve(i , j-1 , grid , false , true);

    //     return up+left;
    //}

    static final int MOD = (int) 1e9+7;
    public int uniquePaths(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        
        int[][][] dp = new int[n][m][2];
        for(int[][] a : dp){
            for(int[] arr : a){
                Arrays.fill(arr , -1);
            }
        }
        return (solve(n-1, m-1, 0, grid, dp)) % MOD;
    }
    int solve(int i , int j , int dir , int[][] grid , int[][][] dp){
        if(i==0 && j ==0) return 1;
        if(i<0 || j<0) return 0;
        if(dp[i][j][dir] != -1) return dp[i][j][dir];

        if(grid[i][j] == 1){
            if( dir == 0){
               return dp[i][j][dir] = solve(i , j-1 , 1 , grid , dp);
            }else{
               return dp[i][j][dir]  = solve(i-1 , j , 0 , grid , dp);
            }
        }
        int up = solve(i-1 , j , 0 , grid , dp);
        int left = solve(i , j-1 , 1 , grid , dp);
        return dp[i][j][dir] = (up+left)%MOD;
    }
}