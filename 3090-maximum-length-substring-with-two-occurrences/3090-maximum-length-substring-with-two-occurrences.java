class Solution {
    public int maximumLengthSubstring(String s) {
               int start = 0, res = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            while (map.get(ch) > 2) {
                char left = s.charAt(start);
                map.put(left, map.get(left) - 1);
                start++;
            }

            res = Math.max(res, i - start + 1);
        }

        return res;
    }
}