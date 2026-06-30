class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        char[] freq = new char[26];
        for(char c : s.toCharArray()){
            freq[c-'a']++;
        }
        for(char c : t.toCharArray()){
            if(freq[c-'a']==0) return false;
            if(--freq[c-'a']<0)
            return false;
        }
        for(char c : s.toCharArray()){
            if(freq[c-'a']==1) return false;
        }
        return true;
    }
}