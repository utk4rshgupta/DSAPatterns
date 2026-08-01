class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] dist = new int[n][m];
        boolean[][] vis = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();

        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                if(mat[i][j] == 0){
                    queue.offer(new int[]{i,j});
                    vis[i][j] = true;
                }
            }
        }

        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};


        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];

            for(int k =0;k<4;k++){
                int nr = r + dr[k];
                int nc = c + dc[k];

                if(nr >= 0 && nr < n && nc >= 0 && nc < m && !vis[nr][nc]) {
                    vis[nr][nc] = true;
                    dist[nr][nc] = dist[r][c] + 1;
                    queue.offer(new int[]{nr, nc});
                }
            }
            
        }
        return dist;
    }
}