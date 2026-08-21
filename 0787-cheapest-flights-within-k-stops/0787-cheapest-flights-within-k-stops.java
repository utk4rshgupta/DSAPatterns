class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int a = flights.length;
        int m = flights[0].length;
        int[] dist = new int[n];

        Arrays.fill(dist , (int)1e9);
        
        List<List<int[]>> adj = new ArrayList<>();
        for(int i =0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] arr : flights){
            int u = arr[0];
            int v = arr[1];
            int price = arr[2];

            adj.get(u).add(new int[]{v , price});
        }

        Queue<int[]> pq = new LinkedList<>();
        pq.offer(new int[]{0, src , 0});

        while(!pq.isEmpty()){
            int[] arr = pq.poll();
            int stops  = arr[0];
            int city = arr[1];
            int cost = arr [2];

            if(stops>k) continue;

            for(int[] nei : adj.get(city)){
                int adjCity = nei[0];
                int adjCost = nei[1];

                int newCost = adjCost + cost;

                if(newCost < dist[adjCity] && stops<=k){
                    dist[adjCity] = newCost;
                    pq.offer(new int[]{
                        stops + 1,
                        adjCity,
                        newCost
                    });
                }
            }
        }
        if(dist[dst]== (int) 1e9) return -1;

        return dist[dst];

    }
}