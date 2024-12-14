package com.hashmap.solutions;

import java.util.*;
/**
 *
 * 1657. Determine if Two Strings Are Close
 *
 * Two strings are considered close if you can attain one from the other using the following operations:
 *
 * Operation 1: Swap any two existing characters.
 * For example, abcde -> aecdb
 * Operation 2: Transform every occurrence of one existing character into another existing character, and do the same with the other character.
 * For example, aacabb -> bbcbaa (all a's turn into b's, and all b's turn into a's)
 * You can use the operations on either string as many times as necessary.
 *
 * Given two strings, word1 and word2, return true if word1 and word2 are close, and false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: word1 = "abc", word2 = "bca"
 * Output: true
 * Explanation: You can attain word2 from word1 in 2 operations.
 * Apply Operation 1: "abc" -> "acb"
 * Apply Operation 1: "acb" -> "bca"
 * Example 2:
 *
 * Input: word1 = "a", word2 = "aa"
 * Output: false
 * Explanation: It is impossible to attain word2 from word1, or vice versa, in any number of operations.
 * Example 3:
 *
 * Input: word1 = "cabbba", word2 = "abbccc"
 * Output: true
 * Explanation: You can attain word2 from word1 in 3 operations.
 * Apply Operation 1: "cabbba" -> "caabbb"
 * Apply Operation 2: "caabbb" -> "baaccc"
 * Apply Operation 2: "baaccc" -> "abbccc"
 *
 *
 * Constraints:
 *
 * 1 <= word1.length, word2.length <= 105
 * word1 and word2 contain only lowercase English letters.
 */
public class CloseStrings {
    /**
     * Time Complexity: O(n). We iterate over each word to build the hashmap which would take O(n) time.
     * Further, we sort the character keys and frequency values of each hashmap. The maximum size of hashmap would be 26, as we store each character a-z only once. In the worst case, all the sort operations would take O(26log26) time to sort those frequency values.
     * This gives us total time complexity as O(n).
     *
     * Space Complexity: O(1), as the maximum size of each hashmap would be 26, we are using constant extra space.
     * @param word1 String
     * @param word2 String
     * @return boolean
     */
    public boolean closeStringsUsingMap(String word1, String word2) {
        //The lenght of the 2 words must be same
        if(word1.length() != word2.length()){
            return false;
        }
        //frequency count of all charater should be same as other
        //Example 3: {a:2,b:3,c:1} {a:1,b:2,c:3}

        //check if the map key set is same.
        Map<Character, Integer> word1Map = new HashMap<>();
        Map<Character, Integer> word2Map = new HashMap<>();
        for (char c : word1.toCharArray()) {
            word1Map.put(c, word1Map.getOrDefault(c, 0) + 1);
        }
        for (char c : word2.toCharArray()) {
            word2Map.put(c, word2Map.getOrDefault(c, 0) + 1);
        }
        //Look at below code. see how map key sets are being compared.
        if (!word1Map.keySet().equals(word2Map.keySet())) {
            return false;
        }
        //condition 2: checking if they have same frequencyies.
        List<Integer> word1FrequencyList = new ArrayList<>(word1Map.values());
        List<Integer> word2FrequencyList = new ArrayList<>(word2Map.values());
        Collections.sort(word1FrequencyList);
        Collections.sort(word2FrequencyList);
        return word1FrequencyList.equals(word2FrequencyList);
    }

    /**
     * Time Complexity : O(n), where n is the length of word.
     *
     * We iterate over words of size n to build the frequency map which takes O(n).
     * To check if both words have the same characters and frequency, we iterate over a fixed-size array of size 26 which takes constant time. The sort operation on the array also takes constant time, as the array is of size 26.
     *
     * This gives us time complexity of O(n)+O(1)+O(1)=O(n)
     *
     * Space Complexity: O(1), as we use constant extra space of size 26 to store the frequency map.
     * @param word1 String
     * @param word2 String
     * @return boolean
     */
    public boolean closeStringsUsingArrayMap(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        int[] word1Map = new int[26];
        int[] word2Map = new int[26];
        for (char c : word1.toCharArray()) {
            word1Map[c - 'a']++;
        }
        for (char c : word2.toCharArray()) {
            word2Map[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if ((word1Map[i] == 0 && word2Map[i] > 0) ||
                    (word2Map[i] == 0 && word1Map[i] > 0)) {
                return false;
            }
        }
        Arrays.sort(word1Map);
        Arrays.sort(word2Map);
        return Arrays.equals(word1Map, word2Map);
    }
}

