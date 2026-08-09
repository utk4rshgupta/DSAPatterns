class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
     List<Integer> safe = new ArrayList<>();
     int[] vis = new int[graph.length];
     int[] pathVis = new int[graph.length];
     int[] check = new int[graph.length];

     for(int i =0;i<graph.length;i++){
        if(vis[i]==0){
            dfs(i , graph , vis , pathVis , check);
        }
     }
     for(int i =0;i<check.length;i++){
        if(check[i] == 1) safe.add(i);
     } 

     return safe;  
    }

    private boolean dfs(int node , int[][] graph , int[] vis , int[] pathVis , int[] check){
        vis[node] = 1;
        pathVis[node] = 1;
        check[node] = 0;

        for(int i : graph[node]){
            if(vis[i]==0){
                if(dfs(i , graph , vis , pathVis, check)) return true;
            }
            else if(pathVis[i] == 1 ) return true;
        }
        check[node] = 1 ; 
        pathVis[node] = 0;
        return false;
    }
}