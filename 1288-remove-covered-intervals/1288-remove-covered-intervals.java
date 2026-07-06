class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        //boolean[] ans = new int[intervals.length];
        int ans = intervals.length;
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(b[1], a[1]);
            }
            return Integer.compare(a[0], b[0]);
        });
       boolean[] covered = new boolean[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            for (int j = i + 1; j < intervals.length; j++) {
                if (intervals[i][0] <= intervals[j][0] &&
                    intervals[i][1] >= intervals[j][1] &&
                    !covered[j]) {
                    covered[j] = true;
                    ans--;
                }
            }
        }

        return ans;

    }
}