class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] vis = new int[numCourses];
        int[] pathVis = new int[numCourses];
        
        for(int i =0 ; i<numCourses;i++){
            if(vis[i] == 0){
                if(dfs(i , prerequisites, vis , pathVis)) return false;
            }
        }
        return true ;
    }

    private boolean dfs( int node , int[][] prerequisites , int[] vis , int[] pathVis){
        vis[node] = 1 ;
        pathVis[node] = 1;

        for(int edge[] : prerequisites){
            
            if(edge[1] == node){
                if(vis[edge[0]]==0){
                    if(dfs(edge[0] , prerequisites , vis , pathVis)) return true;

                }
                else if(pathVis[edge[0]]==1){
                return true;
            }
           
            }
        }
        pathVis[node] = 0;
        return false;
    }
}