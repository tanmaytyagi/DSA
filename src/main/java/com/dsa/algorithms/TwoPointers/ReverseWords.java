package com.dsa.algorithms.TwoPointers;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ReverseWords {

    public static String reverseWords(String s) {
        StringTokenizer st = new StringTokenizer(s);
        List<String> tokens = new ArrayList<>();
        while (st.hasMoreTokens()) {
            tokens.add(st.nextToken());
        }
        StringBuilder sb = new StringBuilder();
        for (int i = tokens.size() - 1; i >= 0; i--) {
            sb.append(tokens.get(i));
            if (i != 0) sb.append(' ');
        }
        return sb.toString();
    }

    public static String reverseWordsInPlace(String s) {
        int i = s.length() - 1;
        StringBuilder sb = new StringBuilder();

        while (i >= 0) {
            // Skip trailing spaces
            while (i >= 0 && s.charAt(i) == ' ') i--;

            if (i < 0) break;

            // Find the start of the word
            int end = i;
            while (i >= 0 && s.charAt(i) != ' ') i--;

            // Append the word
            if (!sb.isEmpty()) sb.append(' ');
            sb.append(s, i + 1, end + 1);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "       Let's take  the  HackerCode contest        ";
        System.out.println(reverseWordsInPlace(str));
    }
}
