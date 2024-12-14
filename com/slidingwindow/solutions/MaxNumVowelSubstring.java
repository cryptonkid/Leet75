package com.slidingwindow.solutions;

/**
 * 1456. Maximum Number of Vowels in a Substring of Given Length
 * Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.
 *
 * Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abciiidef", k = 3
 * Output: 3
 * Explanation: The substring "iii" contains 3 vowel letters.
 * Example 2:
 *
 * Input: s = "aeiou", k = 2
 * Output: 2
 * Explanation: Any substring of length 2 contains 2 vowels.
 * Example 3:
 *
 * Input: s = "leetcode", k = 3
 * Output: 2
 * Explanation: "lee", "eet" and "ode" contain 2 vowels.
 */
public class MaxNumVowelSubstring {
    public int maxVowels(String s, int k) {
        char[] input = s.toCharArray();
        int count = 0;
        for(int i=0;i<k;i++){
            char ch = input[i];
            if(ch =='a' || ch =='e' || ch == 'i' || ch == 'o' || ch == 'u'){
                count++;
            }
        }
        int res = count;
        for(int i=k;i<input.length;i++){
            char ch = input[i];
            char ch1 = input[i-k];
            //below line of code can be replaced vowelSet().contains
            if(ch =='a' || ch =='e' || ch == 'i' || ch == 'o' || ch == 'u'){
                count++;
            }if(ch1 =='a' || ch1 =='e' || ch1 == 'i' || ch1 == 'o' || ch1 == 'u'){
                count--;
            }
            if(res<count)
                res=count;
        }
        return res;

    }
}
