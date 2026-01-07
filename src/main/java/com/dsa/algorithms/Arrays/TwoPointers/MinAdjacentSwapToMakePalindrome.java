package com.dsa.algorithms.Arrays.TwoPointers;

public class MinAdjacentSwapToMakePalindrome {

    public static int minMovesToMakePalindrome(String s) {
        int ans = 0;

        while(s.length() > 2) {
            int len = s.length();

            char ch1 = s.charAt(0);
            char ch2 = s.charAt(len - 1);

            if(ch1 == ch2) {
                s = s.substring(1, len - 1);
            } else {
                int id1 = s.lastIndexOf(ch1);
                int id2 = s.indexOf(ch2);

                int step1 = len - id1 - 1;
                int step2 = id2;

                StringBuilder sb = new StringBuilder();

                if(step1 > step2) {
                    ans += step2;
                    sb.append(s, 0, id2);
                    sb.append(s, id2 + 1, len - 1);
                } else {
                    ans += step1;
                    sb.append(s, 1, id1);
                    sb.append(s, id1 + 1, len);
                }

                s = sb.toString();
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(minMovesToMakePalindrome("mamad"));
    }
}
