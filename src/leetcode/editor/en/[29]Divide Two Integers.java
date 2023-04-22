//Given two integers dividend and divisor, divide two integers without using 
//multiplication, division, and mod operator. 
//
// The integer division should truncate toward zero, which means losing its 
//fractional part. For example, 8.345 would be truncated to 8, and -2.7335 would be 
//truncated to -2. 
//
// Return the quotient after dividing dividend by divisor. 
//
// Note: Assume we are dealing with an environment that could only store 
//integers within the 32-bit signed integer range: [−2³¹, 2³¹ − 1]. For this problem, if 
//the quotient is strictly greater than 2³¹ - 1, then return 2³¹ - 1, and if the 
//quotient is strictly less than -2³¹, then return -2³¹. 
//
// 
// Example 1: 
//
// 
//Input: dividend = 10, divisor = 3
//Output: 3
//Explanation: 10/3 = 3.33333.. which is truncated to 3.
// 
//
// Example 2: 
//
// 
//Input: dividend = 7, divisor = -3
//Output: -2
//Explanation: 7/-3 = -2.33333.. which is truncated to -2.
// 
//
// 
// Constraints: 
//
// 
// -2³¹ <= dividend, divisor <= 2³¹ - 1 
// divisor != 0 
// 
//
// Related Topics Math Bit Manipulation 👍 4196 👎 13153

package leetcode.editor.en;
class divideTwoIntegers{
    //2023-04-19 22:16:05
    //Divide Two Integers
    //编号：[29]
    
    public static void main(String[] args) {
        Solution solution = new divideTwoIntegers().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int divide(int dividend, int divisor) {
        return new Long(longDivide((long) dividend, (long) divisor)).intValue();
    }

    private long longDivide(long dividend, long divisor) {
        long res = 0L;
        long absDividend = Math.abs(dividend), absDivisor = Math.abs(divisor);
        if (absDividend < absDivisor) {
            return 0;
        }
        long t = 1;
        long m = absDivisor;
        while (absDividend > m << 1) {
            t <<= 1;
            m <<= 1;
        }
        res += t + longDivide(absDividend - m, absDivisor);
        if ((dividend < 0) ^ (divisor < 0)) {
            res = -res;
        }
        return res > Integer.MAX_VALUE ? Integer.MAX_VALUE : new Long(res).intValue();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}