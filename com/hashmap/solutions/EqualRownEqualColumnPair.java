package com.hashmap.solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a 0-indexed n x n integer matrix grid, return the number of pairs (ri, cj) such that row ri and column cj are equal.
 *
 * A row and column pair is considered equal if they contain the same elements in the same order (i.e., an equal array).
 *
 * Input: grid = [[3,2,1],[1,7,6],[2,7,7]]
 * Output: 1
 * Explanation: There is 1 equal row and column pair:
 * - (Row 2, Column 1): [2,7,7]
 *
 * Input: [[13,13][13,13]]
 * Output: 4
 * Explanation: there are each coloum has 2 row mapping i.e. 2*2 = 4 row mapping pairs.
 *
 * Constraints:
 * n == grid.length == grid[i].length
 * 1 <= n <= 200
 * 1 <= grid[i][j] <= 105
 */

public class EqualRownEqualColumnPair {
        /**
         * Algorithm:
         * Create an empty hash map row_counter and set count to 0.
         *
         * For each row row in the grid, convert it into an equivalent hashable object and use it as a key to the row_counter. Increment the value of the corresponding key by 1.
         *
         * For each column in the grid, convert it into the same type of hashable object and check if it appears in the row_counter. If it does, increment count by the frequency.
         *
         * Return the answer count.
         */
        public int equalPairs(int[][] grid) {
            int n = grid.length, ans = 0, idx = 0 ;
            Map<String, Integer> rowHash = new HashMap<>();
            Map<String, Integer> colHash = new HashMap<>();

            for(int[] row: grid){ // Calculate hash of each row
                StringBuilder sb = new StringBuilder();
                for(int i : row){
                    sb.append(i).append("#");
                }
                rowHash.put(sb.toString(), rowHash.getOrDefault(sb.toString(), 0)+1);
            }
            for(int j=0; j<n; j++){  // Calculate hash of each col
                StringBuilder sb = new StringBuilder();
                for(int i=0; i<n; i++){
                    sb.append(grid[i][j]).append("#");
                }

                colHash.put(sb.toString(), colHash.getOrDefault(sb.toString(), 0)+1);

            }

            for(Map.Entry<String, Integer> entry : rowHash.entrySet()){
                String rHash = entry.getKey();
                if(colHash.containsKey(rHash)){
                    ans += colHash.get(rHash) * rowHash.get(rHash);
                }
            }
            return ans;

        }
}
