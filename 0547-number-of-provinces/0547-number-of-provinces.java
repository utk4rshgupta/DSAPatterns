class Solution {
    public int findCircleNum(int[][] isConnected){   
        // int n = isConnected.length;
        // boolean vis[]  = new boolean[n];
        // int count =0;

        // for(int i =0;i<n;i++){
        //     if()
        // }

        int n = isConnected.length;
        ArrayList<ArrayList<Integer>> adjL = new ArrayList<>();

        for(int i =0;i<n;i++){
            adjL.add(new ArrayList<>());
        }

        for(int i =0;i<n;i++){
            for(int j =0;j<n;j++){
                if(i != j && isConnected[i][j] == 1){
                    adjL.get(i).add(j);

                }
            }
        }
        int vis[] = new int[n];
        int cnt =0;
        for(int i =0;i<n;i++){
            if(vis[i]==0){
                cnt++;
                dfs(i, adjL,vis);
            }
        }
        return cnt;

    }
    static void dfs(int node , ArrayList<ArrayList<Integer>> adjL, int vis[] ){
        vis[node] = 1;
        for(int i :adjL.get(node)){
            if(vis[i]==0){
                dfs(i, adjL,vis);
            }
        }
    }
    
}