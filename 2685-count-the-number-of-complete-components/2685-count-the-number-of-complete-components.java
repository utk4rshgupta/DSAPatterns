class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i =0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int ans =0;
        boolean[] vis = new boolean[n];
        for(int i =0;i<n;i++){
            if(!vis[i]){
                List<Integer> degree = new ArrayList<>();
                dfs(i , adj , vis , degree);

                boolean isComplete = true;
                for(int it : degree){
                    if(adj.get(it).size() != degree.size()-1) {
                        isComplete = false;
                        break;
                    }
                }
                if(isComplete) ans++;
            }
        }
        return ans;
    }
    void dfs(int node , ArrayList<ArrayList<Integer>> adj , boolean[] vis , List<Integer> degree){
        vis[node] = true;
        degree.add(node);
        for(int it : adj.get(node)){
            if(!vis[it]) dfs(it , adj , vis , degree);
        }
    }
}