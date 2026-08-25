class Solution {
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<long[]>> adj = new ArrayList<>();
        for(int i =0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] arr : roads){
            int u = arr[0];
            int v = arr[1];
            int weights = arr[2];

            adj.get(u).add(new long[]{v , weights});
            adj.get(v).add(new long[]{u , weights});
        }
        long[] ways = new long[n];
        
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);

        long mod = (long) 1e9 + 7;

        PriorityQueue<long[]> q = new PriorityQueue<>((a,b) -> Long.compare(a[0] , b[0]));
        q.add(new long[]{0,0});

        ways[0] =1;
        dist[0] =0;

        while(!q.isEmpty()){
            long[] arr = q.poll();
            long dis = arr[0];
            long node = arr[1];

            if(dis > dist[(int)node]) continue;

            for(long[] edge : adj.get((int) node)){
                long adjNode = edge[0];
                long edgeWt = edge[1];

                if(dist[(int) adjNode] > dis + edgeWt){
                    dist[(int) adjNode] = dis + edgeWt;
                    ways[(int) adjNode ] = ways[(int)node];

                    q.offer(new long[]{dist[(int) adjNode] , adjNode});
                } else if(dis+edgeWt == dist[(int) adjNode]){
                    ways[(int) adjNode] = (ways[(int) adjNode] + ways[(int) node]) % mod;
                }
            }
            
        }
        return (int) ways[n - 1];
        
    }
}