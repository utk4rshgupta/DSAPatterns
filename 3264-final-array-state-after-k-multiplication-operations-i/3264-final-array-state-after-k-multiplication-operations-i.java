class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
        if (a[0] != b[0]) {
            return Integer.compare(a[0], b[0]);
        }
        return Integer.compare(a[1], b[1]);
        });
        int a =0;
        for(int num : nums){
            pq.offer(new int[]{num , a++});
        }
        for(int i =0;i<k;i++){
            int[] arr = pq.peek();
            int num = arr[0];
            int index = arr[1];
            num *=multiplier;
            pq.remove();
            pq.offer(new int[]{num , index});
        }
        int[] ans = new int[nums.length];
        while(!pq.isEmpty()){
            int[] arr = pq.peek();
            int num = arr[0];
            int index = arr[1];
            ans[index] = num;
            pq.remove();

        }
        return ans;
    }
}