class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
    List<Integer> safe = new ArrayList<>();
    List<List<Integer>> adjRev = new ArrayList<>();
    int[] indegree = new int[graph.length];

    for(int i =0;i<graph.length;i++){
        adjRev.add(new ArrayList<>());
    }
    for(int i =0;i<graph.length;i++){
    for(int edge : graph[i]){
        adjRev.get(edge).add(i);
        indegree[i]++;
    }
    }
    Queue<Integer> q = new LinkedList<>();
    for(int i =0;i<graph.length;i++){
        if(indegree[i] == 0) q.offer(i);
    }

    while(!q.isEmpty()){
        int node = q.poll();
        safe.add(node);

        for(int it : adjRev.get(node)){
            indegree[it]--;
            if(indegree[it]==0) q.offer(it);
        }
    }
    Collections.sort(safe);
    return safe;
    }
}