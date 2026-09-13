class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] vis = new boolean[rooms.size()];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while(!q.isEmpty()){
            int node = q.poll();
            vis[node] = true;
            for(int it : rooms.get(node)){
                if(!vis[it]){
                    q.add(it);
                    vis[it] = true;
                }
            }
        }
        for(int i =0;i<vis.length;i++){
            if(vis[i] == false) return false;
        }
        return true;
    }
}