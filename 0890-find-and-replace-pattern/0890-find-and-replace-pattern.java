class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        boolean[] arr = new boolean[words.length];
         List<String> list = new ArrayList<>();
        for(int i =0;i<words.length;i++){
            arr[i] = isIsomorphic(words[i],pattern);
            if(arr[i]) list.add(words[i]);
        }
        return list;
    }
    private boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> map = new HashMap<>();
        for(int i =0;i<s.length();i++){
            char a = s.charAt(i);
            char b = t.charAt(i);
            if(map.containsKey(a)){
                if(map.get(a) != b){ return false;}
                }else{
                if(map.containsValue(b)) return false;
                map.put(a,b);  
            }
        }
        return true;
    }
}