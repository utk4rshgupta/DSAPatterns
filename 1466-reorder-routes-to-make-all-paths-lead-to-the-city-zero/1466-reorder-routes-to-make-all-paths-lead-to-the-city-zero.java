class Solution {
    public int minReorder(int n, int[][] connections) {
        List<List<Integer>> adjU = new ArrayList<>();
        List<List<Integer>> original = new ArrayList<>();
        for(int i =0;i<n;i++){
            adjU.add(new ArrayList<>());
            original.add(new ArrayList<>());
        }
        for(int[] edge : connections){
            int u = edge[0];
            int v = edge[1];
            adjU.get(u).add(v);
            adjU.get(v).add(u);
            original.get(u).add(v);
        }
        boolean[] vis = new boolean[n];
        int ans = dfs(0 , adjU , original , vis);
        return ans;
    }

    int dfs(int node , List<List<Integer>> adjU , List<List<Integer>> original , boolean[] vis){
        int ans =0;
        vis[node] = true;
        for(int nei : adjU.get(node)){
            if(vis[nei]) continue;
            if(original.get(node).contains(nei)) ans++;
            ans += dfs(nei , adjU , original , vis);
        }
        return ans;
    }
}