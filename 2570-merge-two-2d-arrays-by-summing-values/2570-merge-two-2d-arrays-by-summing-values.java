class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int i =0;i<nums1.length;i++){
            map.put(nums1[i][0] , nums1[i][1]);
        } 
        for(int i =0;i<nums2.length;i++){
            if(map.containsKey(nums2[i][0])){
                map.put(nums2[i][0] , nums2[i][1]+map.get(nums2[i][0]));
            }else{
                map.put(nums2[i][0] , nums2[i][1]);
            }
        }
        int size = map.size();
        int[][] ans = new int[size][2];
        int i =0;
        for (Map.Entry<Integer, Integer> Hmap : map.entrySet()) {
            ans[i][0] = Hmap.getKey();
            ans[i][1] = Hmap.getValue();
            i++;
        }
        Arrays.sort(ans, (a, b) -> a[0] - b[0]);
        return ans;
    }

}