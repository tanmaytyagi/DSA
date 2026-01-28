package com.dsa.algorithms.Strings;

public class LongestPalindromicSubstring {

    // O(n^2)
    public static String longestPalindrome(String s) {
        if(s == null || s.length() < 2) return s;

        int n = s.length();
        int start = 0;
        int maxLength = 1;

        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j <= 1 ; j++) {
                int low = i;
                int high = i + j;

                while(low >= 0 && high < n && s.charAt(low) == s.charAt(high)) {
                    int currLength = high - low + 1;
                    if(currLength > maxLength) {
                        maxLength = currLength;
                        start = low;
                    }
                    low--;
                    high++;
                }
            }
        }

        return s.substring(start, start + maxLength);
    }

    public static void main(String[] args) {
        String s = "geeks";
        System.out.println(longestPalindrome(s));
    }
}
