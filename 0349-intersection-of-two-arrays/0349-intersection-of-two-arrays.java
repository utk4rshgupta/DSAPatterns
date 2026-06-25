class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> ansSet = new HashSet<>();

        for(int num: nums1){
            set.add(num);
        }
        for(int num: nums2){
            if(set.contains(num)) ansSet.add(num);
        }
        int i =0;
        int[] ans = new int[ansSet.size()];
        for(int num : ansSet){
            ans[i++] = num;
        }
        return ans ;
       
    }     
}