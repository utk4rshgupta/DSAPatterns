class Solution {
    public int longestSubsequence(int[] nums) {
        int[] zero= new int[nums.length];

        if(Arrays.equals(nums,zero)) return 0;

        int ans =0;
        for(int i : nums){
            ans^=i;
        }
        if(ans == 0) return nums.length-1;
        
        return nums.length;
    }
}