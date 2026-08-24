class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] canJudge = new int[n+1];
        for(int[] arr : trust){
            canJudge[arr[0]]--;
            canJudge[arr[1]]++;
        }
        for(int i =1;i<n+1;i++){
            if(canJudge[i] == n-1) return i ;
        }
        return -1;
    }
}