class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int ans =k;
        for(int num : nums){
            set.add(num);
        }
        while(set.contains(ans)){
            ans +=k;
        }
        return ans;
    }
}