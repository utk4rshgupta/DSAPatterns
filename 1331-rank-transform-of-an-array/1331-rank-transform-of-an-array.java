class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] arrCopy = Arrays.copyOf(arr,arr.length);
        Arrays.sort(arrCopy);
        Map<Integer,Integer> map = new HashMap<>();
        int j =0;
        for(int i : arrCopy){
            if(!map.containsKey(i)){
                map.put(i,j+1);
                j++;
            }
        }
        int[] ans = new int[arr.length];
        for(int i = 0;i<arr.length;i++){
            ans[i] = map.get(arr[i]);
        }
        return ans;
    }
}