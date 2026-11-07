class Solution {
    int r ;
    int c ;
    public int cherryPickup(int[][] grid) {
        r = grid.length;
        c = grid[0].length;
        int[][][] dp = new int[r][c][c];
        for(int[][] rows : dp){
            for(int[] row : rows){
                Arrays.fill(row , -1);
            }
        }
        return pickup(0 , 0 , c-1 , grid, dp);

    }
    int pickup(int i , int j1, int j2 , int[][] grid , int[][][] dp){
        if(j1<0 || j2<0 || j1>=c || j2>=c) return (int)-1e9;
        if(i == r-1){
            if(j1==j2) return grid[i][j1];
            else return grid[i][j1]+grid[i][j2];
        }
        if(dp[i][j1][j2] != -1) return dp[i][j1][j2];

        int maxi =0;
        for(int dj1=-1; dj1<=1; dj1++){
            for(int dj2=-1;dj2<=1;dj2++){
                int value =0;
                if(j1==j2) value = grid[i][j1];
                else value = grid[i][j1] + grid[i][j2];
                value += pickup(i+1 , j1+dj1 , j2+dj2, grid, dp);
                maxi = Math.max(value , maxi);
            
            }
        }
        return dp[i][j1][j2] = maxi;
    }
}