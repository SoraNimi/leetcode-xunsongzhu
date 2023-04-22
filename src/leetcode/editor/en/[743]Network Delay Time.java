//You are given a network of n nodes, labeled from 1 to n. You are also given 
//times, a list of travel times as directed edges times[i] = (ui, vi, wi), where ui 
//is the source node, vi is the target node, and wi is the time it takes for a 
//signal to travel from source to target. 
//
// We will send a signal from a given node k. Return the minimum time it takes 
//for all the n nodes to receive the signal. If it is impossible for all the n 
//nodes to receive the signal, return -1. 
//
// 
// Example 1: 
// 
// 
//Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
//Output: 2
// 
//
// Example 2: 
//
// 
//Input: times = [[1,2,1]], n = 2, k = 1
//Output: 1
// 
//
// Example 3: 
//
// 
//Input: times = [[1,2,1]], n = 2, k = 2
//Output: -1
// 
//
// 
// Constraints: 
//
// 
// 1 <= k <= n <= 100 
// 1 <= times.length <= 6000 
// times[i].length == 3 
// 1 <= ui, vi <= n 
// ui != vi 
// 0 <= wi <= 100 
// All the pairs (ui, vi) are unique. (i.e., no multiple edges.) 
// 
//
// Related Topics Depth-First Search Breadth-First Search Graph Heap (Priority 
//Queue) Shortest Path 👍 6236 👎 333

package leetcode.editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class networkDelayTime {
    //2023-04-16 09:19:53
    //Network Delay Time
    //编号：[743]

    public static void main(String[] args) {
        Solution solution = new networkDelayTime().new Solution();
        // TO TEST
    }

    class Node {
        int id;
        int distFromStart;

        public Node(int id, int distFromStart) {
            this.id = id;
            this.distFromStart = distFromStart;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int networkDelayTime(int[][] times, int n, int k) {
            int[][] graph = new int[n + 1][n + 1];
            for (int i = 0; i < graph.length; i++) {
                Arrays.fill(graph[i], -1);
            }

            for (int[] time : times) {
                graph[time[0]][time[1]] = time[2];
            }

            int[] tmp = dijkstra(k, graph);
            int ret = 0;
            for (int i = 1; i < tmp.length; i++) {
                if (tmp[i] == Integer.MAX_VALUE) {
                    return -1;
                }
                if (tmp[i] > ret) {
                    ret = tmp[i];
                }
            }
            return ret;
        }

        private int[] dijkstra(int start, int[][] graph) {
            int[] ret = new int[graph.length];
            Arrays.fill(ret, Integer.MAX_VALUE);
            ret[start] = 0;
            PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    return o1.distFromStart - o2.distFromStart;
                }
            });
            queue.offer(new Node(start, 0));
            while (!queue.isEmpty()) {
                Node curNode = queue.poll();
                int curNodeId = curNode.id;
                int curNodeDistFromStart = curNode.distFromStart;

                for (Integer nextNodeId : getNextNode(curNodeId, graph)) {
                    int nextNodeDistFromStart = curNodeDistFromStart + graph[curNodeId][nextNodeId];
                    if (nextNodeDistFromStart < ret[nextNodeId]) {
                        queue.offer(new Node(nextNodeId, nextNodeDistFromStart));
                        ret[nextNodeId] = nextNodeDistFromStart;
                    }
                }
            }
            return ret;
        }

        private List<Integer> getNextNode(int curNodeId, int[][] graph) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < graph.length; i++) {
                if (graph[curNodeId][i] != -1) {
                    list.add(i);
                }
            }
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}