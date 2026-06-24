class Solution {
    private int dist(int[] p){
           return p[0] * p[0] + p[1] * p[1];
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
        (a, b) -> dist(b) - dist(a)
        );

        for (int[] point : points) {
            maxHeap.offer(point);

            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        int[][] ans = new int[k][2];
         for (int i = k - 1; i >= 0; i--) {
            ans[i] = maxHeap.poll();
        }
        return ans;
    }
}