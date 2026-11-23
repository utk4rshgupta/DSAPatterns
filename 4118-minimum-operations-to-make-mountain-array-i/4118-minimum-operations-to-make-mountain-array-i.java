class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        if (n < 3) return -1;

        int max = 0;
        for (int x : nums) max = Math.max(max, x);

        int V = max + n;
        long INF = Long.MAX_VALUE / 4;

        long[][] left = new long[n][V + 1];
        long[] prev = new long[V + 1];
        prev[0] = INF;
        for (int v = 1; v <= V; v++) prev[v] = Math.abs((long) nums[0] - v);
        left[0] = prev;

        for (int i = 1; i < n; i++) {
            long[] curr = new long[V + 1];
            curr[0] = INF;
            long best = INF;
            for (int v = 1; v <= V; v++) {
                best = Math.min(best, prev[v - 1]);
                curr[v] = best + Math.abs((long) nums[i] - v);
            }
            left[i] = curr;
            prev = curr;
        }

        prev = new long[V + 1];
        prev[0] = INF;
        for (int v = 1; v <= V; v++) prev[v] = Math.abs((long) nums[n - 1] - v);

        long ans = INF;
        for (int i = n - 2; i >= 1; i--) {
            long[] curr = new long[V + 1];
            curr[0] = INF;
            long best = INF;
            for (int v = 1; v <= V; v++) {
                best = Math.min(best, prev[v - 1]);
                curr[v] = best + Math.abs((long) nums[i] - v);
            }
            for (int v = 1; v <= V; v++) {
                long cost = left[i][v] + curr[v] - Math.abs((long) nums[i] - v);
                ans = Math.min(ans, cost);
            }
            prev = curr;
        }
        return ans >= INF ? -1 : (int) ans;
    }
}