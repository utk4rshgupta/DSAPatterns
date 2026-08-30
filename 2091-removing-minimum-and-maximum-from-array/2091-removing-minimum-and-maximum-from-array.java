class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        if(n == 1) return 1;
        if(n == 2) return 2;
        int iMin = 0;
        int iMax = 0;
        int min = nums[0];
        int max = nums[0];

        for(int i =0;i<n;i++){
            if(nums[i] < min){
                min = nums[i];
                iMin = i;
            }
            if(nums[i] > max){
                max = nums[i];
                iMax = i;
            }
        }
        int first_move = Math.max(iMin , iMax) +1;
        int sec_move = n-Math.min(iMin , iMax );
        int third_move = Math.min(iMax + n -iMin +1 , iMin + n- iMax +1);

        int ans = Math.min(third_move, Math.min(first_move , sec_move));
        return ans ;
    }
}