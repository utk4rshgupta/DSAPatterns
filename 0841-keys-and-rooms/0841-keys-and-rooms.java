class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] vis = new boolean[rooms.size()];
        vis[0] = true;
        dfs(0 , vis , rooms);
        for(int i =0 ;i<vis.length;i++){
            if(!vis[i]) return false;
        }
        return true;
    }
    void dfs(int node , boolean[] vis , List<List<Integer>> rooms){
        vis[node] = true;
        for(int it : rooms.get(node)){
            if(vis[it] == false) dfs(it , vis , rooms);
        }
        return;
    }
}