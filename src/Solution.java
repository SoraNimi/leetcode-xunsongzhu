import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        if (s == null) {
            return res;
        }
        Map<Character, Integer> map = new HashMap<>();
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            while (map.get(s.charAt(r)) != null && map.get(s.charAt(r)) != 0) {
                map.put(s.charAt(r), map.get(s.charAt(r)) - 1);
                l++;
            }
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r) + 1, 1));
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
    public static void main(String[] args){
        Solution solution = new Solution();
        String s = "pwwkew";
        solution.lengthOfLongestSubstring(s);
    }
}