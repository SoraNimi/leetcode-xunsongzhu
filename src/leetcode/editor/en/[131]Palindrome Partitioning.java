//Given a string s, partition s such that every substring of the partition is a 
//palindrome. Return all possible palindrome partitioning of s. 
//
// 
// Example 1: 
// Input: s = "aab"
//Output: [["a","a","b"],["aa","b"]]
// 
// Example 2: 
// Input: s = "a"
//Output: [["a"]]
// 
// 
// Constraints: 
//
// 
// 1 <= s.length <= 16 
// s contains only lowercase English letters. 
// 
//
// Related Topics String Dynamic Programming Backtracking 👍 10522 👎 334

package leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

class palindromePartitioning {
    //2023-04-14 20:42:15
    //Palindrome Partitioning
    //编号：[131]

    public static void main(String[] args) {
        Solution solution = new palindromePartitioning().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> partition(String s) {
            List<List<String>> res = new ArrayList<List<String>>();
            backtrack(s, 0, new ArrayList<String>(), res);
            return res;
        }

        private void backtrack(String s, int index, List<String> path,  List<List<String>> res) {
            if (index >= s.length()) {
                res.add(new ArrayList<>(path));
                return;
            }
            for (int i = index; i < s.length(); i++) {
                if (isPalindrome(s, index, i)) {
                    String str = s.substring(index, i + 1);
                    path.add(str);
                } else {
                    continue;
                }
                backtrack(s, i + 1, path, res);
                path.remove(path.size() - 1);
            }
        }

        private boolean isPalindrome(String s, int start, int end) {
            while (start <= end) {
                if (s.charAt(start) != s.charAt(end)) {
                    return false;
                }
                start++;
                end--;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}