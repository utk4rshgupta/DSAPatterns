class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];

        for(int i =0;i<n;i++){
            if(grid[i][0] == 1 && !vis[i][0]){
                dfs(grid, i , 0 , vis);
            }
            if(grid[i][m-1] == 1 && !vis[i][m-1]){
                dfs(grid, i , m-1, vis);
            }
        }
        for(int i =0;i<m;i++){
            if(grid[0][i] == 1 && !vis[0][i]){
                dfs(grid, 0, i, vis);
            }
            if(grid[n-1][i] == 1 && !vis[n-1][i]){
                dfs(grid, n-1 , i, vis);
            }
        }
        int land_cells = 0;
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                if(grid[i][j]==1 && !vis[i][j]){
                    land_cells+=1;
                }
            }
        }
        return land_cells;
    }

    private void dfs(int[][] grid , int row , int col, boolean[][] vis){
        if(row<0 || row >= grid.length || col<0 || col >=grid[0].length )
        return ; 
        if(grid[row][col] == 0 || vis[row][col]) return; 
        vis[row][col] = true;

        dfs(grid , row+1 , col, vis );
        dfs(grid , row-1 , col, vis);
        dfs(grid , row , col+1, vis );
        dfs(grid , row , col-1, vis );
           
    }
}