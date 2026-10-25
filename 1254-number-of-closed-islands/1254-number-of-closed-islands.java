class Solution {
    public int closedIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
                for (int i = 0; i < n; i++) {
            dfsBoundary(i, 0, grid);
            dfsBoundary(i, m - 1, grid);
        }

        for (int j = 0; j < m; j++) {
            dfsBoundary(0, j, grid);
            dfsBoundary(n - 1, j, grid);
        }

        int closedIsland = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    dfs(i, j, grid);
                    closedIsland++;
                }
            }
        }

        return closedIsland;
    }

    void dfsBoundary(int i, int j, int[][] grid) {
        if (i < 0 || i >= grid.length ||
            j < 0 || j >= grid[0].length ||
            grid[i][j] == 1) {
            return;
        }

        grid[i][j] = 1;

        dfsBoundary(i - 1, j, grid);
        dfsBoundary(i + 1, j, grid);
        dfsBoundary(i, j - 1, grid);
        dfsBoundary(i, j + 1, grid);
    }

    void dfs(int i , int j , int[][] grid){
        if(i>=grid.length || i<0 || j>=grid[0].length || j<0) return;
        
        
        if (grid[i][j] == 1) {
            return;
        }
        grid[i][j] = 1;
        dfs(i - 1, j, grid); // Up
        dfs(i + 1, j, grid); // Down
        dfs(i, j - 1, grid); // Left
        dfs(i, j + 1, grid); // Right
        
    }
}