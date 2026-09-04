class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> adj =new ArrayList<>();
        for(int i =0;i<n;i++){
            adj.add(new ArrayList<>());  
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] vis = new boolean[n];
        dfs(source , vis , adj);
        return vis[destination];
    }

    void dfs(int node , boolean[] vis , ArrayList<ArrayList<Integer>> adj){
        vis[node] = true;

        for(int neigh : adj.get(node)){
                if(!vis[neigh]){
                    dfs(neigh , vis , adj);
                }
        }
    }
}