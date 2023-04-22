//Given an array of intervals where intervals[i] = [starti, endi], merge all 
//overlapping intervals, and return an array of the non-overlapping intervals that 
//cover all the intervals in the input. 
//
// 
// Example 1: 
//
// 
//Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
//Output: [[1,6],[8,10],[15,18]]
//Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
// 
//
// Example 2: 
//
// 
//Input: intervals = [[1,4],[4,5]]
//Output: [[1,5]]
//Explanation: Intervals [1,4] and [4,5] are considered overlapping.
// 
//
// 
// Constraints: 
//
// 
// 1 <= intervals.length <= 10⁴ 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 10⁴ 
// 
//
// Related Topics Array Sorting 👍 18637 👎 634

package leetcode.editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class mergeIntervals{
    //2023-04-21 08:29:23
    //Merge Intervals
    //编号：[56]
    // https://blog.csdn.net/bjyh345/article/details/121711826
    public static void main(String[] args) {
        Solution solution = new mergeIntervals().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {

        List<Integer> a1 = new ArrayList<Integer>();
        a1.toArray(new Integer[0]);

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> merged = new ArrayList<int[]>();
        for (int i = 0; i < intervals.length; i++) {
            int L = intervals[i][0], R = intervals[i][1];
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                merged.add(new int[]{L, R});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(R, merged.get(merged.size() - 1)[1]);
            }
        }
        return merged.toArray(new int[0][]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}