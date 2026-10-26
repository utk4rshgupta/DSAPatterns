class Solution {
    public int countIslands(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;
        long MOD =(long)1e9;
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                if(grid[i][j] != 0){
                    long sum = dfs(i , j , grid);
                    if(sum%k==0) ans++;
                }
            }
        }
        return ans;
    }

    long dfs(int i , int j , int[][] grid){
        if(i>=grid.length ||  i<0 || j<0 || j>=grid[0].length) return 0;
        if(grid[i][j] == 0) return 0;
        long ans =0;
        ans += grid[i][j];
        grid[i][j] = 0;
        ans += dfs(i+1, j, grid);
        ans += dfs(i-1, j, grid);
        ans += dfs(i, j+1, grid);
        ans += dfs(i, j-1, grid);
        return ans;
    }
}