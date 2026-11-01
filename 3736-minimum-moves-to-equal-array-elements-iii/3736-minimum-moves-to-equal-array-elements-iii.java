class Solution {
    public int minMoves(int[] nums) {
        int ans =0;
        int max =Integer.MIN_VALUE;
        for(int i =0;i<nums.length;i++){
            max = Math.max(nums[i] , max);
        }         
        for(int num : nums){
            ans+=(max-num);
        }
        return ans;
    }
}