class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        boolean[][] vis = new boolean[n][m];

        for(int i =0 ;i<n ;i++){
            if(board[i][0] == 'O' && !vis[i][0]) dfs(board, i , 0, vis);
            if(board[i][m-1] == 'O' && !vis[i][m-1]) dfs(board,i,m-1,vis);  
        }
        for(int i =0;i<m;i++){
            if(board[0][i] == 'O' && !vis[0][i]) dfs(board , 0 , i,vis);
            if(board[n-1][i]== 'O' && !vis[n-1][i]) dfs(board , n-1,i,vis);
        }

        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                if(board[i][j] == 'O' && !vis[i][j]){
                    board[i][j] = 'X';
                }
            }
        }
    }
    private void dfs(char[][] board , int row , int col , boolean[][] vis){

        if(row < 0 || row>=board.length || col <0 || col >= board[0].length) return ;
        if(board[row][col] == 'X' || vis[row][col]) return; 

        vis[row][col] = true;

        dfs(board , row+1 , col ,vis);
        dfs(board , row-1 , col ,vis);
        dfs(board , row , col+1 ,vis);
        dfs(board , row , col-1 ,vis);

    }
}