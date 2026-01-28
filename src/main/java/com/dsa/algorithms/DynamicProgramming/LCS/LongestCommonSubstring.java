package com.dsa.algorithms.DynamicProgramming.LCS;

// Concept problem
// find the length of longest common subsequence that exist among two strings

public class LongestCommonSubstring {

    // top down recursive
    public static int func(String s1, String s2, int n , int m , int cnt) {
        if(n == 0 || m == 0) return 0;
        if(s1.charAt(n - 1) == s2.charAt(m - 1)) return func(s1, s2, n - 1, m - 1, cnt + 1);
        else {
            int x =  func(s1, s2, n - 1, m, 0);
            int y =  func(s1, s2, n, m - 1, 0);
            return Math.max(cnt, Math.max(x, y));
        }
    }

    // bottom up iterative approach
    public static int func(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n + 1][m + 1];

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(s1.charAt(i - 1) == s2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = 0;
            }
        }

        int ans = 0;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                ans = Math.max(ans, dp[i][j]);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String s1 = "avblakebdvlaiksncv";
        String s2 = "amgjvfkrubslkfjvbfk";

        // very fast
        System.out.println(func(s1, s2));

        // too slow
        System.out.println(func(s1, s2,  s1.length(), s2.length(), 0));
    }
}
