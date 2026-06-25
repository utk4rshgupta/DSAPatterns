class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int ans = 0;
        for(int i =0;i<n;i++){
            int freq = 0;
            int length =0;
            for(int j =i;j<n;j++){
                length++;
                if(nums[j] == target){
                    freq++;
                }
                if(freq > length/2) ans++;
            }
            
        }
        return ans;
    }
}