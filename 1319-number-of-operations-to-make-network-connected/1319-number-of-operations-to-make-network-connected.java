class Solution {
    public int makeConnected(int n, int[][] connections) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i =0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:connections){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] vis = new boolean[n];
        int count =0;
        for(int i =0;i<n;i++){
            if(!vis[i]){
                count++;
                dfs(i , vis , adj);
            }
        }

        if(connections.length>=n-1){
            return count-1;
        }
        return -1;


    }

    void dfs(int node , boolean[] vis , ArrayList<ArrayList<Integer>> adj){
        vis[node ] = true;
        for(int neigh : adj.get(node)){
            if(!vis[neigh]){
                vis[neigh] = true;
                dfs(neigh , vis , adj);
            }
        }
    }
}