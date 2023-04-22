//Given a non-negative integer x, return the square root of x rounded down to 
//the nearest integer. The returned integer should be non-negative as well. 
//
// You must not use any built-in exponent function or operator. 
//
// 
// For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python. 
// 
//
// 
// Example 1: 
//
// 
//Input: x = 4
//Output: 2
//Explanation: The square root of 4 is 2, so we return 2.
// 
//
// Example 2: 
//
// 
//Input: x = 8
//Output: 2
//Explanation: The square root of 8 is 2.82842..., and since we round it down 
//to the nearest integer, 2 is returned.
// 
//
// 
// Constraints: 
//
// 
// 0 <= x <= 2³¹ - 1 
// 
//
// Related Topics Math Binary Search 👍 6196 👎 3976

package leetcode.editor.cn;
class sqrtx{
    //2023-04-09 16:37:35
    //Sqrt(x)
    //编号：[69]
    
    public static void main(String[] args) {
        Solution solution = new sqrtx().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int mySqrt(int x) {
            long i = 0;
            long j = x / 2 + 1;
            while (i <= j) {
                long mid = (i + j) / 2;
                long res = mid * mid;
                if (res == x) {
                    return (int) mid;
                } else if (res < x) {
                    i = mid + 1;
                } else {
                    j = mid - 1;
                }
            }
            return (int) i;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}