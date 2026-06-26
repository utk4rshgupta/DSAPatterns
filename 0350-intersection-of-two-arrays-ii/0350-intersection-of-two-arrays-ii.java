class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(nums1.length > nums2.length){ return intersect(nums2, nums1); }
        for(int i = 0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                if(nums1[i]==nums2[j]){
                    ans.add(nums1[i]);
                    nums2[j] = Integer.MAX_VALUE;
                    break;
                }
            }
        }
        int x = ans.size();
        int[] arr = new int[x];
        for(int i=0;i<x;i++){
            arr[i] = ans.get(i);
        }
        return arr;
    }
}