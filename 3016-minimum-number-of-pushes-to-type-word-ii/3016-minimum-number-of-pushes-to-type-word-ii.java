class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        int[] freq = new int[26];

        for(char c : word.toCharArray()){
            int index = c -'a';
            freq[index]++;
        }
        Arrays.sort(freq);
        int ans = 0;
        for(int i = 25,index =0 ;i>=0;i--,index++){
            ans += (index/8 + 1 )*freq[i];
        }
        return ans;
    }
}