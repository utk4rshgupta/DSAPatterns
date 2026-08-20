class Solution {
    int n, m;
    int[][] heights;
    PriorityQueue<int[]> pq;
    public int minimumEffortPath(int[][] heights) {
        this.heights = heights;
        n = heights.length;
        m = heights[0].length;
        int[][] dist = new int[n][m];
        for(int[] row : dist){
            Arrays.fill(row , (int)1e9);
        }
        pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0],b[0]));
        dist[0][0] =0;
        pq.offer(new int[]{0,0,0});

        while(!pq.isEmpty()){
            int curr[] = pq.poll();
            int effort = curr[0];
            int row = curr[1];
            int col = curr[2];

            if(row == n-1 && col == m-1) return effort;

            move(effort , dist , row , col ,  row+1 , col );
            move(effort , dist , row , col ,  row-1 , col );
            move(effort , dist , row , col ,  row  , col+1);
            move(effort , dist , row , col ,  row  , col-1);
        }
        return 0;
    }

    private void move(int effort , int[][] dist ,int row , int col, int newRow , int newCol){
        int n = heights.length;
        int m = heights[0].length;
        if(newRow < 0 || newRow >= n ||
            newCol < 0 || newCol >= m) {
            return;
        }
        int newEffort = Math.max(
            effort,
            Math.abs(
                heights[row][col] -
                heights[newRow][newCol]
            )
        );
        if(newEffort < dist[newRow][newCol]){
            dist[newRow][newCol] = newEffort;
            pq.offer(new int[]{newEffort , newRow , newCol});
        }

    }
}