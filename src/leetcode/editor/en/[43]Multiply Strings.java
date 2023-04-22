//Given two non-negative integers num1 and num2 represented as strings, return 
//the product of num1 and num2, also represented as a string. 
//
// Note: You must not use any built-in BigInteger library or convert the inputs 
//to integer directly. 
//
// 
// Example 1: 
// Input: num1 = "2", num2 = "3"
//Output: "6"
// 
// Example 2: 
// Input: num1 = "123", num2 = "456"
//Output: "56088"
// 
// 
// Constraints: 
//
// 
// 1 <= num1.length, num2.length <= 200 
// num1 and num2 consist of digits only. 
// Both num1 and num2 do not contain any leading zero, except the number 0 
//itself. 
// 
//
// Related Topics Math String Simulation 👍 6052 👎 2725

package leetcode.editor.cn;

class multiplyStrings {
    //2023-04-12 18:03:13
    //Multiply Strings
    //编号：[43]

    public static void main(String[] args) {
        Solution solution = new multiplyStrings().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String multiply(String num1, String num2) {
            if (num1.equals("0") || num2.equals("0")) {
                return "0";
            }
            String res = "0";

            for (int i = num2.length() - 1; i >= 0; i--) {
                int carry = 0;
                StringBuilder temp = new StringBuilder();
                for (int j = 0; j < num2.length() - 1 - i; j++) {
                    temp.append(0);
                }
                int n2 = num2.charAt(i) - '0';

                for (int j = num1.length() - 1; j >= 0 || carry != 0; j--) {
                    int n1 = j < 0 ? 0 : num1.charAt(j) - '0';
                    int product = (n1 * n2 + carry) % 10;
                    temp.append(product);
                    carry = (n1 * n2 + carry) / 10;
                }
                res = addStrings(res, temp.reverse().toString());
            }
            return res;
        }

        public String addStrings(String num1, String num2) {
            StringBuilder builder = new StringBuilder();
            int carry = 0;
            for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || carry != 0; i--, j--) {
                int x = i < 0 ? 0 : num1.charAt(i) - '0';
                int y = j < 0 ? 0 : num2.charAt(j) - '0';
                int sum = (x + y + carry) % 10;
                builder.append(sum);
                carry = (x + y + carry) / 10;
            }
            return builder.reverse().toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}