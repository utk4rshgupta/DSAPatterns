class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character , Integer> freq = new HashMap<>();
        for(char c :s.toCharArray()){
            freq.put(c , freq.getOrDefault(c,0)+1);
        }
        int i = 0;
        for(char c :s.toCharArray()){
            if(freq.get(c) == 1)
            return i;
            i++;
        }
        return -1; 
    }
      
}