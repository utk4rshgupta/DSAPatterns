class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m= nums2.length;
        int[] arr = new int[m+n];
        for(int i=0;i<n;i++){
            arr[i]=nums1[i];
        }
        for(int i=0;i<m;i++){
            arr[n+i]=nums2[i];
        }
        Arrays.sort(arr);
        int l=arr.length;
        if(l%2!=0){
            return arr[l/2];
        }
        else return  (arr[l/2]+arr[(l/2)-1])/2.0;
    }
}