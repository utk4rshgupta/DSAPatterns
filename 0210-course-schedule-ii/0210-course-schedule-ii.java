class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        int[] vis = new int[numCourses];
        int[] pathVis = new int[numCourses];

        for(int i =0;i<numCourses ;i++){
            adj.add(new ArrayList<>());
        }
        for(int edge[] : prerequisites){
            adj.get(edge[1]).add(edge[0]);
        }

        Stack<Integer> st = new Stack<>();
        for(int i =0;i<numCourses ;i++){
            if(vis[i] == 0){
                if(dfs(i , adj , vis , pathVis , st)) return new int[]{};
            }
        }
        int[] ans = new int[numCourses];
        int i =0;
        while(! st.isEmpty()){
            ans[i++] = st.peek();
            st.pop();
        }
        return ans;
        
    }

    private boolean dfs(int node , ArrayList<ArrayList<Integer>> adj , int[] vis , int[] pathVis , Stack<Integer> st){
        vis[node] = 1;
        pathVis[node] = 1 ;

        for(int it : adj.get(node)){
            if(vis[it] == 0){
                if(dfs(it , adj , vis , pathVis, st)) return true;;
            }else if(pathVis[it]  == 1) return true;
        }
        st.push(node);
        pathVis[node] = 0;
        return false;
    }
}