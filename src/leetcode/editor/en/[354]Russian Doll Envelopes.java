//You are given a 2D array of integers envelopes where envelopes[i] = [wi, hi] 
//represents the width and the height of an envelope. 
//
// One envelope can fit into another if and only if both the width and height 
//of one envelope are greater than the other envelope's width and height. 
//
// Return the maximum number of envelopes you can Russian doll (i.e., put one 
//inside the other). 
//
// Note: You cannot rotate an envelope. 
//
// 
// Example 1: 
//
// 
//Input: envelopes = [[5,4],[6,4],[6,7],[2,3]]
//Output: 3
//Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] 
//=> [5,4] => [6,7]).
// 
//
// Example 2: 
//
// 
//Input: envelopes = [[1,1],[1,1],[1,1]]
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= envelopes.length <= 10⁵ 
// envelopes[i].length == 2 
// 1 <= wi, hi <= 10⁵ 
// 
//
// Related Topics Array Binary Search Dynamic Programming Sorting 👍 5024 👎 123
//

package leetcode.editor.en;
class russianDollEnvelopes{
    //2023-04-22 08:51:38
    //Russian Doll Envelopes
    //编号：[354]
    
    public static void main(String[] args) {
        Solution solution = new russianDollEnvelopes().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}