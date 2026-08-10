class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] vis = new int[numCourses];
        int[] pathVis = new int[numCourses];
        
        List<List<Integer>> adj= new ArrayList<>();
        for(int i =0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] prereq : prerequisites){
            adj.get(prereq[1]).add(prereq[0]);
        }

        for(int i =0 ; i<numCourses;i++){
            if(vis[i] == 0){
                if(dfs(i , adj, vis , pathVis)) return false;
            }
        }
        return true ;
    }

    private boolean dfs( int node ,List<List<Integer>> adj , int[] vis , int[] pathVis){
        vis[node] = 1 ;
        pathVis[node] = 1;

        for(int it : adj.get(node)){
            
            if(vis[it] == 0){
                if(dfs(it , adj , vis , pathVis)) return true;
            }
            else if(pathVis[it]==1){
                return true;
            }
           
        }
        pathVis[node] = 0;
        return false;
    }
}