class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[n];
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : relations){
            adj.get(edge[0]-1).add(edge[1]-1);
            indegree[edge[1]-1]++;
        }
        int[] end = new int[n];
        Queue<Integer> q = new LinkedList<>();
        for(int i =0;i<n;i++){
            if(indegree[i] == 0){
                q.offer(i);
                end[i]  = time[i];
            }
        }
        while(!q.isEmpty()){
            int node = q.poll();
            for(int it: adj.get(node)){
                indegree[it]--;
                end[it] = Math.max(end[it] , end[node]+time[it]);
                if(indegree[it]==0) q.offer(it);
            }
        }
        int max =0;
        for(int j =0;j<n;j++){
            max = Math.max(max , end[j]);
        }
        return max;
    } 
}